package poo;

import java.util.Arrays;

public class AppDado {
	public static void main(String[] args) {
		// Variables
		int[] nums = new int[3];
		int suma1 = 0, suma2 = 0;

		//Juego 1
//		for (int i = 0; i < nums.length; i++) {
//			Dado d1 = new Dado();
//			d1.lanzarDado();
//			nums[i] = d1.getnCara();
//			System.out.println(d1);
//		}
//		for (int i = 0; i < nums.length; i++) {
//			if (i != nums.length - 1) {
//				for (int j = 1; j < nums.length; j++) {
//					if (nums[i] == nums[j] && i!=j) System.out.println("HAS PERDIDO");
//				}
//			}
//		}
		
		//Juego 2
//		for(int i = 0;i<4;i++) {
//			Dado d1 = new Dado();
//			d1.lanzarDado();
//			suma1 += d1.getnCara();
//		}
//		System.out.println("Suma del JUGADOR 1: "+suma1);
//		System.out.println();
//		for(int i = 0;i<4;i++) {
//			Dado d1 = new Dado();
//			d1.lanzarDado();
//			suma2 += d1.getnCara();
//		}
//		System.out.println("Suma del JUGADOR 2: "+suma2);
//		System.out.println();
//		
//		if(suma1>suma2) System.out.println("Ha ganado el JUGADOR 1");
//		else if (suma1<suma2) System.out.println("Ha ganado el JUAGDOR 2");
//		else System.out.println("HA HABIDO UN EMPATE TÉCNICO");
//		System.out.println(Arrays.toString(nums));
		
		//Juego 3
		int[]jug1 = new int [8];
		int[]jug2 = new int [8];
		int cont1 = 0, cont2 = 0;
		
		for(int i = 0;i<jug1.length;i++) {
			Dado d1 = new Dado();
			d1.lanzarDado();
			jug1[i]=d1.getnCara();
		}
		for(int i = 0;i<jug2.length;i++) {
			Dado d1 = new Dado();
			d1.lanzarDado();
			jug2[i]=d1.getnCara();
		}
		System.out.println(Arrays.toString(jug1));
		
		for(int i = 0;i<jug1.length;i++) {
			if(jug1[i]==6) cont1++;
			if(jug2[i]==6) cont2++;
		}
		System.out.println(Arrays.toString(jug2));
		System.out.println();
		
		System.out.println("El jugador 1 ha sacado "+cont1+" seises");
		System.out.println("El jugador 2 ha sacado "+cont2+" seises");
		System.out.println();
		
		if(cont1>cont2) System.out.println("Ha ganado el JUGADOR 1");
		else if (cont1<cont2) System.out.println("Ha ganado el JUAGDOR 2");
		else System.out.println("HAN EMPATADO");
	}
}
