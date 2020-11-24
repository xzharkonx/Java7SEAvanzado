package com.luis.tema17_3.BufferedInputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class App {
	
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
	
	// Nuevo método para medir el rendimiento por Buffered Input Stream
	public void leerPorBufferedInputStream() {
		// Para medir el tiempo
		long ini = System.currentTimeMillis();
		
		// Tenemos un try donde estamos leyendo el recurso y lo tenemos
		// con with resources (El try con ()) para que la gestión de liberación
		// de recursos sea de manera automática.
		// Entonces tenemos que "Encapsular" el FileInputStream (envolverlo)
		// en una clase que se llama BufferInputStream 
		// try(InputStream fis = new FileInputStream("JavaApache.gif")) {
		// Para ello escribimos lo siguiente: 
		//try(InputStream fis = new BufferedInputStream(new FileInputStream("JavaApache.gif")) ) {
		// try(InputStream fis = new BufferedInputStream(new FileInputStream("luisTexto.txt")) ) {
		
		//-------Necesiamos saber el espacio de nuestro archivo, es útil para lo siguiente-------------
		File f = new File("JavaApache.gif");
		// Tenemos f que es el Objeto de File
		// Verificamos el tamaño del archivo. 
		//System.out.println("Tamaño del Archivo en Bytes: "+f.length() + " Bytes");
		System.out.println("Tamaño del Archivo en KiloBytes: "+(f.length()/1024) + " KB");
		//----------------------------------------------------------------------------------------------
		
		// Además este método nos permite indicarle el tamaño de Buffer que  va a tener nuestra Clase
		// Para ello declaramos un entero que llamaremos  cantidad y mayormente se utilizan múltiplos
		// de 1024 aquí sería un KiloByte.
		// Si quisieramos 8 o 10 KiloBytes tendría que ser lo correspondiente:
		// int cantidad = 8 * 1024;
		// En este caso indicaremos 16 Kilo Bytes.
		//int cantidad = 16 * 1024;
		
		// Ahora que podemos indicar el tamaño del archivo ya sea en Bytes o en KiloBytes:
		int cantidad = (int) f.length(); // En Bytes
		// Primero se obtiene la cantidad en KiloBytes y luego se multiplica por 1024 para transformar a Bytes
		// aunque es mejor dejar la de arriba.
		// int cantidad = (int) (f.length()/1024) * 1024; // En Kilobytes
		
		// Ahora, ¿Como le asociamos esa cantidad?, solo hay que pasarle la cantidad al método.
		// Esto sirve específicamente para poder mejorar el rendimiendo te la lectura cuando tenemos imágenes.
		try(InputStream fis = new BufferedInputStream(new FileInputStream("JavaApache.gif"), cantidad) ) {
			
			// Ahora tenemos ese objeto fis asociado a un BufferReader, es decir, a un Buffer interno
			// que nos va a permitir agilizar el procesamiento en lugar de leer byte a byte.
			
			// Ahora para leer ese continero lo haremos de la misma manera en que lo haríamos con un
			// InputStream
			
			int i = fis.read();
			while(i != -1) {
				// System.out.println(i);
				// Podemos ver los datos con un casteo a char y quitamos el salto de línea.
				// Comentamos por que ahora leemos un archiv .gif
				// System.out.print((char) i);
				i = fis.read();
				// Podemos comprobar el valor de -1 si descomentamos la línea de abajo y nos saldra un signo de ?
				// Pero también podemos apreciar que en esta versión de Java 11 no nos sale nada.
				// System.out.println((char)i);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Para medir el tiempo
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo BufferedInputStream: " + (fin-ini));
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Algunas unidades de medida de archivos");
		// Antes de empezar es útil saber como medir el espacio que ocupan los achivos en memoria.
		// Aquí unos resultados para el archivo leído (ocuparemos más el del tamaño del archivo).
		File f = new File("JavaApache.gif");
		// Tenemos f que es el Objeto de File
		// Verificamos el tamaño del archivo. 
		System.out.println("Tamaño del Archivo en Bytes: "+f.length() + " Bytes");
		System.out.println("Tamaño del Archivo en KiloBytes: "+(f.length()/1024) + " KB");
		//		System.out.println("Espacio Total en Disco en KiloBytes: "+(f.getTotalSpace()/1024)+" KB");
		//		System.out.println("Espacio Total en Disco en GigaBytes: "+((f.getTotalSpace()/1024)/1024)+" GB");
		//		System.out.println("Espacio Total en Disco en TeraBytes: "+(((f.getTotalSpace()/1024)/1024)/1024)+" TB");
		//		System.out.println("Espacio Usable en KiloBytes: "+(f.getUsableSpace()/1024) + " KB");
		//		System.out.println("Espacio Usable en KiloBytes: "+(f.getFreeSpace()/1024) + " KB");
		System.out.println("Nombre del Archivo: "+f.toString());
		System.out.println("---------------------------------------------------------\n");
		
		// Ahora veremos BufferedInputStream
		// Básicamente el uso del BufferedInputStream es muy similar al tema
		// FileInputStream cuando haciamos las lecturas en un arreglo de bytes[]
		// con la diferiencia de que JAVA para hacer este tipo de procesamiento ahora
		// nos proporciona está Clase.
		
		App app = new App();
		
		// Del tema anterior tomamos el método para medir el rendimiento
		app.leerPorFileInputStreamTryWithResourcesRendimiento();
		System.out.println("\n---------- Mediendo el tiempo por BufferedInputStream ----------------");
		// Al correr la aplicación podemos ver la secuencia de bytes de los codigos ACII 
		// que representa el contenido del archivo que estamos leyendo.
		app.leerPorBufferedInputStream();
		
		// El rendimiendo del InputStream en arreglo de bytes bytes[] y el BufferedInputStream
		// Son superiores a que leer con el InputStread byte a byte.
		
		// Cabe mencionar que al BufferedInputStream le puede ir mejor si lo hacemos con
		// archivos muy pesados frente a InputStream en arreglos de bytes bytes[].
		
	}

}
