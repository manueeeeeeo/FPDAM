package ejercicios;

import java.util.Scanner;

public class SaberSiEsPrimo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Declaro las variables
		int num = 0;
		int primo = 0;
		int contador = 0;

		System.out.print("Digame el valor del número: ");
		num = teclado.nextInt();

		primo = esprimo(num, contador, primo);
		if (primo == 1) {
			System.out.println("Es primo");
		} else {
			System.out.println("No es primo");
		}
		teclado.close();
	}

	private static int esprimo(int num, int cont, int primo) {
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				cont++;
			}
		}
		if (cont == 2) {
			primo++;
		}
		return (primo);
	}
}
