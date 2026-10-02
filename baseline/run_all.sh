#!/usr/bin/env bash
# Generate MicroRefact candidates for the input-kit applications.
# usage: baseline/run_all.sh [app ...]   (default: every app in baseline/apps.tsv)
set -uo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
PARSER="$ROOT/app/javaParser"
INPUTS="$ROOT/baseline-inputs"
OUTPUTS="$ROOT/baseline-outputs"

if [ ! -f "$PARSER/target/symbolsolver-1.0.jar" ]; then
  (cd "$PARSER" && mvn -q -B package -DskipTests) || { echo "parser build failed"; exit 1; }
fi

# app/javaParser/output.json is a tracked file of the original repo; keep it unchanged
saved_ast="$(mktemp)"; cp "$PARSER/output.json" "$saved_ast" 2>/dev/null
trap 'cp "$saved_ast" "$PARSER/output.json" 2>/dev/null; rm -f "$saved_ast"' EXIT

wanted=" $* "
summary=()
while IFS=$'\t' read -r app mono lang jdk; do
  [[ -z "$app" || "$app" == \#* ]] && continue
  [[ $# -gt 0 && "$wanted" != *" $app "* ]] && continue
  src="$INPUTS/$app/$mono"
  out="$OUTPUTS/$app"
  name="ik__$app"
  rm -rf "$out" "$ROOT/app/Results/$name"
  mkdir -p "$out/run" "$out/candidate"
  export MR_LANG_LEVEL="$lang" PYTHONHASHSEED=0 MR_STATS_CSV="$out/run/stats.csv"

  # 1. parse once to know which types the parser emits (main.py re-parses identically)
  rm -f "$PARSER/output.json"
  (cd "$PARSER/target" && java -cp symbolsolver-1.0.jar Main "$src") > "$out/run/parse.log" 2>&1
  # 2. decomposition -> MicroRefact proposal
  python3 "$ROOT/baseline/convert.py" --decomposition "$INPUTS/$app/decomposition.json" \
    --ast "$PARSER/output.json" --source "$src" --name "$name" --out "$out/run/proposal.json" \
    > "$out/run/convert.log" 2>&1
  # 3. MicroRefact itself
  start=$(date +%s)
  python3 "$ROOT/baseline/run_seeded.py" -c "$out/run/proposal.json" -pp "$src" > "$out/run/microrefact.log" 2>&1
  rc=$?
  secs=$(( $(date +%s) - start ))

  # 4. collect: numbered clusters get their service name; extra services MicroRefact adds keep theirs
  if [ -d "$ROOT/app/Results/$name" ]; then
    python3 - "$ROOT/app/Results/$name" "$out/candidate" "$out/run/proposal.json.meta.json" <<'PY'
import json, os, shutil, sys
results, candidate, meta = sys.argv[1:]
names = json.load(open(meta))['cluster_index_to_service']
for d in sorted(os.listdir(results)):
    shutil.move(os.path.join(results, d), os.path.join(candidate, names.get(d, d)))
os.rmdir(results)
PY
  fi
  [ -f "$ROOT/app/domain$name.puml" ] && mv "$ROOT/app/domain$name.puml" "$out/run/domain.puml"
  gzip -f "$out/run/microrefact.log" "$out/run/parse.log"
  files=$(find "$out/candidate" -name '*.java' | wc -l)
  printf '{"app":"%s","exit_code":%d,"seconds":%d,"parser_language_level":"%s","compile_jdk":"%s","services":%s,"java_files":%d}\n' \
    "$app" "$rc" "$secs" "$lang" "$jdk" "$(ls "$out/candidate" | python3 -c 'import sys,json;print(json.dumps(sys.stdin.read().split()))')" "$files" \
    > "$out/run/result.json"
  summary+=("$(cat "$out/run/result.json")")
  echo "$app rc=$rc ${secs}s java_files=$files services=$(ls "$out/candidate" | tr '\n' ' ')"
done < "$ROOT/baseline/apps.tsv"
