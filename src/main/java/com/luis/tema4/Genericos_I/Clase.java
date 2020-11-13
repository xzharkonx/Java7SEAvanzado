package com.luis.tema4.Genericos_I;

// Está es una clase del tipo de generico con el operador diamante <T>.
	
	// Tenemos los siguientes genericos:

	// E - Element (used extensively by the Java Collections Framework).
	// K - Key.
	// N - Number.
	// T - Type.
	// V - Value.
	// S,U,V etc. - 2nd, 3rd, 4th types 

public class Clase<T> {

	// Se crea un objeto de ese generico.
	private T objeto;
	
	// Aqui por el constructor se le va a pasar "Algo"
	public Clase (T objeto) {
		// Ese "Algo" Se pasara a la variable del genérico.
		this.objeto = objeto;
	}
	
	// Mostramos el genérico el cuál se le paso.
	public void mostrarTipo() {
		System.out.println("T es un: " + objeto.getClass().getName());
		System.out.println("T es un: " + objeto.getClass().getSimpleName());
	}
	
}
