package com.luis.tema18_1.NIO2_Path_y_Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// Básicamente lo que es el paquete NIO corresponde a Non-bloking I/O

// ¿Que significa esto?, usualmente se le conoce como "New I/O", es una API
// de JAVA en el cuál nos permite hacer operaciones intensivas de operaciones
// de entrada y salida, este paquete fue soltado en el JDK 1.4.
// En ese entonces por lo que es Sun Microsystems

// Luego salió una mejora en el paquee 1.7 del JDK 1.7 en el cuál ofrecia un nuevo
// sistema para la manipulación de archivos conocido como NIO2.

// Ahora veremos este paquete para poder hacer lo mismo que veniamos trabajando en 
// tutoriales anteriores para leer archivos, copiar archivos, eliminar, manipularlos
// y un adicional que venian a ser los Watches.


public class App {

	
	public void operacionesFile(String operacion) throws IOException {
		
		// Primero referenciamos a un archivo con Path
		Path path = Paths.get("luis.txt");
		// Al importar mira que lo hacemos de java.nio.file.Path y java.nio.file.Paths
		
		// Ahora vamos a crear las funcionalidades por medio de estas Clases que nos
		// proveen en Java NIO2
		switch(operacion) {
		case "existe":
			// Nos vamos a apoyar de la Clase Files y especificamente en el método exists
			// donde le vamos a pasar el path que hemos declarado en la parte superior
			// y una lista de opciones en la cual básicamente va a buscar si el archivo
			// se encuentra en el directorio en este caso del proyecto.
			// Le indicamos el path y las opciones vienen a ser las siguientes:
			// new LinkOption[] { LinkOption.NOFOLLOW_LINKS}
			// especificamente: NOFOLLOW_LINKS
			// ¿Que significa esto?, en alguna documentación lo que vamos a encontrar es que
			// básicamente no está buscando aquellos archivos que hagan refernecias a otros archivos.
			// ¿Como se puede entender esto?, un ejemplo de ello es en los accesos directos, pueden
			// tener nombres exactamente iguales al archivo que estamos buscando pero no representa
			// al archivo en sí, entonces al colocar esta acción: NOFOLLOW_LINKS lo que estamos haciendo
			// es escapar esos accesos directos para solamente concentrarnos en que solamente el programa 
			// busque el archivo que estamos requeriendo.
			// Este método retorna un booleano, por lo tanto hay que almacenar la respuesta en este booleano.
			boolean existe = Files.exists(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS});
			System.out.println(existe);
			
			// Para comprobar que la operación NOFOLLOW_LINKS está operando podemos crear un acceso directo en
			// el directorio para que se pueda ver que efectivamente no se va a encontrar.
			
			break;
		case "crear":
			
			// Para crear un archivo básicamente vamos a hacer lo siguiente.
			// Primero vamos a crear una carpeta/directorio.
			Path pathDirectorio = Paths.get("LuisFolder/");
			
			// Lo que vamos a hacer ahora es apoyarnos nuevamente en la clase Files.createDirectory
			// y le indicamos el path, solamente necesitamos un atributo, esto nos va a retornar
			// un path simplemente si quiseramos manipularlo, este metodo .createDirectory() por 
			// obbias razones puede presentar algunas excepciones así que simplemente colocamos la
			// clausúla throws
			Path nuevoPath = Files.createDirectory(pathDirectorio);
			
			break;
		case "copiar":
			
			// Aquí necesitamos 2 paths, uno que es el origen y otro que es el destino.
			Path pathOrigen = Paths.get("luis.txt");
			Path pathDestino = Paths.get("luisCopy.txt");
			
			// Lo que haremos será nuevamente apoyarnos en la Clase Files con el método copy()
			// Así de simple. Esto puede devoler una excepción si es que el archivo existe o no.
			// Deberiamos verificarlo con el método exists() que se vio anteriormente.
			Files.copy(pathOrigen, pathDestino);
			// Con la regla de que si existe ese archivo que lo reemplace.
			// Files.copy(pathOrigen, pathDestino, StandardCopyOption.REPLACE_EXISTING);
			
			break;
		case "mover":
			// Aquí necesitamos 2 paths, uno que es el origen y otro que es el destino.
			Path pathOrigen2 = Paths.get("luis.txt");
			Path pathDestino2 = Paths.get("luisFolder/luis.txt");
			
			// Ahora tenemos la opción de mover, así que utilizamos la Clase Files.move()
			// y le pasamos el origen del archivo, el destino a donde se enviará y también
			// podemos adicionar una lista de opciones que básicamente vendría a ser algunas
			// convenciones como por ejemmplo:
			// StandardCopyOption.REPLACE_EXISTING
			// Donde le estamos indicando que si el archivo se encuentra "reemplazalo".
			// Lo mismo podríamos indicar para la opción de arriba de copiar.
			Files.move(pathOrigen2, pathDestino2, StandardCopyOption.REPLACE_EXISTING);
			
			break;
		case "eliminar":
			// Ahora eliminaremos el archivo que esta dentro de la carpeta, para ello
			// lo  referenciamos
			Path pathOrigen3 = Paths.get("luisFolder/luis.txt");
			// Nos apoyaremos nuevamente en la Clase Files.delete()
			Files.delete(pathOrigen3);
			break;
		}
	}
	
	public void leer() throws IOException {
		// Hacemos referencia a un path
		Path pathOrigenLeer = Paths.get("luisCopy.txt");
		
		// A este path se lo pasamos el método readAllBytes
		// de esta manera nosotros vamos a tener un arreglo de Bytes con
		// el contenido de el archivo que estamos leyendo. 
		// Estos conceptos se han trabajado en temas anteriores de InputStream
		// y OutputStream cuando leiamos los arreglos de Bytes y los recorriamos para
		// obtener la data.
		byte[] bytes = Files.readAllBytes(pathOrigenLeer);
		
		for (byte b : bytes) {
			System.out.print((char) b);
		}
		
		
	}
	
	public void escribir() throws IOException {
		
		// Hacemos referencia a un path
		Path pathOrigenEscribir = Paths.get("luisCopy.txt");
		
		// En está ocación tenemos un texto en el cuál vamos a optener
		// el arreglo de Bytes para pasarselo al método write de la clase Files
		String texto = "Escribiendo con Java NIO2";
		Files.write(pathOrigenEscribir, texto.getBytes());
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// Tenemos aquí simplemente los métodos de operaciones, leer y escribir
		// y la instancia de esta Clase llamando uno a uno a los métodos que vamos a declarar
		// en la parte superior.
		
		App app = new App();
		// vemos que efectivamente se encuentra el archivo luis.txt. 
		// app.operacionesFile("existe");
		
		// Ahora para comprobar si se a creado el directorio/path, hacemos un refresh al proyecto
		// y buscamos el directorio.
		// app.operacionesFile("crear");
		// vemos que efectivamente se a creado.
		// Si colocamos de nuevo la creación, saldrá un error debido a que el folder ya existe y
		// deberiamos atraparlo en un exception, previamente sería recomentable hacer el
		// existe y si es verdadero no hacer la creación, en caso contrario usamos el createDirectory()

		// Hacemos la copia del archivo luis.txt en un nuevo archivo luisCopy.txt
		// app.operacionesFile("copiar");
		// Hacemos un refresh del proyecto y vemos que efectivamente a creado el archivo.
		// Si se vuelve a ejecutar el método, nos saldrá un error porque el archivo luisCopy.txt ya existe.
		
		// Ahora moveremos el archivo luis.txt con el siguiente método
		// app.operacionesFile("mover");
		// Ahora podemos ver que el archivo de luis.txt no se encuentra en la raíz donde estaba, si no 
		// que se ha hecho una copia del mismo y se a creado uno nuevo dentro de luisFolder llamado
		// luisCopy.txt, pero ahora lo renombramos a luis.txt, cambiamos el nombre del destino a luis.txt 
		// en vez de luisCopy que era el que tenía en un principio y también lo copiamos a la raíz donde
		// lo teniamos (si no dará error por que no lo encuentra), así podemos ver que se a cumplido la
		// lista de reglas que tenemos donde si existe el archivo lo reemplazará.
		
		// Finalmente eliminaremos el archivo
		// app.operacionesFile("eliminar");
		// Hacemos un refresh del proyecto y vemos que ya se ha eliminado el archivo luis.txt de la carpeta
		// luisFolder.
		
		// Leer y Escribir ---------------------------------------------------------------------------------
		
		// Nos volveremos a apoyar en la Clase Files del paquete Java NIO2
		// De manera muy fácil podemos ver en los métodos leer y escribir como hacerlo.
		app.escribir();
		app.leer();
		// Vemos que hemos escrito en el archivo luisCopy.txt y que la lectura ha mostrado lo que hemos
		// escrito en el.
		
		// Esto es muy sencillo de hacer con este paquete Java NIO2.
		
		// -------------------------------------------------------------------------------------------------
		
		// Pero también existe otro camino para la escritura y la lectura y es apoyandonos en los Channels y
		// en los Buffers que nos proporciona este paquete también de Java NIO2.
		// Está implementación es un poco más compleja así que se resevará para el siguiente tema.
	}
}
