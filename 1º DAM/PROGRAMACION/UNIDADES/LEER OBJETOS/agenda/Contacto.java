package objetos;

import java.io.Serializable;

public class Contacto implements Serializable{
	private String nombre;
	private String numero;
	private String dire;
	private String correo;
	
	// Constructor con todos los parametros
	public Contacto(String nombre, String numero, String dire, String correo) {
		this.nombre = nombre;
		this.numero = numero;
		this.dire = dire;
		this.correo = correo;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDire() {
		return dire;
	}

	public void setDire(String dire) {
		this.dire = dire;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// toString
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", numero=" + numero + ", dire=" + dire + ", correo=" + correo + "]";
	}
}
