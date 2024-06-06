package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Declaro las variables
		int opcion = 0;
		//Pregunto los números
		System.out.print("Digame el primer número: ");
		double n1 = teclado.nextDouble();
		System.out.print("Digame el segundo número: ");
		double n2 = teclado.nextDouble();
		//Muesro el menú
		System.out.println("1) Sumar a+b");
		System.out.println("2) Restar a-b");
		System.out.println("3) Multiplicar a*b");
		System.out.println("4) Dividr a/b");
		System.out.print("Elige una opción: ");
		opcion = teclado.nextInt();
		//Seleccionamos la opción
		switch(opcion) {
		case 1:
			double suma = suma(n1, n2);
			System.out.println("La suma de los números es: "+suma);
			break;
		case 2:
			double rest = resta(n1, n2);
			System.out.println("La resta de los número es: "+rest);
			break;
		case 3:
			double multipli = multi(n1, n2);
			System.out.println("La multipliación de los número es: "+multipli);
			break;
		case 4:
			double div = division(n1, n2);
			System.out.println("La división de los número es: "+div);
			break;
		default:
			System.err.println("Esa opción no está dsiponible, has detenido el programa");
			break;
		}
		teclado.close();
	}
	
	public static double suma(double num1, double num2) {
		return(num1+num2);
	}
	
	public static double resta(double num1, double num2) {
		return(num1-num2);
	}
	
	public static double multi(double num1, double num2) {
		return(num1*num2);
	}
	
	public static double division(double num1, double num2) {
		return(num1/num2);
	}
}
