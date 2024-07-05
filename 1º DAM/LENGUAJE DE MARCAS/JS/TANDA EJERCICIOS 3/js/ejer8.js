const calcularFactorial = () =>{
    for (let i = 1; i<=n; i++){
        if (i==1){
            fac = i;
        }else{
            fac = fac*i;
        }
    }
}

let n = prompt("Digame un valor: ");
let fac = 0;
calcularFactorial();
alert("5! es igual a: "+fac)
