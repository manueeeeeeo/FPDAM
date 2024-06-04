package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App implements GestionErrores {
	// Variables propias de la clase
	private ArrayList<Guia> guias;

	// Constructor predefinido
	public App() {
		this.guias = new ArrayList<Guia>();
	}

	// Getters y Setters
	public ArrayList<Guia> getGuias() {
		return guias;
	}

	public void setGuias(ArrayList<Guia> guias) {
		this.guias = guias;
	}

	public static void main(String[] args) {
		App app = new App();
		if (app.limpiarTotalGuia() == true) {
			System.out.println("TABLA LIMPIADA EXISTOSAMENTE");
		} else if (app.limpiarTotalGuia() == false) {
			System.out.println("LO SENTIMOS, PERO OCURRIDO UN ERROR LIMPIAR LA TABLA");
		}

		app.cargarGuias("personas.csv");
		int contador = 0;
		double salario = 0.0;

		if (args.length == 0) {
			for (Guia g : app.getGuias()) {
				g.cargarTuristas("personas.csv");
				for (Turista t : g.getTuristas()) {
					g.imprimirVisita(t);
					contador++;
				}
				System.out.println(g.getNombre() + " " + g.getApellidos() + " tiene hoy " + contador + " visitas");
				salario = app.ingreso(g);
				LocalDate d = LocalDate.now();
				BD.getInstance().cargarConexionXML();
				BD.getInstance().consultaBD("INSERT INTO TOTALGUIA VALUES('" + g.getId() + "', " + d.getDayOfMonth()
						+ ", '" + d.getMonth() + "', " + d.getYear() + ", " + salario + ")");
				BD.getInstance().cerrarConsulta();
				BD.getInstance().consultaBD("COMMIT");
				BD.getInstance().cerrarConsulta();
				contador = 0;
			}
		} else if (args.length == 1) {
			double uno = 0.0, total = 0.0;
			for (Guia g : app.getGuias()) {
				if (g.getId().equals(args[0].split("=")[1])) {
					System.out.println("Los turistas de " + g.getNombre() + " " + g.getApellidos() + " son: ");
					g.cargarTuristas("personas.csv");
					for (Turista t : g.getTuristas()) {
						t.cargarVisita("visitasHoy.txt");
						System.out.println(t.getId() + " " + t.getNombre() + " " + t.getApellidos());
						if (t.getVist().getIdioma().equals("español")) {
							uno = (t.getVist().getPrecio() * 25) / 100;
							System.out.println("\tIdioma de la visita: " + t.getVist().getIdioma() + "=>" + uno + "€");
						} else if (t.getVist().getIdioma().equals("ingles")) {
							uno = (t.getVist().getPrecio() * 30) / 100;
							System.out.println("\tIdioma de la visita: " + t.getVist().getIdioma() + "=>" + uno + "€");
						}
						total += uno;
						uno = 0;
					}
					System.out.println("\t\tImporte: " + total + "€");
				}
			}
		}
	}

	// Método para contar los ingresos de guia
	public double ingreso(Guia g) {
		double dinero = 0.0;
		for (Turista t : g.getTuristas()) {
			t.cargarVisita("visitasHoy.txt");
			if (t.getVist().getIdioma().equals("español")) {
				dinero += (t.getVist().getPrecio() * 25) / 100;
			} else if (t.getVist().getIdioma().equals("ingles")) {
				dinero += (t.getVist().getPrecio() * 30) / 100;
			}
		}
		return dinero;
	}

	// Método para cargar los guias
	public void cargarGuias(String filename) {
		try {
			Scanner ler = new Scanner(new File(filename));
			ler.nextLine();
			while (ler.hasNext()) {
				String cadena = ler.nextLine();
				String[] linea = cadena.split(";");

				if (linea[1].length() == 0) {
					String idG = linea[0];
					String nombre = linea[2];
					String ape = linea[3];
					String titu = linea[4];
					int expe = Integer.parseInt(linea[5]);
					this.getGuias().add(new Guia(idG, nombre, ape, titu, null, expe));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Borrar
	@Override
	public boolean limpiarTotalGuia() {
		boolean limpiado = false;
		int cont = 0;
		BD.getInstance().cargarConexionXML();
		BD.getInstance().consultaBD("DELETE FROM TOTALGUIA");
		BD.getInstance().cerrarConsulta();
		
		BD.getInstance().consultaBD("COMMIT");
		BD.getInstance().cerrarConsulta();

		ResultSet rest = BD.getInstance().consultaBD("SELECT * FROM TOTALGUIA");
		try {
			while (rest.next()) {
				cont++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (cont == 0) {
			limpiado = true;
		} else {
			limpiado = false;
		}
		return limpiado;
	}

}