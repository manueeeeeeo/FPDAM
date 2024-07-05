const saberMultiplos = () =>{
    for(let i = 1; i<=500; i++){
        if(i%4==0){
            document.write(i+"(Múltiplo de 4)");
        }else if(i%9==0){
            document.write(i+"(Múltiplo de 9)");
        }else{
            document.write(i);
        }
        cont++;
        if(cont==5){
            document.write("<br>"+"--------------------------")
            cont=0;
        }
        document.write("<br>");
    }
}

let cont = 0;

saberMultiplos();
