package com.luis.tema2;

import java.util.List;
import java.util.ArrayList;

public class App {
	
	List canasta = new ArrayList();

	private void verificar(Object obj) {
		if(obj instanceof Fruta) {
			canasta.add(obj);
			if (obj instanceof Manzana) {
				
				// Se hace un casteo del obj (porque no se sabe que es)
				// para hacer ese objeto de clase Fruta y poder acceder a su metodo getNombre()
				System.out.println("Fruta Manzana: "+ ((Fruta)obj).getNombre());
			}else {
				System.out.println("Fruta agregada: "+ ((Fruta)obj).getNombre());
				
			}
		}else {
			System.out.println("Elemento no permitido");
		}
	}
	
	

	public static void main(String[] args) {
		String texto = new String("Luis");
		
		// Con instanceof Comparamos si una variable pertenece a una clase en especial. 
		//		if (texto instanceof String) {
		//			System.out.println("Es un String");
		//			
		//		}
		
		
		//		Alumno al = new Alumno();
		//
		//		if (al instanceof Persona) {
		//		// Aquí comprobaremos que efectivamente Alumno pertenece a la clase Pesona
		//			System.out.println("Es una persona");
		//		}
		
		// Ejercicio
		// Se tiene una canasta en donde solo se debe permitir ingresar frutas.
		System.out.println("Canasta abierta, porfavor ingresa SOLO frutas");
		Manzana m1 = new Manzana("ROJA");
		Manzana m2 = new Manzana("VERDE");
		Naranja n1 = new Naranja("NARANJA");
		Galleta g1 = new Galleta("CHOCOLATE");
		
		App app = new App();
		app.verificar(m1);
		app.verificar(m2);
		app.verificar(n1);
		app.verificar(g1);
		
		
	}

	private static List ArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

}
