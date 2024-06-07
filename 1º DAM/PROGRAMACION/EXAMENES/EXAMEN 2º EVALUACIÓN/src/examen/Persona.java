package examen;

public class Persona {
	// Variables propias de la clase
	protected String tipo;
	protected String nombre;
	protected String apellidos;
	protected String correo;
	
	// Constructor predefinido
	public Persona() {
		super();
		this.tipo = "";
		this.nombre = "";
		this.apellidos = "";
		this.correo = "";
	}

	// Constructor con todos los parametros
	public Persona(String tipo, String nombre, String apellidos, String correo) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
	}

	// Getters y Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// toString
	@Override
	public String toString() {
		return "Persona [tipo=" + tipo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + "]";
	}
}