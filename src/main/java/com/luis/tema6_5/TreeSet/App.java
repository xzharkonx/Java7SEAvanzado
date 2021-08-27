package com.luis.tema6_5.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class App {

	public static void main(String[] args) {
            
                // Conjunto de Listas Set de tipo TreeSet
                
		// Que nos ofrece la implementación TreeSet
		// - Está implementación nos ofrece poder agregar elementos
		//   a la lista o a la colección que sean únicos, es decir,
		//   que no haya duplicados 
                // - Y a la vez te los ordena (únicos datos ordenados de forma ascendente).
		//   Más abajo se muestra como hacerlo de objetos.
		
		Set<String> lista = new TreeSet<>();
		lista.add("Luis");
		lista.add("Luis Eduardo");
		lista.add("Luis");
		lista.add("Programador");
		lista.add("Programador");
		lista.add("Backen Developer");
		lista.add("Full Developer");
		lista.add("Full Developer");
		
		for (String l : lista) {
			System.out.println(l);
		}
		
		// Que pasaría si tuvieramos una colección de objetos en este caso
		// utilizaremos una Clase Persona. Y que tengamos que odenarlos por
		// el nombre o la edad.

		// A está implementación le importa el orden de los elementos
		// que se están agregando a está lista.
		// Por lo que nuestros objetos es necesario que implementen la interfaz Comparable.
		// Si no nos tirará un error.
		// Adicionalmente a está Clase habrá que añadirle los métodos hashCode e equals con los cuales
		// podremos filtrarlos y que no se repitan.
		System.out.println("...........................");
		Set<Persona> listaPersonas = new TreeSet<>();
		listaPersonas.add(new Persona(1,"Luis",27));
		listaPersonas.add(new Persona(2,"Eduardo",25));
		listaPersonas.add(new Persona(3,"Luis Eduardo",28));
		listaPersonas.add(new Persona(4,"Luis Eduardo",29));
		listaPersonas.add(new Persona(5,"Luis",27));
		listaPersonas.add(new Persona(6,"Daniel",40));
		listaPersonas.add(new Persona(7,"Daniel",40));
		
		// Hacerlo de está forma nos tirará error, por lo que necesitamos
		// implementar la interfaz Comparable en la Clase Persona.
		// También adicionamos los métodos hasCode e equals para que
		// los compare si son iguales y si los son, los omita.
		
		for (Persona per : listaPersonas) {
			System.out.println(per.getId()+" - "+per.getNombre()+" - "+per.getEdad());
		}
		
		// Ahora salen ordenados por edad y filtrados de que no se repitan
		// si son iguales de nombre y edad.
	}

}
