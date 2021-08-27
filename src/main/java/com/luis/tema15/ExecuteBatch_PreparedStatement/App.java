package com.luis.tema15.ExecuteBatch_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	private Connection con = null;
	
	// Modificar con Statement.
	public void modificarBatchStatement(Persona per) throws SQLException{
		// Se captura el tiempo de inicio.
		long ini = System.currentTimeMillis();
		
		try {
			// Con esto estamos indicando que el tipo de transacción será de manera manual
			// es decir, cuando yo confirme todo se va a registrar y actualizar en la base de datos.
			con.setAutoCommit(false);
			
			// Entonces aquí colocamos un for, hacemos pruebas con 20, 500, 5000 y 10000.
			for (int i = 0; i < 10000; i++) {
				
				Statement st = con.createStatement();
				String sql = "UPDATE test SET nombre = '" + per.getNombre() + "', pass = '" + per.getPass() + "'";
				// System.out.println("Query => + sql");
				int numeroFilas = st.executeUpdate(sql);
				// System.out.println("#Filas Afectadas - Statement "+ numeroFilas);
				
			}

			
			// Ahora si, si llega hasta aquí con esto actualizamos y registramos en la base de datos,
			// por que puede que lo de arriba de error.
			con.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// Si llegará a dar error, hacemos un rollback para que todos los cambios no tengan efecto.
			con.rollback();
		}
		
		long fin = System.currentTimeMillis();
		System.out.println("Statement: "+ (fin-ini));
	}

	// # Modificar con PreparedStatement
        // ? Este es mejor y con un ps.addBatch() aún más esto ayuda a 
        // procesamientos masivos.
	public void modificarBatchPreparedStatement(Persona per) throws SQLException{
		// Se captura el tiempo de inicio
		long ini = System.currentTimeMillis();
		
		try {
			// Con esto estamos indicando que el tipo de transacción será de manera manual
			// es decir, cuando yo confirme todo se va a registrar y actualizar en la base de datos.
			con.setAutoCommit(false);
			
			PreparedStatement ps = null;
			
			// Entonces aquí colocamos un for
			for (int i = 0; i < 10000; i++) {
				
				// Sentencia SQL
				String sql = "UPDATE test SET nombre = ?, pass = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, per.getNombre());
				ps.setString(2, per.getPass());
				// Con este método decimos que la sentencia de arriba la vamos a concatenar a este Batch
				ps.addBatch();
				// System.out.println("Query => + sql");
				// Si colocamos arriba el método Batch, ya no lo ejecutariamos aquí uno por uno, si no que al final del for
				//int numeroFilas = ps.executeUpdate();
				// System.out.println("#Filas Afectadas - PreparedStatement "+ numeroFilas);
				
			}
			// Ejecutamos el Batch
			ps.executeBatch();
			
			// Ahora si, si llega hasta aquí con esto actualizamos y registramos en la base de datos,
			// por que puede que lo de arriba de error.
			con.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// Si llegará a dar error, hacemos un rollback para que todos los cambios no tengan efecto.
			con.rollback();
		}

		// Se captura el tiempo de fin
		long fin = System.currentTimeMillis();
		// Para medir el rendimiento en tiempos de cada método.
		System.out.println("PreparedStatement: "+ (fin-ini));
	}
	
	public void conectar() {
		try {
			
		final String JDBC_DRIVER ="org.postgresql.Driver";//Para postgresql
	        // final String JDBC_DRIVER ="com.mysql.jdbc.Driver"; //Para Mysql
		    
	        final String DB_URL = "jdbc:postgresql://localhost:5432/dbtestjava";//Para postgresql
	        // final String DB_URL = "jdbc:mysql://localhost:3306/ejemplo";//Para Mysql
	        
	        // base de datos credenciales
	        final String USER = "estudiante";
	        final String PASS = "estudiante";
	        
	        // Definimos la conexion y la libreria: java.sql.Connection;
	        // Recuerda descargar el conector o libreria de acuerdo a la
	        // version de la base de datos y anadirla en biblioteca
	        // En nuestro caso añadimos la dependencia de postgresql en el archivo pom.xml
	        
	        // # Hacemos la conexion
	        Class.forName(JDBC_DRIVER);
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
	
	public boolean leerPreparedStatement(Persona per) throws SQLException{
		boolean rpta = false;
		// Se añade PreparedStatement
		PreparedStatement ps = null;
		
		//try(Statement st = con.createStatement()){
		// Se coloca este try para cerrar la conexión del PrepareStatement
		try{
						
			// Mira como se cambia está línea por la de abajo, los valores de cambian por ?
			// String sql  = "SELECT * FROM test WHERE nombre = '"+per.getNombre()+"' AND pass = '"+per.getPass()+"'";
			String sql  = "SELECT * FROM test WHERE nombre = ? AND pass = ?";
			System.out.println("Query => " + sql);
			
			// Se cambia está parte donde le indicamos como colocara esos valores.
			// Recuerda cambiar el tipo de método conforme al tipo de dato.
			ps = con.prepareStatement(sql);
			ps.setString(1, per.getNombre());
			ps.setString(2, per.getPass());
			
			// Se cambia está parte
			//ResultSet rs = ps.executeQuery(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("Existen datos");
				rpta = true;
			} else {
				System.out.println("No existen datos");
			}
			
			System.out.println("Consulta exitosa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Cerramos la conexión del PrepareStatement
			ps.close();
		}
		
		
		return rpta;
	}
	
	public static void main(String[] args) throws SQLException {
		
		// En está ocación se hablará sobre la Clase PrepareStatement, vamos a medir el rendimiento
		// frente al tema anterior los Statements (Conocido como ExecuteBatch) que es para los procesamientos
		// en lotes o masivos de sentencias DML (Data Manipulation Languaje) hacia bases de datos.
		
		// Para empezar necesitamos crear una base de datos que llamaremos "dbtest".
		// Tendrá una tabla llamada "test", con los campos:
		// id SMALLSERIAL
		// nombre VARCHAR(50)
		// pass VARCHAR(50)
		// CONSTRAINT pk_id PRIMARY KEY (id)
		
		// Insertamos 1 dato:
		// INSERT INTO test (nombre, pass) VALUES ('Luis', '1234');
		
		// Crearemos una Clase Persona e incluiremos estos campos.
		
		// Revisa la programación del PrepareStatement en el método leerPreparedStatement.
		
		// Conexion de forma normal...
		App app = new App();
		
		app.conectar();
		
		boolean rpta = app.leerPreparedStatement(new Persona("luis","luis1234"));
		if(rpta) {
			System.out.println("Verificación correcta, ingresando al sistema...");
		}else {
			System.out.println("Credenciales incorrectas, acceso denegado");
		}
			
		app.desconectar();
		
		
		// Probemos con datos erroneos---------------------------------------------
		
		System.out.println("\n\n");
		app.conectar();
		
		boolean rptaErrorea = app.leerPreparedStatement(new Persona("LuisEduardo","1234"));
		if(rptaErrorea) {
			System.out.println("Verificación correcta, ingresando al sistema...");
		}else {
			System.out.println("Credenciales incorrectas, acceso denegado");
		}
		
		app.desconectar();
		
		// Esta vez vamos a ver que la conexión fue exitosa, la consulta cambia, no existen datos
		// la consulta fue exitosa y las credenciales son incorrectas porque no encontro coincidencia
		// con los valores que se han establecido.
		
		
		// Ahora vamos a intentar burlar esté mecanismo con la técnica conocida como Inyección SQL.
		
		// lo que vamos a hacer es justamente en el método donde sele pasan los parametros
		// boolean rptaErrorea = app.leerStatement(new Persona("LuisEduardo","1234"));
		// vamos a burlar esté mecanismo.
	
	
		System.out.println("\nConexión Vulnerada... :/\n");
		// Probemos  la inyección cambiando "1234" por: "xxx' OR 'L' = 'L"
		
		app.conectar();
		
		boolean rptaInyeccionSQL = app.leerPreparedStatement(new Persona("LuisEduardo","xxx' OR 'L' = 'L"));
		if(rptaInyeccionSQL) {
			System.out.println("Verificación correcta, ingresando al sistema...");
		}else {
			System.out.println("Credenciales incorrectas, acceso denegado");
		}
		
		app.desconectar();
		
		// Mira que las credenciales ahora son incorrectas porque ahora está protegido frente esté tipo de ataques.
		// ----------------------------------------------------------------------------------------------------
		
		// Pero el principal objetivo de esté tema es ver el rendimiento entre lo que son Statements y PrepareStatements
		// especificamente en procesos Batch, es decir, procesos masivos donde se ejecuten muchas consultas al momento
		// de hacer la llamada al método. 
		
		// Para ello se utilizarán 2 métodos:
		// modificarBatchStatement(Persona per);
		// modificarBatchPreparedStatement(Persona per);
		
		// Ahora para ejecutar la prueba haremos lo siguiente:
		System.out.println("\n--------------------------------------");
		// Creamos una nueva instancia de la Clase App para hacer la prueba.
		App appProbandoStatements = new App();
		
		appProbandoStatements.conectar();
		System.out.println("Tiempos:\n");
                // Se comentaron porque actualizan todos los campos de la tabla.
		// appProbandoStatements.modificarBatchStatement(new Persona("Luis","admin1234"));
		System.out.println("\n**************************************\n");
		// appProbandoStatements.modificarBatchPreparedStatement(new Persona("Luis","admin1234"));
		
		appProbandoStatements.desconectar();
		
		// Observa como el tiempo en el PreparedStatement es muchisimo menor que el de Statement.
		// Podemos comprobar que el PreparedStatement tiene un mejor rendimiento frente al Statement.
		
		// ¿Y esto porque?
		// Por que el PreparedStatement precompila la sentencia SQL que nosotros enviamos a la Base de Datos.
		// Entonces lo que pasa es que la Base de Datos va a tener ya una sentencia compilada y solamente se
		// dedica a ejecutarla mientras que el Statement tiene que Precompilarla en una Instancia hacia la 
		// Base de Datos y luego ejecutarla. Por eso el tiempo es mayor.
		
		// Ahora imaginemos que tenemos un proceso en los métodos modificarBatch que está dentro de un for
		// y en muchas ocaciones tenemos que registrar toda una lista y mandarla a base de datos, si no 
		// utilizamos un sorftware de persistencia UML podemos utilizar básico JDBC pero apoyandonos en un
		// un BatchUpdate que es un método muy útil cuando utilizamos los PrepareStatement.
		
		// Mira que ahora los tiempos con Batch se han reducido considerablemente en el método PreparedStatement.
		
		// La recomendación es que cuando tengamos procesamientos masivos, es decir, muchos Updates, Inserts o 
		// Deletes, en fin cualquier sentencia masiva DML, en lugar de utilizar un for y utilizar un executeUpdate()
		// uno por uno, se recomienda usar el executeBatch() donde se agrega cada lote al PrepareStatement porque se
		// precompila y al final cuando todo este agregado al batch lo ejecutan y el rendimiento va a ser muchisimo mejor.
	}

}
