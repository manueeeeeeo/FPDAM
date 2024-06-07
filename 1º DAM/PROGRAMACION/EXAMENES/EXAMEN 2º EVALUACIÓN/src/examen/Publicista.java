package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Publicista extends Persona {
	// Variables propias de la clase
	private int antiguedad;
	private ArrayList<Cliente> clientes;
	private int cod;

	// Constructor predefinido
	public Publicista() {
		super();
		this.antiguedad = 0;
		this.clientes = new ArrayList<Cliente>();
		this.cod = 0;
	}

	// Constructor sin el AL
	public Publicista(String tipo, String nombre, String apellidos, String correo, int ant, int cod) {
		super(tipo, nombre, apellidos, correo);
		this.antiguedad = ant;
		this.clientes = new ArrayList<Cliente>();
		this.cod = cod;
	}

	// Constructor con todos los parametros
	public Publicista(String tipo, String nombre, String apellidos, String correo, int ant, int cod,
			ArrayList<Cliente> clientes) {
		super(tipo, nombre, apellidos, correo);
		this.antiguedad = ant;
		this.clientes = clientes;
		this.cod = cod;
	}

	// Getters y Setters
	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	// toString
	@Override
	public String toString() {
		return "Publicista [antiguedad=" + antiguedad + ", clientes=" + clientes + ", cod=" + cod + ", tipo=" + tipo
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + "]";
	}

	// Metodo para cargar la lista de los clientes
	public void cargarListClientes(String filename) {
		try {
			Scanner entrada = new Scanner(new File(filename));
			while (entrada.hasNext()) {
				String cadena = entrada.nextLine();
				String[] linea = cadena.split(";");

				String tipo = linea[0];
				if (tipo.equalsIgnoreCase("cliente")) {
					int codPu = Integer.parseInt(linea[1]);
					int codCli = Integer.parseInt(linea[2]);
					String nombre = linea[3];
					String apes = linea[4];
					String gmail = linea[5];
					int edad = Integer.parseInt(linea[6]);
					String ciuda = linea[7];
					String zona = linea[8];
					int nPuntos = Integer.parseInt(linea[9]);
					
					this.getClientes().add(new Cliente(tipo, nombre, apes, gmail, edad, nPuntos, codCli, codPu, ciuda, zona));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Metodo para seleccionar a los clientes de cada pubicista según su código
	public ArrayList<Cliente> seleccionarClientes(int cod) {
		ArrayList<Cliente> cli = new ArrayList<Cliente>();
		for (Cliente cliente : this.getClientes()) {
			if(cliente.getCodPubli()==cod){
				cli.add(cliente);
			}
		}
		return cli;
	}
}