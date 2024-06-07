package examenBarcos;

import java.util.Arrays;

import ejemplos.Nota;

public class Boleto {
	private char [] b;
	private int longitud;
	
	//Constructor por defecto
	public Boleto() {
		this.longitud = 0;
		this.b = new char[longitud];
		for(int i = 0;i<this.b.length;i++) { //Sirve para evitar los nulos en el array de enteros
			this.b[i] = 'A';
		}
	}
	
	//Constructor
	public Boleto(int longitud) {
		this.longitud = 0;
		this.b = new char[longitud];
		for(int i = 0;i<this.b.length;i++) { //Sirve para evitar los nulos en el array de enteros
			this.b[i] = 'A';
		}
	}
	
	//Getters y Setters
	public char[] getB() {
		return b;
	}

	public void setB(char[] b) {
		this.b = b;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	//Metodo para rellenar el Boleto
	public void rellenarBoleto(char [] b, int longitud) {
		int pos = 0, cont = 0;
		while(cont<2) {
			pos = (int)(Math.random()*longitud);
			if(b[pos]=='A') {
				b[pos]='B';
				cont++;
			}
		}
	}
	
	//toString
	@Override
	public String toString() {
		return "Boleto " + Arrays.toString(b);
	}
}
