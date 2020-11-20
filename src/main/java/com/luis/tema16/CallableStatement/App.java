package com.luis.tema16.CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class App {
	
	private Connection con = null;

	public void conectar() {
		try {
			
		    final String JDBC_DRIVER ="org.postgresql.Driver"; // Para postgresql
	        // final String JDBC_DRIVER ="com.mysql.jdbc.Driver"; // Para Mysql
		    
	        final String DB_URL = "jdbc:postgresql://localhost:5432/dbtest"; // Para postgresql
	        // final String DB_URL = "jdbc:mysql://localhost:3306/ejemplo"; // Para Mysql
	        
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
	
	// Este será el método para ejecutar el procedimiento almacenado.
	// Lo que hará será insertar 1 dato en la tabla test de nuestra base de datos.
	public void registrarCallableStatement(Persona per) {
		
		try {
			// El SQL en este caso vamos a indicar la llamada al STORE PROCEDURE
			// Para las bases de datos MySQL utilizamos las llaves que es muy importante 
			//para que pueda reconocer y haga el llamado correspondiente y dentro de ella
			// el llamado como lo hacemos dentro de la Base de Datos.
			// También se le han colocado los ? como en el PreparedStatement.
			
			// Para PostgreSQL
			String sql = "SELECT * FROM spTest(?,?)";
			// Para MySQL
			// String sql = "{call spTest(?,?)}";
			
			// Creamos una instancia de CallableStatement por medio de la variable conexión (con)
			// y le mandamos el SQL con los parametros correspondientes.
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, per.getNombre());
			cs.setString(2, per.getPass());
			// Ejecutamos, y depende de si nos retorna algo, por ejemplo filas, podríamos almacenar
			// esas filas en un ResultSet y luego recorrer para mostrar los datos, como aquí el
			// STORE PROCEDURE no retorna nada lo dejamos así y solo lo invocamos.
			cs.execute();
			cs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Este será el método para ejecutar el procedimiento almacenado.
	// Lo que hará será consultar la tabla test de nuestra base de datos y traer esos datos.
	public void listarCallableStatement() {
		
		try {
			// El SQL en este caso vamos a indicar la llamada al STORE PROCEDURE
			// Para las bases de datos MySQL utilizamos las llaves que es muy importante 
			// para que pueda reconocer y haga el llamado correspondiente y dentro de ella
			// el llamado como lo hacemos dentro de la Base de Datos.
			// También se le han colocado los ? como en el PreparedStatement.
			
			// Para PostgreSQL
			String sql = "SELECT * FROM spListar()";
			// Para MySQL
			// String sql = "{call spListar()}";
			
			// Creamos una instancia de CallableStatement por medio de la variable conexión (con)
			CallableStatement cs = con.prepareCall(sql);

			// Ejecutamos, y depende de si nos retorna algo, por ejemplo filas, podríamos almacenar
			// esas filas en un ResultSet y luego recorrer para mostrar los datos, como aquí el
			// STORE PROCEDURE no retorna nada lo dejamos así y solo lo invocamos.
			
			// Si ejecutamos esto nos retornará un booleano
			cs.execute();
			// boolean x = cs.execute();
			// Para que nos devuelva la lista crearemos un ResultSet
			ResultSet rs = cs.getResultSet();
			
			// con el método .next nos devolvera de toda la lista de datos,
			// dato a dato que recorreremos dentro del while
			while (rs.next()) {
				// Obtenemos los datos y los mostramos
				System.out.print(rs.getInt("id")+" ");
				System.out.print(rs.getString("nombre")+" ");
				System.out.println(rs.getString("pass"));
				
			}
			
			
			
			cs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	
	// Este será el método para ejecutar el procedimiento almacenado.
	// Lo que hará será consultar la tabla test de nuestra base de datos con el nombre del objeto que le pasemos
	// y este traerpa el id de ese dato.
	public void listarOutCallableStatement(Persona per) {
		
		try {
			// El SQL en este caso vamos a indicar la llamada al STORE PROCEDURE
			// Para las bases de datos MySQL utilizamos las llaves que es muy importante 
			// para que pueda reconocer y haga el llamado correspondiente y dentro de ella
			// el llamado como lo hacemos dentro de la Base de Datos.
			// También se le han colocado los ? como en el PreparedStatement.
			
			// Para PostgreSQL
			String sql = "SELECT * FROM spSalidaID(?)";
			// Para MySQL
			// String sql = "{call spSalidaID(?,?)}";
			
			// Creamos una instancia de CallableStatement por medio de la variable conexión (con)
			CallableStatement cs = con.prepareCall(sql);
			// Recogemos el nombre tanto para Postgres como para MySQL
			cs.setString(1, per.getNombre());
			
			// Para obtener el dato con MySQL----------------------------------------------------------------
			// Para el parametro de salida de MySql , tenemos que registrarlo y para ello lo hacemos
			// de la siguiente forma, en (PostgreSQL no hay que agregarlo, eso dependera de nuestro STORE PRODECURE).
			//cs.registerOutParameter(2, Types.INTEGER);
			// También puede ser:
			//cs.registerOutParameter("id", Types.INTEGER);
			
			
			
			// Ejecutamos la consulta-------------------------------------------------------------------------
			// Si ejecutamos esto nos retornará un booleano o solo podríamos ejecutar el método.
			cs.execute();
			// boolean x = cs.execute();
			
			
			// Para obtener el Dato con MySQL----------------------------------------------------------------
			// int idSalida = cs.getInt(2);
			// También puede ser:
			// int idSalida = cs.getInt("id");
			
			// Mostramos el resultado.
			// System.out.println("El codigo obtenido de Salida es:" + idSalida);
			// También puede ser:
			// System.out.println("El codigo obtenido de Salida es:" + cs.getInt("id"));
			
			
			
			// Para obtener el Dato con PostgreSQL-----------------------------------------------------------
			// Ejecutamos, y depende de si nos retorna algo, por ejemplo filas, podríamos almacenar
			// esas filas en un ResultSet y luego recorrer para mostrar los datos, como aquí el
			// STORE PROCEDURE retorna 1 solo dato lo necesitamos para PostgreSQL.
			ResultSet rs = cs.getResultSet();
			
			// Se ejecuta el método next() para indicarle que avance al primer valor que encontro y como solo
			// devulve 1 se moverá a ese.
			rs.next();
			
			// Y con getInt(1) le pasamos el 1 para indicarle que es la primera posición y con esto habremos
			// obtenido ese dato.
			// rs.getInt(1);
			// Mostramos el resultado.
			System.out.println("El codigo obtenido de Salida es: " + rs.getInt(1));
			
			
			cs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		// Como ya conocemos las ventajas que tenemos de los PreparedStement frente los Statements

		// Ahora vamos a aprender a poder llamar a los procedimientos almacenados o StoreProcedure
		// que están almacenados en nuestra base de datos, para ello nos apoyamos de la Interface
		// CallableStatement y está interfaz extiende/hereda de PreparedStatement, es decir, presenta
		// funcionalidades muy parecidas, sin embargo tiene un mecánismo para poder llamar a los
		// procedimientos almacenados.
		
		// A nivel base de datos debemos de crear un procedimiento almacenado que se invocara desde
		// aquí en el código.
		
		// El lenguaje procedural será distinto para cada base de datos y como utilizamos la base de datos PostgreSQL
		// el codigo que utilizaremos para crear la función procedural será el siguiente (ejecutarlo línea a línea 
		// estándo dentro de la base de datos):
		
		// ----------------- PROCEDIMIENTOS ALMACENADOS (STORE PROCEDURES) CODIGOS--------------------------------------
		
		// Procedimiento almacenado para insertar los datos...
		
		// En PostgreSQL será el siguiente:
		
		//		-- CREACIÓN DE LA FUNCIÓN
		//		-- Los 2 guiones significan comentarios y debemos ejecutar linea a linea dentro de la Base de Datos.
		//		CREATE OR REPLACE FUNCTION spTest(_nombre character varying, _pass character varying)
		//		-- Para retornar elementos vacios, es decir, que no retorne nada y solo haga lo que tenga que hacer.
		//		-- En este caso solo insertaremos los datos.
		//		RETURNS void 
		//		AS
		//		-- Para retornar algo
		//		-- RETURNS SETOF ventas
		//		-- AS
		//		$BODY$
		//		-- DECLARE
		//		  -- inicio integer;
		//		BEGIN
		//		   -- REGISTRAR LOS DATOS
		//		  INSERT INTO test (id, nombre, pass)
		//		  VALUES (DEFAULT, _nombre, _pass);
		//
		//		END;
		//		$BODY$
		//		LANGUAGE plpgsql;
		//
		//
		//		-- LLAMADO DE LA FUNCIÓN QUE PERMITE INSERTAR LOS DATOS.
		//		SELECT * FROM spTest('root', 'root');
		
		// Para ejecutar este procedimiento almacenado desde el código se acreado el método
		// registrarCallableStatement(Persona per)
		
		// Llamamos a ese método.
		
		
		
		// En MySQL sería el siguiente:
		
		//		DELIMITER //
		//		CREATE PROCEDURE spTest(IN nombreParam VARCHAR(50), IN passParam VARCHAR(50))
		//		BEGIN
		//			INSERT INTO test (nombre,pass) VALUES(nombreParam,passParam);
		//		END //
		//		DELIMITER ;
		//		
		//		CALL spTest('root','root');
		//		
		//		SELECT * FROM spTest('root', 'root');
				

		// Para ejecutar este procedimiento almacenado desde el código se acreado el método
		// registrarCallableStatement(Persona per)
		
		// Llamamos a ese método.
		
		// -------------------------------------------------------------------------------------------------------
		
		// Procedimiento almacenado para listar los datos...
		
		// PostgreSQL
		
		//		-- CREACIÓN DE LA FUNCIÓN PARA HACER UNA CONSULTA Y RETORNAR LOS DATOS DE UNA TABLA.
		//		CREATE OR REPLACE FUNCTION spListar()
		//		RETURNS SETOF test
		//		AS
		//		$BODY$
		//		BEGIN
		//		  -- CONSULTAR LA TABLA Y DEVOLVEMOS LO SOLICITADO
		//		  RETURN QUERY SELECT * FROM test;
		//		END;
		//		$BODY$
		//		LANGUAGE plpgsql;
		//
		//		-- LLAMADO DE LA FUNCIÓN QUE PERMITE CONSULTAR LOS DATOS.
		//		SELECT * FROM spListar();
		
		// Para ejecutar este procedimiento almacenado desde el código se acreado el método
		// listarCallableStatement()
		
		// Llamamos a ese método.
		
		
		
		
		// MySQL
		
		//		DELIMITER //
		//		CREATE PROCEDURE spListar()
		//		BEGIN
		//			SELECT * FROM test;
		//		END //
		//		DELIMITER ;
		//		
		//		CALL spListar();

		
		// Para ejecutar este procedimiento almacenado desde el código se acreado el método
		// listarCallableStatement()
		
		// Llamamos a ese método.
		
		// ------------------------------------------------------------------------------------------------------
		
		
		// Otro Procedimiento Almacenado (STORE PROCEDURE) donde simplemente pasandole el objeto Persona y 
		// a través del nombre del objeto voy a obtener el id
		
		// PostgreSQL
		
		//		-- CREACIÓN DE LA FUNCIÓN PARA HACER UNA CONSULTA CON EL NOMBRE RETORNAR EL ID DE ESE DATO CONSULTADO.
		//		CREATE OR REPLACE FUNCTION spSalidaID(_nombre character varying)
		//		-- Podemos retornar está variedad de datos segun sea el que querramos.
		//		-- RETURNS character varying
		//		-- RETURNS real
		//		-- RETURNS SETOF INTEGER
		//		RETURNS SETOF SMALLINT
		//		AS
		//		$BODY$
		//		BEGIN
		//		  -- CONSULTAR LA TABLA Y DEVOLVEMOS LO SOLICITADO
		//		  RETURN QUERY SELECT id FROM test WHERE nombre = _nombre;
		//		END;
		//		$BODY$
		//		LANGUAGE plpgsql;
		//
		//		-- LLAMADO DE LA FUNCIÓN QUE PERMITE CONSULTAR LOS DATOS.
		//		SELECT * FROM spSalidaID('_nombre');
		
		// Para ejecutar este procedimiento almacenado desde el código se acreado el método
		// listarOutCallableStatement(Persona per)
		
		// Llamamos a ese método.
		
		
		
		// MySQL
		
		//		DELIMITER //
		//		CREATE PROCEDURE spSalidaID(IN nombreParam VARCHAR(50), OUT idParam INT)
		//		BEGIN
		//			SELECT id INTO idParam FROM test where nombre = nombreParam;
		//		END //
		//		DELIMITER ;
		
		// Para ejecutar este procedimiento almacenado desde el código se acreado el método
		// listarOutCallableStatement(Persona per)
		
		// Llamamos a ese método.
		
		
		
		// Para ELIMINAR una FUNSIÓN ya creada en PostgreSQL:
		// DROP FUNCTION spSalidaID(character varying);
		
		
		// ------------- Comenzamos a probar los métodos------------------------------------------
		
		App app = new App();
		
		app.conectar();
		
		//app.registrarCallableStatement(new Persona("Ing Luis Eduardo", "1234"));
		// Si observamos el la base de datos veremos que efectivamente se a ingresado este dato.
		
		// Listamos los datos consultados desde el STORE PROCEDURE.
		// app.listarCallableStatement();
		// Vemos que si nos consulto los nombres.
		
		// Para que nos retorne un solo dato, en este caso el ID
		// app.listarOutCallableStatement(new Persona("Ing Luis Eduardo", "1234"));
		app.listarOutCallableStatement(new Persona("root", "root"));
		// app.listarOutCallableStatement(new Persona("Luis", "admin1234"));
		
		app.desconectar();
		
	}

}
