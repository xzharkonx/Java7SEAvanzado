package com.luis.tema19_1.Thread_y_Runnable;

// Entramos a la sección de concurencia que es la última sección de temas.
// Especificamente tenemos que iniciar hablando sobre los Hilos, esta es la
// unidad base o tema principal u mínima para entender la concurrencia no solo
// en Java si no en cualquier lenguaje de programación.

// Entonces esta habilidad de concurrencia me va a permitir ejecutar muchos
// procesos a la vez.

// En Java para poder crear esta unidad base que es Hilo tenemos opciones como:
// Primero es, Crear una Clase y heredarla de la Clase principal Thread, otra es implementar
// la interfaz Runnable y una adiciona que veremos en estos temas es el Pull de Hilos
// más conocido como los Exetutors.

// Empezaremos por la Clase Thread y luego con los Runnables

// Tenemos aquí la public Class y hereda de Thread.
public class THilo  extends Thread{

	// Para poder implementar la lógica de un Hilo debemos sobreescribir el método run()
	
	private int id;
        
	public THilo(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// Dentro del método run yo voy a colocar una lógica en particular, está lógica sera
		// la siguiente:
		// Haremos esto para simular que el procesamiento del Hilo se está ejecutando.
		for (int i = 0; i < 100; i++) {
			// Dentro de el indicamos lo siguiente
			// ¿Que id va a ser?, para ello colocamos el atributo id y el constructor con parametros.
			System.out.println("[T] Ejecutándose hilo THREAD de id -->" + id);
			
			// Con esto lo asociamos al método run y lo que tenemos básicamente es el procesamiento que 
			// tenemos es esté método, lo que hará será iterar 100 veces colocando el id que le pasemos
			// en el constructor.
		}
	}
	
	// En el método principal que es donde vamos a ejecutar la Aplicación vamos a crear una instancia
	// de la Clase de THilo que hemos creado.
	
}
