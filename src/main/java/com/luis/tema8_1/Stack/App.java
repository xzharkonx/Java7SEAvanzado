package com.luis.tema8_1.Stack;

import java.util.Stack;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// Vamos a implementar la Clase Stack.
		// Esta clase también conocida como apilar una pila.
		
		// Lo que nos va a permitir es poder agregar elementos 1 a 1,
		// pero la peculiaridad de está clase es al momento de empezar
		// a retirar los elementos. Este estack desarrolla el algoritmo LIFO
		// Significa en sus siglas: Last In, First Out.
		// El último en entrar es el primero en salir.
		
		// Vamos a simular una pila. 
		// Por ejemplo: Como una pila de libros donde vamos apilando libros, y luego
		// los vamos retirando desde encima empezando por el último que apilamos
		// seria el primero en quitarse de la pila.
		
		// Para este caso se utilizará este otro ejemplo de cuando uno espera para ser
		// atendido en un establecimiento.
		
		// Creamos la pila e indicamos el tipo de generico (en este caso algo simple como un String).
		Stack<String> pila = new Stack<>();
		// Agregamos los elmentos pero está vez con el método push().
		pila.push("1.- Luis Eduardo");
		pila.push("2.- Luis");
		pila.push("3.- Eduardo");
		pila.push("4.- Garcia Mercado");
		
		for (String elemento : pila) {
			System.out.println(elemento);
		}
		
		
		// Vamos a crear una simulación a que vamos a atender cada elemento como decir cada cliente
		// de nuestra pila.
		// Mientras que la pila no este vacia vamos a remover estos elementos en orden de atención.
		// en este caso implementado LIFO.
		
		System.out.println("\nLIFO");
		
		while(!pila.isEmpty()) {
			
			// Para remover un elemento (el último que se agrego) se utiliza el método pop()
			System.out.println("Atendiendo a: " + pila.pop());

			// Vamos a dormir por un segundo por medio de un hilo para que el recorrido no sea muy rápido.
			Thread.sleep(1000);
			
			// Mira como el último de la lista es el primero en ser atendido y se elimina de la lista.
		}
		
		// Si la lista nos está vacia imprimira los elementos.
		if (!pila.isEmpty()) {
			System.out.println("Mostrando lista si hay elementos");
			for (String elemento : pila) {
				System.out.println(elemento);
			}
		} // Vemos que no imprime nada, por lo tanto está vacia.
		
		// Pero también tiene otros métodos adicionales.
		// Por ejemplo, como prodriamos ver el último elemento pero sin eliminarlo.
		System.out.println("\nAñadiendo elementos de nuevo.\n");
		pila.push("1.- Luis Eduardo");
		pila.push("2.- Luis");
		pila.push("3.- Eduardo");
		pila.push("4.- Garcia Mercado");
		
		// Esto de aquí nos va a permitir saber cual es el elemento que está en el tope de la 
		// pila sin eliminarlo (El último que se añadio a la pila)
		System.out.println("\nÚltimo elemento: "+ pila.peek());
		
		// También tiene el método search() para entontrar algún elemento en particular si esta disponible.
		// Si lo encuentra, este método me retornará un entero conforme a su posición respecto a la pila,
		// es decir, el elemento de hasta abajo que fue el primero que se añadio pero como será el último
		// en salir tendrá la última posición de la pila, por lo tanto será no sera el primer valor si no el último
		// y así sucesivamente.
		// Si NO lo encuentra, este método me retornará un valor Negativo -1.
		System.out.println("Search: " + pila.search("1.- Luis Eduardo") + " | 1.- Luis Eduardo"); // 4
		System.out.println("Search: " + pila.search("2.- Luis") + " | 2.- Luis");// 3
		System.out.println("Search: " + pila.search("3.- Eduardo") + " | 3.- Eduardo"); // 2
		System.out.println("Search: " + pila.search("4.- Garcia Mercado") + " | 4.- Garcia Mercado"); // 1
		
		System.out.println("Search: " + pila.search("5.- xxx")); // -1
		
		
		System.out.println("\n----------Pila de objetos-------------");
		// Para objetos, supongamos la Clase Persona.
		
		// Creamos la pila e indicamos el tipo de generico (en este caso algo simple como un String).
		Stack<Persona> pilaPersonas = new Stack<>();
		// Agregamos los elmentos pero está vez con el método push().
		pilaPersonas.push(new Persona(4, "4.- Luis Eduardo", 27));
		pilaPersonas.push(new Persona(3, "3.- Luis", 26));
		pilaPersonas.push(new Persona(2, "2.- Eduardo", 28));
		// Los elementos repetidos no son filtrados, es tratada normalmente 
		// (ni aunque pongamos comparable en la Clase Persona).
		// Lo importante es el orden de entrada y salida de los elementos.
		pilaPersonas.push(new Persona(1, "1.- Impostor", 27));
		pilaPersonas.push(new Persona(1, "1.- Impostor", 27));
		
		for (Persona elemento : pilaPersonas) {
			System.out.println(elemento);
		}
		
		System.out.println("\nÚltimo elemento: "+ pilaPersonas.peek());
		// Necesitará de la implementación de los métodos equals y hashCode en la Clase Persona.
		// Para que pueda comparar y buscar ese elemento, si no, no lo encontrará.
		System.out.println("Search: " + pilaPersonas.search(new Persona(1, "1.- Impostor", 27)));
		
		// Si la pila está vaciadará true por lo que cuando de true tendrémos que invertirlo a
		// false para que se rompa el while.
		while(!pilaPersonas.isEmpty()) {
					
			// Para remover un elemento se utiliza el método pop()
			System.out.println("Atendiendo a: " + pilaPersonas.pop());

			// Vamos a dormir por un segundo por medio de un hilo para que el recorrido no sea muy rápido.
			Thread.sleep(1000);
			
			// Mira como el último de la lista es el primero en ser atendido y se elimina de la lista.
		}
		
	}

}
