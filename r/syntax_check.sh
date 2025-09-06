#!/bin/bash

FAILED=0
for f in $(find r -iname "*.r"); do
    echo "Checking syntax in $f ..."
    Rscript -e "invisible(parse(file='$f'))" 2>/dev/null
    if [ $? -eq 0 ]; then
        echo "$f: Syntax OK"
    else
        echo "$f: Syntax ERROR"
        FAILED=$((FAILED+1))
    fi
done

if [ $FAILED -ne 0 ]; then
    echo "$FAILED file(s) have syntax errors."
    exit 1
else
    echo "All files passed syntax check!"
fi
