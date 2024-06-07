package dueñosVeh;

public class Moto extends Vehiculo {
	// Atributos propios
	private double cilindrada;

	// Constructor predefinido
	public Moto() {
		super();
		cilindrada = 0;
	}

	// Constructor con todos los parametros
	public Moto(String matricula, String marca, String modelo, double cilindrada) {
		super(matricula, marca, modelo);
		this.cilindrada = cilindrada;
	}

	// Getters y Setters
	public double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

	// toString
	@Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ "]";
	}

	// Para saber el tipo de vehiculo que es
	public String getTipo() {
		return "Moto";
	}
}
