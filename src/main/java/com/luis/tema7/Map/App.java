package com.luis.tema7.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) {
		// Interfaz Map
		
		System.out.println("HashMap");
		System.out.println("--------------------------------------------\n");
		// Caracteristica peculiar de la implementación HashMap
		// 	- No se permiten valores duplicados.
		//	- El orden en el que se van mostrando los elementos no sigue
		// 	  un patrón en particular.(Es un poco aleatorio).
		//	  Saldrá desordenado si la key es un String.
		Map<Integer, String> map = new HashMap<>();
		map.put(3,  "Luis Eduardo");
		map.put(4,  "Eduardo");
		map.put(1,  "Luis");
		map.put(2,  "Garcia Mercado");
		// Este no lo mostrará porque la clave se repite (tomará el último).
		map.put(5,  null);
		map.put(5,  "ABC");
		map.put(null,  " Hola");
		
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			System.out.println("Clave: "+ key + " -> Valor: " + map.get(key));
		}
		
		
		System.out.println("\nHashMap Con Objetos");
		System.out.println("--------------------------------------------\n");
		// Caracteristica peculiar de la implementación HashMap Con Objetos.
		
		// Si en nuestro caso fueran objetos, como en los ejemplos anteriores de la Clase Persona.
		// Necesitaremos implementar los métodos de equals y hashCode para que pueda
		// ejecutarse correctamente filtrando los elementos repetidos y el orden.
		// También agregamos el método toString para ver los datos del objeto.
		
		// Para esta implementación Hash no es necesaria la implementación Comparable en la Clase Persona.
		// Mira que no los ordena, es aleatorio el orden.
		
		Map<Persona, String> mapHashObj = new HashMap<>();
		mapHashObj.put(new Persona(1,"Luis Eduardo", 27),  "Luis Eduardo");
		mapHashObj.put(new Persona(2,"Eduardo", 25),  "Eduardo");
		mapHashObj.put(new Persona(4,"Luis", 26),  "Luis");
		mapHashObj.put(new Persona(5,"Garcia Mercado", 20),  "Garcia Mercado");
		mapHashObj.put(new Persona(3,null, 0),  null);
		// Mira como aquí se repite el objeto pero no su valor, entonces como el
		// objeto es la clave y la clave se repite entonces solo muestra el último valor.
		mapHashObj.put(new Persona(6,"ABC", 40),  "ABC");
		mapHashObj.put(new Persona(6,"ABC", 40),  "JKI");
		// Este si lo muestra porque el objeto es diferente en almenos 1 dato.
		mapHashObj.put(new Persona(6,"ABC", 50),  "XYZ");
		
		Iterator itHashObj = mapHashObj.keySet().iterator();
		while (itHashObj.hasNext()) {
			Persona keyHashObj = (Persona) itHashObj.next();
			System.out.println("Clave: "+ keyHashObj + " -> Valor: " + mapHashObj.get(keyHashObj));
		}
		
		
		System.out.println("\nTreeMap");
		System.out.println("--------------------------------------------\n");
		// Caracteristica peculiar de la implementación TreeMap
		
		// Como vimos en Set se preocupaba por el ordén ascendente de nuestros elementos.
		// Y para este ordén en la clave (key) no nos va a aceptar un valor nulo (null).
		// Si colocamos un valor nulo en la clave(key) nos dará error.
		
		// Vemos que aquí si nos los ordeno inclusive si la Clave(key) es de tipo String.
		// Elimino las claves repetidas dejando solo la última.
		
		Map<String, String> mapTree = new TreeMap<>();
		mapTree.put("3",  "Luis Eduardo");
		mapTree.put("4",  "Eduardo");
		mapTree.put("1",  "Luis");
		mapTree.put("2",  "Garcia Mercado");
		// Este no lo mostrará porque la clave se repite (tomará el último).
		mapTree.put("5",  null);
		mapTree.put("5",  "ABC");
		
		Iterator itTree = mapTree.keySet().iterator();
		while (itTree.hasNext()) {
			String keyTree = (String) itTree.next();
			System.out.println("Clave: "+ keyTree + " -> Valor: " + mapTree.get(keyTree));
		}
		
		
		System.out.println("\nTreeMap Con Objetos");
		System.out.println("--------------------------------------------\n");
		// Caracteristica peculiar de la implementación TreeMap Con Objetos.
		
		// Si en nuestro caso fueran objetos, como en los ejemplos anteriores de la Clase Persona.
		// Necesitaremos implementar los métodos de equals y hashCode para que pueda
		// ejecutarse correctamente filtrando los elementos repetidos y el orden.
		// También agregamos el método toString para ver los datos del objeto.
		
		// Adicionalmente tenemos que implementar la Interfaz Comparable<Persona>
		// para que pueda ordenarlos según como implementemos su método compareTo()
		// Mira que nos los ordena conforme a la edad de los objetos.
		
		Map<Persona, String> mapTreeObj = new TreeMap<>();
		mapTreeObj.put(new Persona(1,"Luis Eduardo", 27),  "Luis Eduardo");
		mapTreeObj.put(new Persona(2,"Eduardo", 25),  "Eduardo");
		mapTreeObj.put(new Persona(4,"Luis", 26),  "Luis");
		mapTreeObj.put(new Persona(5,"Garcia Mercado", 20),  "Garcia Mercado");
		mapTreeObj.put(new Persona(3,null, 0),  null);
		// Mira como aquí se repite el objeto pero no su valor, entonces como el
		// objeto es la clave y la clave se repite entonces solo muestra el último valor.
		mapTreeObj.put(new Persona(6,"ABC", 40),  "ABC");
		mapTreeObj.put(new Persona(6,"ABC", 40),  "JKI");
		// Este si lo muestra porque el objeto es diferente en almenos 1 dato.
		mapTreeObj.put(new Persona(6,"ABC", 50),  "XYZ");
		
		Iterator itTreeObj = mapTreeObj.keySet().iterator();
		while (itTreeObj.hasNext()) {
			Persona keyTreeObj = (Persona) itTreeObj.next();
			System.out.println("Clave: "+ keyTreeObj + " -> Valor: " + mapTreeObj.get(keyTreeObj));
		}
		
		

		System.out.println("\nLinkedHashMap");
		System.out.println("--------------------------------------------\n");
		// Caracteristica peculiar de la implementación LinkedHashMap
		
		// Está se preocupa por el orden en que voy agregando los datos al Mapa
		// Elimino las claves repetidas dejando solo la última.
		
		Map<String, String> mapLinkedHash = new LinkedHashMap<>();
		mapLinkedHash.put("3",  "Luis Eduardo");
		mapLinkedHash.put("4",  "Eduardo");
		mapLinkedHash.put("1",  "Luis");
		mapLinkedHash.put("2",  "Garcia Mercado");
		// Este no lo mostrará porque la clave se repite (tomará el último).
		mapLinkedHash.put("5",  null);
		mapLinkedHash.put("5",  "ABC");
		
		Iterator itLinkedHash = mapLinkedHash.keySet().iterator();
		while (itLinkedHash.hasNext()) {
			String keyLinkedHash = (String) itLinkedHash.next();
			System.out.println("Clave: "+ keyLinkedHash + " -> Valor: " + mapLinkedHash.get(keyLinkedHash));
		}
		
		
		System.out.println("\nLinkedHashMap Con Objetos");
		System.out.println("--------------------------------------------\n");
		// Caracteristica peculiar de la implementación LinkedHashMap Con Objetos.
		
		// Si en nuestro caso fueran objetos, como en los ejemplos anteriores de la Clase Persona.
		// Necesitaremos implementar los métodos de equals y hashCode para que pueda
		// ejecutarse correctamente filtrando los elementos repetidos y el orden.
		// También agregamos el método toString para ver los datos del objeto.
		
		// Para esta implementación Hash no es necesaria la implementación Comparable en la Clase Persona.
		// Mira que los ordena con forme el orden de agregación al Mapa.
		
		
		
		Map<Persona, String> mapLinkedHashObj = new LinkedHashMap<>();
		mapLinkedHashObj.put(new Persona(1,"Luis Eduardo", 27),  "Luis Eduardo");
		mapLinkedHashObj.put(new Persona(2,"Eduardo", 25),  "Eduardo");
		mapLinkedHashObj.put(new Persona(4,"Luis", 26),  "Luis");
		mapLinkedHashObj.put(new Persona(5,"Garcia Mercado", 20),  "Garcia Mercado");
		mapLinkedHashObj.put(new Persona(3,null, 0),  null);
		// Mira como aquí se repite el objeto pero no su valor, entonces como el
		// objeto es la clave y la clave se repite entonces solo muestra el último valor.
		mapLinkedHashObj.put(new Persona(6,"ABC", 40),  "ABC");
		mapLinkedHashObj.put(new Persona(6,"ABC", 40),  "JKI");
		// Este si lo muestra porque el objeto es diferente en almenos 1 dato.
		mapLinkedHashObj.put(new Persona(6,"ABC", 50),  "XYZ");
		
		Iterator itLinkedHashObj = mapLinkedHashObj.keySet().iterator();
		while (itLinkedHashObj.hasNext()) {
			Persona keyLinkedHashObj = (Persona) itLinkedHashObj.next();
			System.out.println("Clave: "+ keyLinkedHashObj + " -> Valor: " + mapLinkedHashObj.get(keyLinkedHashObj));
		}
		
		
		System.out.println("\nLinkedHashMap Con Objetos, Recorriendo con un for");
		System.out.println("--------------------------------------------\n");
		// Para recorrer nuestros datos con un for en vez de un while.
		// Utilizaremos la Clase Entry<k.V> Tipo: k=key, v=value.
		
		for(Entry<Persona, String>  ent : mapLinkedHashObj.entrySet()) {
			System.out.println("Clave: "+ ent.getKey() + " -> Valor: " + ent.getValue());			
		}
	}

}
