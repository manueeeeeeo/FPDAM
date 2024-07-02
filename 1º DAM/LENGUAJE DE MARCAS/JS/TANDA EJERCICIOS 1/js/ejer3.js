const espacio = document.getElementById('efecto');
const primero = document.getElementById('pasar');

primero.addEventListener("mouseover", cambiarColor); //Si el ratón está encima cambiamos el color
primero.addEventListener("mouseout", volverColor); //Si sale de encima volvemos al color principal

function cambiarColor () {
    espacio.style.backgroundColor = 'green';
    espacio.style.color = 'white';
}

function volverColor () {
    espacio.style.backgroundColor = 'white';
    espacio.style.color = 'black';
}
