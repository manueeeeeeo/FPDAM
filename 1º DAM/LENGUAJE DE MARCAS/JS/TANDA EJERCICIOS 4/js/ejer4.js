const findIndex = (num, bus)=>{
    for(let i = 0;i<num.length;i++){
        if(num[i]===bus){
            document.write("El elemento "+bus+" ha sido encontrado en la posición "+i);
        }
    }
}

let arr = new Array(3,6,46,24,7,8);
let num = prompt("Digame el número que quiere buscar");
findIndex(arr, num);
