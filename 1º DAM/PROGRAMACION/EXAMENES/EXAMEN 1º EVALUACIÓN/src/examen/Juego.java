package examen;

import java.util.Arrays;
import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Variables
		String[] participantes = { "X123", "Z3423", "J111_Ma", "X322", "J222_IV", "J123_Ca", "J341_Ja", "Zdsfa", "Xdfa",
				"zeree", "X111_Lu", "X222_Mi", "X256_PP", "X299_An", "Juan999", "LuisaCC2", "XX1234", "Z23", "X_3234",
				"Z876_Mi", "Z100_TN", "Z987_He", "Z299_Rw", "JJJJ22" };
		String[] jugadores = new String[4];
		int[] apuestas = new int[4];
		int[][] matrizLan = new int[4][10];
		int[][] copiaMatriz = new int[4][10];
		int[] gana = new int[4];
		int[] saldoJugador = { 500, 500, 500, 500 };
		float[] dineroTotal = new float[4];
		String eleccion = "", opcion = "";
		int total = 0;
		boolean salir = false;

		do {
			System.out.print("Digame una de las siguientes letras (J, Z, X): ");
			eleccion = teclado.next();
			if (!usuariosCorrect(eleccion))
				System.out.println("Por favor, introduzca un digito valido");
		} while (!usuariosCorrect(eleccion));

		seleccionJugadores(participantes, eleccion, jugadores);
		System.out.print("Los jugadores seleccionados son: [");
		for (int i = 0; i < jugadores.length; i++) {
			if (i != 3)
				System.out.print(jugadores[i] + ", ");
			else
				System.out.print(jugadores[i] + "");
		}
		System.out.print("]");
		do {
			limpiarGana(gana);
			total = apuetasJuga(jugadores, apuestas, saldoJugador);
			System.out.println("La apuesta total es de " + total + " €");
			matrizLan = lanzamientos(matrizLan);
			menu();
			opcion = teclado.next();
			switch (opcion) {
			case "A":
				sumaSiguiente(matrizLan, jugadores, gana);
				System.out.println(Arrays.toString(gana));
				repartoDinero(jugadores, gana, apuestas, total, dineroTotal, saldoJugador);
				salir = false;
				break;
			case "B": // Suma impares resultado par
				sumaimpar(matrizLan, jugadores, gana);
				System.out.println(Arrays.toString(gana));
				repartoDinero(jugadores, gana, apuestas, total, dineroTotal, saldoJugador);
				salir = false;
				break;
			case "C": // Salimos del bucle.....
				salir = true;
				break;
			default: // No vale la respuesta
				System.out.println("ERROR! Esa opción no está disponible");
				break;
			}
		} while (salir != true);
		resultados(jugadores, dineroTotal, saldoJugador);
	}

	public static void limpiarGana(int[] gana) {
		for (int i = 0; i < gana.length; i++) {
			gana[i] = 0;
		}
	}

	public static void repartoDinero(String[] jugadores, int[] gana, int[] apuestas, int total, float[] dineroTotal,
			int[] saldoJugador) {
		int ganadores = 0, cont = 0;
		float reparto = 0;
		ganadores = 0;
		reparto = 0;
		for (int i = 0; i < gana.length; i++) {
			if (gana[i] == 1)
				ganadores++;
		}
		if (ganadores == 0)
			System.out.println("El dinero se lo queda la banca al no haber ganadores");
		if (ganadores > 0) {
			reparto = (total / ganadores);
			System.out.println("************REPARTO************");
			System.out.println("Nº de ganadores: " + ganadores);
			System.out.println("El reparto es de " + reparto);
			System.out.println();
			for (int i = 0; i < saldoJugador.length; i++) {
				if (gana[i] == 1) {
					saldoJugador[i] += reparto;
					System.out.println("El jugador " + jugadores[i] + " gana " + reparto + " €");
				}
			}
		}
	}

	public static void resultados(String[] jugadores, float[] dineroTotal, int[] saldoJugador) {
		System.out.println();
		System.out.println("***********************Resultado***********************");
		for (int i = 0; i < dineroTotal.length; i++) {
			System.out.println("El jugador: " + jugadores[i] + " se ha quedado con: " + saldoJugador[i] + " €");
		}
	}

	public static void sumaSiguiente(int[][] matrizLan, String[] jugadores, int[] gana) {
		int cont = 0, pos = 0, sum = 0;
		for (int i = 0; i < matrizLan.length; i++) {
			pos = 0;
			cont = 0;
			for (int j = 0; j < matrizLan[0].length; j++) {
				pos = j;
				if (pos < 8) {
					sum = (matrizLan[i][pos] + matrizLan[i][pos + 1]);
					if (sum == matrizLan[i][pos + 2]) {
						cont++;
						sum = 0;
					}

				}
				if (cont > 0) {
					gana[i] = 1;
				} else {
					gana[i] = 0;
				}
			}
		}
	}

	public static void sumaimpar(int[][] matriz, String[] jugadores, int[] gana) {
		int numero = 0, pos = 0, sum = 0;
		for (int i = 0; i < matriz.length; i++) {
			sum = 0;
			for (int j = 1; j < matriz[0].length; j++) {
				pos = j;
				numero = matriz[i][j];
				if (pos % 2 == 1)
					sum += numero;
			}
			if (sum % 2 == 0)
				gana[i] = 1;
			else
				gana[i] = 0;
			System.out.println(sum);
		}
	}

	public static void menu() {
		System.out.println();
		System.out.println("MENU:");
		System.out.println("A) Dos números suman el siguiente");
		System.out.println("B) Tirada impar suma par");
		System.out.println("C) Salir");
		System.out.println();
		System.out.print("Que opción eliges: ");
	}

	public static int[][] lanzamientos(int[][] matrizLan) {
		int numero = 0;
		System.out.println();
		System.out.println("**********************************Lamzamientos**********************************");
		for (int i = 0; i < matrizLan.length; i++) {
			System.out.println();
			for (int j = 0; j < matrizLan[0].length; j++) {
				numero = (int) (Math.random() * 6 + 1);
				matrizLan[i][j] = numero;
				System.out.print(matrizLan[i][j] + "\t");
			}
		}
		System.out.println();
		System.out.println("*******************************************************************************");
		return matrizLan;
	}

	// Establezco las apuestas y las resto del saldo global de cada uno
	public static int apuetasJuga(String[] jugadores, int[] apuestas, int[] saldoJugador) {
		int numero = 0, totalApuesta = 0;
		System.out.println();
		System.out.println();
		System.out.println("NUEVA PARTIDA");
		System.out.println("-------------------------------------");
		System.out.println(
				"El jugador " + jugadores[0] + " apuesta " + (numero = (int) (Math.random() * 100 + 1)) + " €");
		totalApuesta += numero;
		apuestas[0] = numero;
		saldoJugador[0] -= numero;
		System.out.println(
				"El jugador " + jugadores[1] + " apuesta " + (numero = (int) (Math.random() * 100 + 1)) + " €");
		totalApuesta += numero;
		apuestas[1] = numero;
		saldoJugador[1] -= numero;
		System.out.println(
				"El jugador " + jugadores[2] + " apuesta " + (numero = (int) (Math.random() * 100 + 1)) + " €");
		totalApuesta += numero;
		apuestas[2] = numero;
		saldoJugador[2] -= numero;
		System.out.println(
				"El jugador " + jugadores[3] + " apuesta " + (numero = (int) (Math.random() * 100 + 1)) + " €");
		totalApuesta += numero;
		apuestas[3] = numero;
		saldoJugador[3] -= numero;
		return totalApuesta;
	}

	public static void seleccionJugadores(String[] participantes, String eleccion, String[] jugadores) {
		String nick = "";
		int cont = 0;
		for (int i = 0; i < participantes.length; i++) {
			nick = participantes[i];
			if (cont < 4) {
				jugadores[i] = participantes[i];
				cont++;
			}
		}
	}

	public static boolean patCorrect(String s) {
		return s.matches("^[J, X, Z]{1}+[0-9]{3}+[. _]{1}+[A-Z a-z]{2}+$");
	}

	public static boolean usuariosCorrect(String eleccion) {
		return eleccion.matches("^[J, X, Z]{1}+$");
	}
}