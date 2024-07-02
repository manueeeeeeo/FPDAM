/*
PARTE A
Prueba el ejercicio primero utilizando este trozo de código
Luego coméntalo, descomenta el trozo de código de abajo 
y pruébalo de nuevo
*/

const button = document.querySelector("button");

button.onclick = function () {
    alert("Hello!");
}

/******************************************/

/*
PARTE B
¿Qué diferencia encuentras entre este código (PARTE B)
y el de la PARTE de arriba (PARTE A)?
*/
/*Primero que todo en la parte A no se ejecuta ya que no se está cargando el archivo al iniciar
el progrma, sino mientras en el apartado b estamos usando el DOMContentLoaded para que si
que se cargue la función al iniciar la página*/

/*document.addEventListener("DOMContentLoaded", function() {
    
const button = document.querySelector("button");
button.onclick = function () {
    alert("Hello!");
}

});*/


<!DOCTYPE html>
<html>

<head>
    <title>HTML DOM Events</title>
</head>

<body>
    <button>Saludar</button>

    <script>
        const button = document.querySelector("button");
        button.onclick = function () {
            alert("Hello!");
        }
    </script>
/* Por otro lado este script al tener el script en la parte de abajo del body si que funciona
ya que no lo carga al incio de iniciar la página, sino al final y por eso si que podemos usarlo*/
</body>

</html>
