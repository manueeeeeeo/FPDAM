package practica;

public class Canciones {
	// Variables propias de la clase
	private String codGrup;
	private String album;
	private String nombre;
	private int minut;
	private int seg;
	
	// Constructor predefinido
	public Canciones() {
		this.codGrup = "";
		this.album = "";
		this.nombre = "";
		this.minut = 0;
		this.seg = 0;
	}

	// Constructor con todos los parametros
	public Canciones(String codGrup, String album, String nombre, int minut, int seg) {
		this.codGrup = codGrup;
		this.album = album;
		this.nombre = nombre;
		this.minut = minut;
		this.seg = seg;
	}

	// Getters y Setters
	public String getCodGrup() {
		return codGrup;
	}

	public void setCodGrup(String codGrup) {
		this.codGrup = codGrup;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMinut() {
		return minut;
	}

	public void setMinut(int minut) {
		this.minut = minut;
	}

	public int getSeg() {
		return seg;
	}

	public void setSeg(int seg) {
		this.seg = seg;
	}

	@Override
	public String toString() {
		return nombre+", Albúm: "+album+", Duración: "+minut+":"+seg;
	}
}