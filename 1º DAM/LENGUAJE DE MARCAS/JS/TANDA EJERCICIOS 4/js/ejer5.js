const numeroCuadrado = (n) =>{
    let cuadrado = 0;
    cuadrado = Math.pow(n,2);
    return cuadrado;
}

const numeroCubo = (n) =>{
    let cubo = 0;
    cubo = Math.pow(n,3);
    return cubo;
}

let num = prompt("Digame un número: ");
let n = numeroCuadrado(num);
let c = numeroCubo(num);
document.write("El cuadrado de "+num+" es: "+n);
document.write("<br>El cubo de "+num+" es: "+c);
