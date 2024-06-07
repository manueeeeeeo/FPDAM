package examen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

public class EnvioPorFichero implements Envio{

	//Metodo de envio
	@Override
	public void enviarPublicidad(String destino, String mensaje) {
		try {
			PrintWriter salida = new PrintWriter(destino); // Creamos el archivo
			salida.println(mensaje); // Imprimos el mensaje
			salida.flush(); 
			salida.close(); // cerramos el PrintWriter
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}