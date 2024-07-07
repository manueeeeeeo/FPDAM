const sumarNum = (num)=>{
    let suma = 0;
    for(let i = 0;i<num.length;i++){
        suma+=num[i];
    }
    return suma;
}

const promedio = (num, suma)=>{
    let prom = 0;
    prom = parseFloat(suma/num.length);
    return prom;
}

const numMayor = (num)=>{
    let aux = 0;
    for(let i = 0;i<num.length;i++){
        if(num[i]>aux){
            aux = num[i];
        }
    }
    return aux;
}

const numMenor = (num, may)=>{
    let aux = may;
    for(let i = 0;i<num.length;i++){
        if(num[i]<aux){
            aux = num[i];
        }
    }
    return aux;
}

let numeros = new Array(4,6,3,7,2,65,7,3);
let suma1 = sumarNum(numeros);
document.write("La suma de todos los números del array es: "+suma1);
let prome = promedio(numeros, suma1);
document.write("<br>El promedio de todos los números del array es: "+prome);
let mayor = numMayor(numeros);
document.write("<br>El número mayor del array es: "+mayor);
let menor = numMenor(numeros, mayor);
document.write("<br>El número mayor del array es: "+menor);
