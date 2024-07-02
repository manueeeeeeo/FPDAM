const boton = document.getElementById('enviar');
const resul = document.getElementById('total');

boton.addEventListener("click", calculo);

function calculo (){
    let pre = document.getElementById('precio').value; //Obtengo el valor del precio
    let cant = document.getElementById('cantidad').value; //Obtengo la cantidad de veces que quiero el producto
    console.log(parseFloat(pre)*parseFloat(cant));
    resul.value = parseFloat(pre)*parseFloat(cant) //Lo multiplico y le estblezco ese valor al input del resultado
}
