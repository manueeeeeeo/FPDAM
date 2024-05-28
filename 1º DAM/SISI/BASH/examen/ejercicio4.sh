#!/bin/bash

function menu {
echo "1) Sumar"
echo "2) Restar"
echo "3) Multiplicar"
echo "4) Dividir"
echo ""
}

echo "Introduzca el primer número: "
read num1
echo "Introduzca el seundo número: "
read num2

function sumar {
var=$(($num1+$num2))
echo "La suma es: $var"
}

function resta {
var=$(($num1-$num2))
echo "La resta es: $var"
}

function mult {
var=$(($num1*$num2))
echo "La mutiplicacion es: $var"
}

function div {
var=$(($num1/$num2))
echo "La divison es: $var"
}

menu
echo "Que opción eliges:"
read op

case "$op" in
	"1" )
	 sumar
	;;
	"2" )
	resta
	;;
	"3" )
	mult
	;;
	"4" )
	div
	;;
	* )
	;;
esac
