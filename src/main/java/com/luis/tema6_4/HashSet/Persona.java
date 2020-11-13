package com.luis.tema6_4.HashSet;

// Se implementan los métodos hashCode y equals.
public class Persona {

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



	// En está clase lo que vamos a hacer es sobeescibir
	// 2 métodos importantes llamados: equals y hashCode
	// especialmente vamos a seleccionar bajo que criterio
	// vamos a hacer la comparación en este caso solo el nombre.
	
	// Y estos métodos hashCode y equals nos va a permitir comparar
	// ambos objetos (en este caso de toda la lista) y asociar o 
	// buscar si el valor que hemos seleccionado relativamente es igual
	// a otros objetos, entonces se va a hacer la comparación y se
	// le va a calcular o se le va a asociar un valor
	
	// Se hace la comparación y se le asigna un valor aleatorio,
	// solo como un valor referencial.

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	// Comparacion de objetos, si son iguales o diferentes.
	// Si son iguales, retornara verdadero.
	// si son diferentes retornara falso.


	
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
		
	// Ahora si le podremos pasar está lista de interfaz Set que implementa con hashCode.
	// Y los mostrara si son diferentes de nombre y edad.
	
	
}
