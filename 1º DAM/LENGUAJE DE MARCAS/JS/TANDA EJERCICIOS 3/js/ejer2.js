const determianrNota = (nota)=>{
    if(nota>=0 && nota<=10){
        if(nota>=0 && nota<3){ // Lo que pasa si la nota no está entre 0 y 3
            alert("Muy Deficiente");
        }else if(nota>=3 && nota<5){ // Lo que pasa si la nota no está entre 3 y 5
            alert("Insuficiente");
        }else if(nota>=5 && nota<6){ // Lo que pasa si la nota no está entre 5 y 6
            alert("Suficiente");
        }else if(nota>=6 && nota<7){ // Lo que pasa si la nota no está entre 6 y 7
            alert("Bien");
        }else if(nota>=7 && nota <9){ // Lo que pasa si la nota no está entre 7 y 9
            alert("Notable");
        }else{ // Lo que pasa si la nota no está entre 9 y 10
            alert("Sobresaliente");
        }
    }else{ // Lo que pasa si la nota no está entre 0 y 10
        alert("Esa nota no está en la escala");
    }
}

let nota = prompt("Dime una notad el 0 al 10: ");

determianrNota(nota);
