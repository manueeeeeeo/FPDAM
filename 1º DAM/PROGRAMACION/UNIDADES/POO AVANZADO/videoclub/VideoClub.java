package videoclub;

public class VideoClub {
	public static void main(String[] args) {
		//Creo los DVD's
		DVD casablanca = new DVD("Casablanca", DVD.NORMAL);
		DVD mulan = new DVD("Mulan", DVD.INFANTIL);
		DVD it = new DVD("IT", DVD.NOVEDAD);
		DVD esplendor = new DVD("Resplandor", DVD.NOVEDAD);
		DVD cars = new DVD("Cars", DVD.INFANTIL);
		DVD toystory = new DVD("TOY STORY", DVD.INFANTIL);
		
		//Creo los alquileres
		Alquiler a1 = new Alquiler(3, casablanca);
		Alquiler a2 = new Alquiler(4, mulan);
		Alquiler a3 = new Alquiler(2, it);
		
		//Creo los Clientes
		Cliente manuel = new Cliente("Manuel");
		Cliente alfonso = new Cliente ("Alfonso");
		Cliente alvaro = new Cliente("Alvaro");
		
		//Informe de manuel
		manuel.nuevoAlquiler(a1);
		manuel.nuevoAlquiler(a2);
		manuel.nuevoAlquiler(a3);
		manuel.informe(manuel);
		System.out.println();
		
		//Informe de alfonso
		alfonso.nuevoAlquiler(a2);
		alfonso.nuevoAlquiler(a3);
		alfonso.informe(alfonso);
		System.out.println();
		
		//informe de alvaro
		alvaro.nuevoAlquiler(a1);
		alvaro.informe(alvaro);
	}
}
