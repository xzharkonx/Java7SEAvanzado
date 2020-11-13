package com.luis.tema1;

public class Alumno extends Persona{
	
	// Un método de instancia no puede ser sobreescrito por un método estatico
	// ni viceversa
	//	public static int sumar(int numero) {
	//		return numero + 2;
	//	}
	
	// Por o que ahora crearemos el mismo método pero solo de instancia
	public int sumar(int numero) {
		return numero +2;
	}
	
}
