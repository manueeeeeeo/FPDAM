package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BD {
	private static BD miInstancia = null;
	private static boolean permitirInstanciaNueva;

	private Connection conn;
	private Statement stmt;
	private String cadenaConex; // driver@server:puerto:sid
	private String usuario;
	private String pass;

	// Constructor predefinido
	public BD() throws Exception {
		if (!permitirInstanciaNueva) {
			throw new Exception("No se puede crear otro obejto. Usa getIntance()");
		}
	}

	// Metodo para obtener la instancia
	public static BD getInstance() {
		if (miInstancia == null) {
			permitirInstanciaNueva = true;
			try {
				miInstancia = new BD();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			permitirInstanciaNueva = false;
		}
		return miInstancia;
	}

	// GETTERS Y SETTERS
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public String getCadenaConex() {
		return cadenaConex;
	}

	public void setCadenaConex(String cadenaConex) {
		this.cadenaConex = cadenaConex;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// Metodo para hacer una consulta en la base de datos
	public ResultSet consultaBD(String consulta) {
		ResultSet rset = null;
		try {
			this.conn = DriverManager.getConnection(this.cadenaConex, this.usuario, this.pass);
			this.stmt = conn.createStatement();
			rset = stmt.executeQuery(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rset;
	}

	// Metodo para cerrar la consulta
	public void cerrarConsulta() {
		try {
			this.stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarConexionXML() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("config.json"));
			JSONObject parametros = (JSONObject) obj;
			String driver = (String) parametros.get("DRIVER");
			String servidor = (String) parametros.get("SERVIDOR");
			String puerto = (String) parametros.get("PUERTO");
			String sid = (String) parametros.get("SID");
			String user = (String) parametros.get("USUARIO");
			String pass2 = (String) parametros.get("CLAVE");
			
			this.cadenaConex = driver+servidor+":"+puerto+":"+sid;
			this.usuario = user;
			this.pass = pass2;
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BD.getInstance().cargarConexionXML();
		System.out.println(BD.getInstance().getUsuario()+" "+BD.getInstance().getPass()+" "+BD.getInstance().getCadenaConex());
		ResultSet rset = BD.getInstance().consultaBD("SELECT * FROM TOTALGUIA");
		try {
			while(rset.next()) {
				System.out.println(rset.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}