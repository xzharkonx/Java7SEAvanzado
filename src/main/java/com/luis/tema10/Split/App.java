package com.luis.tema10.Split;

public class App {

	public static void main(String[] args) {
		// Sirve básicamente para poder extraer elementos
		// de una cadena de texto para poder asignarlos a un arreglo.
		String cadena = "Luis;LuisEduardo;Eduardo;Impostor";
		// Necesitamos indicar la expresión regular que vamos a desear para poder
		// tener el criterio de extracción.
		
		// Aquí pueden surgir algunos inconvenientes por el tema de expresiones regulares que se ve más adelante.
		String[] extraccion = cadena.split(";");
		// También así podría funcionar:
		//String[] extraccion = cadena.split("\\;");
		for (String elemento : extraccion) {
			System.out.println(elemento);
		}
		
		// En algunas aplicaciones algunas apicaciones que consumen algún servicio y devuelven una data
		// que prácticamente tiene el siguiente formato: (está separado por |).
		
		String cadena2 = "Luis|LuisEduardo|Eduardo|Impostor";
		
		String[] extraccion2 = cadena2.split("|");
		for (String elemento : extraccion2) {
			System.out.println(elemento);
		}
		
		// Saldrá algo que no esperaba.
		// Esto es un comportamiento inusual debido a que es un error de interpretación por parte 
		// del programador.
		
		// El método split() puede presentar 2 parametros, el primero que es una expresión regular (se ve 
		// a profundidad más adelante).
		// Y el segundo parámetro es un entero límite.
		// Miremos como se coloca correctamente.

		String cadena3 = "Luis|LuisEduardo|Eduardo|Impostor";
		
		// Está expresión vendría a ser así paa este simbolo |
		String[] extraccion3 = cadena3.split("\\|");
		for (String elemento : extraccion3) {
			System.out.println(elemento);
		}
		
		// Vemos que ahora si está reconociendo.
		
		//Entonces si ahora le paso un parametró en este caso 2, tendremos 2 elementos solamente.
		System.out.println("\n");
		
		String cadena4 = "Luis|LuisEduardo|Eduardo|Impostor";
		
		// Le pasamos el parametro 2.
		String[] extraccion4 = cadena4.split("\\|",2);
		for (String elemento : extraccion4) {
			System.out.println(elemento);
		}
		// Está encontrando la primera coincidencia y todo lo demás desde esa coincidencia hacia la 
		// derecha va a ser impreso.
		
		// Se tendría que colocar una expresión regular un poco más trabajada para poder evaluar la
		// cadena de texto que necesitamos.
	}

}
