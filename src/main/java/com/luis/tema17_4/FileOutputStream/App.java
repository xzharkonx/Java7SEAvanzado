package com.luis.tema17_4.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class App {
	
	public void escribirPorOutputStream() {
		// Medición de tiempo byte a byte
		long ini = System.currentTimeMillis();
		String texto = "Aprende JAVA con Luis E. Garcia Mercado";
		
		// Entonces lo que vamos a hacer es hacer referecia a este archivo
		// que tenemos en la ruta de nuestra 
		try(OutputStream destino = new FileOutputStream("luisFile.txt")) {
			// ¿Como registramos este contenido de la varible texto?
			// utilizamos write() y nos pide diferentes atributos pero el básico
			// es pasarle la cadena de texto con el método del arreglo de bytes getBytes()
			// para poder escribir en nuestro archivo.
			// destino.write(texto.getBytes());
			
			// Si queremos manipular un poco este método write() con el arreglo de bytes que
			// le estamos pasando podemos indicar que byte podemos escribir, por ejemplo,
			// agregandole la posición como si fuera un arreglo (porque estamos hablando de 
			// arreglos de bytes.
			destino.write(texto.getBytes()[0]);
			// Veremos como ahora solo coloco la primera letra de lo que hemos colocado en la variable texto.
			
			// Ahora, podemos leer un archivo plano y copiarlo en otro archivo.
			// lo hacemos en el método copiarEscribirPorOutputStream() de abajo.
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo OutputStream " + (fin - ini));
	}
	
	public void copiarEscribirPorOutputStream() throws IOException {
		// Medición de tiempo byte a byte
		long ini = System.currentTimeMillis();
		// String texto = "Aprende JAVA con Luis E. Garcia Mercado";
		
		// Variable para abrir el archivo que vamos a copiar.
		InputStream fuente = null;
		
		// Entonces lo que vamos a hacer es hacer referecia a este archivo
		// que tenemos en la ruta de nuestra 
		// Este será el archivo en el que será guardado lo que copiemos del archivo luisTexto.txt
		try(OutputStream destino = new FileOutputStream("luisFile.txt")) {
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
			// Este será el archivo del que copiaremos para llevarlo al archivo luisFile.txt
			fuente = new FileInputStream("luisTexto.txt");

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
				// destino.write(buffer, 0, byteRead);
				
				// Pero que pasa si colocamos un offset de 1
				destino.write(buffer, 1, byteRead);
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
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo OutputStream " + (fin - ini));
	}
	
	public void copiarEscribirGifPorOutputStream() throws IOException {
		// Medición de tiempo byte a byte
		long ini = System.currentTimeMillis();
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
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo OutputStream " + (fin - ini));
	}
	
	public static void main(String[] args) throws IOException {
		// Vamos a ver el uso de OutputStream, esto es para poder escribir un
		// archivo en JAVA.
		
		
		App app = new App();
		
		// Con este método al invorcarlo escribira nuestro texto y nos mostrará el tiempo
		// en que lo realizó.
		// app.escribirPorOutputStream();
		
		// Copiamos del archivo luisTexto.txt al archivo luisFile.txt
		// Reguerda agregar la clasusula throws IOException  a este método main por el trycatch
		//app.copiarEscribirPorOutputStream();
		// Ahora vemos como efectivamente se a copiado el contenido de nuestro archivo 
		// luisText.txt al archivo luisFile.txt
		
		// Ahora lo que haremos será copiar un archivo .gif
		app.copiarEscribirGifPorOutputStream();
		// Vemos que lo habrá generado automáticamente sin necesidad de crear nada
	}

}
