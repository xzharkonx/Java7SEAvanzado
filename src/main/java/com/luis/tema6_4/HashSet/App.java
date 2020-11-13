package com.luis.tema6_4.HashSet;

import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		// La lista de tipo Set utilizando la interfaz HashSet
		// no guardará un orden de agregación ni tampoco valores repetidos.
		// (Es como una tupla).
		// No se preocupa por el orden de adición.
		
		Set<String> lista = new HashSet<>();
		lista.add("Luis");
		lista.add("Eduardo");
		lista.add("Luis Eduardo");
		
		for (String l : lista) {
			System.out.println(l);
		}
		
		// El problema comienza cuando tenemos una lista de objetos
		// hay que agregar a esa Clase de esos objetos los métodos
		// hashCode y equals para que se puedan filtrar.
		// Lo importante al crearlos es que al método equals le tenemos
		// que ingresar por que valores serán los que se comparen si
		// son iguales con los de los demas objetos.
		System.out.println("...........................");
		Set<Persona> listaPersonas = new HashSet<>();
		listaPersonas.add(new Persona(1,"Luis",27));
		listaPersonas.add(new Persona(1,"Eduardo",25));
		listaPersonas.add(new Persona(1,"Luis Eduardo",28));
		listaPersonas.add(new Persona(1,"Luis Eduardo",29));
		listaPersonas.add(new Persona(1,"Luis",27));

		// Si los comparamos solo por nombres tanto "Luis" como
		//"Luis Eduardo" son los mismos valores solo nos pararecerán
		// una vez porque el método que sobreescribimos de equals solo
		// le indicamos que comparará por nombre, pero también podremos hacerlo por
		// nombre y edad. (Se lo indicaremos a continuación, revisar la Clase Persona).
		// En este caso los objetos que tienen "Luis Eduardo" "28"
		// Y "Luis Eduardo" "29" serán diferentes y ambos si se mostrarán.
		
		
		for (Persona per : listaPersonas) {
			System.out.println(per.getEdad()+"-"+per.getNombre());
		}
		
		// Como le asociamos un equals para las variables nombre y edad, no interpretará como valores diferentes.
		// Mira también como imprime Luis Eduardo ambas veces por que son diferentes de edad.
		// Sin embargo los objetos de Luis no lo son, son iguales y por ello solo se muestran una vez.
		

	}

}
