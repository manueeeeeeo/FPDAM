package poo;

public class Carta {
	// Variables
	private int numero;
	private String palo;

	// Metodo Constructor
	public Carta() {
		this.numero = 0;
		this.palo = "";
	}

	//Metodo get y set
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	//toString
	@Override
	public String toString() {
		return numero + " de " + palo;
	}
	
	public void extraerCarta() {
		int alea = 8;
		String pal = "";
		String [] palo = {"oros", "bastos", "espadas", "copas"};
		
		while(alea==8 || alea==9) {
			alea = (int)(Math.random()*12+1);
		}
		pal = palo[(int)(Math.random()*4)];
		
		this.numero=alea;
		this.palo=pal;
	}
}
