package com.luis.tema3.Singleton;

public class App {

	public static void main(String[] args) {
		// Para el ejemplo se simulara una lista de paises y se hará uno sin Singleton y otro con Singleton.
		
		/* 
		 
			PaisDAOImpl dao = new PaisDAOImpl();
			
			for(Object obj : dao.getPaises()) {
				// Se hace un casteo de obj a Pais para que pueda acceder a sus métodos,
				// esto es porque la lista de Paises que asignamos en la clase PaisDAOImp
				// no tiene un generico indicado.
				System.out.println(((Pais)obj).getNombre());
			}
			
			System.out.println("*********Separación donde se vuelve a instanciar************");
			// Pero evitamos está segunda instanciación comprobando que la lista esté vacia, 
			// revisar PaisDAOImpl.java
	
			for(Object obj : dao.getPaises()) {
				// Se hace un casteo de obj a Pais para que pueda acceder a sus métodos,
				// esto es porque la lista de Paises que asignamos en la clase PaisDAOImp
				// no tiene un generico indicado.
				System.out.println(((Pais)obj).getNombre());
			}
			
			// El problema está cuando creamos otra instancia lo hace en un nuevo bloque de 
			// memoria por lo tanto cuando se vuelve a acceder con ese metodo getPaises()
			// la variable paises de ese método será nula y por lo tanto vuelve a acceder
			// a ese if y recolecta todos los valores de nuevo, es decir que tuvieramos
			// los mismos valores recolectados en el objeto "dao" y en el objeto "daoi".
			// Revisar el archivo PaisDAOImpl.java
			
			PaisDAOImpl daoi = new PaisDAOImpl();
			
			for(Object obj : daoi.getPaises()) {
				// Se hace un casteo de obj a Pais para que pueda acceder a sus métodos,
				// esto es porque la lista de Paises que asignamos en la clase PaisDAOImp
				// no tiene un generico indicado.
				System.out.println(((Pais)obj).getNombre());
			}
		
		*/
		
		// Si es una lista pequeña pues el rendimiento o la diferiencia no podría
		// ser tan significativa pero imagina que tienes una lista de miles de
		// registros y estar trayendo constantemente está data de base de datos
		// o de cualquier otro repositorio que tengamos, estarlo consumiendo
		// constantemente para mostrar lo mismo no tendría mucho sentido, además
		// la aplicación tendría un golpe en performance.
		
		
		
		// Para aplicar el patron Singleton hacemos lo siguiente:
		
		// Nos saltará un error si lo instanciamos de está manera porque el constuctor
		// es privado. Se hace privado para evitar está forma de instanciar la Clase.
		// Así cumpliremos con el patrón Singleton. 
		// PaisDAOImpl dao = new PaisDAOImpl();

		// Entonces para crear un objeto de esta Clase con una única instancia
		// lo haremos con el método getInstance()
		PaisDAOImpl dao = PaisDAOImpl.getInstance();
		
		// Se instancia desde el método que de coloco como estático y no de la instancia
		for(Object obj : PaisDAOImpl.getPaises()) {
		// for(Object obj : daoi.getPaises()) {
			// Se hace un casteo de obj a Pais para que pueda acceder a sus métodos,
			// esto es porque la lista de Paises que asignamos en la clase PaisDAOImp
			// no tiene un generico indicado.
			System.out.println(((Pais)obj).getNombre());
		}
		
		// Se instancia desde el método que de coloco como estático y no de la instancia
		for(Object obj : PaisDAOImpl.getPaises()) {
		// for(Object obj : daoi.getPaises()) {
			// Se hace un casteo de obj a Pais para que pueda acceder a sus métodos,
			// esto es porque la lista de Paises que asignamos en la clase PaisDAOImp
			// no tiene un generico indicado.
			System.out.println(((Pais)obj).getNombre());
		}
		
		
		// Nos saltará un error si lo instanciamos de está manera porque el constuctor
		// es privado. Se hace privado para evitar está forma de instanciar la Clase.
		// Así cumpliremos con el patrón Singleton. 
		// PaisDAOImpl daoi = new PaisDAOImpl();

		// Entonces para crear un objeto de esta Clase con una única instancia
		// lo haremos con el método getInstance()
		PaisDAOImpl daoi = PaisDAOImpl.getInstance();
		
		// Se instancia desde el método que de coloco como estático y no de la instancia
		for(Object obj : PaisDAOImpl.getPaises()) {
		// for(Object obj : daoi.getPaises()) {
			
			// Se hace un casteo de obj a Pais para que pueda acceder a sus métodos,
			// esto es porque la lista de Paises que asignamos en la clase PaisDAOImp
			// no tiene un generico indicado.
			System.out.println(((Pais)obj).getNombre());
		}
		
		// Cambiamos nombre a los paises para comprobar si a las otras variables les pasa lo mismo.
		// Con PaisDAOImpl.getPaises() obtenemos una lista de paises la cual será la que
		// le pasaremos para poderla cambiar, luego el método cambiarNombrePaises nos
		// devolvera esa misma lista pero ya con los nombre cambiados.
		
		// Pero utilizamos daoi.getPaises() daoi.cambiarNombrePaises(lista_de_paises)
		// para asegurarnos de que atacamos a ese objeto.
		for(Object obj : daoi.cambiarNombrePaises(daoi.getPaises())) {
			System.out.println(((Pais)obj).getNombre());
		}
		
		System.out.println("\n---------------Comprobamos con la primera instancia los datos----------------\n");
		for(Object obj : dao.getPaises()) {
			System.out.println(((Pais)obj).getNombre());
		}
		
		// Efectivamente todas se cambian de igual manera.
		
		System.out.println("\nComo vemos, cualquier variable que creemos contendrá los mismos datos de está"
				+ "\nmisma instancia, lo que si podremos hacer será modificarla y aúnque la copiemos en"
				+ "\notra variable será la misma");
		
		// Entonces cada variable que creemos con está clase instanciada de está manera
		// tendrá los mismos datos con los que fue instanciada por anteriormente (como una copia)
		// y solo será instanciada 1 sola vez, por lo que sean las variables que sean
		// cada vez que se cree una instancia ya conendrá los datos anteriores y si cambiamos algo
		// de información a una de estás variables, todas las demás quedarán iguales a esta.
		// Este patron puede complementarse con el Patrón DAO o con algún otro.
	}

}
