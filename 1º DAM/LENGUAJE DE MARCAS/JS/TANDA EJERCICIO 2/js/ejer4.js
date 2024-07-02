// Meses
const nombresMeses = ["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"];

// Saber si es bisiesto
function bisiesto(año){
    return (año%4===0 && año%100!==0) || año % 400 === 0;
}

let dia = parseInt(prompt("Introduce el día: "));
let mes = parseInt(prompt("Introduce el número del mes: "));
let año = parseInt(prompt("Introduce el año: "));

let diaMes = [31, bisiesto(año) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

if (año>=0 && (mes>=1 && mes<=12) && (dia >= 1 && dia <= diaMes [mes-1])){
    alert("Fecha: "+dia+" de "+nombresMeses[mes-1]+" del "+año);
}else{
    alert("La fecha no es posible de reconocer")
}
