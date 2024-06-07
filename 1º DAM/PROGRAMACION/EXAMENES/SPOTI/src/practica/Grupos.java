package practica;

public class Grupos {
	// Variables propias de la clase
	private String cod;
	private String nombre;
	private int fecha_Inicio;
	private String genero;
	
	// Constructor por defecto
	public Grupos() {
		this.cod = "";
		this.nombre = "";
		this.fecha_Inicio = 0;
		this.genero = "";
	}

	// Constructor con todos los parametros
	public Grupos(String cod, String nombre, int fecha_Inicio, String genero) {
		this.cod = cod;
		this.nombre = nombre;
		this.fecha_Inicio = fecha_Inicio;
		this.genero = genero;
	}

	// Getters y Setters
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFecha_Inicio() {
		return fecha_Inicio;
	}

	public void setFecha_Inicio(int fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return nombre+", Código: "+cod+", genero: "+genero+", desde: "+fecha_Inicio;
	}
	
	
}