package com.luis.tema6_2.Comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona(1,"Luis",25));
		lista.add(new Persona(2,"Eduardo",28));
		lista.add(new Persona(3,"Luis Eduardo",27));
		lista.add(new Persona(4,"AAA",26));
		
		// Tenemos que crear una clase que implemente la interfaz de Comparator.
		// Por lo tanto crearemos la clase NombreComparator e implementaremos Comparator.
		// Y le pasaremos nuestra lista de nombres a ordenar y una insancia de esa clase.
		Collections.sort(lista, new NombreComparator());
		
		System.out.println("---------Ordenamiento por Nombre---------------------");
		
		// Ahora solo mostraremos el nombre de cada elemento.
		for (Persona persona : lista) {
			System.out.println(persona.getNombre());
		}
		
		System.out.println("---------Ordenamiento por Id---------------------");
		// Si queremos utilizar el mismo criterio para edad y para el codigo del usuario
		// tendríamos que implementar un comparator por cada uno de ellos.
		
		// Pero si no queremos hacer una clase y hacerlo de forma directa, podemos ordenar
		// la lista por orden de edad.

		// Instanciamos Comparator e importamos lo que nos pide e implementamos los métodos.
		// Recuerda que Comparato es una Interfaz por lo que hay que sobreescribirlos.
		Collections.sort(lista, new Comparator<Persona>() {

			@Override
			public int compare(Persona per1, Persona per2) {
				// Hacemos la comparación de las edades retornando
				// Valor positivo si el primer objeto es mayor al segundo.
				// Valor neutro = 0 si el primer objeto es igual al segundo.
				// Valor negativo si el primer objeto es mayor al segundo.
				
				if (per1.getId() > per2.getId()) {
					
					return 1;
				}else if(per1.getId() < per2.getId()) {
					
					return -1;
				}else {
					
					return 0;
				}
				
				// SOLO IMPORTARÁ ESTE ORDEN:
				// Positivo:  Obj1.x > Obj2.x
				// Neutro, 0: Obj1.x = Obj2.x
				// Negativo:  Obj1.x < Obj2.x
			}
			
		});
		
		// Ahora solo mostraremos el nombre e id de cada elemento.
		for (Persona persona : lista) {
			System.out.println("Id: "+persona.getId()+" Nombre: "+persona.getNombre());
		}
		
		// Pero si queremos tener de otra forma más practica de ordenar las listas sin indicar
		// un Comparator, eso va a ser utilizando otra interfaz llamada Comparable.

	}

}
