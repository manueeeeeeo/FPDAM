package ejercicios;

import java.util.Scanner;

public class Primos {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Declaro las variables
		int num1 = 0;
		int num2 = 0;
		int contador = 0;
		int primos = 0;
		int saberprimos = 0;

		while (num1 < 0 || num2 < 0 || num1 == num2) {
			System.out.print("Digame el primer número: ");
			num1 = teclado.nextInt();
			System.out.print("Digame el segundo número: ");
			num2 = teclado.nextInt();
		}

		saberprimos = saberprimos(num1, num2, contador, primos);
		System.out.println("Hay " + saberprimos + " primos entre los dos números");
		teclado.close();
	}

	public static int saberprimos(int a, int b, int cont, int primos) {
		if (a > b) {
			for (int i = b; i < a; i++) {
				cont = 0;
				for (int j = 1; j < a; j++) {
					if (i % j == 0) {
						cont++;
					}
				}
				if (cont == 2) {
					primos++;
				}
			}
		} else if (b > a) {
			for (int i = a; i < b; i++) {
				cont = 0;
				for (int j = 1; j < b; j++) {
					if (i % j == 0) {
						cont++;
					}
				}
				if (cont == 2) {
					primos++;
				}
			}
		}else {
			System.out.println("Lo números son iguales no puedo darte el resultado");
		}
		return (primos);
	}
}
