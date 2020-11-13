package com.luis.tema4.Genericos_II;

import java.util.ArrayList;
import java.util.List;

// El concepto de los genericos básicamente tiene 2 propositos:
// 		- Uno de ellos es proveer seguridad en tipos.
// 		- El otro es evitar casteos.
public class App {

	public static void main(String[] args) {

		// ¿Por qué seguridad en tipos?, veamos el siguiente ejemplo.
		// List lista = new ArrayList();
		// Le podemos asignar cualquier tipo de valor.
		// lista.add("Luis");
		// lista.add(25);
		
		// Pero cuando yo indico con el indicador Diamante <> algún tipo de dato en
		// particular por ejemplo String estoy haciendo un type safety,
		// Un type safety quiere decir que hay una protección en cuanto al tipo
		// de datos, en este caso estamos agregando a una lista que solo serán de tipo String.
		List<String> lista = new ArrayList();
		lista.add("Luis");
		// lista.add(25); // Este marcará error.
		// Podemos deducir que una Lista no es por defecto type safety.
		// Es decir, no brinda una protección de tipo de dato.
		
		// En contraparte los arrayas, por ejemplo:
		String[] array = new String[5];
		// Estos si brindan protección contra el tipo de dato.
		array[0] = "Luis";
		// array[1] = 10; // Aquí ya nos saltaría un error en tipo de dato.
		
		// Otro aspecto que nos brinda esto de los genericos es evitar el casteo.
		// Antes de que existieran los genericos las listas no tenian tipo de dato.
		List lista2 = new ArrayList<>();
		lista2.add("Luis");
		lista2.add(27);
		
		// Tenemos que hacer un Casteo, si no dará error
		String texto = (String) lista2.get(0);
		Integer num = (Integer) lista2.get(1);
		System.out.println(texto);
		System.out.println(num);
		
		// Entonces lo correcto sería definir el tipo ya que esto lleva mucha
		// practicidad en entornos grandes, porque estamos definiendo en un orden
		// y respetando quizas algunos estándares para algunas aplicaciones.
		// Vemos aquí que no hay necesidad de un casteo.
		List<String> lista3 = new ArrayList<>();
		lista3.add("Luis Eduardo");
		String nombre = lista3.get(0);
		System.out.println(nombre);
		
		// En versiones anteriores como por ejemplo la 1.6 de Java se necesita
		// poner en el operador diamante del ArrayList<String>(); indicarle que sea String.
		
		
		
		// En este otro ejemplo, mira que aquí dentro del operador diamante <> se definen los tipos
		// que querramos darle siempre y cuando sea la misma cantidad.
		// Ya en la Clase le pasamos los parametros por el constructor.(Revisar la Clase)
		Clase<String, Integer, String, Double,String,String> c = new Clase<>("Luis",27,"Programador",27.0,"LuisEduardo","1234");
		c.mostrarTipo();
		
		// Mira que aquí se crea una lista pero ya será del tipo de la clase que se le a pasado al operador Diamante <>
		List<Clase<String, Integer, String, Double,String,String>> listaClase = new ArrayList<>();
		listaClase.add(new Clase<>("Luis",27,"Programador",27.0,"LuisEduardo","1234"));
		listaClase.add(new Clase<>("Eduardo",25,"Programador",25.0,"Eduardo","admin1234"));
		
		// Recorremos la lista de esos objetos.
		for(Clase<String, Integer, String, Double,String,String> l : listaClase) {
			l.mostrarTipo();
		}
		
		// RESUMEN: Los Genericos básicamente atacan a 2 objetivos principales:
		// 1.- El type safety: Que es prácticamente para asegurarnos que el tipo de dato
		//	   sea el adecuado, y también el tema de los casteos, si nosotros no indicamos
		// 	   tipo propicio necesariamente al momento de obtener los valores de una lista vamos
		// 	   a tener que hacer un casteo.
		// 2.- Por es por defecto una lista dinamica la interfaz List (no es type safety), sin hembargo
		// un arrayList() si lo es, además, también hemos visto que las clases genericas las podemos
		// implementar con diferentes estereotipos separados por ","
	}

}
