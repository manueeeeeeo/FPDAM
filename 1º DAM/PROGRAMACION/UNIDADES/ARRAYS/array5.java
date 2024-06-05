package arrays;

import java.util.Scanner;

public class Array5 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[] numero = new int[20];
		int[] primo = new int[20];
		int cont = 0;
		int numprimos = 0;
		System.out.println("Impresión de 20 números aleatorios: ");
		System.out.println();
		for (int i = 0; i < numero.length; i++) {
			numero[i] = (int) (Math.random() * 100);
			System.out.print(numero[i] + " ");
			System.out.println();
			cont = 0;
			numprimos = 0;
			for(int j = 1; j<numero[i];j++) {
				if(numero[i]%j==0) {
					cont++;
				}
			}
			if(cont == 2) {
				numprimos++;
			}
			if(numprimos==1) {
				primo[i] = numero[i];
			}
		}
		System.out.println();
		System.out.println("Estos son los números primos: ");
		for(int g = 0; g<primo.length;g++) {
			System.out.println(primo[g]);
		}
		teclado.close();
	}
}
