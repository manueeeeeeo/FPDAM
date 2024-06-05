package arrays;
import java.util.Scanner;
public class Array4 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Declaro las variables
		double sumatall = 0;
		double mediatall = 0;
		int contadoraltos = 0;
		int contadorbajos = 0;
		
		//Introducimos el número de alturas que introducimos
		System.out.println("*********************");
		System.out.print("¿Cuantas alturas quieres introducir?: ");
		int n = teclado.nextInt();
		
		//Declaro el array
		double[] alturas = new double[n];
		
		for(int i=0;i<alturas.length;i++) {
			System.out.print("Introduce una altura: ");
			alturas[i] = teclado.nextDouble();
		}
		
		for(int j=0;j<alturas.length;j++) {
			//System.out.println(alturas[j]);
			sumatall += alturas[j];
		}
		mediatall = sumatall/alturas.length;
		
		for(int g=0;g<alturas.length;g++) {
			if(alturas[g]>mediatall) {
				contadoraltos++;
			} else if(alturas[g]<mediatall) {
				contadorbajos++;
			}
		}
		
		
		System.out.println();
		System.out.println("La suma de todas las alturas es: "+sumatall+" m");
		System.out.println();
		System.out.println("La media de todas las alturas es: "+mediatall+" m");
		System.out.println();
		System.out.println("Hay "+contadoraltos+" personas por encima de la media y "+ contadorbajos+" por debajo");
		teclado.close();
	}
}
