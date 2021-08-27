package com.luis.tema6_6.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
            
                // Conjunto de Listas Set de tipo LinkedHashSet
                
                // Que nos fresce la implementación LinkedHashSet
		// - Está implementación nos ofrece poder agregar elementos
		//   a la lista o a la colección que sean únicos, es decir,
		//   que no haya duplicados 
                // - Y los deja en el orden en que fueron agregados a la lista.
                // - El Objeto que le pasemos No necesita implementar nada.
		
                // Si trabajamos con Objetos
                // Adicionalmente a está Clase habrá que añadirle
                // los métodos hashCode e equals con los cuales
		// podremos filtrarlos y que no se repitan en la Clase del Obj.
		Set<Persona> listaPersonas = new LinkedHashSet<>();
		listaPersonas.add(new Persona(1,"Luis",27));
		listaPersonas.add(new Persona(2,"Eduardo",25));
		listaPersonas.add(new Persona(3,"Luis Eduardo",28));
		listaPersonas.add(new Persona(4,"Luis Eduardo",29));
		listaPersonas.add(new Persona(5,"Luis",27));
		
		for (Persona per : listaPersonas) {
			System.out.println(per.getId()+" - "+per.getNombre()+" - "+per.getEdad());
		}
		
	}

}
