let n = prompt("Digame un valor: ");
let fac = 0;

for (let i = 1; i<=n; i++){
    if (i==1){
        fac = i;
    }else{
        fac = fac*i;
    }
}
alert("5! es igual a: "+fac)
