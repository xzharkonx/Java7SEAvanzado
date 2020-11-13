package com.luis.tema6_3.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {

	public static void main(String[] args) {
		// Utilizaremos Collections para ordenar nuestros objetos.
		
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona(1,"Luis",25));
		lista.add(new Persona(2,"Eduardo",28));
		lista.add(new Persona(3,"Luis Eduardo",27));
		lista.add(new Persona(4,"AAA",26));
		
		System.out.println("------Imprimiendo datos--------");
		// Ahora solo mostraremos el nombre e id de cada elemento.
		for (Persona persona : lista) {
			System.out.println("Id: "+persona.getId()+" Edad: "+ persona.getEdad()+" Nombre: "+persona.getNombre());
		}
		
		// Ordenamos la lista, está lista es de objetos y al pasarsela al método sort()
		// daría un error, pero esto se puede porque como la Clase Persona implementa
		// la interfaz Comparable, la cuál implementa un método compareTo().
		Collections.sort(lista);
		
		System.out.println("\n------Imprimiendo datos ordenados por Edad--------");
		// Ahora solo mostraremos el nombre e id de cada elemento.
		for (Persona persona : lista) {
			System.out.println("Id: "+persona.getId()+" Edad: "+ persona.getEdad()+" Nombre: "+persona.getNombre());
		}
		

	}

}
