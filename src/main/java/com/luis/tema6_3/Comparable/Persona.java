package com.luis.tema6_3.Comparable;

// Agregamos un generico de tipo persona <Persona> a la Clase Comparable
// para decirle que no sea el Object por Default.
public class Persona implements Comparable<Persona>{

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
	
	// El método necesario para hacer está comparación interna
	// es el método compareTo, está esperando como parametro un Object
	// Por la tanto añadiremos un Generico a la clase Comparable para indicarle que 
	// ese objeto será de tipo persona.
	@Override
	public int compareTo(Persona per) {
		
		// ORDENAR POR ENTEROS ---------------------------
		// Para ordenar por edades.
		// Por orden Ascendente
		//return this.edad - per.getEdad();
		
		// ¿Porqué se ha hecho una resta?
		// El método compareTo retorna un entero, este puede ser Positivo, Negativo o "0".
		// Si es 0, indica que son iguales.
		// Si fuese Positivo o Negativo, el orden varia.

		// Por orden Decendente
		// return per.getEdad() - this.edad;
		
		// ORDENAR POR STRING ----------------------------
		
		// Ordenar de forma Ascendente.
		return this.nombre.compareTo(per.getNombre());

		// Ordenar de forma Decendente.
		//return per.getNombre().compareTo(this.nombre);
	}
	
	
}
