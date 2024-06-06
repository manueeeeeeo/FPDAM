package poo;
public class Dado {
	//Variables
	private int nCara;

	//Constructor por defecto
	public Dado() {
		this.nCara = 0;
	}
	
	//Getters y setters
	public int getnCara() {
		return nCara;
	}

	public void setnCara(int nCara) {
		this.nCara = nCara;
	}
	
	//toString
	@Override
	public String toString() {
		return " ---"+"\n| "+nCara+" |\n"+" ---";
	}
	
	//Lanzar el dado
	public  void lanzarDado() {
		this.nCara = (int)(Math.random()*6+1);
	}
}
