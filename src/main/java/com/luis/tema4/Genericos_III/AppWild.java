package com.luis.tema4.Genericos_III;

import java.util.ArrayList;
import java.util.List;

// WILDCARDS
// Como trabajar con ellos para
// LowerBon

// Si traducimos la palabra WILDCARD al español quiere dar a entender que es un comodín
// o una carta de sustituto.

// Si lo llevamos al contexto de JAVA y especificamente los genericos, lo que nos va a 
// permitir los WILDCARDS es poder ejecutar nuestros genericos sin indicar el tipo de dato
// es decir, este tipo de dato va a indicarse en tiempo de ejecución, no lo vamos a mencionar
// directamente en el código.

public class AppWild {
	
	// Todo esto bajo en Contexto de los Wildcars.
	
	//UnBounded: Es que no estamos indicando el tipo, es decir, vamos a esperar de un tipo
	// object en común.
    
        // Hace referencia cualquier Clase que le enviemos, pero de nosotros
        // depende el comportamiento, porque casteamos a la Clase Alumno y
        // ira que le pasamos una lista de alumnos.
	public void listarUnBounded(List<?> lista) {
		for (Object a : lista) {
			// Como lo reconoce como un objeto cualquiera tenemos que definir si es 
			// alguna clase de la que tengamos conocimiento en este caso Alumno
                        
                        // Se comprueba si pertenece a la clase para evitar el error: ClasCastException.
			// Ahora forzosamente tendríamos que Castear el método de este objeto
			// Para que pueda ser reconocido de que pertenece a la Clase Alumno.
			if (a instanceof Alumno) 
                                
				System.out.println(((Alumno)a).getNombre());
			else
				// Si no pues será de la Clase Profesor
				System.out.println(((Profesor)a).getNombre());
		}
	}
	
	// UpperBounded: Hace mención a que va a resivir cualquier tipo que
	// sea una SubClase de la clase que estamos indicando. (Ojo, herencia o interfaz). 
	// En este caso como la clase es Persona, todos los objetos que hereden de ella
	// en este caso la Clase Alumno y la Clase Profesor heredan de ella. Es por eso que es Upper
	// porque se toma algo superior.
        
        // Hace referencia a la Clase Profesor que hereda de Persona.
        // Se le pasa una lista de objetos de tipo Profesor.
	public void listarUpperBounded(List<? extends Persona> lista) {
		for (Persona a : lista) {
			// Observa que solo se imprime este método que está dentro de está clase.
                        // No tiene necesidad de casteo a Profesor porque es un 
                        // método de la Clase heredera principal.
			System.out.println(a.getNombre());
		}
	}

	// LowerBounded: La lista será de cualquier tipo que sea una super clase de la clase que estamos
	// indicando aquí que es Alumno, es decir, las Clases que sean superiores a Alumno
	// como en este caso lo es Object. Es por eso que es Lower porque se toma el menor.      
        
        // Hace referencia a la Clase heredera permirte a todos las Clases que
        // hereden de esta misma Clase.
        
        // En este caso la Clase Alumno Hereda de Persona pero le pasamos una lista
        // de Objetos de Tipo Alumno y Profesor Mezclados que Heredan de Persona.
        // Solo detallamos la lógica para cada uno con un Casteo dentro del ciclo.
	public void listarLowerBounded(List<? super Alumno> lista) {
		for (Object  a : lista) {
			if (a instanceof Alumno) {
				System.out.println(((Alumno)a).getNombre());
				((Alumno)a).mostrarEdad();
			}else {
				System.out.println(((Profesor)a).getNombre());
				((Profesor)a).mostrarEdad();
			}
		}
	}

	public static void main(String[] args) {
		AppWild aw = new AppWild();
		
		Alumno al1 = new Alumno("Luis",25);
		Alumno al2 = new Alumno("Eduardo",26);
		Alumno al3 = new Alumno("Luis Eduardo",27);
		
		Profesor pr1 = new Profesor("Oscar",38);
		Profesor pr2 = new Profesor("Daniel",40);
		Profesor pr3 = new Profesor("Elia",30);
		
		List<Alumno> listaUnBounded = new ArrayList<>();
		listaUnBounded.add(al1);
		listaUnBounded.add(al2);
		listaUnBounded.add(al3);
		
		aw.listarLowerBounded(listaUnBounded);
		
		List<Profesor> listaUpperBounded = new ArrayList<>();
		listaUpperBounded.add(pr1);
		listaUpperBounded.add(pr2);
		listaUpperBounded.add(pr3);
		
		
		aw.listarUpperBounded(listaUpperBounded);
		
		List<Object> listaLowerBounded = new ArrayList<>();
		listaLowerBounded.add(al1);
		listaLowerBounded.add(al2);
		listaLowerBounded.add(al3);
		listaLowerBounded.add(pr1);
		
		
		aw.listarLowerBounded(listaLowerBounded);
		
		
	}
}
