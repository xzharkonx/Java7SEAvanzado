package com.luis.tema6_2.Comparator;

import java.util.Comparator;

// Hemos implementado Comparator y uno de sus métodos.
//public class NombreComparator implements Comparator{
// Pero podemos indicarle que su génerico (para el tema de type safety
// y nos deje de mostrar advertencias).
public class NombreComparator implements Comparator<Persona>{

	// Este método va comparar ambos valores,
	// Si la comparación es positiva quiere decir que el valor 1 es mayor al valor 2, 
	// Si la comparación da igual a 0 ambos valores son iguales.
	// Si la comparación da negativa quiere decir que el valor 1 es menor al valor 2.
	
	// Positivo:  Obj1.x > Obj2.x
	// Neutro, 0: Obj1.x = Obj2.x
	// Negativo:  Obj1.x < Obj2.x
	@Override
	//public int compare(Object obj1, Object obj2) {
	public int compare(Persona per1, Persona per2) {
		// Aquí implementaremos nuestra lógica.
		// Utilizamos nuestra clase Persona.
		// Hacemos un Casteo de esos objetos.
		//Persona per1 = (Persona)obj1;
		//Persona per2 = (Persona)obj2;
		
		// Aquí retornariamos el valor de la comparación
		return per1.getNombre().compareTo(per2.getNombre());
		
	}

}
