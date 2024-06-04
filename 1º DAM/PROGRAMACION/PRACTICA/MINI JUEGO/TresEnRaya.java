package MINIJUEGOS;

import java.util.Scanner;

public class TresEnRaya {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Variables
		String[][] tablero = new String[3][3];
		int x = 0, y = 0, win = 0;
		crearTablero(tablero);
		mostrarTablero(tablero);
		do {
			System.out.println();
			do {
				System.out.print("Jugador: Digame la posición X: ");
				x = teclado.nextInt();
				System.out.print("Jugador: Digame la posición Y: ");
				y = teclado.nextInt();
			}while(x<0 && x>tablero.length && y<0 && y>tablero.length);
			dibujarMov(tablero, x, y);
			mostrarTablero(tablero);
			juegaPc(tablero);
			System.out.println();
			mostrarTablero(tablero);
			win = comprobarHorizontal(tablero,win);
			win = comprobarVertical(tablero, win);
			win = comprobarDiagonal(tablero, win);
			win = comprobarDiagonalSec(tablero, win);
		} while (win==0);
		if(win==1) {
			System.out.println();
			System.out.println("Ha ganado el Jugador");
		}else {
			System.out.println();
			System.out.println("Ha ganado el Ordenador");
		}
		System.out.println();
		System.out.println("FIN");
	}

	public static int comprobarDiagonalSec(String[][] tablero, int win) {
		int cont1 = 0, cont2 = 0;
		for(int i = 0;i<tablero.length;i++) {
			for(int j = 0;j<tablero[0].length;j++) {
				if(i+j==2 && tablero[j][i]=="X") cont1++;
				if(i+j==2 && tablero[i][j]=="O") cont2++;
			}
		}
		if(cont1==tablero.length)win = 1;
		if(cont2==tablero.length)win = 2;
		return win;
	}

	private static int comprobarDiagonal(String[][] tablero, int win) {
		int cont1 = 0, cont2 = 0;
		for(int i = 0;i<tablero.length;i++) {
			for(int j = 0;j<tablero[0].length;j++) {
				if(i==j && tablero[j][i]=="X") cont1++;
				if(i==j && tablero[i][j]=="O") cont2++;
			}
		}
		if(cont1==tablero.length)win = 1;
		if(cont2==tablero.length)win = 2;
		return win;
	}

	private static int comprobarVertical(String[][] tablero, int win) {
		int cont1 = 0, cont2 = 0;
		for(int i = 0;i<tablero.length;i++) {
			cont1 = 0;
			cont2 = 0;
			for(int j = 0;j<tablero[0].length;j++) {
				if(tablero[j][i]=="X") cont1++;
				if(tablero[j][i]=="O") cont2++;
			}
			if(cont1==tablero.length)win = 1;
			if(cont2==tablero.length)win = 2;
		}
		return win;
	}

	public static int comprobarHorizontal(String[][] tablero, int win) {
		int cont1 = 0, cont2 = 0;
		for(int i = 0;i<tablero.length;i++) {
			cont1 = 0;
			cont2 = 0;
			for(int j = 0;j<tablero[0].length;j++) {
				if(tablero[i][j]=="X")cont1++;
				if(tablero[i][j]=="O")cont2++;
			}
			if(cont1==tablero.length)win = 1;
			if(cont2==tablero.length)win = 2;
		}
		return win;
	}

	public static void juegaPc(String[][] tablero) {
		int numerox = (int) (Math.random() * 3);
		int numeroy = (int) (Math.random() * 3);
		if(tablero[numeroy][numerox]==" ")
		tablero[numeroy][numerox] = "O";
	}


	public static void dibujarMov(String[][] tablero, int x, int y) {
		if(tablero[y][x]==" ") 
		tablero[y][x]="X";
	}

	public static void mostrarTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			if(i==0) System.out.print("***********");
			System.out.println();
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print("| " + tablero[i][j]);
			}
			System.out.print("|");
			if(i==2) {
				System.out.println();
				System.out.print("***********");
			}
		}
	}

	public static void crearTablero(String[][] tabla) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				tabla[i][j] = " ";
			}
		}
	}
}
