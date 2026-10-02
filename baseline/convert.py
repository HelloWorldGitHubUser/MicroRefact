"""Convert an input-kit decomposition into MicroRefact's microservice-proposal format.

MicroRefact expects a disjoint partition: every class in exactly one cluster, and every
class the parser saw must be in some cluster. Rules applied here:

  * a class listed before "" by exactly one service      -> that service
  * a class in the top-level "shared" list               -> shared
  * a class listed before "" by several services         -> shared
  * a class only listed after "" (used, owned by shared) -> shared
  * an inner class not listed itself                     -> same cluster as its outer class
  * a parsed class listed nowhere                        -> shared
  * a listed type the parser does not emit (enum, record, annotation, ...)
                                                         -> dropped, recorded in the meta file
"""
import argparse
import json
import os
import re

TYPE_DECL = re.compile(r'^(?:\s*@\w+(?:\([^)]*\))?\s*)*\s*(?:public\s+|protected\s+|private\s+|abstract\s+|final\s+|static\s+|sealed\s+|non-sealed\s+|strictfp\s+)*'
                       r'(class|interface|enum|@interface|record)\s+(\w+)', re.M)
PACKAGE = re.compile(r'^\s*package\s+([\w.]+)\s*;', re.M)


def source_kinds(source_root):
    """Map top-level type FQN -> declaration kind, from the monolith sources."""
    kinds = {}
    for dirpath, _, files in os.walk(source_root):
        for name in files:
            if not name.endswith('.java'):
                continue
            text = open(os.path.join(dirpath, name), errors='ignore').read()
            pkg = PACKAGE.search(text)
            decl = TYPE_DECL.search(text)
            if decl:
                kinds[(pkg.group(1) + '.' if pkg else '') + decl.group(2)] = decl.group(1)
    return kinds


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--decomposition', required=True)
    ap.add_argument('--ast', required=True, help='output.json written by app/javaParser')
    ap.add_argument('--source', required=True, help='monolith path given to MicroRefact')
    ap.add_argument('--name', required=True, help='relativePath / project name for MicroRefact')
    ap.add_argument('--out', required=True, help='proposal json to write; <out>.meta.json is written too')
    args = ap.parse_args()

    decomposition = json.load(open(args.decomposition))
    ast = json.load(open(args.ast))
    services = [s for s in decomposition if s != 'shared']
    shared_list = set(c for c in decomposition.get('shared', []) if c)

    owners, used = {}, set()
    for svc in services:
        before_sep = True
        for c in decomposition[svc]:
            if c == '':
                before_sep = False
                continue
            if before_sep:
                owners.setdefault(c, []).append(svc)
            else:
                used.add(c)

    assigned, reason = {}, {}
    for c, svcs in owners.items():
        if c in shared_list:
            assigned[c], reason[c] = 'shared', 'in shared list'
        elif len(svcs) == 1:
            assigned[c], reason[c] = svcs[0], 'owned'
        else:
            assigned[c], reason[c] = 'shared', 'owned by several services: ' + ', '.join(svcs)
    for c in shared_list | used:
        if c not in assigned:
            assigned[c], reason[c] = 'shared', 'in shared list' if c in shared_list else 'listed only after ""'

    for c in sorted(ast, key=lambda k: k.count('.')):
        if c in assigned:
            continue
        outer = c.rsplit('.', 1)[0]
        if outer in assigned and outer in ast:
            assigned[c], reason[c] = assigned[outer], 'inner class of ' + outer
        else:
            assigned[c], reason[c] = 'shared', 'not listed in decomposition'

    kinds = source_kinds(args.source)
    dropped = sorted(c for c in assigned if c not in ast)
    for c in dropped:
        del assigned[c]

    order = services + ['shared']
    clusters = [(svc, sorted(c for c, s in assigned.items() if s == svc)) for svc in order]
    clusters = [(svc, classes) for svc, classes in clusters if classes]
    cluster_string = '{' + ', '.join('%d: %s' % (i, classes) for i, (_, classes) in enumerate(clusters)) + '}'
    json.dump([{'id': args.name, 'name': args.name, 'relativePath': args.name,
                'clusterString': cluster_string}], open(args.out, 'w'), indent=2)

    meta = {
        'cluster_index_to_service': {str(i): svc for i, (svc, _) in enumerate(clusters)},
        'cluster_sizes': {svc: len(classes) for svc, classes in clusters},
        'dropped_not_emitted_by_parser': [{'class': c, 'kind': kinds.get(c, 'unknown')} for c in dropped],
        'moved_to_shared': {c: reason[c] for c, s in sorted(assigned.items())
                            if s == 'shared' and reason[c] != 'in shared list'},
        'inner_classes_following_outer': {c: assigned[c] for c in sorted(assigned) if reason[c].startswith('inner class')},
    }
    json.dump(meta, open(args.out + '.meta.json', 'w'), indent=2)
    print(json.dumps({'clusters': meta['cluster_sizes'], 'dropped': len(dropped),
                      'moved_to_shared': len(meta['moved_to_shared'])}))


if __name__ == '__main__':
    main()
