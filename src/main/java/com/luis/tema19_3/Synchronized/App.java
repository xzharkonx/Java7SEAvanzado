package com.luis.tema19_3.Synchronized;


// Cuando trabajamos con concurrencia debemos tener muy en cuenta las secciones
// criticas, ¿Y a que nos referimos con secciones criticas?, a aquellas porciones
// de codigo donde existen elementos de recuso compartidos.

// Así que retomaremos lo que veniamos trabajando del patron Singleton y vamos a
// ver que cosas debemos tener en cuenta.

// También es importante hablar de una palabra reservada conocida como "Synchronized"
// está palabra reservada nos va a permitir proteger un bloque de código (un método
// para ser más exacto) de un múltiprocesamiento indeseado, ¿Qué significa esto?
// si nosotros quisieramos proteger una zona critica donde solamente necesitamos que 
// un hilo se procese a la vez, si recordamos el tema del patrón singleton donde 
// simplemente si la instancia era nula creabamos un objeto.
// En la Clase PaisDAOImpl podemos ver el método de public static PaisDAOImpl que
// nos retorna una instancia, pero esto funciona correcto siempre y cuando este en 
// un único hilo, en este caso el método main.

// Pero ahora como sabemos crear más de un hilo vamos a crear 2 hilos y vamos a ver
// que este código se cae.

// Recomendación: Darle una repasada al tema del patrón Singleton. Para que quede
// más entendible.

public class App {

	public static void main(String[] args) {
		
		// Así que nos apoyamos de un Runnable
		Runnable r = new Runnable() {

			// Colocamos aquí la implementación de estos métodos
			@Override
			public void run() {
				
				// Utilizando el Patrón Singleton-------------------------------------------------------------------------
				
				// Entonces para crear un objeto de esta Clase con una única instancia
				// lo haremos con el método getInstance()
				// La instancia es creada por primera vez
				PaisDAOImpl dao = PaisDAOImpl.getInstance();
				
				// Si la instancia es creada por primera vez entonces le agregara los
				// países a la lista y los retornará.
				for(Object obj : PaisDAOImpl.getPaises()) {
					System.out.println(((Pais)obj).getNombre());
				}
				
			}
			
		};
		
		// Debajo crearemos 2 hilos
		
		Thread hilo1 = new Thread(r);
		hilo1.start();

		Thread hilo2 = new Thread(r);
		hilo2.start();
		
		// Dentro de la Clase PaisDAOImpl creamos un mensaje dentro del método getIntance() que
		// diga que se a creado una instancia.
		
		// Ahora corremos la aplicación.
		// Miramos que sale el mensaje 2 veces de se ha creado una instancia, y estamos yendo
		// encontra del patrón Singleton porque nos dice que es tener una única instancia pero
		// aquí vemos 2.
		// ¿Que está pasando aquí?, como hemos creado 2 hilos justamente estos 2 hilos están
		// entrando a la vez y creando una instancia en el mismo instante de tiempo, por lo
		// tanto tengo 2 intancias en memoria que va en contra del patrón.
		
		// Para protegernos de esto o para corregirlo mejor dicho debemos utilizar la palabra reservada
		// "synchronized" en el método getInstance() de la Clase PaisDAOImpl
		
		// Vemos como ahora nos manda un solo mensaje de se ha creado una instancia
		
		// Otra forma de ponder la sincronización es colocar todo lo que hay dentro de ese método
		// (excepto el return), ir a ver a ese método para ver como está colocado.
		
		// Volvemos a correr el codigo y vemos que solo tenemos una única instancia.
		
		// Pero vemos que el método getPaises de vuelve un poco loco o incuerente si lo ejecutamos
		// varias veces, por lo que hay que SINCRONIZAR todos los métodos que coloquemos dentro
		// del hilo o hilos
	}

}
