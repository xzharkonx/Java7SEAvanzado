package com.luis.tema13.CatchLineal;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

	public void mostrar() {
		try {
			throw new IOException("IOException");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostrar2() {
		try {
			throw new IOException("IOException");
		} catch (FileNotFoundException f) { // Este bloque va antes por la gerarquía de excepciones
											// si no tirara error.
			System.out.println(f.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void mostrar3() {
		try {
			throw new IOException("IOException");
			// Tenemos un error y aquí vemos que el bloque IOException a capturado ya la excepción
			// FileNotFoundExceptio, entonces para el ejemplo lo cambiamos por NullPointerException
		// } catch (FileNotFoundException | IOException ex) { 
		} catch (NullPointerException | IOException ex) { // Vemos que ahora tenemos diferentes excepciones
														  // en una sola línea de código.
			System.out.println(ex.getMessage());
		} 
	}
	
	public void mostrar4() {
		try {
			throw new IOException("IOException");

		} catch (NullPointerException | IOException | NumberFormatException ex) { // Aquí incluso tenemos hasta 3
			System.out.println(ex.getMessage());
		} 
	}

	public static void main(String[] args) {
		// A estás alturas ya deberíamos conocer las excepciones.

		// Entonces en el método mostrar() tenemos un bloque try/catch
		// donde veremos una funcionalidad muy peculiar del JDK 1.7

		// Aquí tenemos la instancia e invocamos al método mostrar()
		// donde simplemente simulamos una excepción de tipo IOException
		// y en el Catch está capturando esa misma excepción y mostrando
		// un mensaje del error (algo simple).

		// Pero nosotros podemos indicar varias excepciones a la vez y no
		// estar colocando catch varias veces para poder colocar diferentes
		// tipos de excepciones como se muestra en el método mostrar2()
		
		// Sin embargo podemos hacer esto de una manera un poco más practica
		// como se muestra en el método mostrar3(), vemos que tenemos varias
		// excepciones en una sola línea de codigo, debemos tener en cuenta
		// la jeraquía de excepciones
		App app = new App();
		app.mostrar();

	}

	// Entonces tenemos 5 temas para las excepciones que podemos repasar.
	// Excepciones.
	// Jerarquía de excepciones.
	// Throws y Throw.
	// Excepciones Personalizadas.
	// try with resources.
	
	// Catch Lineal. (Este tema).
}
