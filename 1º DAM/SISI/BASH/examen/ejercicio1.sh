#!/bin/bash

#funcion del menu
function menu {
echo "1) Mostrar hora y fecha"
echo "2) Mostrar fichero"
echo "3) Salir"
}
op=0

while [ "$op" -ne "3" ]
do
 menu
 echo "Que opción quieres"
 read op
 case "$op" in
	"1")
	date
	;;
	"2")
	pwd
	;;
	"3")
	exit;;
	* )
	echo "Esa opción no está disponible"
esac
done
