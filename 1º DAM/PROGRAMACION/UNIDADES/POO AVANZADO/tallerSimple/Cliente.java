package taller;

import java.util.Arrays;

public class Cliente {
	private String nombre;
	private String apellido;
	private String dni;
	private String direccion;
	private double saldo;
	private Vehiculo v[];
	
	public Cliente(String nombre, String apellido, String dni, String direccion, double saldo, Vehiculo[] v) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.saldo = saldo;
		this.v = v;
	}
	
	public Cliente() {
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.direccion = "";
		this.saldo = 0;
		this.v = new Vehiculo[5];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Vehiculo[] getV() {
		return v;
	}

	public void setV(Vehiculo[] v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion=" + direccion
				+ ", saldo=" + saldo + ", v=" + Arrays.toString(v) + "]";
	}	
}
