package examenElearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Manuel
 * @version 1.0
 */

public class AppJuego {
	// Caracteristicas propias de la clase AppJuego
	public ArrayList<Jugador> jugadores;
	public double dineroBanca;

	/**
	 * 
	 * Constructor por defecto
	 */
	public AppJuego() {
		this.jugadores = new ArrayList<Jugador>();
		this.dineroBanca = 0;
	}

	/**
	 * 
	 * Constructor con todos los parametros
	 * @param jugadores
	 * @param dineroBanca
	 */
	public AppJuego(ArrayList<Jugador> jugadores, double dineroBanca) {
		this.jugadores = jugadores;
		this.dineroBanca = dineroBanca;
	}

	// Getters y Setters
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public double getDineroBanca() {
		return dineroBanca;
	}

	public void setDineroBanca(double dineroBanca) {
		this.dineroBanca = dineroBanca;
	}

	/**
	 * 
	 * Metodo para cargar los jugadores del fichero
	 * @param fichero
	 * @throws FileNotFoundException
	 */
	public void cargarJugadores(String fichero) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(fichero));
		entrada.nextLine(); // línea de cabezera
		while (entrada.hasNext()) {
			String cadena = entrada.nextLine();
			String linea[] = cadena.split(";");

			String nombre = linea[0];
			int edad = Integer.parseInt(linea[1]);
			String ciudad = linea[2];

			jugadores.add(new Jugador(nombre, edad, ciudad));
		}
		entrada.close();
	}

	// Metodo para mostrar los jugadores
	private void mostrarJugadores() {
		for (Jugador jugador : jugadores) {
			System.out.println(jugador);
		}
	}

	/**
	 * 
	 * Metodo para imprimir el Boleto de la tirada de cada jugador
	 * @param lanza
	 */
	public void imprimirBol(int[] lanza) {
		System.out.print("[");
		for (int i = 0; i < lanza.length; i++) {
			if (i != lanza.length) {
				System.out.print(lanza[i] + ", ");
			} else {
				System.out.print(lanza[i]);
			}
		}
		System.out.print("]");
	}

	/**
	 * 
	 * Metodo para jugar
	 * @param nPartida
	 */
	private void Jugar(int nPartida) {
		int cont = 0, cont2 = 0;
		int prueba = 0;
		double apuestaa = 0, saldoActual = 0;
		int[] gana = new int[4];
		for (Jugador jugador : jugadores) {
			jugador.lanzarDados();
			System.out.println(jugador.getNombre() + " ");
			imprimirBol(jugador.getLanza());
			apuestaa = jugador.apostarDinero();
			saldoActual = (jugador.getApuesta() - apuestaa);
			jugador.setApuesta(saldoActual);
			System.out.println("\t Apuesta: " + apuestaa + "€" + " --------- " + " le quedan "
					+ jugador.getApuesta() + "€");
			cont++;
			dineroBanca += apuestaa;
			for (int i = 0; i < (jugador.getLanza().length - 1); i++) {
				if (jugador.getLanza()[i] == jugador.getLanza()[i + 1]) {
					cont2++;
				} else {
					cont2 = 0;
				}
				if (cont2 >= 3) {
					i = (jugador.getLanza().length - 1);
					gana[nPartida] = 1; // Jugador gana
					jugador.setGana(gana);
				}
			}
		}
		System.out.println("\t \t \t \t TOTAL APOSTADO: " + dineroBanca + "€");
		System.out.println();
		repartoTotal(dineroBanca, nPartida);
	}

	/**
	 * 
	 * Metodo para repartir el total de dinero apostado en cada partida
	 * @param totalApostado
	 * @param nPartida
	 */
	private void repartoTotal(double totalApostado, int nPartida) {
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		int cont = 0;
		double reparto = 0.0;
		for (Jugador jugador : jugadores) {
				for(int i = 0;i<jugador.getGana().length;i++) {
					if(jugador.getGana()[nPartida]==1) {
						ganadores.add(jugador);
						cont++;
						i = jugador.getGana().length;
					}
				}
		}
		reparto = totalApostado/(cont);
		System.out.println("Han ganado "+(cont)+" jugadores, cada uno se lleva "+reparto+"€");
		for (Jugador jugador : ganadores) {
			jugador.setApuesta(reparto);
			System.out.println(jugador.getNombre()+" tiene "+jugador.getApuesta()+"€");
		}
	}

	// Metodo para imprimir los informes
	private void mostrarInformes() {
		System.out.println("***************************************");
		System.out.println("************Resultado Final************");
		System.out.println("***************************************");
		for (Jugador jugador : jugadores) {
			System.out.println(jugador + " tiene " + jugador.getApuesta() + "€");
		}
	}

	/**
	 * 
	 * Metodo para generar los informes
	 * @throws FileNotFoundException
	 */
	private void generarInformes() throws FileNotFoundException {
		int cont = 0;
		for (Jugador jugador : jugadores) {
			cont = 0;
			PrintWriter salida = new PrintWriter("Resultado" + jugador.getNombre() + ".txt");
			salida.println("Resultado del juego de " + jugador.getNombre());
			for (int i = 0; i < jugador.getGana().length; i++) {
				if (jugador.getGana()[i] == 1)
					cont++;
			}
			salida.println("Partidas Gandas: " + cont);
			salida.println("Dinero conseguido: " + jugador.getApuesta() + "€");
			salida.close();
		}
	}

	/**
	 * 
	 * Metodo Main
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		AppJuego app = new AppJuego();
		app.cargarJugadores("jugadores.csv");
		System.out.println("Los jugadores son: ");
		app.mostrarJugadores();
		System.out.println();
		System.out.println("*******************************");
		System.out.println("******Comienza el Juego********");
		System.out.println("*******************************");
		System.out.println();

		for (int i = 0; i < 4; i++) {
			app.Jugar(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
		app.mostrarInformes();
		app.generarInformes();
	}
}
