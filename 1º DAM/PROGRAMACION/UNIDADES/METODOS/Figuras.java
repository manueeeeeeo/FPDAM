package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		// Declaro las variables
		int opcion = 0;
		do { 
			System.out.println();
			System.out.println("1) Área del círculo");
			System.out.println("2) Área del cuadrado");
			System.out.println("3) Área del rectángulo");
			System.out.println("4) SALIR");
			System.out.println();
			System.out.print("Eliga una opción: ");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1: 
				System.out.print("Digame el valor del radio: ");
				double radiocir = teclado.nextInt();
				double areacir = areaci(radiocir);
				System.out.println("El resultado del area del circulo es: "+areacir);
				break;
			case 2: 
				System.out.print("Digame el valor del lado del cuadrado: ");
				double lado = teclado.nextDouble();
				double areacua = cuadrado(lado);
				System.out.println("El resultado del lado del cuadrado es: "+areacua);
				break;
			case 3: 
				System.out.print("Digame el valor del lado del rectángulo: ");
				double lado2 = teclado.nextDouble();
				System.out.print("Digame el valor de la altura del rectángulo: ");
				double altura = teclado.nextDouble();
				double arearec=rectan(lado2, altura);
				System.out.println("El area del rectángulo es: "+arearec);
				break;
			case 4: //SALIR
				break;
			default:
				break;
			}
		}while(opcion!=4);
		teclado.close();
	}
	
	public static double areaci(double radio) {
		return(Math.PI*(Math.pow(radio, radio)));
	}
	
	public static double cuadrado(double lado) {
		return(lado*lado);
	}
	
	public static double rectan(double lado1, double altura1) {
		return(lado1*altura1);
	}
}
