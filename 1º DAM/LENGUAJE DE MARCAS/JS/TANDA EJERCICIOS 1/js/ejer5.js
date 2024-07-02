const cuadrado = document.getElementById('cuadrado');

document.addEventListener("DOMContentLoaded", function() {
    cuadrado.addEventListener("mouseover", ponerRojo);
    cuadrado.addEventListener("mouseout", ponerNormal);
    function ponerRojo(){
        cuadrado.style.background = 'red';
    }
    
    function ponerNormal(){
        cuadrado.style.background = 'white';
    }
});
