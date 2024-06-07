package examenBarcos;

public class Juego {
	private Persona j1;
	private Persona j2;
	
	//Constructor
	public Juego(Persona j1, Persona j2) {
		this.j1 = new Persona();
		this.j2 = new Persona();
	}
	
	//Main
	public static void main(String[] args) {
		Persona m = new Persona("Manuel", 18);
		Persona i = new Persona("Alvaro", 23);
		System.out.println(m);
		System.out.println(i);
		System.out.println("***********************************************");
		System.out.println("************* COMIENZA EL JUEGO ***************");
		System.out.println("***********************************************");
		Juego j = new Juego(m, i);
		j.Partida(m, i);
	}
	
	public void Partida(Persona m, Persona i) {
		int pos = 0, cont1 = 2, cont2 = 2, longitud = 0;
		
		while(cont1>0 && cont2>0) {
			//Turno jugador 1
			System.out.println("\t Turno del jugador "+m.getNick());
			pos = (int)(Math.random()*6-1);
			System.out.println(m.getNick()+" dice el número: "+pos);
			if(i.getB1().getB()[pos]=='B') {
				System.out.println(i.getNick()+" dice el HUNDIDO");
				i.getB1().getB()[pos]='A';
				cont2--;
			}else {
				System.out.println(i.getNick()+" dice el número AGUA");
			}
			System.out.println("_______________________________________");
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			//Turno Jugador 2
			System.out.println("\t Turno del jugador "+i.getNick());
			pos = (int)(Math.random()*6-1);
			System.out.println(i.getNick()+" dice el número: "+pos);
			if(m.getB1().getB()[pos]=='B') {
				System.out.println(m.getNick()+" dice el HUNDIDO");
				m.getB1().getB()[pos]='A';
				cont1--;
			}else {
				System.out.println(m.getNick()+" dice el número AGUA");
			}
			System.out.println("_______________________________________");
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Al terminar el bucle detectar el ganador
		System.out.println();
		System.out.println("*****************************************************");
		System.out.println("***************** Final de juego *********************");
		System.out.println("*****************************************************");
		System.out.println();
		System.out.println("Los boletos han quedado: ");
		System.out.println(m);
		System.out.println(i);
		System.out.println();
		if(cont1>0) System.out.println("Ha ganado el Jugador: "+m.getNick());
		else if(cont2>0) System.out.println("Ha ganado el Jugador: "+i.getNick());
		else System.out.println("Se ha producido un empate");
	}
}
