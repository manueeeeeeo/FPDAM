package videoclub;

public class DVD {
	private String titulo;
	private int tipo;
	
	//Constructor predifinido
	public DVD() {
		this.titulo="";
		this.tipo=DVD.NORMAL;
	}

	//Constructor profesional
	public DVD(String titulo, int tipo) {
		this.titulo = titulo;
		this.tipo = tipo;
	}

	//Getters and Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public static final int INFANTIL = 2;
	public static final int NORMAL = 0;
	public static final int NOVEDAD = 1;

	//toString
	@Override
	public String toString() {
		return "DVD [titulo=" + titulo + ", tipo=" + tipo + "]";
	}
}
