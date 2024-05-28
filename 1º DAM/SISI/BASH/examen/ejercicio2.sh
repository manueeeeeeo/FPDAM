#!/bin/bash

for i in 1 2 3 4 5
do
echo "Digame un número:"
read num
	if [ $((num%2)) -eq "0" ]; then
		echo "ES PAR"
	elif [ $((num%2)) -ne "0"  ]; then
		echo "ES IMPAR"
	fi
done
