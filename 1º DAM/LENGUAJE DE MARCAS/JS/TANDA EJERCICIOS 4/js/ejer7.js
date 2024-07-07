const ordenar = (num)=>{
    let numeros = [];
    cont=0;
    for(let i = num;i>=1;i--){
        numeros[cont]=i;
        cont++;
    }
    return numeros;
}

let num = prompt("Digame un número");
document.write("El array del "+num+" al 1 es: <br>");
for(let num1 of ordenar(num)){
    document.write(num1+" ");
}
