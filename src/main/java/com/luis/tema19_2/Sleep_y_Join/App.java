package com.luis.tema19_2.Sleep_y_Join;


// En el tema anterior ya hemos aprendido a crear los Hilos de manera muy práctica 
// bajo el enfoque de la herencia de la Clase Thread y también sobre la implementación
// de la interfaz Runnable, en está ocación toca poder manipularlos, ¿Como?,
// utilizando el método Sleep y  también el método Join y además vamos a ver que pasaría
// si tratamos de inicializar un hilo nuevamente.

// Método Join --------------------------------------------------------------------------------------------------
// Para poder entender el método Join que vamos a explicar a continuación, es basicamente para poder controlar el 
// ciclo de vida de los hilos, es decir, cuando deseamos que este muera para que otro inicie.


public class App {
	
	// Entones tenemos los 3 hilos y aparte el hilo del método main del Tema anterior y lo que vamos
	// a hacer es aprender a poder dormir un hilo (detener un hilo) y ver que es lo que sucede si
	// tratamos de detener un hilo más de una vez.
	

	public static void main(String[] args) throws InterruptedException {
		
		// Entonces en está ocación el programa inicia y se requiere ejecutar el hilo1 por lo tanto
		// hay una división de tareas y se inicia un proceso de manera concurente.
		
		THilo hilo1 = new THilo(1);
		// Mira que aquí podemos dormir directamente el hilo desde la Clase y el método Statico sleep()
		THilo.sleep(3000);
		
		
		hilo1.start();
		
		// Método Join --------------------------------------------------------------------------------------------------
		// Si nosotros colocamos esto aquí, estamos indicando que estoy esperando que primero muera el hilo, es decir,
		// vamos a terminar el proceso del hilo 1 y una vez que muere el hilo1 va a recien inicializar otro hilo.
		hilo1.join();
		// -------------------------------------------------------------------------------------------------------------
		
		
		// Método Sleep --------------------------------------------------------------------------------------------------
		// Luego de la misma manera se ejecua para el hilo2, pero quiero esperar a el hilo1,
		// es decir, hacer esperar el hilo2 unos 3 segundos antes de su iniciación.
		
		Thread hilo2 = new Thread(new RHilo(2));
		// Para ello hacemos lo siguiente, utilizamos el método slepp y le pasamos 3000 en
		// milisegundos (3 segundos). ¿Que quiere decir esto?, que voy a dormir/detener el hilo
		// por un periodo de 3 milisegundos antes de que se inicie. 
		// Pero si nos damos cuenta esto nos bota una excepción que puede provocar de tipo InterruptedException
		// por lo tanto es recomendable apoyarse de una claúsula TryCatch pero por cuestiones didacticas 
		// simplemente vamos a colocar InterruptedException directo en el método main.
		
		// Y nos sale en amarillo es una advertencia porque el método Sleep es estático (podemos verlo en la
		// declaración como un método estatico) si recordamos static no necesariamene necesita de una instancia
		// de un objeto para ser invocado, basta directamente con la Clase para poder inicializar este método.
		// Entonces no necesito dormir el hilo2 si no apoyarme de uno nuevo.
		// hilo2.sleep(3000);
		// Nos apoyamos de un hilo nuevo para dormir el proceso:
		Thread.sleep(3000); // Mira que ya no sale de amarillo porque se invoca directo y no desde el objeto de hilo2.
		// vemos que tenemos el mismo comportamiento.
		hilo2.start();
		// Mira que primero sale el hilo1, luego se detiene los 3 segundos, sale el hilo2 de ejecución y
		// continua con el proceso.
		// En este caso como es de manera concurrente primero ejecuta el main y luego en este caso el hilo [A].
		
		// Método Join --------------------------------------------------------------------------------------------------
		// Ahora si aquí también colocamos lo siguiente, vamos a ver que se ejecutara en orden, hilo1 luego hilo2 y 
		// despues todo lo demás en orden (conforme coloquemos join()).
		hilo2.join();
		
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("[A] Hilo Anonimo ejecutandose.");
				
			}
			
		};
		
		Thread hilo3 = new Thread(r);
		//		hilo3.start();
		//		hilo3.join();
		
		// Método Join --------------------------------------------------------------------------------------------------
		// Entonces con el método join colocandolo de está manera lo ejecutaremos en orden secuencial.
		// Al volverse a ejecutar ocurrira el mismo comportamiento.
		
		System.out.println("Ejecutandose hilo MAIN");
		
		// Si modificamos y eliminamos alguno de los join() podemos ver que el comportamiento va a alterarse debido
		// a que se rompe la secuencia en que vamos deteniendo y comenzando cada hilo.
		
		// Si por ejemplo lo hacemos desde el hilo 3, los hilos hilo1 e hilo2 se ejecutarán simultaneamente luego
		// en el transcurso de la ejecución se ejecurará el hilo 3 y terminará durante la ejecución de los hilos
		// hilo1 e hilo2 pero terminará antes de que se ejecute el hilo del main (hilo principal).
		
		// Esto parece un poco confuso pero es una forma de controlar los hilos de una manera básica.
		// Otra es apoyandonos en semaforos que lo veremos más adelante en otro tema.
		
		// ¿Que pasaría si inicializamos un hilo nuevamente?-----------------------------------------------------------
		// Vemos que nos saldría una excepción por ahí durante el transcurso de la ejecución
		// Y la excepción nos dice que no se puede inicializar un hilo 2 veces, estaríamos hiendo en contra de un
		// IllegalThreadStateException.
		
		// Para ello podemos hacer lo siguiente:
		// Podríamos preguntar apoyandonos de un if y preguntando ejecutando algún método de hilo los siguientes:
		// isAlive()/isInterrupted() ¿Está vivo? ¿Esta corriendo?, nosotros podríamos detenerlo un momento y ya
		// no nos saldría el error, o por ejemplo:
		if(!hilo3.isAlive()) {
			System.out.println("Iniciando hilo 3");
			hilo3.start();
		}
		
		// Con esto deberia mostrarnos el mensaje del hilo 3 y lo inicializa porque está comprobando si no esta
		// inicializado.
				
	}

}
