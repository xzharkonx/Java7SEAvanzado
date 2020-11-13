package com.luis.tema4.Genericos_I;

public class App {
	
	// Los GENERICOS Y SUS ESTEREOTIPOS MAS COMUNES.

	// Genérico: - Común a varias especies.
	//			 - Que denota el conjunto de los miembros de una clase o especie.
	//			 - Perteneciente o relativo al conjunto de los miembros de una clase.
	
	// Cuando hablamos de genéricos en JAVA estamos haciendo mención a que una clase va a poder 
	// implementar un determinado tipo de elemento por decirlo de está manera.
	
	// Supongamos que nosotros tuvieramos una lista y en está lista no definimos que tipo de dato es,
	// sería una lista simple por ejemplo:
	//
	//	List lista = new ArrayList();
	// 
	// Está lista me va a permitir almacenar todos los elementos posibles, es decir, va a poder 
	// aceptar un Entero, un String o inclusive un Objeto propio que nosotros hayamos creado.
	// Pero en mayores aplicaciones generalmente se respeta un ordén en el cuál se indica que
	// una lista debe o debe especificar de que elemento se va a implementar, es por ello
	// que existe el operador Diamante <> , este operador va a indicar el tipo de dato que
	// van a implementar algunos determinados objetos, en este caso es la lista, yo le indicaria
	// que la lista sería de tipo String, o podría ser de tipo integer o inclusive de un objeto propio.
	//
	//	List<String> lista1 = new ArrayList();
	//	List<Integer> lista2 = new ArrayList();
	//	List<Persona> lista3 = new ArrayList();
	//	
	// Ahora que ventaja tengo yo con esto,, imagina una aplicación a grandes escalas donde trabajan
	// otros desarrolladores y si la lista no tiene indicado quizas el tipo de dato que se va a procesar
	// ahí y si estámos haciendo una lógica únicamente para ese tipo de dato y quizás algún otro 
	// desarrollador no considera ese tipo de dato y aplica una lógica pensando a que vendrán datos
	// distintos a los que tú declaraste inicialmente puede haber quizás una situación controversial
	// en algún futuro y peor aún cuando hay que darle mantenimiento a esa aplicación.
	
	public static void main(String[] args) {
		
		// Entonces crearemos una Clase genérica.
		// Le indicamos que será el genérico de tipo String
		// Le pasamos un tipo de dato String por el constructor.
		// Cualquier otro tipo de dato que le pasemos dará error.
		Clase<String> c = new Clase<String>("Luis Eduardo");
		c.mostrarTipo();
		
		// Ahora mira como la clase cambia y se le pasan datos de tipo entero.
		Clase<Integer> i = new Clase<Integer>(27);
		i.mostrarTipo();
	}

}
