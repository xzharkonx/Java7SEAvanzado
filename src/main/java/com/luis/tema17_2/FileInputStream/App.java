package com.luis.tema17_2.FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class App {

	public void leerPorFileInputStream() throws IOException{
		// Tenemos aquí un Objet fis que pertenece a la Clase Abstracta
		// InputStream
		InputStream fis = null;
		try {
			// En donde creamos un objeto (una instancia) de FIleInputStream
			// Esto es aceptable debido a que es un subtipo.
			// En el Constructor necesito indicarle la fuente, ¿Que es lo que voy a leer?
			// Puede ser un Archivo, una fuente de datos, lo que querramos.
			// En este caso es un archivo luisTexto.txt que ya tenemos en el proyecto con un pequeño texto.
			// Una vez que ya tenemos la instancia ya tenemos la referencia a ese archivo
			// pero necesito procesar los datos.
			
			
			fis = new FileInputStream("luisTexto.txt");
			// Podes comentar está línea de abajo junto con las otras de abajo que se indican 
			// para ver una secuencia de bytes
			byte[] arr = new byte[1024];
			


			// Tenemos que leer a través del método read, este método read() lo que va a hacer es
			// leer bit a bit en la secuencia de datos, cuando tenemos un Stream la lectura 
			// tradicional es leer item tras item de una manera secuencial y cuando el último
			// item sea leido va a ser interpretado como un valor negativo interpretado en -1
			// que lo que va a hacer es indicar que la secuencia a terminado y por lo tanto no
			// hay más que leer.
			
			// Pero el método read() presenta algo en particular que es la lectura de bytes de manera
			// de un arreglo, ¿Con que objetivo esto es usado?, muchas veces cuando se navega por internet
			// encontramos algunos arreglos de bytes definidos en 512 o 1024 y son leídos en los Streams
			// esto es para mejorar el rendimiento, en vez de leer de manera secuencial vamos a leer
			// exactamente así pero de manera más bloque, es decir, leyendo en la cantidad en que esta definido
			// el arreglo en bytes, por eso se coloca el arreglo de bytes arriba.
			int i = fis.read(arr, 0, arr.length);
			// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
			//int i = fis.read();
			
			// Dentro del while, lo que estoy haciendo es imprimir el byte leído.
			// Se continua leyendo hasta que sea -1 y rompa el ciclo.
			while(i != -1) {
				System.out.println((char) i + ":" + i);
				// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
				//System.out.println(i);
				i = fis.read(arr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			 // Finalmente cerramos el recurso para no desperdiciar la memoria.
			if(fis != null) {
				fis.close();
			}
		}
	}
	
	public void leerPorFileInputStreamBytes() throws IOException{
		// Tenemos aquí un Objet fis que pertenece a la Clase Abstracta
		// InputStream
		InputStream fis = null;
		try {
			// En donde creamos un objeto (una instancia) de FIleInputStream
			// Esto es aceptable debido a que es un subtipo.
			// En el Constructor necesito indicarle la fuente, ¿Que es lo que voy a leer?
			// Puede ser un Archivo, una fuente de datos, lo que querramos.
			// En este caso es un archivo luisTexto.txt que ya tenemos en el proyecto con un pequeño texto.
			// Una vez que ya tenemos la instancia ya tenemos la referencia a ese archivo
			// pero necesito procesar los datos.
			
			
			fis = new FileInputStream("luisTexto.txt");
			// Podes comentar está línea de abajo junto con las otras de abajo que se indican 
			// para ver una secuencia de bytes
			//byte[] arr = new byte[1024];
			


			// Tenemos que leer a través del método read, este método read() lo que va a hacer es
			// leer bit a bit en la secuencia de datos, cuando tenemos un Stream la lectura 
			// tradicional es leer item tras item de una manera secuencial y cuando el último
			// item sea leido va a ser interpretado como un valor negativo interpretado en -1
			// que lo que va a hacer es indicar que la secuencia a terminado y por lo tanto no
			// hay más que leer.
			
			// Pero el método read() presenta algo en particular que es la lectura de bytes de manera
			// de un arreglo, ¿Con que objetivo esto es usado?, muchas veces cuando se navega por internet
			// encontramos algunos arreglos de bytes definidos en 512 o 1024 y son leídos en los Streams
			// esto es para mejorar el rendimiento, en vez de leer de manera secuencial vamos a leer
			// exactamente así pero de manera más bloque, es decir, leyendo en la cantidad en que esta definido
			// el arreglo en bytes, por eso se coloca el arreglo de bytes arriba.
			//int i = fis.read(arr, 0, arr.length);
			// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
			int i = fis.read();
			
			// Dentro del while, lo que estoy haciendo es imprimir el byte leído.
			// Se continua leyendo hasta que sea -1 y rompa el ciclo.
			while(i != -1) {
				//System.out.println((char) i + "-" + i);
				// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
				System.out.println(i);
				i = fis.read();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			 // Finalmente cerramos el recurso para no desperdiciar la memoria.
			if(fis != null) {
				fis.close();
			}
		}
	}
	
	// Empleando trywithresources
	public void leerPorFileInputStreamTryWithResources() throws IOException{
		// Tenemos aquí un Objet fis que pertenece a la Clase Abstracta
		// InputStream
		try(InputStream fis = new FileInputStream("luisTexto.txt");) {
			// En donde creamos un objeto (una instancia) de FIleInputStream
			// Esto es aceptable debido a que es un subtipo.
			// En el Constructor necesito indicarle la fuente, ¿Que es lo que voy a leer?
			// Puede ser un Archivo, una fuente de datos, lo que querramos.
			// En este caso es un archivo luisTexto.txt que ya tenemos en el proyecto con un pequeño texto.
			// Una vez que ya tenemos la instancia ya tenemos la referencia a ese archivo
			// pero necesito procesar los datos.
			
			byte[] arr = new byte[1024];
			
			// Tenemos que leer a través del método read, este método read() lo que va a hacer es
			// leer bit a bit en la secuencia de datos, cuando tenemos un Stream la lectura 
			// tradicional es leer item tras item de una manera secuencial y cuando el último
			// item sea leido va a ser interpretado como un valor negativo interpretado en -1
			// que lo que va a hacer es indicar que la secuencia a terminado y por lo tanto no
			// hay más que leer.
			
			// Pero el método read() presenta algo en particular que es la lectura de bytes de manera
			// de un arreglo, ¿Con que objetivo esto es usado?, muchas veces cuando se navega por internet
			// encontramos algunos arreglos de bytes definidos en 512 o 1024 y son leídos en los Streams
			// esto es para mejorar el rendimiento, en vez de leer de manera secuencial vamos a leer
			// exactamente así pero de manera más bloque, es decir, leyendo en la cantidad en que esta definido
			// el arreglo en bytes, por eso se coloca el arreglo de bytes arriba.
			// int i = fis.read(arr, 0, arr.length);

			int i = fis.read(arr);
			
			// Dentro del while, lo que estoy haciendo es imprimir el byte leído.
			// Se continua leyendo hasta que sea -1 y rompa el ciclo.
			while(i != -1) {
				System.out.println("bytes leidos " + i);
				// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
				//System.out.println(i);
				i = fis.read(arr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	// Empleando trywithresources en Rendimiento
	public void leerPorFileInputStreamTryWithResourcesRendimiento() throws IOException{
		
		// Ahora mediremos el rendimento en bytes leyendo la imagen y midiendo el tiempo
		// leyendo con un arreglo y el otro midiendolo con el método read() tradicional.
		// Colocamos una variable para medir el rendimiento
		long ini = System.currentTimeMillis();
		// Tenemos aquí un Objet fis que pertenece a la Clase Abstracta
		// InputStream
		//try(InputStream fis = new FileInputStream("luisTexto.txt");) {
		// Ahora leemos un archivo Gif.
		try(InputStream fis = new FileInputStream("JavaApache.gif");) {
			// En donde creamos un objeto (una instancia) de FIleInputStream
			// Esto es aceptable debido a que es un subtipo.
			// En el Constructor necesito indicarle la fuente, ¿Que es lo que voy a leer?
			// Puede ser un Archivo, una fuente de datos, lo que querramos.
			// En este caso es un archivo luisTexto.txt que ya tenemos en el proyecto con un pequeño texto.
			// Una vez que ya tenemos la instancia ya tenemos la referencia a ese archivo
			// pero necesito procesar los datos.
			
			byte[] arr = new byte[1024];
			
			// Tenemos que leer a través del método read, este método read() lo que va a hacer es
			// leer bit a bit en la secuencia de datos, cuando tenemos un Stream la lectura 
			// tradicional es leer item tras item de una manera secuencial y cuando el último
			// item sea leido va a ser interpretado como un valor negativo interpretado en -1
			// que lo que va a hacer es indicar que la secuencia a terminado y por lo tanto no
			// hay más que leer.
			
			// Pero el método read() presenta algo en particular que es la lectura de bytes de manera
			// de un arreglo, ¿Con que objetivo esto es usado?, muchas veces cuando se navega por internet
			// encontramos algunos arreglos de bytes definidos en 512 o 1024 y son leídos en los Streams
			// esto es para mejorar el rendimiento, en vez de leer de manera secuencial vamos a leer
			// exactamente así pero de manera más bloque, es decir, leyendo en la cantidad en que esta definido
			// el arreglo en bytes, por eso se coloca el arreglo de bytes arriba.
			// int i = fis.read(arr, 0, arr.length);
			
			int i = fis.read(arr);
			
			// Dentro del while, lo que estoy haciendo es imprimir el byte leído.
			// Se continua leyendo hasta que sea -1 y rompa el ciclo.
			while(i != -1) {
				// System.out.println("bytes leidos " + i);
				// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
				//System.out.println(i);
				i = fis.read(arr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo bytes[]: " + (fin-ini));
		
		
		// ----------------------------------------------------------------------------------------------------
		// Midiendo el rendimiento con el método read() tradicional.
		System.out.println("-----------------------------");
		
		ini = System.currentTimeMillis();
		// Tenemos aquí un Objet fis que pertenece a la Clase Abstracta
		// InputStream
		//try(InputStream fis = new FileInputStream("luisTexto.txt");) {
		// Ahora leemos un archivo Gif.
		try(InputStream fis = new FileInputStream("JavaApache.gif");) {
			// En donde creamos un objeto (una instancia) de FIleInputStream
			// Esto es aceptable debido a que es un subtipo.
			// En el Constructor necesito indicarle la fuente, ¿Que es lo que voy a leer?
			// Puede ser un Archivo, una fuente de datos, lo que querramos.
			// En este caso es un archivo luisTexto.txt que ya tenemos en el proyecto con un pequeño texto.
			// Una vez que ya tenemos la instancia ya tenemos la referencia a ese archivo
			// pero necesito procesar los datos.
			
			// Quitamos el arreglo.
			//byte[] arr = new byte[1024];
			
			// Tenemos que leer a través del método read, este método read() lo que va a hacer es
			// leer bit a bit en la secuencia de datos, cuando tenemos un Stream la lectura 
			// tradicional es leer item tras item de una manera secuencial y cuando el último
			// item sea leido va a ser interpretado como un valor negativo interpretado en -1
			// que lo que va a hacer es indicar que la secuencia a terminado y por lo tanto no
			// hay más que leer.
			
			// Pero el método read() presenta algo en particular que es la lectura de bytes de manera
			// de un arreglo, ¿Con que objetivo esto es usado?, muchas veces cuando se navega por internet
			// encontramos algunos arreglos de bytes definidos en 512 o 1024 y son leídos en los Streams
			// esto es para mejorar el rendimiento, en vez de leer de manera secuencial vamos a leer
			// exactamente así pero de manera más bloque, es decir, leyendo en la cantidad en que esta definido
			// el arreglo en bytes, por eso se coloca el arreglo de bytes arriba.
			// int i = fis.read(arr, 0, arr.length);
			
			int i = fis.read();
			
			// Dentro del while, lo que estoy haciendo es imprimir el byte leído.
			// Se continua leyendo hasta que sea -1 y rompa el ciclo.
			while(i != -1) {
				// System.out.println("bytes leidos " + i);
				// Puedes descomentar la línea de abajo y comentar la de arriba para ver la secuencia de bytes
				//System.out.println(i);
				i = fis.read();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		fin = System.currentTimeMillis();
		System.out.println("Tiempo byte a byte: " + (fin-ini));
	}
	
	
	public static void main(String[] args) throws IOException{
		
		// Cuando trabajamos el paquete JAVAIO especificamente
		// tenemos que tener claro la diferiencia entre BinaryData
		// y TextData, así que JAVA para poder implementar o leer este
		// tipo de datos nos ofrece Stream y nos ofrece Readers.
		
		// En este tema solamente vamos a ver la parte de Input especificamente
		// para lo que es BinaryData.
		// Vamos a tocar el tema de los Streams, especifícamente lo que es InputStream
		// en un subtipo de FileInputStream.
		
		App app = new App();
		// Podemos ver el número de byes que salen
		
		// app.leerPorFileInputStream();
		
		System.out.println("\n-------------------------------------------------------------\n");
		// Si descomentamos las líneas indicadas y comentamos las que se indican podemos ver
		// una secuencia de bytes que podemos interpretarla con una tabla de códigos ASCII.
		
		// app.leerPorFileInputStreamBytes();

		System.out.println("\n-------------------------------------------------------------\n");
		// Mejoramos el método con trywithresources para liberar recursos aútomaticamente
		// Podemos ver el número de byes que salen
		
		// app.leerPorFileInputStreamTryWithResources();
		// Nos sale 11 por la longitud de lo que hemos escrito en el archivo.

		System.out.println("\n-------Midiendo el rendimiento en bytes y sin ellos----------------------\n");
		// Mejoramos el método con trywithresources para liberar recursos aútomaticamente
		// Podemos ver el número de byes que salen.
		
		// Esto es más recomendable cuando tenemos una secuencia enorme de bytes
		// especifícamente en imagenes, es mejor utilizar este tipo de lecturas
		// para que con el contenido que tengamos en el arreglo de tipo bytes lo podamos
		// enviar a una base de datos o trabajar como nosotros gustemos.
		// (Para guardarlo en la base de datos, tendremos que sacar los bites de la imagen y guardar esa
		// decuencia de bytes).
		
		// Ahora mediremos el rendimento en bytes leyendo la imagen y midiendo el tiempo
		// leyendo con un arreglo y el otro midiendolo con el método read() tradicional.
		
		app.leerPorFileInputStreamTryWithResourcesRendimiento();

		// Podemos ver que al leer bytes[] ha sido muchísimo menor en comparación a leer byte a byte.
		// Vemos que con bytes[] tarda milesimas de segundos, el otro tarda varios segundos.
		// En el siguiente tema se verá lo mismo pero apoyandonos de un BufferStream.
		
		

	}

}
