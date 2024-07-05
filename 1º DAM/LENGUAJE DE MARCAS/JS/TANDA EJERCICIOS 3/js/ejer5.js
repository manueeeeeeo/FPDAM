const piramide = () =>{
    for (let i=1; i<=30;i++){ // Hacemos un for para ir de 1 al 30
        for(j=1;j<=i;j++){ // Imprimimos el número de veces el número que es
            document.write(i+" ");
        }
        document.write("<br>");
    }
}

piramide();
