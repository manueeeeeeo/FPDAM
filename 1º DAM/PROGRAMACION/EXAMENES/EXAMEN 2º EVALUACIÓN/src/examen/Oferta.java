package examen;

public class Oferta {
	// Variables propias de la clase
	private String codProducto;
	private String nombre;
	private String categoria;
	private int puntos;
	
	// Constructor predefinido
	public Oferta() {
		this.codProducto = "";
		this.nombre = "";
		this.categoria = "";
		this.puntos = 0;
	}

	// Constructor con todos los parametros
	public Oferta(String codProducto, String nombre, String categoria, int puntos) {
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.puntos = puntos;
	}

	// Getters y Setters
	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	// toString
	@Override
	public String toString() {
		return "Código: "+codProducto+", "+nombre+", "+categoria+", Puntos: "+puntos;
	}
}