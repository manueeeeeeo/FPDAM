package examenBarcos;

import java.util.Arrays;

public class Persona {
	private String nombre;
	private int edad;
	private String nick;
	private Boleto b1;
	
	//Constructor por defecto
	public Persona() {
		nombre = "";
		edad = 0;
		nick = "";
		b1 = new Boleto(6);
		b1.rellenarBoleto(b1.getB(), 6);
	}
	
	//Constructor 1
	public Persona(String nombre, int edad) {
		this.nombre = "";
		this.edad = 0;
		if(nombre.length()>3) {
			this.nick = "Jugador_"+nombre.substring(0, 3)+edad;
		}else {
			this.nick = "Jugador_"+nombre+edad;
		}
		b1 = new Boleto(6);
		b1.rellenarBoleto(b1.getB(), 6);
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Boleto getB1() {
		return b1;
	}

	public void setB1(Boleto b1) {
		this.b1 = b1;
	}

	//toString
	@Override
	public String toString() {
		return "El jugador "+this.nick+" tiene el boleto "+Arrays.toString(this.b1.getB());
	}
}
