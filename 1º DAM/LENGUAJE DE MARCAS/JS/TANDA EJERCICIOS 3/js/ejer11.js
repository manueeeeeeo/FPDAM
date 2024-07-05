const comprobarDni = () =>{
// Comprobar si el número de DNI es válido
if (nume < 0 || nume > 99999999) {
    alert("Ese número no vale");
} else {
    // Calcular la letra del DNI
    let resto = nume % 23;
    let letraTocada = letras[resto];

    // Comparar la letra calculada con la letra proporcionada por el usuario
    if (letraTocada !== letra) {
        alert("La letra indicada no es correcta.");
    } else {
        alert("El número y la letra del DNI son correctos.");
    }
}
}

let letras = new Array('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E');

// Solicitar al usuario que ingrese el número de DNI y la letra del DNI
let nume = parseInt(prompt("Introduce solo los números del DNI:"));
let letra = prompt("Introduce tu letra del DNI:").toUpperCase(); // Convertir la letra a mayúsculas
comprobarDni();
