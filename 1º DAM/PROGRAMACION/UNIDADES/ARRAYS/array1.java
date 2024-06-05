package arrays;

import java.util.Scanner;

public class Array1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Declaración array
		int [] numeros = new int[10];
		
		//Pedimos los valores
		for(int i=0;i<numeros.length;i++) {
			System.out.print("Introduce un número: ");
			numeros[i] = teclado.nextInt();
		}
		
		//Imprimimos los valores
		System.out.println("Los números introducidos han sido: ");
		for(int j = 0;j<numeros.length;j++) {
			System.out.println(numeros[j]);
		}
		teclado.close();
	}
}
