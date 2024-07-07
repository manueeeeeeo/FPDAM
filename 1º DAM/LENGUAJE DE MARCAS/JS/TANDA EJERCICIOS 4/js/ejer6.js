const sumar = (n1, n2)=>{
    let suma = parseInt(n1)+parseInt(n2);
    return suma;
}

const restar = (n1, n2)=>{
    let resta = parseInt(n1)-parseInt(n2);
    return resta;
}

const multiplicar = (n1, n2)=>{
    let multi = parseInt(n1)*parseInt(n2);
    return multi;
}

const dividir = (n1, n2)=>{

}

let num1 = prompt("Digame el primer número");
let num2 = prompt("Digame el segundo número");

/*Variables*/
let sum = sumar(num1, num2);
let rest = restar(num2, num2);
let mul = multiplicar(num1, num2);

/*Escribir*/
document.write("La suma de "+num1+" y "+num2+" es: "+sum);
document.write("<br>La resta de "+num1+" y "+num2+" es: "+rest);
document.write("<br>La multiplicación de "+num1+" y "+num2+" es: "+mul);
