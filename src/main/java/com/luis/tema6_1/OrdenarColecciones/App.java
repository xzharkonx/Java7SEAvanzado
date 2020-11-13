package com.luis.tema6_1.OrdenarColecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {

		
		// Estructura simple sería un Array (Arreglos).
		int[] array = new int[3];
		// La principal desventaja es que necesitamos indicar un tamaño particular
		// y este no crece =C
		// Si queremos hacer ordenamientos de estos elementos nos tenemos que apoyar
		// de métodos como el algoritmo de la burbuja o del de quicksort, que es valido
		// cuando necesitamos situaciones de alto rendimiento.
		// Pero funcionan muy bien trabajar estos arreglos de forma simple por rendimiento.
		
		// En contraparte, JAVA provee de una API llamada Collections para que puedas
		// manejar listas de una manera más dinámica.
		// Si necesitas de algo práctico y más rápido de programar sin algoritmos
		// avanzados para poder aplicar la lógica que necesitamos, podríamos optar por
		// esta API.
		
		// Aquí tenemos una lista, pero como podríamos ordenar los datos que contiene.
		List<Integer> lista = new ArrayList<>();
		lista.add(25);
		lista.add(1000);
		lista.add(1);
		System.out.println(lista.get(0)); 
		System.out.println(lista);
		
		// Con esta API Collections vamos a tener varios métodos a nuestra disposición.
		// uno de ellos es el método sort, que espera como parametro una lista de tipo
		// generico T: List<T> list
		// Le pasamos la lista desordenada, es de tipo void por lo que no nos retornará
		// nada, pero una vez que se la pasemos hará el ordenamiento.
		Collections.sort(lista);
		
		// Ahora vemos como se ordena.
		System.out.println(lista);
		
		// Hagamoslo a la inversa
		Collections.reverse(lista);
		System.out.println(lista);
		
		// Esto podemos aplicarlo a una lista de tipo String.
		List<String> listaNombres = new ArrayList<>();
		listaNombres.add("Luis");
		listaNombres.add("Eduardo");
		listaNombres.add("Luis Eduardo");
		
		System.out.println(listaNombres);
		
		//Ordenamos la lista de nombres.
		Collections.sort(listaNombres);
		
		System.out.println(listaNombres);
		
		// Ahora ordenaremos objetos.
		
		
	}
}
