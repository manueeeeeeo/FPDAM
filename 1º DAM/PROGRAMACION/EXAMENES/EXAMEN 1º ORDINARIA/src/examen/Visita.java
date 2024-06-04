package examen;

public class Visita {
	// Variables propias de la clase
	private String codigo;
	private int hor_visita;
	private String idioma;
	private double precio;
	
	// Constructor predefinido
	public Visita() {
		this.codigo = "";
		this.hor_visita = 0;
		this.idioma = "";
		this.precio = 0.0;
	}

	// Constructor con todos los parametros
	public Visita(String codigo, int hor_visita, String idioma, double precio) {
		this.codigo = codigo;
		this.hor_visita = hor_visita;
		this.idioma = idioma;
		this.precio = precio;
	}

	// Getters y Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getHor_visita() {
		return hor_visita;
	}

	public void setHor_visita(int hor_visita) {
		this.hor_visita = hor_visita;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// toString
	@Override
	public String toString() {
		return "Visita [codigo=" + codigo + ", hor_visita=" + hor_visita + ", idioma=" + idioma + ", precio=" + precio
				+ "]";
	}
}