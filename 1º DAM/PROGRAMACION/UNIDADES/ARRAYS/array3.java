package arrays;

import java.util.Scanner;

public class Array3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Declaro losa arrays
		int [] numero = new int [10];
		int contadorpos = 0;
		int contadorneg = 0;
		int sumapos = 0;
		int sumaneg = 0;
		int media = 0;
		
		//Para introducir los números
		for(int i=0; i<numero.length;i++) {
			System.out.print("Digame el valor del número: ");
			numero[i] = teclado.nextInt();
			media++;
		}
		
		//Para la media de los positivos y negativos
		for(int  j=0; j<numero.length;j++) {
			if(numero[j]>0) {
				contadorpos++;
				sumapos += numero[j];
			}else if(numero[j]<0) {
				contadorneg++;
				sumaneg += numero[j];
			}
		}
		System.out.println("La suma de los positivos introducidos es: "+sumapos);
		System.out.println("La media de los positivos introducidos es: "+(sumapos/numero.length));
		System.out.println("La suma de los negativos introducidos es: "+sumaneg);
		System.out.println("La media de los negativos introducidos es: "+(sumaneg/numero.length));
		teclado.close();
	}
}
