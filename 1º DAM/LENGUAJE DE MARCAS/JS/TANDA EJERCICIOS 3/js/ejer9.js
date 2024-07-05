const calcularPotencia = () =>{
    for (let i = 1; i <= n2; i++) {
        pot = pot * n1; 
    }
}

let n1 = prompt("Digame el primer número: ");
let n2 = prompt("Digame el exponente: ");
let pot = 1; 

calcularPotencia();

alert("La potencia de " + n1 + " es: " + pot);
