const campo = document.getElementById('letras'); //Obtengo el input

document.addEventListener("DOMContentLoaded", function() {
    campo.addEventListener("input", borrarNum); //Cada vez que escriba en el input hace la función de borrar números
    function borrarNum(){
        let valor =campo.value;
        let letras2 = valor.split(''); //Voy añadiendo a un array todo lo que voy escribiendo
        console.log(letras2);
        let letrasSolo = letras2.filter(caracter => isNaN(caracter)); //Voy filtrando para que no me deje escribir números en otro array
        campo.value = letrasSolo.join(''); //El valor del input se actualzia con el del array sin números
    }
});
