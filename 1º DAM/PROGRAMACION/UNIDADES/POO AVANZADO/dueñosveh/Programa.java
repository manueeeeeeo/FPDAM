package dueñosVeh;

public class Programa {
	public static void main(String[] args) {
		int nCoches = 0, nMotos = 0;

		// Creo array de Vehiculos
		Vehiculo[] v = new Vehiculo[5];

		// Creo diferentes Vehiculos -> Motos
		Moto m1 = new Moto("0000AAA", "Zontes", "G1", 125);
		Moto m2 = new Moto("2345JKA", "Yamaha", "MT-09", 900);
		Moto m3 = new Moto("1234HAY", "Ducati", "Panigale V4", 400);

		// Creo diferentes Vehiculos -> Coches
		Coche c1 = new Coche("3728OEU", "Seat", "Leon", "Amarillo", 4);
		Coche c2 = new Coche("8910KCM", "Kia", "Stonic", "Rojo-Negro", 4);

		// Guardo los vehiculos en el array
		v[0] = m2;
		v[1] = c2;
		v[2] = m1;

		// Creo al Cliente
		Cliente a = new Cliente("9847129H", "Manuel", "Sanchez", "GranVia", 600, v);

		System.out.println(a.getNombre() + " " + a.getApellido() + " con DNI: " + a.getDni());
		System.out.println("-------------------------------------------------");

		for (int i = 0; i < a.getV().length; i++) {
			if (a.getV()[i] != null) {
				if (a.getV()[i] instanceof Coche)
					nCoches++;
				if (a.getV()[i] instanceof Moto)
					nMotos++;
				System.out.println(
						"\t " + a.getV()[i].getMatricula() + " " + a.getV()[i].getMarca() + " " + a.getV()[i].getModelo());
			}
		}
		System.out.println("-------------------------------------------------");
		System.out.println("Número de Coches: " + nCoches);
		System.out.println("Número de Motos: " + nMotos);
	}
}
