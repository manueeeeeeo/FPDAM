package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Turista extends Persona {
	private String nacionalidad;
	private String idioma;
	private Visita vist;

	// Constructor predefinido
	public Turista() {
		super();
		this.nacionalidad = "";
		this.idioma = "";
		this.vist = new Visita();
	}

	// Constructor con todos los parametros
	public Turista(String id, String nombre, String apellidos, String nacionalidad, String idioma, Visita vist) {
		super(id, nombre, apellidos);
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.vist = vist;
	}

	// Constructor con todos los parametros menos la visita
	public Turista(String id, String nombre, String apellidos, String nacionalidad, String idioma) {
		super(id, nombre, apellidos);
		this.nacionalidad = nacionalidad;
		this.idioma = idioma;
		this.vist = new Visita();
	}

	// Getters y Setters
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Visita getVist() {
		return vist;
	}

	public void setVist(Visita vist) {
		this.vist = vist;
	}

	// toString
	@Override
	public String toString() {
		return "Turista [nacionalidad=" + nacionalidad + ", idioma=" + idioma + ", vist=" + vist + ", id=" + id
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	// Método para cargar la visita
	public void cargarVisita(String filename) {
		try {
			Scanner leer = new Scanner(new File(filename));
			leer.nextLine();
			while(leer.hasNext()) {
				String cadena = leer.nextLine();
				String [] linea = cadena.split(";");
				
				if(this.id.equals(linea[1])) {
					String cod = linea[2];
					int hora = Integer.parseInt(linea[3]);
					String idioma = linea[4];
					double precio = Double.parseDouble(linea[5]);
					Visita vi = new Visita(cod, hora, idioma, precio);
					this.setVist(vi);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}