package taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		App a = new App();
		ArrayList<Coche> coches = new ArrayList<Coche>();
		coches = a.cargarCoches("coches.csv");
		System.out.println(coches);
		int cont = 0;

		for (Coche c : coches) {
			System.out.println(c.getMatricula());
		}

		for (Coche c : coches) {
			if (c.getnPuertas() == 5)
				cont++;
		}
		System.out.println("Hay " + cont + " coches con 5 puertas");

		// Marca, modelo y matriculo de los coches negros
		for (Coche c : coches) {
			if (c.getColor().equals("negro")) {
				System.out.println(c.getMatricula() + " - " + c.getMarca() + " - " + c.getModelo());
			}
		}

		// El coche con mayor número de KM(objeto)
		Coche cMayor = new Coche();
		for (Coche c : coches) {
			if (c.getKm() > cMayor.getKm())
				cMayor = c;
		}
		System.out.println("El coche con más Km es el " + cMayor);

		// Matricula del coche con menor número de KM
		Coche cMenor = coches.get(0);
		for (Coche c : coches) {
			if (cMenor.getKm() < c.getKm())
				cMenor = c;
		}
		System.out.println("El coche con menos Km es el "+cMenor.getMatricula());

		// Guardar en otro AL los coches de 3 puertas
		ArrayList<Coche> coche3 = new ArrayList<Coche>();
		for (Coche c : coches) {
			if (c.getnPuertas() == 3)
				coche3.add(c);
		}
		
		// Borrar de Coches
		Coche c = coches.get(0);
		for(int i = 0;i<coches.size();i++) {
			if (c.getnPuertas() == 3)
				coches.remove(i);
		}
		System.out.println(coche3);
		
		//Buscar coches que tenga en la matricula una f
		for (Coche ca : coches) {
			if(ca.getMatricula().contains("F")) System.out.println(ca.getMatricula());
		}
	}

  // Método para cargar los coches
	public ArrayList cargarCoches(String fichero) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(fichero));
		ArrayList<Coche> coches = new ArrayList<Coche>();
		String linea[];
		String cadena;
		entrada.nextLine();
		while (entrada.hasNext()) {
			cadena = entrada.nextLine();
			linea = cadena.split(";");
			coches.add(new Coche(linea[0], linea[1], linea[2], linea[3], Integer.parseInt(linea[4]),
					Double.parseDouble(linea[5])));
		}
		return coches;
	}
}
