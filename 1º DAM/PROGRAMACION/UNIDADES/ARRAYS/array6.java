package arrays;

import java.util.Scanner;

public class Array6 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		String [] nombre = new String [5];
		int [] edad = new int [5];
		
		for(int i = 0;i<nombre.length;i++) {
			System.out.print("Digame el nombre del alumno: ");
			nombre[i] = teclado.next();
			System.out.print("Digame la edad de "+nombre[i]+": ");
			edad [i] = teclado.nextInt();
		}
		System.out.println();
		for(int j = 0;j<nombre.length;j++) {
			System.out.println("El alumno "+nombre[j]+", tiene "+edad[j]+" años");
		}
		teclado.close();
	}
}
