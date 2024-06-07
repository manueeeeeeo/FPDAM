package videoclub;

public class Cliente {
	private Alquiler[] alquileres;
	private String nombre;
	private int posicion;

	// Constructor por defecto
	public Cliente() {
		this.alquileres = new Alquiler[5];
		this.posicion = 0;
		this.nombre = "";
	}

	// Constructor profesional
	public Cliente(String nombre) {
		this.nombre = nombre;
		this.alquileres = new Alquiler[5];
		this.posicion = 0;
	}

	// Constructor con todos los parametros
	public Cliente(Alquiler[] alquileres, String nombre, int posicion) {
		this.alquileres = alquileres;
		this.nombre = nombre;
		this.posicion = posicion;
	}

	// Getters y Setters
	public Alquiler[] getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(Alquiler[] alquileres) {
		this.alquileres = alquileres;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

  // Método para generar un nuevo alquiler
	public void nuevoAlquiler(Alquiler a) {
		if (this.posicion < 5) {
			this.alquileres[posicion] = a;
			this.posicion++;
		}
	}

  // Método para ver el informe de cada cliente
	public void informe(Cliente a) {
		int puntos = 0;
		double precio = 0.0, total = 0.0;
		
		System.out.println("Informe para "+a.getNombre());
		for(int i = 0;i<a.getPosicion();i++) {
			if(a.getAlquileres()[i].getDvd().getTipo()==0) precio = 2;
			else if(a.getAlquileres()[i].getDvd().getTipo()==1) precio = 3;
			else if(a.getAlquileres()[i].getDvd().getTipo()==2) precio = 1.5;
			precio = precio * a.getAlquileres()[i].getTiempo();
			System.out.println("\t "+a.getAlquileres()[i].getDvd().getTitulo()+"\t "+precio+"€");
			total += precio;
			System.out.println();
			if(a.getAlquileres()[i].getDvd().getTipo()==1 && a.getAlquileres()[i].getTiempo()>1) puntos+=2;
			else puntos++;
		}
		System.out.println("IMPORTE TOTAL = "+total+" €");
		System.out.println("Dispone de "+puntos+" puntos");
	}
}
