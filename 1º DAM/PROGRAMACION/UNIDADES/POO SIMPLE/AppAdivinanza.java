package poo;

import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Adivina a = new Adivina();
		Scanner sc = new Scanner(System.in);
		int intentos = 3;
		String vocal;
		String cad;
		cad = a.imprimirSinVocales();
		a.setAux(cad);

		System.out.println("LA PALABRA QUE TIENES QUE ADIVINAR ES: " + a.getAux());
		// Bucle del juego
		do {
			System.out.print("DIGAME UNA VOCAL: ");
			vocal = sc.next();
			vocal = vocal.toUpperCase();
			cad = a.imprimir(vocal);
			System.out.println(cad);
			intentos--;
		}while(intentos>0 && !cad.equals(a.secreta));
		
		if(cad.equals(a.secreta)) System.out.println("MUY BIEN!! GANASTE");
		else System.out.println("HAS PERDIDO!!");
	}
}
