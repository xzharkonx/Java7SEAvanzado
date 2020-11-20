package com.luis.tema14.InyeccionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	private Connection con = null;
	
	public void conectar() {
		try {
			
		    final String JDBC_DRIVER ="org.postgresql.Driver";//Para postgresql
	        // final String JDBC_DRIVER ="com.mysql.jdbc.Driver"; //Para Mysql
		    
	        final String DB_URL = "jdbc:postgresql://localhost:5432/dbtest";//Para postgresql
	        // final String DB_URL = "jdbc:mysql://localhost:3306/ejemplo";//Para Mysql
	        
	        // base de datos credenciales
	        final String USER = "estudiante";
	        final String PASS = "zelda1234";
	        
	        // Definimos la conexion y la libreria: java.sql.Connection;
	        // Recuerda descargar el conector o libreria de acuerdo a la
	        // version de la base de datos y anadirla en biblioteca
	        // En nuestro caso añadimos la dependencia de postgresql en el archivo pom.xml
	        
	        // Hacemos la conexion
	        Class.forName(JDBC_DRIVER);
			con = null;
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Conexión exitosa");
			
			
		} catch(Exception e) {
			System.out.println("Error de conexión");
		}
	}
	
	public void desconectar() throws SQLException {
		if (con != null) {
			con.close();
		}
	}
	
	public boolean leerStatement(Persona per) throws SQLException{
		boolean rpta = false;
		
		try(Statement st = con.createStatement()){
			String sql  = "SELECT * FROM test WHERE nombre = '"+per.getNombre()+"' AND pass = '"+per.getPass()+"'";
			System.out.println("Query => " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println("Existen datos");
				rpta = true;
			} else {
				System.out.println("No existen datos");
			}
			
			System.out.println("Consulta exitosa");
		} 
		
		
		return rpta;
	}
	
	public static void main(String[] args) throws SQLException {
		
		// En está ocación se hablará sobre la Clase Statement y las cosideraciones
		// a tener en cuenta cuando nos conectamos a Bases de Datos y hacemos algunas
		// consultas e insersiones, especificamente para evitar la Inyección SQL.
		
		// La inyección sql es una vulnerabilidad que es común encontrar en aplicativos 
		// que utilizan Statements para interactuar con la base de datos, en este tema 
		// se aprenderá sobre este tipo de ataques.

		// Entonce vamos a reforzar las cosas que hay que tener en cuenta solamente 
		// utilizando Statemens, está manera muy rudimentaria de hacer está conexión.
		
		// Para empezar necesitamos crear una base de datos que llamaremos "dbtest".
		// Tendrá una tabla llamada "test", con los campos:
		// id SMALLSERIAL
		// nombre VARCHAR(50)
		// pass VARCHAR(50)
		// CONSTRAINT pk_id PRIMARY KEY (id)
		
		// Insertamos 1 dato:
		// INSERT INTO test (nombre, pass) VALUES ('Luis', '1234');
		
		// Crearemos una Clase Persona e incluiremos estos campos.
		
		App app = new App();
		
		app.conectar();
		
		boolean rpta = app.leerStatement(new Persona("Luis","1234"));
		if(rpta) {
			System.out.println("Verificación correcta, ingresando al sistema...");
		}else {
			System.out.println("Credenciales incorrectas, acceso denegado");
		}
			
		app.desconectar();
		
		System.out.println("\n\n");
		// Probemos con datos erroneos
		app.conectar();
		
		boolean rptaErrorea = app.leerStatement(new Persona("LuisEduardo","1234"));
		if(rptaErrorea) {
			System.out.println("Verificación correcta, ingresando al sistema...");
		}else {
			System.out.println("Credenciales incorrectas, acceso denegado");
		}
		
		app.desconectar();
		
	// Esta vez vamos a ver que la conexión fue exitosa, la consulta cambia, no existen datos
	// la consulta fue exitosa y las credenciales son incorrectas porque no encontro coincidencia
	// con los valores que se han establecido.
	
	
	// Ahora vamos a burlar esté mecanisco con la técnica conocida como Inyección SQL.

	// Está se vale de un hueco en el sistema que el usuario va a poder ingresar datos de manera
	// manual o automática (Scripts) y ests datos van a ser enviados a nuestra base pudiendo ejecutar
	// operaciones que nosotros no deseamos.
	
	// El origen de este falló radica en el incorrecto checkeo o filtrado de las variables utilizadas
	// en un programa que contiene o bien genera código SQL.
	
	// Este tipo de vulnerabilidad puede ser aplicado a cualquier lenguaje de programación.
	
	// Para esté ejemplo nosotros tenemos 2 atributos a llenar que son Nombre y Clave
	// Imaginemos que tenemos una aplicación de escritorio donde tenemos 2 cajas de texto que
	// van a ser llenadas y van a ser almacenadas en esté objeto persona para luego
	// ser concatenadas a la sentencia SQL que esta armandose.
	
	// lo que vamos a hacer es justamente en el método donde sele pasan los parametros
	// boolean rptaErrorea = app.leerStatement(new Persona("LuisEduardo","1234"));
	// vamos a burlar esté mecanismo.
	
	
		System.out.println("\nConexión Vulnerada... :/\n");
		// Probemos  la inyección cambiando "1234" por: "xxx' OR 'L' = 'L"
		
		// Observa las comillas, vez como cierran y abren la sentencia...
		// Por lo que No volvemos a Cerrar Comillas al final, porque eso se concatena a la sentencia
		// en la cadena de texto original
		
		app.conectar();
		
		boolean rptaInyeccionSQL = app.leerStatement(new Persona("LuisEduardo","xxx' OR 'L' = 'L"));
		if(rptaInyeccionSQL) {
			System.out.println("Verificación correcta, ingresando al sistema...");
		}else {
			System.out.println("Credenciales incorrectas, acceso denegado");
		}
		
		app.desconectar();
		
		// Lo que pasará ahora es que nos dirá que existen datos y que la consulta fue exitosa.
		// Que la verificación fue correcta y se ingreso al sistema a pesar de que el usuario 
		// LuisEduardo no existe en la base de datos....
		
		// Hemos logrado burlar la seguridad
		// Así que podríamos cambiar el usuario y la verificación seguiría siendo exitosa.
		
		// Está es la infiltración de codigo que estamos teniendo justamente a la concatenación
		// de nuestra consulta, que hace o burla la consulta a nuestro mecánismo de verificación
		// y nos permite seguir avanzando en el sistema.
		
		// Observamos que luego de xxx cerramos una '
		// xxx'
		//Con eso estamos indicando que hasta ahí
		// ya proporcionamos el parametró, luego hemos colocado OR, entonces con el OR si nosotros
		// tenemos en la expresión anterior que es falso, entonces lo que se evaluaría seria que
		// lo de la izquierda a esa ' sería falso pero lo de la derecha sea verdadero esto es lo que
		// ponemos de 'L' = 'L' entonces como una compuerta OR falso y verdadero nos da Verdadero.
		
		// Por lo tanto lo que está indicando es, o sucede lo uno o sucede lo otro y por lo tanto
		// continua con la aplicación.
		
		// Entonces no es muy recomendable utilizar de está manera rudimentaria Statements y colocar
		// o armar toda la aplicación simplemente utilizando la concatenación de los valores de 
		// a cuerdo a los paramétros que uno va indicando, para ello existen otros mécanismos un poco
		// más protectores conocidos como los "Prepare Statements" o los "Collable Statements"
		// que nos proporciona el API de JDBC en Java.
		
		// Ahora si queremos apoyarnos de mecánismos más avanzados podemos apoyarnos de Frameworks
		// que engloban en Persistencia de Datos, como Hibernate o un Manipulador de Consultas de 
		// este tipo de Frameworks como mybatis o trabajar en base a lo que nos proporciona el 
		// estándar de Java como JPA.
		
		// Así que lo mejor es evitar en lo posible el uso de Statements para solicitar datos al usuario
		// y de está manera protegernos de esa vulnerabilidad de que el usuario pueda ingresar datos
		// como en esté ejemplo.
		
		// En los siguientes temas se veran los PreparedStatement y CallableStatement para evitar este
		// tipo de anomalías.
		
		
		
	}

}
