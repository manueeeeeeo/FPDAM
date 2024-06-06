package poo;
import java.util.*;

public class Adivina {
		String secreta;
		String aux="";
		//constructor sin parámetros
		Adivina(){
			this.secreta="PAYASO";
			this.aux=this.secreta;
		}

		//constructor con parámetros
		Adivina(String cadena){
			
		}
		//Imprime secreta con _ en lugar de vocal
		public String imprimirSinVocales() {
			for(int i = 0;i<secreta.length();i++) {
				if(secreta.charAt(i)=='A' || secreta.charAt(i)=='E' || secreta.charAt(i)=='I' || secreta.charAt(i)=='O' || secreta.charAt(i)=='U') {
					if(i!=(secreta.length()-1))
						aux = aux.substring(0, i)+'_'+aux.substring((i+1), (secreta.length()));
					else
						aux = aux.substring(0, i)+'_';
				}
			}
			return aux;
		}
		

		//Devuelve verdadero si la vocal v está en secreta
		public  boolean vocalEncontrada(String v) {
			if(secreta.contains(v)) return true;
			else return false;
		}
		
		//Getters y setters
		public String getSecreta() {
			return secreta;
		}

		public void setSecreta(String secreta) {
			this.secreta = secreta;
		}

		public String getAux() {
			return aux;
		}

		public void setAux(String aux) {
			this.aux = aux;
		}

		//Imprime secreta con vocal/vocales en su sitio
		public String imprimir(String vocal) {
			for(int i = 0;i<secreta.length();i++) {
				if(secreta.charAt(i)==vocal.charAt(0))
					if(i!=(secreta.length()-1))
						aux = aux.substring(0, i)+vocal.charAt(0)+aux.substring((i+1), (aux.length()));
					else
						aux = aux.substring(0, i)+vocal.charAt(0);
			}
			return aux;
		}
}
