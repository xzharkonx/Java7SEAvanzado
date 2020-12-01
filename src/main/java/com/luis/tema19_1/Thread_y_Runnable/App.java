package com.luis.tema19_1.Thread_y_Runnable;

// En una aplicación Java, si es que no creamos Hilos adicionales como en esté ejemplo que 
// hemos agregado de la Clase Thread.
// Por defecto Java presenta un único Hilo que es el Hilo de la Clase main, es decir
// el hilo principal que ejecuta toda la aplicación línea por línea hasta que termine.
// Pero si en el transcurso tu divides o vifurcas muchas más instancias de hilo el hilo
// principal va ejecutandose pero a medida que va avanzando la ejecución vas creando nuevas
// instancias de hilo, por lo tanto vamos a tener PROCESAMIENTO CONCURRENTE, vamos a tener
// muchos procesos a la vez mientras que el hilo principal sigue ejecutandose.
public class App {

	// Aquí en el método principal donde vamos a ejecutar la Aplicación vamos a crear una instancia
	// de la Clase de THilo que hemos creado.
	public static void main(String[] args) {

		// Hilo heredando de Thread-----------------------------------------------------------------
		// Instancia del Hilo que hemos creado de la Clase THilo
		// Y le pasamos el id de 1, porque creamos un constructor con 1 parametro.
		THilo hilo1 = new THilo(1);
		// Para llamar la ejecución de esté metodo run(), muchas personas hacen lo siguiente:
		// hilo1.run();
		// Pero para poder crear este proceso alterno necesitamos apoyarnos del método start()
		hilo1.start();
		
		// Interfaz Runable------------------------------------------------------------------------------------
		
		// Entonces si nosotros queremos iniciar un hilo hacemos lo siguiente:
		// Y el constructor me está pidiendo un objeto que implemente la interfaz Runnable, que es justamente
		// lo que hemos indicado en la Clase RHilo
		
		Thread hilo2 = new Thread(new RHilo(2));
		
		// Entonces ahora este hilo2 vamos a iniciarlo también con el método start().
		// Corremos la aplicación y deberían ejecutarse esos Threads a la vez
		hilo2.start();
		// Entonces podemos ver que se están ejecutando estos 3 métodos a la vez.
		
		// Hilo de Clase anoníma/directa----------------------------------------------------------------------
		
		// Ahora si nosotros quisieramos crear un hilo apoyandonos solamente de una Clase anonima, es decir,
		// no definirla como lo hemos hecho en las clases de Hilos (THilo y RHilo), basicamente podríamos 
		// apoyarnos de un Runnable de está manera:
		
		// Pero si nos damos cuenta las interfaces no pueden instanciarse, por eso creamos una Clase anonima
		// abriendo los Corchetes, también hay que colocarle un ; al final de los corchetes.
		Runnable r = new Runnable() {
			// Nos va a pedir implemenar básicamente sus méodos abstractos, para ello vamos a tener que
			// sobreescribir el método run()
			@Override
			public void run() {
				// Y simplemente aquí decimos lo siguiente:
				// A de anonimo.
				for (int i = 0; i < 100; i++) {
				System.out.println("[A] Hilo Anonimo ejecutandose.");
				}
				
			}
			
		};
		
		// Ahora lo que debemos de crear es un hilo y nos pide una instancia un objeto que herede de Thread
		// o en su defecto que implemente la interfaz Runnable, en este caso como tenemos este runable
		// anonimo podemos pasarselo.
		Thread hilo3 = new Thread(r);
		// Ahora sí podemos ejecutar ese hilo con el método start().
		hilo3.start();
		
		// Ahora podemos ver que tenemos los 3 hilos ejecuandose.
		
		// Hilo principal ------------------------------------------------------------------------
		// Pero expliquemos lo que sucede al hacer esto, como el hilo principal de Java es el main
		// y a corriendo línea a línea una a una hasta que acabe la aplicación, por lo tanto al
		// invocar el método run veamos lo que sucede.
		
		// Entonces creamos aquí un bucle para poder ver el ejemplo de manera un poco más visual.
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Ejecutandose hilo MAIN" + i);
			
		}

		// Entonces vamos a ver que primero sale ejecutandose el Hilo de id 1, es decir, está ejecutando
		// el hilo que he creado como instancia de Objeto pasandole el 1 como atributo en el constructor
		// y luego que termine ese procesamiento de 100 veces recien entra al for de esta Clase y ejecuta
		// lo que hemos colocado dentro.
		// ¿Pero cuando vemos un procesamiento concurrente?, aquí no estamos viendo que se está trabajando
		// los 2 procesos a la vez, ¿porque?, porque el método run() no me crea un hilo en el procesamiento
		// simplemente se ejecuta lo que está dentro del método.

		// Pero para poder crear este proceso alterno necesitamos apoyarnos del método start()
		// Entonces ahora corremos de nuevo la aplicación.
		// Entonces podemor ver como se ejecutan simúltaneamente y así va alternandose la impresión de 
		// mensajes que habiamos colocado en ambos for.
		
		
		//-----------------------------------------------------------------------------------------------------
		
		
		// Uno apoyandose directamente de la Clase Thread, otro apoyandose en la implementación de Runnable.
		
		// Ya depende de nosotros como nos sentamos más agusto de trabajar.
		
		// La recomendación sería siempre uilizar un Runable porque si nosotros usamos un Thread estamos
		// haciendo una herencia y ya no podremos heredar otros atributos de otras Clases, en cambio,
		// si nosotros implementamos (implements) la interfaz de Runnable podemos implementar muchas
		// interfaces y por lo tanto tener direfentes funcionalidades para nuestras Clases.
		
		// También por observación, es mejor ejecutar primero los hilos y luego que se ejecute el conenido de 
		// la Clase main, es decir, ponerlo despues de la invocación a estos métodos de los hilos. 
		
		
	}

}
