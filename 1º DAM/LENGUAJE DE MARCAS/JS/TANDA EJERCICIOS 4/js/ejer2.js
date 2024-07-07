const cambiarPos = (pos1, pos2)=>{
    let aux = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = aux;
    //Sustituimos al aux por uno, le cambiamos por otro y luego le damos
    //ese valor a la pos dos
}

let arr = new Array (1,2,3);
let pos1 = prompt("Que indice quieres cambiar?");
let pos2 = prompt("Por que posición?");

cambiarPos(pos1, pos2);

for(let i = 0;i<arr.length;i++){
    document.write(arr[i]+" ");
}
