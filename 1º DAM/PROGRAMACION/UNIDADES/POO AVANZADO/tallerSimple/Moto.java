package taller;

public class Moto extends Vehiculo {
	private double cilindrada;

	public Moto(String matricula, String marca, String modelo, double cilindrada) {
		super(matricula, marca, modelo);
		this.cilindrada = cilindrada;
	}

	public Moto() {
		super();
		this.cilindrada=0;
	}

	public double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ "]";
	}
}
