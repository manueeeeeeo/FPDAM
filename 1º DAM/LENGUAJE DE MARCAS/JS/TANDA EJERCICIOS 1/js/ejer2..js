document.addEventListener("DOMContentLoaded", function() {
    const di = document.getElementById("area");
    di.addEventListener("click", myfunction); //Al tocar el botón llamamos a mi función

    function myfunction() {
        alert("Hola, esto es un alert");
    }
});
