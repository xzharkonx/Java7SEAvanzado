package com.luis.tema18_2.NIO2_Channel_y_Buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// En el paquete Java NIO2 existen 2 Clases que no hay que dejar pasar.
// Una de ellas es el Channel y la otra es el Buffer.
// Estás 2 Clases trabajan conjuntamente para poder leer y escribir la 
// data en Java, y si nosotros recordamos los temas anteriores cuando
// vimos JavaIO teniamos un único sentido para lo que es la lectura o 
// escritura de datos, teniamos el InputStream o el OutputStream.

// En está ocación Java NIO2 apoyandonos en Channel y Buffer vamos a tener
// estás 2 Clases a nuestra disposición para poder hacer la lectura y
// escritura de manera bidireccional, es decir, apoyandonos solamente en
// estás 2 Clases.

public class App {

	// En este paquete Java NIO2 tenemos Channel y Buffer donde simplemente
	// interaccionan entre sí para poder tener la escritura y la lectura
	// de los datos.
	
	public void leerPorChannel() throws IOException {
		
		// En primer lugar tenemos un RandomAccessFile, que lo que estamos haciendo aquí
		// es tener la insancia, es decir, la referencia al archivo que vamos a leer.
		// Y como segundo parametro estoy indicando los permisos que puede ser:
		// readOnly, writeOnly o read and write. En este caso estamos indicando como 
		// leer y escribir (rw).
		RandomAccessFile file = new RandomAccessFile("luisCopy.txt", "rw");
		// Posteriormente nos apoyamos en este Channel ya mencionado.
		FileChannel channel = file.getChannel();
		
		// Y luego estamos creando un tipo de dato Long para obtener el tamaño de este canal,
		// es decir, ¿Cuantos bytes tendrá la lectura de este archivo?...
		long size = channel.size();
		// Luego estamos creando el Buffer que es practicamene un primo hermano de FileChannel
		// que trabajan conjuntamente en Java NIO2. Y nos apoyamos en el método allocate(),
		// este método recibe un entero en el cuál estoy indicando el límite o esté tamaño del 
		// buffer que por obvias razones estamos colocando practicamente el mismo tamaño que la 
		// secuencia de bytes que vamos a leer (podemos ampliarlo y reducirlo de acuerdo a nuestra
		// conveniencia).
		ByteBuffer buf = ByteBuffer.allocate((int) size);
		
		// Aquí ahora podemos ver que el channel.read pasandole el buffer nos va a devolver un 
		// entero que vendría a ser el byte y si recordamos los temas anteriores en JavaIO cuando
		// leíamos hasta direfente de -1 significaba hasa que ya no existan más datos.
		int bytesRead = channel.read(buf);
		while (bytesRead != -1) {
			
			// Estamos indicando cuandos bytes estamos leyendo.
			System.out.println("Leídos " + bytesRead);
			
			// Y el método flip() que es practicamente asociado al buffer, al byte buffer, lo que
			// está haciendo es preparando el buffer para leer.
			// ¿Qué significa esto?, ya tenemos toda la información contenida en nuestro buffer
			// (en ese espacio de memoria) pero necesitamos tener como un apuntador para decir
			// Ok! ya empieza a leerlo, es por eso que abajo nos apoyamos de un while y en el
			// método hasRemaining().
			buf.flip(); // Preparando el buffer para leer
			
			// Esté método hasRemaining, lo único que va a hacer es preguntar si todavía queda 
			// dato en esté buffer. El buffer está en memoria y vamos a leer uno a uno hasta que
			// no obtenga más datos.
			while(buf.hasRemaining()) {
				// Es por eso que nos apoyamos en el método get() para obtener el byte leído
				// casteandolo a un char que sea legible para el momento de imprimirlo en la consola.
				System.out.print((char) buf.get());
			}
			
			// Por último, cuando ya no exista ningún dato, cuando haya terminado el bucle de hasRemaining()
			// estoy cambiando el sentido a lo que es "modo escritura".
			// ¿Que significa esto?, que si seguimos leyendo, es decir, en la primera corrida vamos a seguir
			// leyendo quizas para seguir trayendo más data del archivo y lo tengo que cambiar a modo escritura,
			// dicho de otra manera:
			// Primero con buf.flip() tengo que indicarle que quiero leer en el buffer, luego que termine de leer
			// tengo que cambiar el sentido para escribir y luego vuelvo a seguir obteniendo la data.
			// -> Tenemos que preparar la lectura.
			// -> Termino la lectura.
			// -> Escribir. Cambiar el sentido a escribir.
			// -> Y luego a volver a volcar más información  en el buffer.
			buf.clear(); // Cambio a modo escriura
			bytesRead = channel.read(buf);
			
			// Repetimos el proceso hasta que no exista más información almacenada en este buffer.
		}
		
		// Finalmente cerramos el archivo.
		file.close();		
		
	}
	

	// Por otra parte tenemos a Escribir por Channel.
	// También se apoya en FileChannel y en el Buffer.
	public void escribirPorChannel() throws IOException{
		
		RandomAccessFile file = new RandomAccessFile("luisCopy.txt", "rw");
		FileChannel channel = file.getChannel();
		
		String texto = "Escribiendo y leyendo usando Channel y Buffer con Java NIO2";
		
		// Aquí en el método allocate estamos indicando 128
		ByteBuffer buf = ByteBuffer.allocate(128);
		
		buf.clear(); // Cambiar a modo escritura
		// Aquí lo que estamos haciendo es colocar en el buffer el contenido
		// de la cadena de texto, todos los bytes están asociados ahí.
		buf.put(texto.getBytes());
		
	
		buf.flip(); // Cambiamos a modo de lectura.
		// Para que podamos apoyarnos con el hasRemaining()
		// es decir, que descargue todo lo que está en el buffer y lo
		// plasme ahora en el archivo txt que hemos mencionado en la parte superior.
		// Podemos ver que es muy similar a la lectura.
		while (buf.hasRemaining()) {
			
			channel.write(buf);
		}
		
		// Finalmente cuando ya se obtuvo todo el volcado del buffer cerramos el file
		// y la aplicación deberia culminar.
		file.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		App app = new App();
		
		
		// Leemos el arhivo
		// Mira que prepara la informacion en el primer while,
		// luego ya que sabe lo que va a leer, se pone a leer con el método buf.flip()
		// como si dijera voy a leer y entonces lee lo que esta en el archivo en el segundo while 
		// que esta en memoria porque ya lo paso anteriormente.
		// una vez que ya haya leido todo y no quede nada, ahora si se pone a
		// escribir para eso el método buf.clear() como si dijera ahora voy a escribir y escribe
		// lo que tiene que escribir conforme a los bytes que leyó.
		// app.leerPorChannel();

		// Escribimos en el archivo
		app.escribirPorChannel();
		
		// Hay que tener cuidado por que si colocamos una cadena mejor como Hola, vamos a ver
		// que se sobreescribe el buffer la cadena que colocamos sobreescribiendo los primeros bytes
		// pero si la cadena es mayor, eso que que resta se mantiene de lo que había en el texto anterior.
		// Así que ignora lo demas.
		
		// Esto es porque solo estamos escribiendo de acuerdo a los bytes de la cadena de texto.
		// Lo que se recomendaría sería eliminar todo y luego volver a escribir.
		
		// RESUMEN: Vease de esta manera.
		// El buffer es un espacio en memoria que necesita llenarse y volarse varias veces hacia un channel
		// para poder leer o escribir.
	}

}
