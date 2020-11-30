package com.luis.tema17_6.Readers_y_Writers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class App {
	
	// En este metodo simplemente estoy leyendo, necesito
	// de la Clase Reader y está es una Clase abstracta y por
	// ende las Clases abstractas no pueden instanciarse.
	public void leer() throws IOException{
		// Entonces hacemos un subtipo con FileReader, el cuál
		// nos va a permitir leer un archivo
		try(Reader r = new FileReader("luisWriter.txt")){
			// Y estamos leyendo la data de manera muy similar a los 
			// anteriores temas de InputStream, con la diferiencia de que
			// aquí ya se están leyendo los caracteres.
			int data = r.read();
			System.out.print((char) data);
			while (data != -1) {
				data = r.read();
				System.out.print((char) data);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// En este método escribir utilizamos la clase FileWriter de 
	// la Clase Abstracta Writer.
	public void escribir() throws IOException{
		// Simplemente hacemos la referencia al objeto que vamos a leer.
		// en el otro parametro vamos a indicar si lo vamos a sobreescribir 
		// o no con false o true, cuando lo tenemos en falso indicamos que
		// queremos que se sobreescriba el archivo (borrará el contenido) 
		// y cuando lo tenemos en true simplemente va a concatenar al 
		// archivo (no borrará el contenido).
		
		// Pero que pasaría si no le colocamos el true o el false,
		// por defecto vendría a tomar false (borraría y sobreescribira
		// el archivo por lo que le hayamos colocado).
		try(Writer w = new FileWriter("luisWriter.txt", true)){
			// Y escribiremos en el archivo lo siguiente
			w.write("A codear en Java!");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Ahora lo envolveremos con un Buffer.
	// Le agregamos un tamaño al Buffer por defecto de 8 Kbs.
	private int BUFFER_SIZE = 8 * 1024;
	
	public void leerBufferedReader() throws IOException{
		// Entonces hacemos un subtipo con FileReader, el cuál
		// nos va a permitir leer un archivo
		try(Reader r = new BufferedReader(new FileReader("luisWriter.txt"),BUFFER_SIZE)){
			// Y estamos leyendo la data de manera muy similar a los 
			// anteriores temas de InputStream, con la diferiencia de que
			// aquí ya se están leyendo los caracteres.
			int data = r.read();
			System.out.print((char) data);
			while (data != -1) {
				data = r.read();
				System.out.print((char) data);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// La envolvermos con un Buffer
	public void escribirBufferedWriter() throws IOException{
		// Simplemente hacemos la referencia al objeto que vamos a leer.
		// en el otro parametro vamos a indicar si lo vamos a sobreescribir 
		// o no con false o true, cuando lo tenemos en falso indicamos que
		// queremos que se sobreescriba el archivo (borrará el contenido) 
		// y cuando lo tenemos en true simplemente va a concatenar al 
		// archivo (no borrará el contenido).
		
		// Pero que pasaría si no le colocamos el true o el false,
		// por defecto vendría a tomar false (borraría y sobreescribira
		// el archivo por lo que le hayamos colocado).
		try(Writer w =  new BufferedWriter(new FileWriter("luisWriter.txt", true), BUFFER_SIZE)){
			// Y escribiremos en el archivo lo siguiente
			w.write("A codear en Java!");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Debido a que ya conocemos el uso de los InputStream y los OutputStream
		
		// En esta ocación es el turno de los Readers y de los Writes.
		// Será muy sensillo y muy similar a los temas anteriores.
		
		App app = new App();
		//		app.escribir();
		//		app.leer();
		
		// Entonces así como veniamos trabajando en los tutoriales anteriores
		// lo que era el BufferInputStream y el BufferOutputStream para mejorar
		// el rendimiento en la lectura y en la escritura, también existe la 
		// contraparte para los Readers. 
		// Así que vamos a utilizar un Wraper, y vamos a envolver esto (en el try
		// de los métodos).
		
		// Así que con esto, prácticamente estamos mejorando el rendimiento de la
		// lectura y escritura cuando estamos trabajando en Readers y Writers.
		
		// Podemos comprobarlos al momento que nosotros leamos excesiva Data y el 
		// rendimiento va a mejorarse al momento de apoyarse en estos Buffered.
		
		app.leerBufferedReader();
		app.escribirBufferedWriter();
	}

}
