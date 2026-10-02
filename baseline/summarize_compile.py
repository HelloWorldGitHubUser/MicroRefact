"""Summarize the Maven logs written by compile_all.sh.

usage: summarize_compile.py <baseline-outputs/<app>/compile> [...]
Rewrites summary.tsv in each directory (monolith first, then services) and prints one
Markdown row per application.

javac_errors counts distinct `file:[line,col]` errors reported by javac. It is a lower
bound: javac stops after syntax errors and reports at most 100 errors per module.
"""
import gzip
import os
import re
import sys

JAVAC = re.compile(r'\[ERROR\] /.*?/src/main/java/(.*\.java):\[\d+,\d+\] (?:error: )?(.*)')


def classify(path):
    text = gzip.open(path, 'rt', errors='ignore').read()
    lines = text.splitlines()
    javac = sorted({l for l in lines if JAVAC.match(l)})
    if 'BUILD SUCCESS' in text:
        status, first = 'OK', ''
    elif javac:
        status = 'javac'
        file, msg = JAVAC.match(javac[0]).groups()
        first = '%s: %s' % (file, msg)
    else:
        first = next((l for l in lines if l.startswith('[ERROR]') and 'Some problems' not in l), '')
        if re.search(r'Child module .* does not exist|ProjectBuildingException|Non-resolvable|Non-parseable POM', text):
            status = 'pom'
        elif re.search(r'Could not resolve dependencies|Could not find artifact|Failed to collect dependencies', text):
            status = 'dependencies'
        elif 'TIMEOUT' in text:
            status = 'timeout'
        else:
            status = 'other'
    return status, len(javac), first.replace('\t', ' ')[:300]


def main():
    for directory in sys.argv[1:]:
        app = os.path.basename(os.path.dirname(os.path.abspath(directory)))
        logs = sorted(f for f in os.listdir(directory) if f.endswith('.log.gz'))
        modules = ['monolith'] + [f[:-7] for f in logs if f != 'monolith.log.gz']
        rows = []
        for module in modules:
            status, count, first = classify(os.path.join(directory, module + '.log.gz'))
            rows.append((module if module != 'monolith' else 'monolith (control)', status, count, first))
        with open(os.path.join(directory, 'summary.tsv'), 'w') as f:
            f.write('module\tstatus\tjavac_errors\tfirst_error\n')
            for row in rows:
                f.write('%s\t%s\t%d\t%s\n' % row)
        services = rows[1:]
        ok = sum(1 for r in services if r[1] == 'OK')
        kinds = sorted({r[1] for r in services if r[1] != 'OK'})
        print('| %s | %s | %d/%d | %s | %s |' % (
            app, 'OK' if rows[0][1] == 'OK' else rows[0][1], ok, len(services), ', '.join(kinds) or '-',
            '%d–%d' % (min(r[2] for r in services), max(r[2] for r in services)) if any(r[1] == 'javac' for r in services) else '-'))


if __name__ == '__main__':
    main()
