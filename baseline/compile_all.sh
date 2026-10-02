#!/usr/bin/env bash
# Compile the original monolith (control) and every candidate service, each with the
# application's own JDK (column 4 of baseline/apps.tsv), using `mvn compile` unchanged.
# Builds run on copies under $WORK so no target/ directories land in the repository.
# usage: baseline/compile_all.sh [app ...]
set -uo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
WORK="${WORK:-${TMPDIR:-/tmp}/microrefact-compile}"
TIMEOUT="${TIMEOUT:-1800}"
# Build switches applied identically to monolith and candidates: they only skip plugins
# that need a git checkout or a frontend toolchain, never Java compilation.
MVN_FLAGS=(-B -DskipTests -Dmaven.gitcommitid.skip=true -Dskip.npm -Dskip.yarn -Dskip.installnodenpm -Dskip.installnodeyarn)

build() {  # <dir> <jdk> <log>
  (cd "$1" && JAVA_HOME="/usr/lib/jvm/java-$2-openjdk-amd64" PATH="/usr/lib/jvm/java-$2-openjdk-amd64/bin:$PATH" \
     timeout "$TIMEOUT" mvn "${MVN_FLAGS[@]}" compile) > "$3" 2>&1 || { [ $? -eq 124 ] && echo TIMEOUT >> "$3"; }
}

wanted=" $* "
while IFS=$'\t' read -r app mono lang jdk; do
  [[ -z "$app" || "$app" == \#* ]] && continue
  [[ $# -gt 0 && "$wanted" != *" $app "* ]] && continue
  out="$ROOT/baseline-outputs/$app/compile"
  rm -rf "$out" "$WORK/$app"; mkdir -p "$out" "$WORK/$app"

  cp -r "$ROOT/baseline-inputs/$app/monolith" "$WORK/$app/monolith"
  build "$WORK/$app/$mono" "$jdk" "$out/monolith.log"

  for svc in $(ls "$ROOT/baseline-outputs/$app/candidate"); do
    cp -r "$ROOT/baseline-outputs/$app/candidate/$svc" "$WORK/$app/svc-$svc"
    build "$WORK/$app/svc-$svc" "$jdk" "$out/$svc.log"
  done
  gzip -f "$out"/*.log
  python3 "$ROOT/baseline/summarize_compile.py" "$out" > /dev/null
  echo "== $app (JDK $jdk)"; cut -f1-3 "$out/summary.tsv"
done < "$ROOT/baseline/apps.tsv"
