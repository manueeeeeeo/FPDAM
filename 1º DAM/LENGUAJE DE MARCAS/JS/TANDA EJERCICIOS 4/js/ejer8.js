const quitarRepes =(array) =>{
    let auxae = [];
    let cont = 0;
    for(let i = 0;i<array.length;i++){
        for (let j=0;j<array.length;j++){
            if(array[i]==array[j]){
                cont++;
            }
        }
        if(cont===1){
            auxae[i]=array[i];
        }
        cont = 0;
    }
    return auxae;
}

let arr = new Array(3,4,5,6,3,4,9,1,2);
let arrayNuevo = quitarRepes(arr);
document.write("<h1>El array con los repes quitados queda: </h1>");
arrayNuevo.forEach(element => {
    document.write(element+" ");
});
