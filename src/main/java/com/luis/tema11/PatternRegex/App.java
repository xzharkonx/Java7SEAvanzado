package com.luis.tema11.PatternRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {
		
		// Definición de una expresión regular.
		
		// Una expresión regular a menudo también llamada regex, es una secuencia de caracteres
		// que forma un patrón de búsqueda, principalmente utilizada para la búsqueda de 
		// patrones de cadenas de caracteres u operaciones de sustituciones.
		
		// En otras palabras, lo que da a entender es que una expresión regular es una cadena
		// de texto que tiene un formato en particular (que respeta algunas caracteristicas)
		// que nos va a permitir facilitar la búsquda en otras cadenas de textos de acuerdo a
		// ese patrón que hemos venido definiendo anteriormente.
		
		// En JAVA existen 2 clases importante para el manejo de expresiones regulares.
		// La primera que veremos será la Clase Pattern.
		// La Otra es la Clase Matcher.
		
		// Importamos lo que nos pide.
		// El método compile() es un método de clase.
		// Aquí definimos la expresión regular que queremos evaluar.
		Pattern p = Pattern.compile(".");
		
		// Nos apoyamos de la Clase Matcher, pero de manera muy simple.
		// En el matcher le indicamos la secuencia a evaluar
		Matcher m = p.matcher("XYZ");
		// Con matches() averiguamos si coincide con el patrón que estamos indicando.
		// Nos va a retornar una variable de tipo booleana.
		System.out.println(m.matches());
		// Obtenemos false debido a lo siguiente:
		// El . que le pasamos al método compile() indica que yo voy a evaluar cualquier
		// caracter en particular

		// Si solo coloco X vemos que nos da true. 
		// Pero si colocaramos más caracteres obtendríamos false.
		Matcher m1 = p.matcher("X");
		System.out.println(m1.matches());

		
		// Ahora colocamos lo siguiente:
		Pattern p2 = Pattern.compile(".m");
		Matcher m2 = p2.matcher("amb");
		System.out.println(m2.matches());
		// Obtenemos false, debido a que el patrón nos está indicando que no importa que
		// elemento sea el primero, pero el segundo debe ser m y ahí debe terminar la expresión.
		// por lo que ahora borramos la b que teníamos al final.
		// Por lo que ahora nos dará true
		Matcher m3 = p2.matcher("am");
		System.out.println(m3.matches());
		
		
		// Ahora si yo colocara 2 ..
		// Estamos indicando que nuestra expresión va a tener necesariamente 3 caracteres
		// y la última debe ser m
		Pattern p3 = Pattern.compile("..m");
		// Le pasamos abm a matcher()
		Matcher m4 = p3.matcher("abm");
		// Y efectivamente nos dará true
		System.out.println(m4.matches());
		
		// En internet podemos encontrar mucha documentación con respecto a las expresiones regulares.
		// Hay expresiones regulares preparadas para que nosotros simplemente copiemos y las pequemos
		// en nuestro patrón y podamos evaluarlo sin la necesidad de construirlo desde 0.
		// Claro está que si tenemos una necesidad en particular habría que analizar simplemente como
		// se construyen estás.
		
		
		// Por ejemplo si yo evaluo la expresión [abc] entre corchetes, entonces lo que nos va a evaluar
		// es que nuestro texto tenga solamente una de estás letras.
		Pattern p4 = Pattern.compile("[abc]");
		// Le pasamos "a" a matcher() (puede ser b o c también).
		Matcher m5 = p4.matcher("a");
		// Y efectivamente nos dará true
		System.out.println(m5.matches());

		// Si le paso "e" va a ser false.
		Matcher m6 = p4.matcher("e");
		// Y efectivamente nos dará false
		System.out.println(m6.matches());
		
		
		
		// Ahora si colocamos el simbolo ^, estaremos haciendo lo contrario a lo que coloquemos dentro
		// de los corchetes. 
		Pattern p5 = Pattern.compile("[^abc]");
		// Dará true, siempre y cuando sea cualquier elemento diferente a "abc".
		// Por lo que ahora colocaremos "e".
		Matcher m7 = p5.matcher("e");
		// Y efectivamente nos dará true
		System.out.println(m7.matches());
		
		
		// Podemos ver que tenemos el patron compilado en nuestras variables p* de la Clase Pattern.
		// Recordemos el método split() que nos permitia poder separar de acuerdo a una expresión regular
		// y pasarlo a un arreglo de String.
		// Ahora veremos lo siguiente.
		
		// Apoyandonos de un Pattern
		long ini = System.currentTimeMillis();
		Pattern pp = Pattern.compile(";");
		for (int i = 0; i < 10000; i++) {
			// Aquí es mucho más eficiente tener la expresión regular copilada una única vez.
			// Y utilizar el método split() de la expresión Pattern
			String[] arreglo = p.split("Luis;Luis Eduardo;Eduardo;Impostor");			
		}
		
		long fin = System.currentTimeMillis();
		System.out.println(fin-ini);

		// Por otro lado pero bajo el enfoque de Split
		long iniSplit = System.currentTimeMillis();
		
		for (int i = 0; i < 10000; i++) {
			// Este método .split() que aquí está iterando varias veces, está llamando a
			// compilar nuestra expresión regular esas cantidades de veces que iteran en el ciclo.
			// Entonces en cuestiones de rendimiento o de memoria, estar mandando a compilar muchas
			// veces la misma expresión regular a evaluar durante todas los procesos.
			String[] arreglo = "Luis;Luis Eduardo;Eduardo;Impostor".split(";");			
		}
		
		long finSplit = System.currentTimeMillis();
		System.out.println(finSplit-iniSplit);
		
		// Miramos que la primera parte donde utilizamos el Pattern.split
		// Es mayor a Split.
		// Entonces podemos encontrar que en JDK 1.6 este resultado es inverso
		// en lo que es que el Pattern es más efectivo que el Split, pero en la
		// JDK 1.7 esto a mejorado siempre y cuando la expresión regular sea básica.
		// A medida que la expresión regular se complique el resultado va a estár
		// más a favor de Pattern que de Split.
		
		// Dicho de otra manera, siempre es más aconsejable utilizar Pattern cuando
		// tenemos un procesamiento masivo de una cadena de texto, especialmente cuando
		// utilizamos los métodos de la clase String que necesitan de una expresión regular.
		// Por ejemplo, Split es uno de ellos.
		
		// Otros métodos que utilizan esto son:
		// "Mi cadena".matches("") // Necesita también de un regex (expresión regular).
		// "Mi cadena".replaceAll("") // Necesita también de un regex (expresión regular).
		// "Mi cadena".replaceFirst("") // Necesita también de un regex (expresión regular).
		// "Mi cadena".startsWith("") // Necesita también de un regex (expresión regular).
		
		// Mucho texto =C
	}

}
