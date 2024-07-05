const concatenar = () =>{
    do{
        let respuesta = prompt("Introduce una cadena");
        cadena = cadena + "-" + respuesta; // Concatenas las variables para que al final te de el resutado
    }while(confirm("Quieres introducir otra cadena")); // Que haga el bucle mientras que sigas queriendo meter cadenas
}

let cadena=prompt("Introduce una cadena"); // Le damos un valor por pantalla a la variable cadena

concatenar();

alert(cadena); // Imprimimos el resultado
