package videoclub;

public class Alquiler {
	private int tiempo;
	private DVD dvd;
	
	//Constructor predefinido
	public Alquiler() {
		this.tiempo=0;
		this.dvd=new DVD();
	}
	
	//Constructor profesinal
	public Alquiler(int tiempo, DVD dvd) {
		this.tiempo = tiempo;
		this.dvd = dvd;
	}

	//Getters and Setters
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public DVD getDvd() {
		return dvd;
	}
	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	//toString
	@Override
	public String toString() {
		return "Alquiler [tiempo=" + tiempo + ", dvd=" + dvd + "]";
	}

  // Prueba unitaria
	public static void main(String[] args) {
		DVD mulan = new DVD("Mulan", DVD.INFANTIL);
		Alquiler a = new Alquiler(3, mulan);
		System.out.println(a);
	}
}
