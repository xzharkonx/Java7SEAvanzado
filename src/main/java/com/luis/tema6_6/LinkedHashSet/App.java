package com.luis.tema6_6.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

import com.luis.tema6_5.TreeSet.Persona;

public class App {

	public static void main(String[] args) {
		
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
