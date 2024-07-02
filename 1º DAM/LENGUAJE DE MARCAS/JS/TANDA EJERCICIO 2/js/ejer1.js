let valores = [true, 5, false, "hola", "adios", 2];

alert("Apartado 1:");
let var1 = valores[3];
let var2 = valores[4];

if (var1.length > var2.length) {
    alert("Es mayor: "+var1);
} else if (var2.length > var1.length) {
    alert("Es mayor: "+var2);
} else {
    alert("Tinen la misma longitud");
}

alert("Apartado 2:");
let resul1 = valores[0] && valores[2];
let resul2 = valores[0] || valores[2];

alert("Resultado 1:" + resul1);
alert("Resultado 2:" + resul2);

alert("Apartado 3:");
let num1 = valores[1];
let num2 = valores[5];

alert("Suma:" + (parseInt(num1) + parseInt(num2)));
alert("Resta:" + (parseInt(num1) - parseInt(num2)));
alert("Multiplicación:" + (parseInt(num1) * parseInt(num2)));
alert("División:" + (parseInt(num1) / parseInt(num2)));
alert("Resto:" + (parseInt(num1) % parseInt(num2)));
