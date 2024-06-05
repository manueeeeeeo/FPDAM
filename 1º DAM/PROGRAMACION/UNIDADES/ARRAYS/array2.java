package arrays;

import java.util.Scanner;

public class Array2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Declaro el array
		int [] num = new int[10];
		int contadorpos = 0;
		int contadorneg = 0;
		int contador0 = 0;
		
		//Para que el usuario rellene los datos
		for(int i=0;i<num.length;i++) {
			System.out.print("Digame un número: ");
			num[i] = teclado.nextInt();
		}
		
		//Para obtener los numeros y saber cuantos pos,neg, y 0 hay
		for(int j=0;j<num.length;j++) {
			if(num[j]>0) {
				contadorpos++;
			}else if(num[j]<0) {
				contadorneg++;
			}else {
				contador0++;
			}
		}
		if(contadorpos>0) {
			System.out.println("El número de valores positivos es: "+contadorpos);
		}
		if(contadorneg>0) {
			System.out.println("El número de valores positivos es: "+contadorneg);
		}
		if(contador0>0) {
			System.out.println("El número de valores positivos es: "+contador0);
		}
		teclado.close();
	}
}
