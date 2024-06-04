package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Guia extends Persona {
	private String titulacion;
	private String idioma;
	private int experiencia;
	private ArrayList<Turista> turistas;

	// Constructor predefinido
	public Guia() {
		super();
		this.titulacion = "";
		this.idioma = "";
		this.experiencia = 0;
		this.turistas = new ArrayList<Turista>();
	}

	// Constructor con todos los parametros
	public Guia(String id, String nombre, String apellidos, String titulacion, String idioma, int experiencia,
			ArrayList<Turista> turistas) {
		super(id, nombre, apellidos);
		this.titulacion = titulacion;
		this.idioma = idioma;
		this.experiencia = experiencia;
		this.turistas = turistas;
	}

	// Constructor con todos los parametros menos el al
	public Guia(String id, String nombre, String apellidos, String titulacion, String idioma, int experiencia) {
		super(id, nombre, apellidos);
		this.titulacion = titulacion;
		this.idioma = idioma;
		this.experiencia = experiencia;
		this.turistas = new ArrayList<Turista>();
	}

	// Getters y Setters
	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public ArrayList<Turista> getTuristas() {
		return turistas;
	}

	public void setTuristas(ArrayList<Turista> turistas) {
		this.turistas = turistas;
	}

	// toString
	@Override
	public String toString() {
		return "Guia [titulacion=" + titulacion + ", idioma=" + idioma + ", experiencia=" + experiencia + ", turistas="
				+ turistas + ", id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	// Método para cargar los turistas
	public void cargarTuristas(String filename) {
		try {
			Scanner ler = new Scanner(new File(filename));
			ler.nextLine();
			while(ler.hasNext()) {
				String cadena = ler.nextLine();
				String [] linea = cadena.split(";");
				if (this.getId().equals(linea[0]) && linea[1].length()>0) {
					String idTu = linea[1];
					String nombre = linea[2];
					String ape = linea[3];
					String nacio = linea[6];
					String idioma = linea[7];
					this.getTuristas().add(new Turista(idTu, nombre, ape, nacio, idioma));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Método para imprimir la visita
	public void imprimirVisita(Turista t) {
		t.cargarVisita("visitasHoy.txt");
		String mensaje="";
		LocalDateTime todo = LocalDateTime.now();
		try {
			File directorio = new File(this.getId());
			directorio.mkdir();
			PrintWriter escribir = new PrintWriter(new File(directorio+"\\Entrada"+t.getId()+".txt"));
			DateTimeFormatter forma = DateTimeFormatter.ofPattern("EEEE dd-MMMM-yyyy HH:mm:ss");
			String fecha = todo.format(forma);
			mensaje = "Visita guiada a la Alhambra y al Generalife \nFecha y hora de la impresion: "+fecha+"\n\n";
			mensaje = mensaje+"Guía Titulado: "+this.getNombre()+" "+this.getApellidos()+"\nNº Entrada: "+t.getId()+"\n"+t.getNombre()+" "+t.getApellidos()+"\nHora visita: "+t.getVist().getHor_visita()+"\nIdioma: "
					+t.getIdioma();
			mensaje = mensaje+"\n\t\t\tImporte Total: "+t.getVist().getPrecio()+"€";
			escribir.print(mensaje);
			escribir.flush();
			escribir.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Guia t = new Guia();
		t.setId("100");
		t.cargarTuristas("personas.csv");
		for (Turista tu : t.getTuristas()) {
			System.out.println(tu.getNombre()+" "+tu.getApellidos());
			t.imprimirVisita(tu);
		}
	}
}