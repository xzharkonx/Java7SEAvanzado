package com.luis.tema4.Genericos_III;

public class Alumno extends Persona{
	
	Integer edad;
	
	public Alumno(String nombre, Integer edad) {
		super(nombre);
		this.edad = edad;
	}
	
	public void mostrarEdad() {
		System.out.println(this.edad);
	}
	
}
