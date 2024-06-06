package ejercicios;

import java.util.Scanner;

public class Metodos {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digame un exponente: ");
		int expo = teclado.nextInt();
		System.out.print("Digame una base: ");
		int base = teclado.nextInt();
		System.out.println(potencia(expo, base));
		System.out.println(fact2((base)));
		teclado.close();
	}
	
	public static int potencia(int n, int x) {
		if(n == 0) { //Caso base
			return 1;
		}else {
			return x*potencia(n-1,x);
		}
	}
	
	public static int factorial (int num) {
		int fact=1;
		for(int i = num;i>=1;i--) {
			fact = fact*i;
			System.out.print(i);
			if(i>1) {
				System.out.print("*");
			}
		}
		System.out.print("=");
		return fact;
	}
	public static int fact2 (int num) {
		if(num == 0) {
			return 1;
		}else {
			return (num*fact2(num-1));
		}
	}
}
