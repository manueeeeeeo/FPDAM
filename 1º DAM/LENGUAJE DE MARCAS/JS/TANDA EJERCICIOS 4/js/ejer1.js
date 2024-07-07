const bucleWhile = (num)=>{
    //Iterar con un while
    let contador = 0;
    document.write("<h2>Iterar con bucle while:</h2>");
    while(contador<num.length){
        document.write(num[contador]+" ");
        contador++;
    }
}

const bucleFor = (num)=>{
    document.write(" <br> <h2>Iterar con bucle for:</h2>");
    for(var i=0;i<num.length;i++){
        document.write(num[i]+" ");
    }
}

const bucleForEach = (num)=>{
    document.write(" <br> <h2>Iterar con bucle forEach:</h2>");
    num.forEach(element => {
        document.write((element)+" ");
    });
}

const forSumando1 = (num)=>{
    document.write(" <br> <h2>Iterar con bucle y sumando uno a cada elemento:</h2>");
    for(var i = 0;i<num.length;i++){
        document.write(num[i]+1+" ");
    }
}

const guardarArr = (num) =>{
    document.write(" <br> <h2>Guar en un nuevo array:</h2>");
    let arraynuevo = num;
    for(let i = 0;i<num.length;i++){
        arraynuevo[i]+=1;
        document.write(arraynuevo[i]+" ");
    }
}

const numAlea = ()=>{
    document.write(" <br> <h2>Crear numeros aleatorios:</h2>");
    let randi = [];
    for(let i = 0;i<20;i++){
        randi[i]=parseInt(Math.random() * 100 + 1);
        document.write(randi[i]+" ");
    }
}

const numAleaN = () =>{
    document.write(" <br> <h2>Crear numeros aleatorios N veces:</h2>");
    let n = parseInt(prompt("Cuantos números quieres introducir?"));
    let randi2 = [];
    for(let i = 0;i<n;i++){
        randi2[i]=parseInt(Math.random()*100+1);
        document.write(randi2[i]+" ");
    }
}

const comprobarColor=()=>{
    document.write(" <br> <h2>Saber si el introducido está en el arrray:</h2>");
    let resp = prompt("Digame color:");
    let con = 0;
    let colores = new Array("azul", "amarillo", "rojo", "verde", "café", "rosa");
    for(let i = 0;i<colores.length;i++){
        if (resp === colores[i]){
            con++;
        }
    }
    if(con>0){
        document.write("El color "+resp+" si que aparece en el array");
    }else{
        document.write("El color "+resp+" no que aparece en el array");
    }
}

let numeros = new Array(1,2,3,4,5,6);
bucleWhile(numeros);
bucleFor(numeros);
bucleForEach(numeros);
forSumando1(numeros);
guardarArr(numeros);
numAlea();
numAleaN();
comprobarColor();
