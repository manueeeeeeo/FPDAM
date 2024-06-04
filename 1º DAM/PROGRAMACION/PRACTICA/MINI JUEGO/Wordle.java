package MINIJUEGOS;

import java.util.Scanner;

public class Wordle {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Variables
		String[] bateriaPal = { "PLATO", "PISAR", "PLANO", "PRADO", "MIXTO", "BULTO", "USADO", "BRAVO", "TRUCO",
				"QUESO" };
		String palabra = "";
		int intentos = 6;
		palabra = palabradeldia(bateriaPal, palabra);
		System.out.println("La palabra del día es: " + palabra);
		juego(palabra, intentos);
		teclado.close();
	}

	public static void juego(String palabra, int intentos) {
		Scanner teclado = new Scanner(System.in);
		String prueba = "", introducida = "";
		int numletras = palabra.length();
		boolean ganado = false;
		for(int i = 0;i<palabra.length();i++) {
			introducida+="_";
		}
		System.out.println(introducida);
		System.out.println();
		do {
			do {
				System.out.println("Dime una palabra de " +numletras+ " letras: ");
				prueba = teclado.next();
			} while (prueba.length() != palabra.length() && !esMayus(prueba));
			for(int i = 0;i<numletras;i++) {
				if(prueba.charAt(i)==palabra.charAt(i)) {
					if(prueba.charAt(i)!=numletras) {
						introducida = introducida.substring(0, i)+prueba.charAt(i)+introducida.substring(i+1, numletras);
					}else {
						introducida = introducida.substring(0, i)+prueba.charAt(i);
					}
				}
			}
			System.out.println(introducida);
			if(palabra.equals(introducida)) {
				ganado = true;
			}else {
				intentos--;
				System.out.println();
				System.out.println("Te quedan "+intentos+" vidas");
			}
		} while (intentos > 0 && ganado==false);
		System.out.println();
		if(ganado==true) {
			System.out.println("Has ganado!!");
		}else {
			System.out.println("Has perdido!!");
		}
	}

	public static boolean esMayus(String s) {
		return s.matches("[A-Z]");
	}

	public static String palabradeldia(String[] bateriaPal, String palabra) {
		int numero = 0;
		numero = (int) (Math.random() * 10);
		palabra = bateriaPal[numero];
		return palabra;
	}
}
