package MINIJUEGOS;

import java.util.Arrays;
import java.util.Scanner;

public class Bingo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Variables
		String nombre1 = "", nombre2 = "", alias1 = "", alias2 = "";
		int[] numero = new int[20];
		int[] boleto1 = new int[5];
		int[] boleto2 = new int[5];
		boolean ganador = false;
		int cont1 = 0, cont2 = 0;
		// Inicio del menu de juego
		while (nombre1.length() < 3 || nombre2.length() < 3) {
			System.out.println("********************************************************");
			System.out.print("Dime el nombre del primer participante: ");
			nombre1 = teclado.next();
			System.out.print("Dime el nombre del segundo participante: ");
			nombre2 = teclado.next();
			System.out.println("********************************************************");
		}

		getBoleto(boleto1, boleto2);
		alias1 = getAlias(nombre1);
		alias2 = getAlias(nombre2);
		System.out.println(
				"El jugador " + nombre1 + " con alias " + alias1 + " tiene el boleto " + Arrays.toString(boleto1));
		System.out.println(
				"El jugador " + nombre2 + " con alias " + alias2 + " tiene el boleto " + Arrays.toString(boleto2));
		System.out.println();
		System.out.println("COMIENZA EL JUEGO");
		System.out.println();

		// Empieza el juego
		imprimirNumeros(numero, boleto1, boleto2, alias1, alias2, cont1, cont2, ganador);
		// Mostrar todos los números
		System.out.println();
		System.out.println("Los número que han salido son: " + Arrays.toString(numero));
		teclado.close();
	}

	// Para jugar
	private static void imprimirNumeros(int[] num, int[] bol1, int[] bol2, String ali1, String ali2, int c1, int c2,
			boolean ganador) {
		int numero = 0;
		int cont = 0;
		for (int i = 0; i < num.length; i++) {
			do {
				numero = (int) (Math.random() * 20 + 1);
				for (int j = 0; j < num.length; j++) {
					if (num[j] == numero) {
						numero = 0;
					}
				}
			} while (numero == 0);
			num[i] = numero;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("EL NÚMERO QUE HA SALIDO DEL BOMBO ES: " + num[i]);
			System.out.println();
			for (int j = 0; j < bol1.length; j++) {
				if (bol1[j] == num[i]) {
					System.out.println("EL NÚMERO ESTÁ EN EL BOLETO DE " + ali1);
					bol1[j] = 0;
					c1++;
					System.out.println(ali1 + Arrays.toString(bol1));
				}
				if (c1 == 5) {
					ganador = true;
				}
			}
			if (c1 == 5 && ganador == true) {
				System.out.println();
				System.out.println("El jugador " + ali1 + " HA GANADO!!!");
				break;
			}
			for (int j = 0; j < bol2.length; j++) {
				if (bol2[j] == num[i]) {
					System.out.println("EL NÚMERO ESTÁ EN EL BOLETO DE " + ali2);
					bol2[j] = 0;
					c2++;
					System.out.println(ali2 + Arrays.toString(bol2));
				}
				if (c2 == 5) {
					ganador = true;
				}
			}
			if (c2 == 5 && ganador == true) {
				System.out.println();
				System.out.println("El jugador " + ali2 + " HA GANADO!!!");
				break;
			}
		}
	}

	// Metodo para obtener el alias
	public static String getAlias(String nom1) {
		nom1 = "J" + nom1.substring(0, 3) + (int) (Math.random() * 101);
		return nom1;
	}

	// Metodo para generar los boletos
	public static void getBoleto(int[] bol1, int[] bol2) {
		int numero = 0;
		for (int i = 0; i < bol1.length; i++) {
//			numero = (int) (Math.random() * 20 + 1);
//			bol1[i] = numero;
			do {
				numero = (int) (Math.random() * 20 + 1);
				for (int j = 0; j < bol1.length; j++) {
					if (bol1[j] == numero) {
						numero = 0;
					}
				}
			} while (numero == 0);
			bol1[i] = numero;
		}
		for (int i = 0; i < bol2.length; i++) {
//			numero = (int) (Math.random() * 20 + 1);
//			bol2[i] = numero;
			do {
				numero = (int) (Math.random() * 20 + 1);
				for (int j = 0; j < bol2.length; j++) {
					if (bol2[j] == numero) {
						numero = 0;
					}
				}
			} while (numero == 0);
			bol2[i] = numero;
		}
	}
}
