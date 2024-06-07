//En este caso leeremos peliculas de un fichero csv, es igual que el paquete de cine
//Una vez coges la estructura resulta facil

public ArrayList cargarPelis(String fichero) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(fichero));
		ArrayList<Pelicula> peli = new ArrayList<Pelicula>();
		String linea[];
		String cadena;
		entrada.nextLine(); //línea de cabezera
		while (entrada.hasNext()) {
			cadena = entrada.nextLine();
			linea = cadena.split(";");
			peli.add(new Pelicula(Integer.parseInt(linea[0]), linea[1], linea[2], linea[3]));
		}
		return peli;
	}
