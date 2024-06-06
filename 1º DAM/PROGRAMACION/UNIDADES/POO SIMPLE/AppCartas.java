package poo;

import java.util.Scanner;

public class AppCartas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cartas c1 = new Cartas();
		Cartas c2 = new Cartas();
		int total1 = 0, total2 = 0, num1 = 1, num2 = 1;
		String op1 = "";
		String op2 = "";
		
		System.out.println("TURNO JUGADOR 1:");
		do {
			total1 = jugada1(c1, total1);
			System.out.print("¿Quieres seguir jugando? S/N: ");
			num1 = sc.nextInt();
			System.out.println();
		}while(num1 == 1 && total1<21);
		
		System.out.println("TURNO JUGADOR 2:");
		do {
			total2 = jugada1(c2,total2);
			System.out.print("¿Quieres seguir jugando? S/N: ");
			num2 = sc.nextInt();
			System.out.println();
		}while(num2 == 1 && total2<21);
		
		if(total1==21)System.out.println("Ha ganado el jugador 1");
		else if(total2==21)System.out.println("Ha ganado el jugador 2");
		else System.out.println("No ha ganado nadie");
	}

	public static int jugada1(Carta c, int total) {
		c.extraerCarta();
		System.out.println(c);
		total+=c.getNumero();
		System.out.println("Sumo Jugador: "+total);
		return total;
	}
}
