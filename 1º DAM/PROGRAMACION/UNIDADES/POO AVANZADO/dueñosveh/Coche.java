package dueñosVeh;

public class Coche extends Vehiculo {
	//Atributos propios
	private String color;
	private int nPuertas;
	
	//Constructor predefinido
	public Coche() {
		super();
		this.color = "";
		this.nPuertas = 0;
	}
	
	//Constructor con todos los parametros
	public Coche(String matricula, String marca, String modelo, String color, int nPuertas) {
		super(matricula, marca, modelo);
		this.color = color;
		this.nPuertas = nPuertas;
	}
	
	//Getters y Setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getnPuertas() {
		return nPuertas;
	}

	public void setnPuertas(int nPuertas) {
		this.nPuertas = nPuertas;
	}

	//toString
	@Override
	public String toString() {
		return "Coche [color=" + color + ", nPuertas=" + nPuertas + ", matricula=" + matricula + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}
	
	//Para saber el tipo de vehiculo que es
	public String getTipo() {
		return "Coche";
	}
}
