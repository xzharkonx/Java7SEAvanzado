package com.luis.tema17_5.BufferedOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class App {
	
	public void copiarEscribirGifPorOutputStream() throws IOException {
		// Medición de tiempo byte a byte
		long ini = System.nanoTime();
		// String texto = "Aprende JAVA con Luis E. Garcia Mercado";
		
		// Variable para abrir el archivo que vamos a copiar.
		InputStream fuente = null;
		
		// Entonces lo que vamos a hacer es hacer referecia a este archivo
		// que tenemos en la ruta de nuestra 
		// Este será el archivo en el que será guardado lo que copiemos del archivo JavaApache.gif
		// Vemos que lo habrá generado automáticamente sin necesidad de crear nada
		try(OutputStream destino = new FileOutputStream("luisJavaApache.gif")) {
			// ¿Como registramos este contenido de la varible texto?
			// utilizamos write() y nos pide diferentes atributos pero el básico
			// es pasarle la cadena de texto con el método del arreglo de bytes getBytes()
			// para poder escribir en nuestro archivo.
			// destino.write(texto.getBytes());
			
			// Si queremos manipular un poco este método write() con el arreglo de bytes que
			// le estamos pasando podemos indicar que byte podemos escribir, por ejemplo,
			// agregandole la posición como si fuera un arreglo (porque estamos hablando de 
			// arreglos de bytes.
			// destino.write(texto.getBytes()[0]);
			// Veremos como ahora solo coloco la primera letra de lo que hemos colocado en la variable texto.
			
			// Ahora, podemos leer un archivo plano y copiarlo en otro archivo.
			
			// Nos apoyamos de in InputStream para poder hacer la lectura.
			// Este será el archivo del que copiaremos para llevarlo al archivo luisJavaApache.gif
			fuente = new FileInputStream("JavaApache.gif");

			// Vamos a crear el arreglo de bytes
			// Recuerda inicializarlo con múltiplos de 1024 1kb para mejor rendimiento.
			byte[] buffer = new byte[1024];
			
			
			// Ahora es necesario leer el contenido, para ello nos vamos a apoyar en un while
			// Declaramos un entero que es justamente el Byte leído.
			int byteRead;
			// Ahora lo que vamos a hacer es almacenar en ese byte leído lo que estamos leyendo
			// en fuente.read() y dentro del read() le vamos a pasar ese buffer. 
			// Y si es diferente de -1, es decir que se salga si no hay más lectura
			while ((byteRead = fuente.read(buffer)) != -1) {
				// Y luego este byteRead se lo voy a pasar al destino
				// ¿Que le voy a pasar? unos 3 parametros a este constructor.
				// Le vamos a pasar un buffer, luego un offset que viene a ser como un salto o
				// un desplazamiento desde que byte se va a leer y finalmente el byte que hemos leído.
				destino.write(buffer, 0, byteRead);
				
				// Si cambiamos el offset (todo lo que se explica abajo) no serviría y la imagen
				// nos daría error =c debido a que se pierde la integridad de la imagen y no se podría
				// mostar... Solo funciona con el texto.
				
				// Pero que pasa si colocamos un offset de 1
				// destino.write(buffer, 1, byteRead);
				// vemos como al volver a correr la aplicación el archivo a copiar toma el valor
				// no desde el inicio del texto, sino desde una posición más adelante del texto
				// como si se saltará la primera letra y desde ahí la copia al archivo.
				// Y así dependiendo de que valor le coloquemos, comenzará desde esa posición.
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Pero ahora si colocamos finally para liberar los recursos del archivo
			// luego de haberse leído.
			if(fuente != null) 
				fuente.close();
		}
		long fin = System.nanoTime();
		System.out.println("Tiempo OutputStream " + (fin - ini));
	}
	
	
	public void escribirPorBufferedOutputStream() throws IOException{
		long ini = System.nanoTime();
		
		// Tenemos aquí una constante que la hemos creado con tamaño de 8 Kb
		// La recomendación es que siempre se debe usar múltiplos de 1024.
		// E investigando en Internet un tamaño promedio adecuado es entre 4 y 8 Kbs.
		final int BUFFER_SIZE = 1024 * 8;
		// Luego se crea un buffer apoyandonos en la constante anterior definida.
		// Ese buffer es simplemente para la lectura, es decir, lo va a usar el 
		// InputStream (lo que se vio en el tema anterior).
		byte[] buffer = new byte[BUFFER_SIZE];

		// El InputStream es desde donde voy a leer el archivo.
		InputStream fuente = null;
		
		// Aquí en el trywithresources lo único que estamos haciendo es crear el destino (a donde irá
		// a parar la información), la única diferiencia del tema anterior es que en está ocación 
		// estamos creando una Clase llamada BufferedInputStream que envuelve este FileOutputStream 7
		// como segúndo parametro le podemos pasar un BUFFER_SIZE ¿Esto con que objetivo?, pues de poder
		// definir un Buffer interno en está Clase para mejorar el rendimiento de la escritura de archivos
		// en JAVA.
		try(OutputStream destino = new BufferedOutputStream(new FileOutputStream("luisBufferJavaApache.gif"), BUFFER_SIZE)) {
			
			// Definimos la fuente de donde se extraerá la información.
			fuente = new FileInputStream("JavaApache.gif");
			// Creamos un byteRead que almacenara los bytes a bytes
			int byteRead;
			// Con el while hacemos las veces que se está leyendo byte a byte.
			// Pero para que la lectura de está imágen sea de manera eficiente le pasamos
			// un buffer (el arreglo de bytes, esto ya se vio en los temas anteriores).
			while((byteRead = fuente.read(buffer)) != -1) {
				// Luego, lo que estamos haciendo es llamar al método write(),
				// en el tema anterior vimos que aquí en este método se utilizaba
				// el constructor de distinta manera con un offset, pues en esta 
				// ocación como ya estamos apoyandonos en un BufferOutputStream ya no tendría
				// mucho sentido guiarnos en otro buffer adicional aquí simplemente está Clase
				// ya lo tiene, es decir, que se lo estamos indicando en el trywithresources en
				// la variable que le pasamos de BUFFER_SIZE. Entonces simplemente vamos a 
				// escribir lo que viene siendo leído por el FileOutputStream.
				//destino.write(byteRead); // Pero esto esta mal, al hacer la prueba no construye el archivo .gif.
				destino.write(buffer,0,byteRead); // Por lo que lo usamos de esta manera.
			}
		} catch (Exception e) {
			// Si hay errores capturamos la excepción.
			System.out.println(e.getMessage());
		} finally {
			// Finalmente estamos cerrando los recursos del FileOuputStream
			// Recuerda que como es un trywithresources la gestión de recursos del
			// OutputStream es de manera autoática.
			if (fuente != null)
				fuente.close();
		}
		// Finalmente leemos los tiempos al culminar la lectura.
		long fin = System.nanoTime();
		System.out.println("Tiempo BufferedOutputStream: "+(fin - ini));
	}

	public static void main(String[] args) throws IOException {
		
		// Como bien sabemos el uso de BufferInputStream
		// En este tema veremos la contraparte a lo que es el BufferOutputStream
		// Más conocido como BufferedOuputStream.
		
		// Como lo hemos venido viendo en estos temas es para mejorar el rendimiento en 
		// este caso de la escritura en JAVA.
		// Esta escritura tiene que ser medida con mejor presición por eso se utiliza
		// System.nanoTime(); para mida mejor el tiempo y la diferiencia sea más significativa.
		
		//Agregamos el método anterior del OutputStream para probarlo frete al BufferOutputStream
		
		// Aquí crearemos 2 hilos (la veremos más a detalle en temas más adelante).
		// Se vera en la sección de hilos y concurrencia más adeante.
		
		final App app = new App();

		// Por lo que crearemos 2 Runnable que se los pasaemos a 2 hilos con el objetivo de tener
		// tareas al mismo tiempo.
		
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				try {
					app.copiarEscribirGifPorOutputStream();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		};
			
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				try {
					app.escribirPorBufferedOutputStream();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		};
		
		// OutputStream
		Thread hilo1 = new Thread(r1);
		hilo1.start();
		
		// BufferedOutputStream
		Thread hilo2 = new Thread(r2);
		hilo2.start();
		
		// Mira como BufferedOutputStream tiene un rendimiento un poco mejor que el OuputStream
		// por minima diferiencia.
		// Sin embargo en archivos más grandes podría ser más útil el BufferedOuputStream frente al 
		// OuputStream
		
		// Entonces se lee con un Buffer es decir el OuputStream apoyandonos en un Buffer para el rendimiento de la
		// lectura y para el rendimiento en la escritura nos apoyamos de BufferOuputStream
		// Podría mezclar ambos enfoques, un BufferOutputStream para escritura y un BufferInputStream para la lectura
		// y tendríamos el mismo comportamiento.
	}

}
