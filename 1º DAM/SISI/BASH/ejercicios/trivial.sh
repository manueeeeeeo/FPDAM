#!/bin/bash
echo "TRIVIAL"
echo ""
echo "Introduce tu nombre: "
read nombre

if [ -e "Participantes.txt" ]; then
        echo ""
        arch="Participantes.txt"
        if [[ $(grep -i "$nombre" "$arch") ]]; then
                echo "Ese nombre ya existe"
                echo "Quieres modificar la puntucación: "
                read mod
                if [ "$mod"="S" ]; then
                        sed -i /"$nombre /d" "$arch"
                fi
        fi
else
        touch Participantes.txt
fi
function preguntas {
        p=0
        echo "Pregunta 1. ¿Que número llevaba raul en el real madrid?"
        read re
        if [ $re -eq "7" ]; then
                ((p++))
        fi
        echo "Pregunta 2. ¿Nombre del personaje principal de Dragon Ball?"
        read re
        if [ $re = "Goku" ]; then
                ((p++))
        fi
        echo "Pregunta 3. ¿Cuantas peliculas hay de SAW?"
        read re
        if [ $re = "10" ]; then
                ((p++))
        fi
        echo "Pregunta 4. ¿Capital de Toledo?"
        read re
        if [ $re = "Talavera" ]; then
                ((p++))
        fi
        echo "Pregunta 5. ¿Cuál es la capital de macedonia?"
        read re
        if [ $re = "Skopje" ]; then
                ((p++))
        fi
        echo "Pregunta 6. ¿Cual es la moneda oficial de japón?"
        read re
        if [ $re = "Yen" ]; then
                ((p++))
        fi
        echo "Pregunta 7. ¿Cuantos mundiales tiene españa?"
         read re
         if [ $re = "1" ]; then
                 ((p++))
         fi
         echo "Pregunta 8. ¿Cual fue el primer metal que el hombre empleo?"
         read re
         if [ $re = "Cobre" ]; then
                 ((p++))
         fi
         echo "Pregunta 9. ¿Cuál es el lugar más frio de la tierra?"
         read re
         if [ $re = "Antartida" ]; then
                 ((p++))
         fi
         echo "Pregunta 10. Formula quimica del agua"
         read re
         if [ $re = "H20" ]; then
                 ((p++))
         fi
         echo ""
         echo "Has adivinido $p preguntas"
 
         echo "El jugador $nombre ha obtenido $p puntos" >> Participantes.txt
}
echo ""
echo "Quieres jugar? S/N"
read resp

case "$resp" in
        [Ss]*)
        preguntas
        ;;
        [Nn]*)
        exit;;
        *)
                echo "Introduce un valor posible S/N"
        ;;
        esac
