const determinarEdad = (edad) =>{
    if(edad>=18){ // Saber si es mayor de 18 y lo que pasa si es así o si no lo es
        return(alert("Si que puedes conducir"));
    }else{
        return(alert("No puedes conducir"));
    }
}

let edad = prompt("Introduce tu edad: "); // Le damos el valor por pantalla a edad

determinarEdad(edad);
