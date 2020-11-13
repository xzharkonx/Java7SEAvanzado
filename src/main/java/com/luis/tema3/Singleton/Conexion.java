package com.luis.tema3.Singleton;

// Está clase no se utiliza más que para explicar como se ve el patrón SINGLETON, revisar la clase PaisDAOImpl donde se implementa.
public class Conexion {
	
	// Lo que dice este patrón es
	// poseer una sola instancia en este caso de la clase Conexion
	// Creamos un objeto vacio de está Clase llamado instancia
	private static Conexion instancia = null;
	
	// Cuando un método en java te devuelve un valor por convenciones
	// se coloca el prefijo get, de ahí lo que le querramos poner de nombre.
	
	// Para hacerlo lo haremos de la siguiente manera. Creamos un método público.
	public static Conexion getInstance(){
		// Vamos a comprobar si el nombre del objeto, es decir, la instancia
		// es igual a null, por lo tanto no se a instanciado por primera vez.
		if (instancia == null) {
			// Si es nulo, vamos a devolver una nueva instancia de Conexion.
			// Es decir, le daremos un valor a está variable que antes era null,
			// de esta forma haremos la instancia a través de este método y
			// retornaremos el objeto.
			instancia = new Conexion();
		}
		
		
		return instancia;
	}
	
	// Solo faltaría para que está clase pueda tener una única instancia
	// agregar un constructor privado. Para que de está manera puedas asegurar
	// una única instancia y o haya instancias posteriores de tu clase
	private Conexion() {
		
	}
	
	// Entonces aquí ya tendríamos la implementación del patrón Singleton
	// ¿Que funcionalidades le puedo dar?
	// Una de ellas en las conexiones a base de datos.
		// Pues como es fija, no es variable, durante el transcurso de la aplicación.
	// Otra de las aplicaciones es en el Framework de Spring.
		// Sus containers manejan los beans de un ambito Singleton.
	// Otra de las funcionalidades también podría ser que si en nuestra aplicacion tenemos
	// datos que son constantes, es decir, no va a variar en el transcuso de nuestra aplicación,
	// por ejemplo, la lista de ciudades, la lista de países, etc.. Estos no van a variar
	// Por lo tanto sería recomendable tenerlos como Singleton para que todas nuestras clases
	// accedan a esa única instancia y por lo tanto tengamos un mejor rendimiento en nuestra aplicación.
	
	// Para el ejemplo se simulara una lista de paises y se hará uno sin Singleton y otro con Singleton.
}
