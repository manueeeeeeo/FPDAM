#!/bin/bash

#Para crear el documento
if [ -e "ejemplo.txt" ]; then
	echo "Ya esta creado"
else
	touch "ejemplo.txt"
	echo "Hola, Mundo!" >> "ejemplo.txt"
	echo "Esto es un fichero de ejemplo" >> "ejemplo.txt"
	echo "¡Adiós!" >> "ejemplo.txt"
fi

#Para cambiar el fchero por ejemplo

sed -i "s/fichero/archivo/" ejemplo.txt
