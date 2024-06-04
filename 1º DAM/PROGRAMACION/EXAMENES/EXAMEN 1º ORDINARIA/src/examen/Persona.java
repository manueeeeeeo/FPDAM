package examen;

public abstract class Persona {
	// Variables propias de la clase
	protected String id;
	protected String nombre;
	protected String apellidos;
	
	// Constructor predefinido
	public Persona() {
		this.id = "";
		this.nombre = "";
		this.apellidos = "";
	}

	// Constructor con todos los parametros
	public Persona(String id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	// toString
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
}