package objetos;

import java.util.Scanner;

public class App {
	
	public void menu() {
		System.out.println("1) Imprimir agenda");
		System.out.println("2) Añadir contacto");
		System.out.println("3) Eliminar contacto");
		System.out.println("4) Salir");
		System.out.print("Elige una opción: ");
	}
	
	public static void main(String[] args) {
		App app = new App();
		Agenda a = new Agenda();
		a.cargarAgenda("agenda.bin");
		int op = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			app.menu();
			op = sc.nextInt();
			switch(op) {
			case 1 : //imprimir agenda
				a.imprimirAgenda();
				break;
			case 2: // añadir contacto
				String nombre = "", numero = "", dir = "", correo = "";
				System.out.println();
				System.out.println("****************************");
				System.out.println("Registro de Contactos: ");
				System.out.println();
				System.out.print("Digame su nombre: ");
				nombre = sc.next();
				System.out.print("Digame su número: ");
				numero = sc.next();
				System.out.print("Digame su Dirección: ");
				dir = sc.next();
				System.out.print("Digame su Correo: ");
				correo = sc.next();
				a.getCont().add(new Contacto(nombre, numero, dir, correo));
				break;
			case 3: // eliminar
				String nom = "";
				System.out.print("Digame el nombre del Contacto que quiere borrar: ");
				nom = sc.next();
				a.eliminarContacto(nom);
				break;
			case 4: //salir
				a.guardarAgenda("agenda.bin");
				break;
			default:
				System.out.println("Lo sentimos!! Esa opción no está disponible aún");
				System.out.println();
				break;
			}
		}while(op!=4);
		System.out.println();
		System.out.println("FIN!!");
	}
}
