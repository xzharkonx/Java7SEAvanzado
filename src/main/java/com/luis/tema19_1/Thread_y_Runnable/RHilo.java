package com.luis.tema19_1.Thread_y_Runnable;

// Otra manera de poder apoyarnos en el uso de Hilos es mediante la interfaz Runnable,
// para ello creamos esta Clase que se llama RHilo que implementa está interfaz y
// sobreescribe el método run() nuevamente.
public class RHilo implements Runnable{

	// Para poder implementar la lógica de un Hilo debemos sobreescribir el método run()
	
	private int id;
	public RHilo(int id) {
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
			System.out.println("[R] Ejecutándose hilo RUNNABLE de id -->" + id);
			
			// Con esto lo asociamos al método run y lo que tenemos básicamente es el procesamiento que 
			// tenemos es esté método, lo que hará será iterar 100 veces colocando el id que le pasemos
			// en el constructor.
		}

	}
	
	// En el método principal que es donde vamos a ejecutar la Aplicación vamos a crear una instancia
	// de la Clase de RHilo que hemos creado.

}
