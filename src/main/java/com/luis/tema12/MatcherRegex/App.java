package com.luis.tema12.MatcherRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {
		// En el tema anterior se vio que la Clase Patter tenía un método de Clase
		// conocido como compile(), sin embargo esté método tiene 2 atributos
		// uno que es regex (Expresión regular) y otro que es flag.
		// Esté constante flag: Pattern.CASE_INSENSITIVE lo que va a indicar es que
		// voy a obviar si el contenido a evaluar va a ser indistinto de mayúsculas
		// o minusculas (no será muy extricto en esa parte).
		
		String texto = "Bienvenido a mis codigos en Java";
		// Al compilar está cadena lo que indicamos es que no importa  lo que haya
		// atrás de la palabra Java ni lo que haya despues, entonces va a buscarme
		// en todo el texto.
		Pattern p = Pattern.compile(".*Java.*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(texto);
		// Vemos que nos dará true
		System.out.println("matches: "+m.matches());
		
		// Ahora, adicionalmente de compile() nosotros podemos concatenar matcher()
		// pero esto no me devuelve un Patter (necesitaría tener un booleano),
		// entonces solamente indicariamos el método matches()
		boolean p2 = Pattern.compile(".*Java.*", Pattern.CASE_INSENSITIVE).matcher(texto).matches();
		System.out.println(p2);
		// Y podemos ver que es el mismo resultado en una sola línea de código (ya depende
		// de nosotros como queremos organizar nuestro código).
		
		
		// En la Clase Matcher, vamos a ver el método lookingAt()
		// Vamos a imprimir en pantalla, podemos ver que dará true.
		System.out.println("lookingAt: "+m.lookingAt());

		// ¿Que es este método y para que sirve?.
		// Cuando yo estoy indicando el método lookingAt me va a buscar si la expresión regular (regex)
		// cumple con la cadena (Java) con que inicia el texto. 
		
		System.out.println("\n");
		String texto2 = "Hola mundo en Java";
		// Quitamos los asteriscos y las barras verticales
		Pattern p3 = Pattern.compile("Java", Pattern.CASE_INSENSITIVE);
		Matcher m2 = p3.matcher(texto2);
		System.out.println("matches: "+m2.matches());
		System.out.println("lookingAt: "+m2.lookingAt());
		// Vemos que sale false
		// ¿Porque?, porque matches evalua toda la cadena y lo que estamos indicando es que si toda la cadena
		// practicamente obedece a la expresión Java y como vemos hay diferentes caracteres y en lookinAt()
		// Java se encuentra al final.
		
		System.out.println("\n");
		
		// Entonces si colocamos Hola al inicio, vamos a ver que matches() sale fase, debido a que no coincide
		// con esa expresión regular.
		// Y en lookingAt() sale true, porque el inicio de la cadena de texto coincide con la expresión regular
		// que estamos indicando.
		Pattern p4 = Pattern.compile("Hola", Pattern.CASE_INSENSITIVE);
		Matcher m3 = p4.matcher(texto2);
		System.out.println("matches: "+m3.matches());
		System.out.println("lookingAt: "+m3.lookingAt());
		
		// Entonces con esto podríamos colocar una expresión regular más preparada y ver si la primera coinicidencia
		// (la primera palabra "Hola") coincide con la expreción regular a evaluar (Lo de la Clase Paatern).
		
		
		System.out.println("\n------Método find()-------");
		// Vamos a ver ahora el método find() de la clase Match
		//Mientras que exista o encuentre el patrón regular:
		// Agregamos un contador.
		int contador = 0;
		// Reeditamos nuestro texto:
		texto2 = "Hola mundo en Java hola hola";
		m3 = p4.matcher(texto2);
		while (m3.find()) {
			contador++;
			System.out.println("Coincidencia N° "+ contador);
		}
		// Vemos que tenemos 3 coincidencias (Por que se volvio a reeditar el texto, si se volviera a 
		// ejecutar el método find no concideraria los que ya encontro OJO!).
		
		// Dicho de otra manera, la expresión find() va a ejecutarse siempre y cuando se ecuentre una o más de 1 coicidencia.
		// Si no hay una coincidencia no se ejecutara
		// Mira que aquí como ya se a ejecutado antes no ejecuta nada...
		texto2 = "Hola mundo en Java";
		// texto2 = "mundo en Java"; // Si lo colocamos así no se ejecutaría.
		m3 = p4.matcher(texto2);
		contador = 0;
		while (m3.find()) {
			contador++;
			System.out.println("\nCoincidencia Sin repetir N° "+ contador);
		}
		
		
		
		System.out.println("\n---Método star() y end() para saber el indice---");
		// Y ¿Como saber el inidice de esas coincidencias o saber en que posición están?
		// Para eso existen 2 métodos más como start() y end().
		// Volvemos a reasignar el texto para que vuelva a considerar toda la cadena.
		texto2 = "Hola mundo en Java hola hola";
		m3 = p4.matcher(texto2);
		while (m3.find()) {
			contador++;
			System.out.println("Coincidencia N° "+ contador + " start " + m3.start() + " end "+ m3.end());
		}
		// Mira que cada palabra se encontro desde donde inicia hasta donde termina.
		

		// Conclusión: Lo que se quizó explicar es como poder utiizar las clases Pattern y Matcher
		// en conbinatoría con ambas para poder evaluar las cadenas de texto frente algunos patrones
		// que son las expresiones regulares que nosotros empleemos en nuestras aplicaciones.
		// Recuerda que es importante tener conceptos de rendimiento y apoyarse en la Clase Pattern
		// y Matcher para ver si es que efectivamente la cadena cumple o satisface nuestra Expresión Regular.
	}
}
