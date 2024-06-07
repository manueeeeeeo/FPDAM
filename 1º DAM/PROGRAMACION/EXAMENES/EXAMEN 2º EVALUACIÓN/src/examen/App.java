package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	// Variables propias de la clase
	private ArrayList<Publicista> publicistas;
	private ArrayList<Oferta> ofertas;

	// Constructor por defecto
	public App() {
		this.publicistas = new ArrayList<Publicista>();
		this.ofertas = new ArrayList<Oferta>();
	}

	// Getters y Setters
	public ArrayList<Publicista> getPublicistas() {
		return publicistas;
	}

	public void setPublicistas(ArrayList<Publicista> publicistas) {
		this.publicistas = publicistas;
	}

	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	// Metodo para leer los Publicitas
	public void cargarPublicistas(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNext()) {
				String cadena = sc.nextLine();
				String[] linea = cadena.split(";");

				String tipo = linea[0];
				if (tipo.equalsIgnoreCase("publicista")) {
					int codPu = Integer.parseInt(linea[1]);
					String nombre = linea[2];
					String apes = linea[3];
					String correo = linea[4];
					int antiguedad = Integer.parseInt(linea[5]);

					this.getPublicistas().add(new Publicista(tipo, nombre, apes, correo, antiguedad, codPu));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo para leer las ofertas
	public void cargarOfertas(String filename) {
		try {
			Scanner s = new Scanner(new File(filename));
			while (s.hasNext()) {
				String cadena = s.nextLine();
				String[] linea = cadena.split(",");

				String cod = linea[0];
				String nombre = linea[1];
				String categoria = linea[2];
				int puntos = Integer.parseInt(linea[3]);

				this.getOfertas().add(new Oferta(cod, nombre, categoria, puntos));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo para generar ficheros
	public void generarCorreo(Publicista p) {
		int puntos = 0, total = 0;
		p.cargarListClientes("Personas.csv"); // Cargamos los clientes
		for (Cliente cli : p.getClientes()) {
			total = 0;
			cli.interesesCliente("intereses.csv");
			if (cli.getCodPubli() == p.getCod()) { // Me aseguro de que ese cliente es de ese Publicista
				String mensaje = "", productos = "", intereses = "";
				for(int i = 1;i<cli.getInterese().size();i++) {
					intereses = intereses + "* " + cli.getInterese().get(i)+"\n \t";
				}
				
				
				mensaje = "Estimado/a " + cli.getNombre() + "\nSabemos que entre tus intereses se encunetran: "
						+ "\n \t" + intereses + "\nasí que puedes canjear tus " + cli.getnPuntos()
						+ " Puntos por estos que tenemos en oferta"
						+ "\n*************************************************************************************";
				puntos = cli.getnPuntos();
				for (Oferta oferta : this.getOfertas()) {
					for (String a : cli.getInterese()) {
						if (a.equalsIgnoreCase(oferta.getCategoria())) {
							if (puntos > oferta.getPuntos()) {
								puntos -= oferta.getPuntos(); // resto para tener la variable de puntos actualizada
								total += oferta.getPuntos(); // sumo los puntos al total de puntos
								productos = productos + "\n \t \t" + oferta.getNombre() + ": " + oferta.getPuntos();
							}
						}
					}
				}
				mensaje += productos;
				mensaje = mensaje + "\n \t \t \tTOATAL: " + total;
				mensaje = mensaje + "\n**********************************************************************"
						+ "\n No dejes pasar esta oportunidad porque vuelan" + "\nSi tienes cualquier duda escríbeme a "
						+ p.getCorreo() + "\n \t \t \tUn saludo " + p.getNombre() + " " + p.getApellidos();

				EnvioPorFichero fe = new EnvioPorFichero();
				fe.enviarPublicidad("Oferta" + cli.getCorreo() + ".txt", mensaje);
			}
		}
	}

	// Metodo principal
	public static void main(String[] args) {
		App app = new App();
		app.cargarPublicistas("Personas.csv"); // Cargo personas
		app.cargarOfertas("Ofertas.txt"); // Cargo las ofertas
		System.out.println("Enívo de ofertas a los clientes 27/02/2024");
		System.out.println();
		ArrayList<Cliente> aux = new ArrayList<Cliente>(); // Creo un AL auxiliar para la selección de Clientes de cada Publicista
		for (Publicista p : app.getPublicistas()) {
			app.generarCorreo(p); // Genero los ficheros 
			aux = p.seleccionarClientes(p.getCod()); //Selecciono los clientes de cada publicista
			p.setClientes(aux); //Establezco como su AL de Clientes
			System.out.println(
					" " + p.getNombre() + " " + p.getApellidos() + " envía " + p.getClientes().size() + " coreros");
		}
	}
}