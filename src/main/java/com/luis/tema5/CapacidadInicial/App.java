package com.luis.tema5.CapacidadInicial;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// El crear un: ArrayList(int initialCapacity) con capacidad inicial.
		// Nosotros podemos crear e instancias una lista con un tamaño por defecto.
		// Para tener más rendimiendo en la operación.
		// Si yo no establesco un número ya viene con una capacidad inicial
		// por defecto uno establecido que es 10.
//		List<String> lista = new ArrayList<>(300);
		List<String> lista = new ArrayList<>(2);
                lista.add("Hello");
                lista.add("World");
		System.out.println(lista.toString()); // "[Hello, World]"
		
		// En el caso de LinkedList no tiene capacidad inicial
	}

}
