const sumar = () =>{
    while(confirm("Quieres introducir más números?")){ // Mientras que sigamos queriendo meter números hacemos el bucle
        let num = prompt("Introduce un número");
        if(num.match("[A-Z a-z]")){ // Comrpobamos que la variable no contenga una letra y lo que pasa
            alert("Eso no es un número");
        }else{ // En caso de que sean números los sumamos
            sum = sum + parseInt(num);
        }
    }
}

let sum = 0; // Inicializamos una variable = 0

sumar();

alert("La suma es: "+sum); // Imprimimos el resultado de la suma
