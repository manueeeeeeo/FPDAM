package matrices;

import java.util.Scanner;

public class SumarMatrices {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Variables
		int[][] matriz1 = new int[3][4];
		int[][] matriz2 = new int[3][4];
		int[][] suma = new int[3][4];

		// Rellenar matrices
		rellenarMatriz(matriz1);
		rellenarMatriz(matriz2);
		sumarMatrices(matriz1, matriz2, suma);

		// Mostrar matrices
		imprimirMatrices(matriz1, matriz2, suma);
		teclado.close();
	}

  // Método para imprimir todas las matrices
	public static void imprimirMatrices(int[][] matriz1, int[][] matriz2, int[][] suma) {
		for (int i = 0; i < matriz1.length; i++) {
			System.out.println();
			for (int j = 0; j < matriz1[0].length; j++) {
				System.out.print(matriz1[i][j] + "\t");
			}
			if(i==1) {
				System.out.print(" + ");
			}
			System.out.print("\t");
			for(int j = 0;j<matriz2[0].length;j++) {
				System.out.print(matriz2[i][j] + "\t");
			}
			if(i==1) {
				System.out.print(" = ");
			}
			System.out.print("\t");
			for(int j = 0;j<suma[0].length;j++) {
				System.out.print(suma[i][j] + "\t");
			}
		}
	}

  // Método para sumar las matrices
	public static void sumarMatrices(int[][] matriz1, int[][] matriz2, int[][] suma) {
		for (int i = 0; i < suma.length; i++) {
			for (int j = 0; j < suma[0].length; j++) {
				suma[i][j] = matriz1[i][j] + matriz2[i][j];
			}
		}
	}

  // Método para rellenar las matrices
	public static void rellenarMatriz(int[][] matriz) {
		int numero = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				numero = (int) (Math.random() * 30 + 1);
				matriz[i][j] = numero;
			}
		}
	}
}
