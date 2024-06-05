package arrays;

import java.util.Scanner;

public class Array7 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Declaro los arrays
		String[] conductor = new String[4];
		int[] km = new int[4];
		int kmtotal = 0;

		for (int i = 0; i < conductor.length; i++) {
			System.out.print("Digame el nombre del conductor: ");
			conductor[i] = teclado.next();
			System.out.print("Digame el Nº de Km que ha hecho este més " + conductor[i] + ": ");
			km[i] = teclado.nextInt();
			kmtotal += km[i];
		}
		System.out.println();

		for (int j = 0; j < conductor.length; j++) {
			System.out.println("El conductor "+conductor[j]+" hizo "+km[j]+" Km este més");
		}
		System.out.println();
		System.out.println("El número total de Km este més fued de: "+kmtotal);
		teclado.close();
	}
}
