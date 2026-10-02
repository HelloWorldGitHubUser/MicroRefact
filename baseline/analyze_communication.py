"""Pair every REST call MicroRefact generated with the endpoint it targets and check that
the two sides agree. Compilation problems are deliberately ignored.

usage: analyze_communication.py [baseline-outputs dir]
Writes <app>/run/communication.json per application and prints a Markdown summary.

A call's contract matches when all of these hold:
  target   the host index in the URL names a generated service other than the caller
  endpoint that service exposes exactly one endpoint with the same HTTP method and path
  params   query-parameter names, path-variable count and request-body use agree
  types    no side falls back to the Object placeholder, and parameter / return types agree
Separately, for matching calls, the server side is checked for what would still break at
run time without touching compilation: an injected delegate and a delegate method that exists.
"""
import collections
import glob
import json
import os
import re
import sys

SIG = re.compile(r'public\s+(?:static\s+)?([\w<>\[\],.? ]+?)\s+(\w+)\s*\((.*?)\)\s*(?:throws[^{;]*)?\{', re.S)
CALL = re.compile(r'restTemplate\.(getForObject|put)\s*\(')
MAPPING = re.compile(r'@(Get|Put|Post|Delete)Mapping\s*\(?\s*"([^"]+)"\s*\)?\s*public\s+([\w<>\[\],.? ]+?)\s+(\w+)\s*\((.*?)\)\s*\{(.*?)\n\}', re.S)
FIELD = re.compile(r'((?:@Autowired\s*)?)\s*private\s+([\w<>,.]+)\s+(\w+)\s*;')
INPUTS = os.path.join(os.path.dirname(os.path.abspath(__file__)), '..', 'baseline-inputs')
VERB = {'getForObject': 'GET', 'put': 'PUT'}


def split_params(text):
    parts, depth, cur = [], 0, ''
    for ch in text:
        depth += ch == '<'
        depth -= ch == '>'
        if ch == ',' and depth == 0:
            parts.append(cur.strip())
            cur = ''
        else:
            cur += ch
    if cur.strip():
        parts.append(cur.strip())
    return parts


def raw(t):
    return re.sub(r'<.*>', '', t or '').strip()


def norm_path(p):
    return re.sub(r'\{[^}]*\}', '{}', p)


def java_files(root):
    return glob.glob(os.path.join(root, 'src/main/java/**/*.java'), recursive=True)


def parse_clients(svc, root):
    calls = []
    for path in java_files(root):
        text = open(path, errors='ignore').read()
        if 'restTemplate.' not in text:
            continue
        base = re.search(r'url\s*=\s*"http://([^"/]*)"', text)
        for m in CALL.finditer(text):
            sigs = [s for s in SIG.finditer(text, 0, m.start())]
            if not sigs:
                continue
            sig = sigs[-1]
            ret, name = sig.group(1).strip(), sig.group(2)
            ptypes = {}
            for p in split_params(sig.group(3)):
                bits = p.rsplit(' ', 1)
                if len(bits) == 2:
                    ptypes[bits[1]] = bits[0].strip()
            segment = text[sig.end():m.start()]
            args = text[m.end():text.find(';', m.end())]
            literal = re.match(r'\s*"http://([^/"]*)(/[^"]*)"', args)
            if literal:                                   # entity-relationship client
                host, url_path = literal.group(1), literal.group(2)
                rest = split_params(args[literal.end():].strip().lstrip(',').rstrip(') '))
                query = []
                if VERB[m.group(1)] == 'GET':
                    ret_cls, uri_vars, body = rest[0] if rest else '', rest[1:], False
                else:
                    ret_cls, body, uri_vars = 'void', bool(rest) and rest[0] != 'null', rest[1:]
            else:                                         # instance / local-variable client
                host = base.group(1) if base else None
                pm = re.search(r'concat\("(/[^"]*)"\)\s*$', segment.split('UriComponentsBuilder.fromUriString')[-1].split(')')[0] + ')') \
                    or re.search(r'url\.concat\("(/[^"]*)"\)', segment)
                url_path = pm.group(1) if pm else None
                query = re.findall(r'\.queryParam\("([^"]*)",\s*([^)]*)\)', segment)
                rest = split_params(args.rstrip(') '))
                if VERB[m.group(1)] == 'GET':
                    ret_cls, body = (rest[1] if len(rest) > 1 else ''), False
                else:
                    ret_cls, body = 'void', len(rest) > 1 and rest[1] != 'null'
                uri_vars = []
            calls.append({
                'client_service': svc, 'client_file': os.path.relpath(path, root), 'method': name,
                'verb': VERB[m.group(1)], 'host': host, 'path': url_path,
                'query': [q[0] for q in query], 'query_types': [ptypes.get(q[1].strip(), '?') for q in query],
                'uri_vars': len(uri_vars), 'body': body,
                'return': ret if ret_cls == 'void' else re.sub(r'\.class$', '', ret_cls.strip()),
            })
    return calls


def parse_servers(svc, root):
    endpoints = []
    for path in java_files(root):
        if not re.search(r'/\w*NEW\w*/[^/]+Controller\.java$', path):
            continue
        text = open(path, errors='ignore').read()
        fields = {f.group(3): {'type': f.group(2), 'autowired': bool(f.group(1).strip())} for f in FIELD.finditer(text)}
        for m in MAPPING.finditer(text):
            params = {'request': {}, 'path': 0, 'body': False}
            for p in split_params(m.group(5)):
                rq = re.match(r'@RequestParam\(name\s*=\s*"([^"]*)"\)\s*(.+?)\s+\w+$', p)
                if rq:
                    params['request'][rq.group(1)] = rq.group(2).strip()
                elif p.startswith('@PathVariable'):
                    params['path'] += 1
                elif p.startswith('@RequestBody'):
                    params['body'] = True
            delegate = re.search(r'(\w+)\.(\w+)\s*\(', m.group(6))
            endpoints.append({
                'service': svc, 'file': os.path.relpath(path, root), 'verb': m.group(1).upper(),
                'path': m.group(2), 'return': m.group(3).strip(), 'name': m.group(4), 'params': params,
                'delegate_field': delegate.group(1) if delegate else None,
                'delegate_method': delegate.group(2) if delegate else None, 'fields': fields,
            })
    return endpoints


def find_type(root, simple):
    for path in java_files(root):
        if os.path.basename(path) == simple + '.java' and not (re.search(r'/\w*NEW\w*/', path) and path.endswith('Controller.java')):
            return open(path, errors='ignore').read()
    return None


SIMPLE = {'byte', 'short', 'int', 'long', 'float', 'double', 'boolean', 'char', 'Byte', 'Short', 'Integer',
          'Long', 'Float', 'Double', 'Boolean', 'Character', 'String', 'BigDecimal', 'BigInteger'}


def bindable(t):
    """Can a value of this type travel as a URL query parameter and be bound back?"""
    t = t.strip()
    inner = re.match(r'(?:List|Set|Collection)<(\w+)>$', t)
    return t in SIMPLE or bool(inner and inner.group(1) in SIMPLE)


def runtime_problems(call, ep, root):
    """Non-compilation reasons a call whose contract matches would still fail at run time."""
    problems = []
    for name, stype in sorted(ep['params']['request'].items()):
        if not bindable(stype):
            problems.append('%s object sent as a query-string parameter (cannot be bound)' % raw(stype))
            break
    field = ep['fields'].get(ep['delegate_field'])
    if field is None:
        return problems + ['delegate field not found']
    if not field['autowired']:
        problems.append('delegate field not injected (@Autowired missing)')
    src = find_type(root, raw(field['type']))
    if src is None:
        return problems + ['delegate type %s not in service' % raw(field['type'])]
    if re.search(r'/\w*NEW/', ep['file']):
        # entity-relationship endpoint: Controller -> generated Service -> new repository method
        repo_call = re.search(r'%s\s*\([^)]*\)\s*\{[^}]*?(\w+)\.(\w+)\s*\(' % re.escape(ep['delegate_method']), src)
        problems.append('repository method %s has no query or implementation' % (repo_call.group(2) if repo_call else '?'))
    elif not re.search(r'\b%s\s*\(' % re.escape(ep['delegate_method']), src):
        if re.search(r'extends\s+(Jpa|Crud|PagingAndSorting)Repository|extends\s+BaseMapper|extends\s+IService', src):
            problems.append('inherited %s.%s (signature unknown to MicroRefact)' % (raw(field['type']), ep['delegate_method']))
        else:
            problems.append('delegate method %s.%s not found' % (raw(field['type']), ep['delegate_method']))
    return problems


def originally_static(app, type_name, method):
    for path in glob.glob(os.path.join(INPUTS, app, 'monolith', '**', type_name + '.java'), recursive=True):
        if re.search(r'\bstatic\b[^;{()=]*\b%s\s*\(' % re.escape(method), open(path, errors='ignore').read()):
            return True
    return False


def analyze(app_dir):
    meta = json.load(open(os.path.join(app_dir, 'run/proposal.json.meta.json')))
    index = meta['cluster_index_to_service']
    cand = os.path.join(app_dir, 'candidate')
    services = sorted(os.listdir(cand))
    calls, endpoints = [], collections.defaultdict(list)
    for svc in services:
        calls += parse_clients(svc, os.path.join(cand, svc))
        for ep in parse_servers(svc, os.path.join(cand, svc)):
            endpoints[svc].append(ep)
    results = []
    for c in calls:
        issues = []
        target = index.get(c['host'])
        ep = None
        if target is None:
            issues.append('target: host "%s" is not a cluster index' % c['host'])
        elif target == c['client_service']:
            issues.append('target: calls its own service')
        else:
            same = [e for e in endpoints[target] if c['path'] and norm_path(e['path']) == norm_path(c['path'])]
            hits = [e for e in same if e['verb'] == c['verb']]
            if not same:
                issues.append('endpoint: no %s %s in %s' % (c['verb'], c['path'], target))
            elif not hits:
                issues.append('endpoint: path exists in %s but with %s' % (target, '/'.join(sorted({e['verb'] for e in same}))))
            elif len(hits) > 1:
                issues.append('endpoint: %d endpoints share %s %s in %s' % (len(hits), c['verb'], c['path'], target))
                ep = hits[0]
            else:
                ep = hits[0]
        if ep:
            sp = ep['params']
            if sorted(c['query']) != sorted(sp['request']):
                issues.append('params: client sends %s, server expects %s' % (c['query'], sorted(sp['request'])))
            if c['uri_vars'] != sp['path']:
                issues.append('params: %d path variables sent, %d expected' % (c['uri_vars'], sp['path']))
            if c['body'] != sp['body']:
                issues.append('params: request body %s by client, %s by server' % (
                    'sent' if c['body'] else 'not sent', 'expected' if sp['body'] else 'not expected'))
            if 'Object' in c['query'] or 'Object' in sp['request'] or raw(c['return']) == 'Object' or raw(ep['return']) == 'Object':
                issues.append('types: Object placeholder (method signature unknown to MicroRefact)')
            else:
                for qname, qtype in zip(c['query'], c['query_types']):
                    stype = sp['request'].get(qname)
                    if stype and qtype != '?' and raw(qtype) != raw(stype):
                        issues.append('types: %s is %s at client, %s at server' % (qname, qtype, stype))
                if c['verb'] == 'GET' and raw(c['return']) != raw(ep['return']):
                    issues.append('types: client reads %s, server returns %s' % (c['return'], ep['return']))
        r = dict(c, target_service=target, server_endpoint=(ep['file'] + '#' + ep['name']) if ep else None,
                 contract_ok=not issues, contract_issues=issues,
                 runtime_problems=runtime_problems(c, ep, os.path.join(cand, target)) if ep and not issues else [])
        if ep and not issues:
            field = ep['fields'].get(ep['delegate_field'])
            r['original_method_static'] = bool(field) and originally_static(
                os.path.basename(app_dir), raw(field['type']), ep['delegate_method'])
        results.append(r)
    json.dump(results, open(os.path.join(app_dir, 'run/communication.json'), 'w'), indent=2)
    return results


def main():
    root = sys.argv[1] if len(sys.argv) > 1 else os.path.join(os.path.dirname(__file__), '..', 'baseline-outputs')
    total = collections.Counter()
    reasons = collections.Counter()
    runtime = collections.Counter()
    print('| app | calls | contract matches | of which target is a static method | ...and no run-time blocker |')
    print('|---|---|---|---|---|')
    for app in sorted(os.listdir(root)):
        res = analyze(os.path.join(root, app))
        ok = [r for r in res if r['contract_ok']]
        clean = [r for r in ok if not r['runtime_problems']]
        static = sum(1 for r in ok if r.get('original_method_static'))
        print('| %s | %d | %d | %d | %d |' % (app, len(res), len(ok), static, len(clean)))
        total.update(static=static)
        total.update(calls=len(res), ok=len(ok), clean=len(clean))
        for r in res:
            for i in r['contract_issues']:
                reasons[re.sub(r'"[^"]*"|\S+-service|\b[a-z]+-[a-z-]+\b|/\S*|\[[^\]]*\]|\d+', '…', i)] += 1
            for p in r['runtime_problems']:
                runtime[re.sub(r'^\S+ object|\S+\.\S+|\bdelegate type \S+|method \w+ has', lambda m: 'X object' if m.group(0).endswith('object') else ('method … has' if m.group(0).startswith('method') else '…'), p)] += 1
    print('| total | %d | %d | %d | %d |' % (total['calls'], total['ok'], total['static'], total['clean']))
    print('\ncontract issues:')
    for k, v in reasons.most_common():
        print('  %4d  %s' % (v, k))
    print('\nrun-time problems among matching calls:')
    for k, v in runtime.most_common():
        print('  %4d  %s' % (v, k))


if __name__ == '__main__':
    main()
