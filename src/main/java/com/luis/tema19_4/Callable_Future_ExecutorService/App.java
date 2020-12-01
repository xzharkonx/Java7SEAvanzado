package com.luis.tema19_4.Callable_Future_ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// En este tema veremos como parte para aprender el procesamiento asincrono
// en Java vamos a ver lo que son los Future, los Callable y el pull conocido
// como los Excecutors.

// Vemos que dentro del paquete tenemos una Clase llamada RHilo que implementa
// la interfaz Runnable e implemenamos su método.
// En contraparte tenemos también otra Clase llamada CHilo que implementa la
// interfaz Callable, no se debe confundir con el CallableStatement que es otra cosa.

// Está interfaz Callable, básicamente tenemos que sobreescribir su método call()
// que necesita devolver el tipo de dato que tenemos en el operador diamanante ocea
// un String.

// La principal diferiencia entre la interfaz Runnable y la interfaz Callable es que
// Callable retorna valor  y la de Runnable no retorna valor.

// ¿Para que hacemos esto?, imaginen un procesamiento asincrono donde quizas es un 
// procesamiento pesado y necesitamos de esa respuesta en un periodo de tiempo
// pero no vamos a esperar que todo esto termine para recién seguir ejecutando
// otros procesos, podríamos hacer un hilo aparte que vaya procesando todo eso y
// continuar con un externo (otro proceso independiente) y cuando ya el proceso A
// termine recién evaluar esa respuesta y poder hacer con ella lo que gustemos.

// Entonces para ello nos tenemos que apoyar en los Executors.
// Básicamente esos son los pools que nos provee la api de Java.

public class App {

	public static void main(String[] args) throws Exception {
		
		// La Clase ExecutorService la estamos creando de está manera
		// Executors.newFixedThreadPool(2); donde le estamos indicando cuantos
		// hilos va a tener mi pool en este caso 2, nosotros podemos tener los
		// que querramos de acuerdo a como evaluemos cuantos procesos concurrentes
		// podemos hacer a la vez.
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// Luego aquí esta clase muy importante conocida como Future, esta Clase
		// es practicamente como una promesa, es decir, va a almacenar el dato
		// que va a tener el procesamiento que realizamos con el Runnable o con
		// el Callable, por eso nos apoyamos del executor en el pool y practicamente
		// hacemos un submit, es decir, ejecutamos el Hilo (CHilo) por eso le pasamos
		// la instancia de CHilo del Callable.
		// Y al hacer está línea de código nos va a devolver un Objeto de tipo Future
		// y lo llamamos tarea 1 (task1) es porque nos retorna un parametro <String>
		Future<String> task1 = executor.submit(new CHilo());
		// Sin hembargo el submit del RHilo  que implementa la interfaz Runnable no 
		// retorna un parametro, por lo tanto también devolvería un Future cuando hacemos
		// un submit desde un executor, sin embargo el parametro a devolver sería nulo.
		Future<?> task2 = executor.submit(new RHilo());
		
		// En este while lo que estamos haciendo es un tiempo muerto esperando a que
		// la tarea 1 y la tarea 2 estén completas para que recien continue con la
		// ejecución del hilo principal.
		while (!task1.isDone() && !task2.isDone()) {}
		
		// Solo falta exceutor.shutdown(); al final para que corte el programa al final.
		// Inicia un cierre ordenado en el que se ejecutan las tareas enviadas anteriormente,
		// pero no se aceptarán nuevas tareas. La invocación no tiene ningún efecto adicional 
		// si ya se ha cerrado.
		// Este método no espera a que se completen las tareas enviadas anteriormente. 
		// Utilice awaitTermination para hacer eso.
		executor.shutdown();
		// Y corremos la aplicación.
		System.out.println(task1.get());
		System.out.println(task2.get());
		
		// Podemos ver que nos salen 3 mensajes:
		// Hilo Runnable.
		// Hilo Callable.
		// null
		
		// El mensaje de Runnable es simplemente su invocación. Y como no retorna valor
		// nos arroja un nulo.
		// Y el otro el del mensaje Callable es un Callable que nos retorna valor.

	}

}
