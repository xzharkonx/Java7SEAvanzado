package com.luis.tema8_3.Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// Interfaz Deque con la implementación ArrayDeque.
		
		// Es una mezcla de Stack y Queue.
		// Podemos agregar tanto al inicio como al final de está colección.
		// Proviene de la palabra "Double-ended queue".
		
		
		Deque<String> dq = new ArrayDeque<>();
		dq.add("1.- Luis");
		dq.add("2.- Luis Eduardo");
		dq.add("3.- Eduardo");
		
		// Muestra primer elemento
		String x = dq.peek();
		System.out.println("Peek " + x);
		
		
		// Elimina primer elemento que se agrego.
		x = dq.poll();
		System.out.println("Poll " + x);		
		
		// Para remover un elemento (el primero de la lista) se utiliza el método pop()
		// In otherwords, removes and returns the first element of this deque. 
		x = dq.pop();
		System.out.println("Poop " + x);
		
		// Agregando elementos...
		
		// Para agregar un elemento al inicio de la lista con addFirst()
		dq.addFirst("1er Impostor");
		
		// Para agregar un elemento al final de la lista con addLast()
		dq.addLast("2do Impostor");
		
		
		System.out.println("\n---------Nueva lista----------------");
		for (String elemento : dq) {
			System.out.println(elemento);
		}
		
		
		// Removiendo el primer elemento de la lista de objetos con remove();
		// dq.remove();
		
		// Removiendo el último elemento de la lista de objetos con remove();
		dq.removeLast();
		
		System.out.println("\n-------------------------");
		for (String elemento : dq) {
			System.out.println(elemento);
		}
		
		// Deque no acepta valores nulos (No thread-safe).
		
		// Trabajando con objetos de la Clase Persona
		System.out.println("\n-------------------Objetos---------------------");
		
		// No es necesario que los objetos, en este caso de la Clase Persona
		// que no implemente la Interfaz Comparable (para comparar el orden) porque no funcionara,
		// lo que si es el método hashCode, equals (para que los distinga si son iguales)
		// y toString() (para que pueda mostrar los atributos del objeto directamente).
		
		Deque<Persona> dqObjPersona = new ArrayDeque<>();
		dqObjPersona.add(new Persona(1,"Luis", 27));
		dqObjPersona.add(new Persona(2,"Luis Eduardo", 30));
		dqObjPersona.add(new Persona(3,"Eduardo ", 29));
		// Le indicaremos que elimine el primer repetido de estos impostores.
		dqObjPersona.add(new Persona(4,"1er Impostor", 27));
		dqObjPersona.add(new Persona(4,"1er Impostor", 27));
		// Le indicaremos que elimine el último repetido de estos impostores.
		dqObjPersona.add(new Persona(5,"2do Impostor", 30));
		dqObjPersona.add(new Persona(5,"2do Impostor", 30));
		
		for (Persona persona : dqObjPersona) {
			System.out.println(persona);
		}
		
		System.out.println("\n------------Eliminando Objetos----------------");
		// Eliminar objetos repetidos, siempre y cuando las clases de estos objetos
		// implementen los métodos hashCode y equals para que se puedan distinguir entre ellos.
		
		// Eliminara el primer objeto repetido que se encuentre
		// dqObjPersona.removeFirstOccurrence(new Persona(4,"1er Impostor", 27));
		System.out.println("Eliminando primer objeto repetido que indicamos: "+ dqObjPersona.removeFirstOccurrence(new Persona(4,"1er Impostor", 27)));
		// Eliminara el último objeto repetido que se encuentre
		// dqObjPersona.removeLastOccurrence(new Persona(5,"2do Impostor", 30));
		System.out.println("Eliminando último objeto repetido que indicamos: "+ dqObjPersona.removeLastOccurrence(new Persona(5,"2do Impostor", 30)));
		
		System.out.println("\n------------Mostrando Objetos----------------");
		
		for (Persona persona : dqObjPersona) {
			System.out.println(persona);
		}
		
		System.out.println("\n------------Comprobando Objetos----------------");
		System.out.println("Comprobando si tiene este elemento: " + dqObjPersona.contains(new Persona(5,"2do Impostor", 30)));
		System.out.println("Comprobando si tiene este elemento: " + dqObjPersona.contains(new Persona(6,"3do Impostor", 40)));
		
		
		System.out.println("\n------------Atendiendo y eliminando Objetos----------------");
		while(!dqObjPersona.isEmpty()) {
			// Eliminando desde el primer elemento de la lista
			// dqObjPersona.pollFirst();
			
			// Eliminando desde el último elemento de la lista
			System.out.println("Atendiendo a: " + dqObjPersona.pollLast());
			Thread.sleep(1000);
		}
		
		System.out.println("¿La lista está vacia?: " + dqObjPersona.isEmpty());
		
	}

}
