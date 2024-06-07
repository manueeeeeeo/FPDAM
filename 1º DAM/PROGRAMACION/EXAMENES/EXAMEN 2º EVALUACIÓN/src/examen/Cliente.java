package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cliente extends Persona {
	// Variables propias de la clase
	private int edad;
	private int nPuntos;
	private ArrayList<String> interese;
	private int codCli;
	private int codPubli;
	private String ciudad;
	private String zona;

	// Constructor predefinido
	public Cliente() {
		super();
		this.edad = 0;
		this.nPuntos = 0;
		this.interese = new ArrayList<String>();
		this.codCli = 0;
		this.codPubli = 0;
		this.ciudad = "";
		this.zona = "";
	}

	// Constructo sin el AL
	public Cliente(String tipo, String nombre, String apellidos, String correo, int edad, int nPuntos, int codCli,
			int codP, String ciudad, String zona) {
		super(tipo, nombre, apellidos, correo);
		this.edad = edad;
		this.nPuntos = nPuntos;
		this.interese = new ArrayList<String>();
		this.codCli = codCli;
		this.codPubli = codP;
		this.ciudad = ciudad;
		this.zona = zona;
	}

	// Constructo con todos los parametros
	public Cliente(String tipo, String nombre, String apellidos, String correo, int edad, int nPuntos, int codCli,
			int codP, ArrayList<String> interese, String ciudad, String zona) {
		super(tipo, nombre, apellidos, correo);
		this.edad = edad;
		this.nPuntos = nPuntos;
		this.interese = interese;
		this.codCli = codCli;
		this.codPubli = codP;
		this.ciudad = ciudad;
		this.zona = zona;
	}

	// Getters y Setters
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getnPuntos() {
		return nPuntos;
	}

	public void setnPuntos(int nPuntos) {
		this.nPuntos = nPuntos;
	}

	public ArrayList<String> getInterese() {
		return interese;
	}

	public void setInterese(ArrayList<String> interese) {
		this.interese = interese;
	}

	public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	public int getCodPubli() {
		return codPubli;
	}

	public void setCodPubli(int codPubli) {
		this.codPubli = codPubli;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	// toString
	@Override
	public String toString() {
		return "Cliente [edad=" + edad + ", nPuntos=" + nPuntos + ", interese=" + interese + ", tipo=" + tipo
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + "]";
	}

	// Metodo para cargar los intereses de los clientes
	public void interesesCliente(String filename) {
		try {
			Scanner entrada = new Scanner(new File(filename));
			while (entrada.hasNext()) {
				String cadena = entrada.nextLine();
				String[] linea = cadena.split(";");

				int cod = Integer.parseInt(linea[0]);
				if (cod == this.getCodCli()) { // Comprobamos si el código del cliente concide con el de sus intereses
					for(int i = 0;i<linea.length;i++) {
						String interes1 = linea[i];
						this.getInterese().add(interes1);
					}
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}