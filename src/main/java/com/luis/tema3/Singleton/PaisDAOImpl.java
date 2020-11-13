package com.luis.tema3.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaisDAOImpl{

	// Para implementar el patrón, a cada objeto se colocara lo siguiente:---------------------------------
	// * Creamos un constructor privado para evitar que esta Clase sea instanciada de forma normal y que
	//   solo pueda ser instanciada por el método getInstance() que crearemos a continuación.
	// * Creamos un objeto de está misma clase estático y nulo.
	// * Crearemos un método llamado getInstance() donde comprobaremos si hemos
	// 	 instanciado o no (esta vacio/nulo) un objeto de está misma clase.
	//   Si esta vacio creamos la instancia y lo retornamos, si no, solo lo retornamos.
	// * Ahora cuando creemos un objeto de está clase, lo deberemos hacer pero llamando este método.
	//   por ejemplo: PaisDAOImlp dao = PaisDatoImpl.getInstance();
	
	// Se coloca este constructor de ambito privado para no poder instanciar de forma normal
	// está clase y así evitar la creación de clases normales con constructor y que exclusivamente
	// sean por el método getInstance()
	 private PaisDAOImpl() {}

	// El patrón dice que necesitamos un método que me retorne una única instancia
	// de esa Clase.
	// Por lo tanto creamos un objeto estático de está clase. Es de ambito estático
	// para que pueda ser utilizado por el método estático getInstance()
	public static PaisDAOImpl instancia = null;
	
	// Creamos un método que nos retorne una única instancia recien creada.
	public static PaisDAOImpl getInstance() {
		// Si la instancia está vacia la creara, si no, se saltará.
		if (instancia == null) {
			// Creamos la única instancia.
			instancia = new PaisDAOImpl();
		}
		// Se retorna la instancia.
		return instancia;
	}
	
	// * Hasta aquí termina la implementaión del patrón Singleton para este objeto. 
	// * Cabe mencionar que habría que hacer esto por cada objeto que creemos de 
	// 	 nuestra aplicación donde solo llamemos una sola vez con esta clase a una
	//   determinada colección de objetos para no volver a recargarlos por cada 
	//   instancia que creemos.
	// --------------------------------------------------------------------------------------
	
	// Opcionalmente podemos hacer que este método sea de tipo estático para 
	// mantener la secuencia de invocar a la Clase y a su vez el metodo para instanciarla (aplicacndo Singleton)
	// pero ahora será invocar a la Clase y a su vez el método para devolver los países
	private static List paises = null;
	//private  List paises = null;
	
	public static List getPaises() {
	// public List getPaises() {
		
		// Se comprueba que la lista este vacia, para añadirle los datos.
		// Este if será una decición clave para indicarle que hará o que no hará
		// en caso de que este recien instanciada a cada uno de nuestros métodos según
		// nuestra lógica.
		if (paises == null) {
			
			// Se crea la instancia para que no nos de un
			// error de nullPointerException.
			paises = new ArrayList();
			
			Pais p1 = new Pais("PERU");
			Pais p2 = new Pais("MEXICO");
			Pais p3 = new Pais("COLOMBIA");
			
			paises.add(p1);
			paises.add(p2);
			paises.add(p3);
		}
		
		return paises;
		
	}
	
	
	// Este metodo lo coloque yo para comprobar que el objeto que solo puede ser instanciado
	// una sola vez puede ser modificado.
	public static List cambiarNombrePaises(List p) {
		System.out.println("El número de paises son: "+p.size());
		// Para preguntar por el nombre del país.
		try (Scanner sc = new Scanner(System.in)) {
			String nombre = "";
			// Contador de países
			int i = 1;
			for(Object obj: p) {
				System.out.println("Cambia el nombre del país "+((Pais)obj).getNombre()+" número: "+i+".");
				 nombre = sc.next();
				((Pais)obj).setNombre(nombre);
				i++;
			}
		}catch(Exception e) {
			System.out.println("Ha ocurrido el siguiente error: "+e.getMessage());
		}
		return p;
	}
	
}
