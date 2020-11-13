package com.luis.tema2;

public class Galleta {

	private String nombre;

	public Galleta(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Galleta [nombre=" + nombre + "]";
	}
	
}
