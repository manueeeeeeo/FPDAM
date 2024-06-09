package examenElearning;

import java.util.Arrays;

/**
 * 
 * @author Manuel
 * @version 1.0
 */

public class Jugador {
	// Cracteristicas propias de la clase Jugador
	private String nombre;
	private int edad;
	private String ciudad;
	private int [] lanza;
	private int [] gana;
	private double apuesta;
	
	/**
	 * 
	 * Constructor con todos los campos
	 * @param nombre
	 * @param edad
	 * @param ciudad
	 * @param lanza
	 * @param gana
	 * @param apuesta
	 */
	public Jugador(String nombre, int edad, String ciudad, int[] lanza, int[] gana, double apuesta) {
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.lanza = lanza;
		this.gana = gana;
		this.apuesta = apuesta;
	}
	
	/**
	 * 
	 * Constructor con los 3 valores solicitados
	 * @param nombre
	 * @param edad
	 * @param ciudad
	 */
	public Jugador(String nombre, int edad, String ciudad) {
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.lanza = new int [10];
		this.gana = new int [4];
		this.apuesta = 500;
	}
	
	// Getters y Setters
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * 
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * 
	 * @return
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getLanza() {
		return lanza;
	}

	/**
	 * 
	 * @param lanza
	 */
	public void setLanza(int[] lanza) {
		this.lanza = lanza;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getGana() {
		return gana;
	}

	/**
	 * 
	 * @param gana
	 */
	public void setGana(int[] gana) {
		this.gana = gana;
	}

	/**
	 * 
	 * @return
	 */
	public double getApuesta() {
		return apuesta;
	}

	/**
	 * 
	 * @param apuesta
	 */
	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return nombre+" de "+edad+" años de la ciudad "+ciudad;
	}
	
	/**
	 * 
	 * Metodo para apostar el dinero
	 * @return
	 */
	public double apostarDinero() {
		int alea = (int)(Math.random()*500+1);
		return alea;
	}
	
	/**
	 * 
	 * Metodo para tirar los dados
	 */
	public void lanzarDados() {
		int alea = 0;
		for(int i = 0;i<this.lanza.length;i++) {
			alea = (int)(Math.random()*6+1);
			this.lanza[i] = alea;
		}
	}
}
