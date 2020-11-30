package com.luis.tema18_3.NIO2_WatchService;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;

// import java.nio.file.StandardWatchEventKinds;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class App {

	// En este tema veremos una de las clases más importantes también en el Java NIO2
	// que viene siendo una interfaz conocida como WatchService, está interfaz me va 
	// a permitir monitorear un directorio en particular los eventos como creación
	// modificación y eliminación.
	
	public void observar() throws Exception{
		// Lo que estamos haciendo aquí es prácticamente crear la instancia para
		// tener nuestro objeto que va a monitorear un directorio en particular
		WatchService watcher = FileSystems.getDefault().newWatchService();
		
		// Para hacer referencia a un directorio en Java NIO2 nos apoyamos en la
		// Clase Path. Y le pasamos la ruta de la carpeta donde tendremos los archivos
		// Esa carpeta está en la raíz de nuestro proyecto.
		Path dir = Paths.get("luisFolder");
		
		// Ahora, tenemos el observador y tenemos la dirección pero no lo hemos asociado,
		// para ello hacemos lo siguiene:
		// utilizamos el metodo register y vamos a pasarle el watcher (el servicio que va a 
		// monitorear) y una serie de eventos, estos eventos dependen de la Clase StandardWatchEventKinds
		// y tenemos ENTRY_CREATE, ENTRY_MODIFY y ENTRY_DELETE.
		//		dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
		//				StandardWatchEventKinds.ENTRY_DELETE);
		
		// Pero tipear como tipear todo esto es muy tedioso varias veces, podemos hacer una importación
		// estática, pero ¿Que significa esto? en la importación arriba del todo tenemos que cambiar de 
		// import java.nio.file.StandardWatchEventKinds; a import static java.nio.file.StandardWatchEventKinds.*;
		// así le diremos que importe todo lo que contiene la clase de StandardWatchEventKinds, por lo que ahora
		// en el método register podemos obviarla colocación del nombre de la Clase StandardWatchEventKinds para
		// acceder a los atributos directamente sin el prefijo de la Clase, entonces nos quedaría así:
		dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
		
		// Luego crearemos este mensaje en pantalla para mostrar nuestro directorio.
		System.out.println("Iniciando observación para " + dir.getFileName());
		
		// Hasta aquí lo que estamos haciendo es crear el servicio, relacionandolo con un path y simplemente registrando
		// los eventos que va a monitorear.
		
		// Ahora, esto es un demonio así que practicamente tiene que estar activo todas las veces, para ello
		// nos vamos a apoyar en un bucle infinito.
		
		// Podemos hacer un for infinito de está manera:
		// for (;;) {}
		
		// O podemos hacer el tradicional While
		while(true) {
			// Ya que tenemos este bucle infinito, es necesario accionar un activador para empezar a moniorear y luego
			// poder ver que eventos se han disparado y en base a esos eventos que se  han disparadohay que ejecutar
			// alguna lógica.
			// Para ello nos vamos a apoyar en una clase WatchKey, ¿Y que es lo que a a hacer este Watchkey?, va a
			// ser el accionador cuando un evento se dispare.
			WatchKey key;
			
			// Para ello vamos a hacer lo siguiente:
			key = watcher.take(); 
			// Notamos que tiene que estar en un bloque trycatch por si sucede alguna excepción, pero como estamos 
			// colocando el throws Exception practicamente va a salir a la consola, y necesitamos capturar los 
			// eventos que se han realizado en esté directorio. Para ello tenemos una lista de eventos que hay que
			// capturar, para esto nos apoyamos en el key y utilizamos el método pullEvents() y como podemor ver
			// este evento devuelve una lista de objetos WatchEvent con el operador unkown, po lo que hay que 
			// capturarlos en una lista de ese tipo.
			List<WatchEvent<?>> listaEventos = key.pollEvents();
			
			// Entones esta listaEventos ya la tenemos capturada y necesitamos recorrerla para evaluar los tipos
			// que hay en ella, para ello nos apoyaremos en un for
			for (WatchEvent<?> evento : listaEventos) {
				// Ahora necesitamos obtener que evento se ha ejecutado, para ello vamos a apoyarnos en la Clase
				// Kind<?>, esta Clase lo que va a hacer es al evento kind(), con esto capturamos el tipo de evento.
				// Y la importamos.
				// Obteniendo tipo evento.
				Kind<?> tipoEvento = evento.kind();
				
				// Como ya tenemos el evento capturado nosotros podemos asociar una lógica más adelante.
				
				// Así que ahora obtenemos el nombre del archivo para saber que archivo ha sido afectado.
				// Con esto nos devolverá el objeto y como es de tipo Object lo casteamos a tipo Path
				Path fileName = (Path) evento.context();
				
				// Y ahora haremos una impresión en pantalla para ver el tipo de evento que se ha disparado.
				// Entonces llamamos el tipo de evento que se a disparado y a que archivo.
				System.out.println(tipoEvento.name() + ":" + fileName);
				
				// Hasta aquí lo que hemos hecho es asociar el servicio de observador, registrarlo (los eventos
				// también), crear un bucle infinito para que esto este constantemente en observación, accionar
				// el observador, recuperar la lista de eventos si es que sucede alguna acción, recorrer la lista
				// de eventos, capturar el tipo de evento, capturar algún archivo que puede entrar, salir o 
				// eliminar en este directorio e imprimir en consola el tipo del evento con el archivo asociado.
				
				// Pero hay algo muy importante que hay que adicionar aquí, hay que evaluar si el evento (tipo de
				// evento) es igual a un Overflow. Este Overflow no nostará errores por la importación estática
				// que hicimos arriba con StandardWatchEventKinds
				
				if (tipoEvento == OVERFLOW) {
					// Que es lo que vamos a hacer cuando tengamos este tipo de OVERFLOW, le asignaremos un
					// continue, pero que significa esto, si sucede algún evento que no ha sido capturado
					// entonces nuestra aplicación no sabría que hacer, si esto sucede por alguna que otra
					// razón vamos a indicarle que continue, es decir, que siga iterando el ciclo hasta buscar
					// otro evento y pueda ser procesado.
					continue;
					
					// Entonces si sucede algún otro tipo de evento, ¿pero como que tipo?
					// por ejemplo: ENTRY_DELETE, ENTRY_CREATE o ENTRY_MODIFY.
					// Si sucede alguno de estos eventos nosotros podríamos indicar alguna lógica especial
					// para tomar acciones como si un archivo a sido eliminado, que lo mencione.
					
					// Así que por ahora los dejaremos en blanco.
					
				}else if(tipoEvento == ENTRY_DELETE) {

					// Por ejemplo si el archivo que hemos eliminado es igual a este nombre
					if(fileName.toString().equals("luis.txt")) {
						// Enviaremos el siguiente mensaje.
						System.out.println("[IMPORTANTE] El archivo " + fileName.toString() + " ha sido eliminado");
					}
					
				}else if(tipoEvento == ENTRY_CREATE) {
					
				}else if(tipoEvento == ENTRY_MODIFY) {
					
				}				
			
			}
			
			// Luego de que hayamos terminado de recorrer con el for la lista de los eventos tenemos que
			// hacer algo muy importante, debemos resetear la llave, es decir, la variable key hay que resetearla,
			// porque cuando ya se ejecuto o se disparo un evento necesitamos colocarle su estado en
			// default para que pueda seguir monitoreando nuestros eventos, para ello crearemos un booleano
			boolean valid = key.reset();
			// Si la llave no ha sido reseteada correctamente, quizas se elimino el directorio justo en el momento
			// en que la llave iva a ser reseteada para evaluar otro evento, podría ocurrir un error, para ello
			// nosotros vamos a validar que la llave efectivamente ha sido incorrectamente reseteada, es decir,
			// no se pudo realizar.
			if(!valid) {
				// y vamos a salir del bucle para evitar que esto sea un bucle infinito.
				break;
			}
			
			// Esto de arriba es un PASO MUY IMPORTANTE que no debe de obviarse.
			// Ya con esto tenemos el código para poder observar lo que pasa en un directorio.
		}
		// Si la validación fue incorrecta debemos de matar el proceso por obvias razones al momento debemos
		// cerrar el watcher.
		watcher.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		// Ahora creamos una instancia para ejecutar el método para observar lo que pasa en un directorio
		App app = new App();
		// Lo ejecutamos y vemos que sale la observación para ese folder, copiamos un archivo a ese 
		// directorio, y al pegar se han disparado los eventos de ENTRY_CREATE y ENTRY_MODIFY, 
		// espicifícamente la creación y modificación aunque puede darse un coportamiento muy común de
		// que se pueda repetir el evento porque la iteración es tan rápida que puede interpretarse como
		// varios eventos. 
		// Aunque podemos colocar un hilo que duerma unos segundos para evitar que esto suceda constantemente.
		app.observar();
		
		// Pero si quisieramos utilizar está aplicación para algún fin en particular, es decir, para que se
		// detecte cuando algo se ha eliminado por ejemplo, podemos editar justamente los bloques del método
		// donde se verifica el tipo de evento lanzado y hacer el comportamiento de las acciones que 
		// querramos tomar.
		// Por ejemplo en el caso de que querramos eliminar un archivo como lo hemos colocado en el bloque de
		// ENTRY_DELETE, nos avizara que ese archivo a sido eliminado.
		
		// RESUMEN: Tenemos la interfaz WatchService watcher y un Path dir donde los estamos relacionando con
		// el método register y le indicamos los eventos que vamos a monitorear (recuerda que se hizo una 
		// importanción estatica para que se puedan llamar sin estar utilizando el prefijo de la Clase 
		// StandardWatchEventKinds), luego hacemos el bucle infinito para que el demonio se mantenga en
		// memoria ( podríamos usar un while(true){} o un for(;;){} ), creamos el objeto WatchKey, es decir,
		// el accionador que va a estar viendo que evento sucede, lo iniciamos, vamos a obtener la lista de
		// eventos que se han desencadenado, recorremos esa lisa de eventos, capturamos el tipo de evento,
		// capturamos el nombre asociado al tipo de evento, es decir, el archivo asociado a un evento en 
		// particular y valuamos cada evento, recuerda lo del OVERFLOW por que si el evento no fue capturado
		// va a continuar con el bucle, también podremos evaluar los otros caso de ENTRY_CREATE y ENTRY_MODIFY
		// o ENTRY_DELETE y dentro de ellos podemos adicionar alguna lógica y para finalizar luego del bucle
		// for es importante que reseteemos la llave luego de procesamiento superior para que podamos seguir
		// monitoreando futuros eventos, si la validación fue incorrecta debemos matar el proceso, por obvias
		// razones debemos de cerrar el watcher al momento.
		
		// Hasta aqui hemos visto la tanto en el paquete JavaIO como en el paquete Java NIO2 toda la 
		// manipulación de un sistema de ficheros para lo que es lectura y escritura y como adicional 
		// está clase Watcher que nos va a permitir monitorear archivos en un directorio en particular.
	}

}
