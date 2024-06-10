package objetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Agenda {
	ArrayList<Contacto> cont;
	
	public Agenda() {
		this.cont = new ArrayList<Contacto>();
	}

	// Getters y Setters
	public ArrayList<Contacto> getCont() {
		return cont;
	}

	public void setCont(ArrayList<Contacto> cont) {
		this.cont = cont;
	}
	
	// Leer los contactos del fichero
	public void cargarAgenda(String filename) {
		try {
			FileInputStream fi = new FileInputStream(filename);
			ObjectInputStream entrada = new ObjectInputStream(fi);
			Contacto c = null;
			while(entrada!=null) {
				try {
					c=(Contacto)entrada.readObject();
					this.getCont().add(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					entrada = null;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Ver los contactos
	public void imprimirAgenda() {
		for (Contacto contacto : cont) {
			System.out.println(contacto.getNombre()+" "+contacto.getNumero());
		}
	}
	
	// Eliminar un contacto
	public void eliminarContacto(String name) {
		for(int i = 0;i<this.getCont().size();i++) {
			if(this.getCont().get(i).getNombre().equalsIgnoreCase(name))
				this.getCont().remove(i);
		}
	}
	
	// Guardar los contactos del AL en el fichero
	public void guardarAgenda(String filename) {
		// escribir -> OUT
		try {
			FileOutputStream fo = new FileOutputStream(filename);
			ObjectOutputStream salida = new ObjectOutputStream(fo);
			for(Contacto c: this.getCont()) {
				salida.writeObject(c); // escribimos los objetos en el fichero
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Añadir un contacto
	public void addContacto(Contacto c)
	{
		this.getCont().add(c);
	}

  // Prueba unitaria
	public static void main(String[] args) {
		Agenda a = new Agenda();
		
		a.cargarAgenda("agenda.bin"); // Cargamos la agenda
		a.imprimirAgenda(); // Imprimimos la agenda para ver todo lo que tenemos
		System.out.println("--------------------------");
		a.addContacto(new Contacto("Jose", "777777777", "Jose Jose", "random@gmail.com")); // Agregamos un nuevo contacto
		a.guardarAgenda("agenda.bin"); /// Guardamos la agenda nueva
		a.imprimirAgenda();
		System.out.println("--------------------------");
		a.eliminarContacto("Manuel");
		a.imprimirAgenda();
		a.guardarAgenda("agenda.bin");
	}
}
