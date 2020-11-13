package com.luis.tema8_2.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// Para implementar el uso de Colas vamos a utilizar
		// La Interfaz Queue con la implementación PriorityQueue<>()
		// Para poder hacer el:  FIFO First In, First Out.
		// Primero en entrar, primero en salir.
		
		// Es algo muy similar a lo que sucede en las colas en la vida real.
		// El primero que se forma en la fila es el primero en ser atendido.
		
		// Hay una implementación de la interfaz Queue muy importante
		// que es la clase PriorityQueue<>()
		
		Queue<String> cola = new PriorityQueue<>();
		// Se utiliza el metodo offer() para ir agregando los elemntos uno trás otro.
		cola.offer("1.- Luis Eduardo");
		cola.offer("2.- Luis");
		cola.offer("3.- Eduardo");
		cola.offer("4.- Garcia Mercado");
		
		// Para ir removiendo cada elemento utilizaremos el método poll(), 
		// que nos retornará un String.
		

		for (String elemento : cola) {
			System.out.println(elemento);
		}
		
		System.out.println("\nRemoviendo\\Atendiendo elementos.");
		while(!cola.isEmpty()) {
			
			System.out.println("Atendiendo a: " + cola.poll());
			Thread.sleep(1000);
		}

		// Mira como los atiende conforme se añadieron primero a la cola.
		// Por lo que cumpliría con la idea de la implementación FIFO.
		
		// Como podría yo ver analogamente de cuál es el que se va a atender pero
		// sin removerlo.
		// Tendríamos que utilizar el método peek(), lo mismo que en Stack
		System.out.println("\nRellenamos la cola de nuevo...");
		cola.offer("1.- Luis Eduardo");
		cola.offer("2.- Luis");
		cola.offer("3.- Eduardo");
		cola.offer("4.- Garcia Mercado");
		
		System.out.println("Se procede a atender a: " + cola.peek());
		
		// Ahora trabajaremos con Objetos, será una Cola de Personas.
		
		Queue<Persona> colaPersona = new PriorityQueue<>();
		colaPersona.offer(new Persona(1, "Luis Eduardo", 27));
		colaPersona.offer(new Persona(2, "Luis", 26));
		colaPersona.offer(new Persona(3, "Eduardo", 28));
		colaPersona.offer(new Persona(4, "Impostor", 7));
		
	}
}
