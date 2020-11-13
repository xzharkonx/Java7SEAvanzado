package com.luis.tema8_1.Stack;

// Está implementación de Comparable para la Clase persona
// que estára dentro de una pila (Stack) no funcionara para
// ordenar los elementos.
public class Persona implements Comparable<Persona> {
	
	private int id;
	private String nombre;
	private int edad;
	public Persona(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// Está implementación de hashCode y equals para la Clase persona
	// que estára dentro de una pila (Stack) no funcionara para
	// filtrar los elementos que sean repetidos.
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (edad != other.edad)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	// Está implementación de Comparable y este método para la Clase persona
	// que estára dentro de una pila (Stack) no funcionara para
	// ordenar los elementos.
	
	@Override
	public int compareTo(Persona per) {
		return this.edad - per.getEdad();
	}
	
	

}
