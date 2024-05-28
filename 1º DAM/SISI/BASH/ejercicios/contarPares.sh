#!/bin/bash

pares=""
impares=""

echo "Hasta que númeo quieres llegar:"
read resp

for((i=0; i<=$resp; i++))
do
        if [ $((i%2)) -eq 0 ]; then
                pares="$pares $i"
        elif [ $((i%2)) -eq 1 ]; then
                impares="$impares $i"
        fi
done
echo "Números pares: "
echo "$pares"
echo "Números impares: "
echo "$impares"
