package com.luis.tema19_5.CompletionService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// Ahora veremos el tema de CompletionService

// Básicamente para tener un mejor rendimiento frente a lo que es el executor service.

// Nos basaremos en la Clase CHilo del tema anterior pero le agregamos unas cosas (revisarla).
public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Aquí prácticamente agregamos lo mismo del metodo main del tema anterior
		// Pero en la tarea 2 lo hemos cambiado a un Callable, es por eso que nos
		// regresa un <String> en el segundo Future.
		// También le pasamos como argumentos los segundos a los parametros del
		// constructor, a uno 3 segundos y a otro 2 segundos. Y nos quedamos
		// con 2 hilos en el executor como en el tema anterior.
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// En este ExecutorCompletionService, lo que hace es que este es un pool que se
		// apoya en el executor principal, podemos ver que tenemos una instancia de
		// new ExecutorCompletionService<>(executor); y como parámetro en el constructor
		// se apoya en el executor
		ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);
		// Para ello ya no haremos el submit con el executor si no con el "completionService".
		//		Future<String> task1 = executor.submit(new CHilo(3000));
		//		Future<String> task2 = executor.submit(new CHilo(2000));
		
		// Este submit nos devuelve un future, sin embargo,  ya depende de mi que quiero hacer con las
		// tareas 1 y 2 independientemente, así que podríamos obviarlo para este tema.
		// Future<String> task1 = completionService.submit(new CHilo(3000));
		// Future<String> task2 = completionService.submit(new CHilo(2000));
		completionService.submit(new CHilo(3000));
		completionService.submit(new CHilo(2000));
		
		// Hasta que la tarea 1 y 2 esten completas,
		// pero esto ya lo podemos comentar
		// while (!task1.isDone() && !task2.isDone()) {}
		
		// Terminamos los executors pero los comentamos porque ya usamos el completionService
		// executor.shutdown();
		
		// E imprimimos los mensajes, pero lo quitamos por lo de abajo
		//		System.out.println(task1.get());
		//		System.out.println(task2.get());

		// Contamos los segunos 1,2,3 y luego estaremos viendo que el ExecutorService
		// toma en cuenta el hilo que más se demora, es decir, esta haciendo los procesamientos
		// de manera concurrente, pero muestra el mensaje luego de que el hilo de mayor duración
		// haya acabado, es por eso que acabo el Hilo de 3 segundos y muestra el mensaje de 
		// los 3 segundos y el de los 2 segundos, sin embargo, si nos apoyaramos en un
		// ExecutorCompletionservice esto se torna distinto.

		// Pero ahora hacemos lo siguiente:
		// Creamos un while(true) pero quizás podríamos tener en vez de este, agregando los 
		// futures a una lista y simplemente recorrela hasta que la lista termine
		while(true) {
			// Y aquí simplemente utilizamos un completionService con el método take() y
			// get(), ¿Que estamos haciendo aquí?, es obtener cualquier Hilo del 
			// completionService y simplemente el conenido de esté hilo.
			System.out.println(completionService.take().get());
		}
		
		// Entonces corremos la aplicación.
		// ¿Se pudo ver la diferiencia?
		// Exactamente la principal diferiencia entre CompletionService y el ExecutorService
		// es que el ExecutorService necesita que todos los hilos se hayan procesado 
		// para mostrar recien los resultados, esto no quiere decir que se haga de 
		// manera "CONCURRENTE", (ojo estamos viendo e procesamiento asincrono), sin embargo,
		// el CompletionService va a mostrar los resultados a medida que los Hilos van
		// terminando su ejecución, es por eso que nos apoyamos en completionService.take().get()
		// para tomar justamente lo que va terminando de está manera, nosotros podríamos quizas
		// tomar un poco más de ventaja en el procesamiento asincrono utilizando CompletionService.
		
		// Hasta aquí todos los temas =D
		
	}

}
