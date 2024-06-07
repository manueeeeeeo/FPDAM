package dueñosVeh;

public abstract class Vehiculo {
	// Atributos
	protected String matricula;
	protected String marca;
	protected String modelo;

	// Constructor predefinido
	public Vehiculo() {
		this.matricula = "";
		this.marca = "";
		this.modelo = "";
	}

	//Cosntructor con todos los parametros
	public Vehiculo(String matricula, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}

	//Getters y Setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	//toString
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	//Método para obtener el tipo
	public String getTipo() {
		return "";
	}
}
