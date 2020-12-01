package com.luis.tema19_5.CompletionService;

import java.util.concurrent.Callable;

public class CHilo implements Callable<String>{

	// Agregamos está variable en segundos.
	private int segundos;
	
	// Agregamos este Constructor para pasarle los segundos.
	public CHilo(int segundos) {
		this.segundos = segundos;
	}
	
	@Override
	public String call() throws Exception {
		// Aquí nos apoyamos de un hilo ejecutnado el método sleep que le pasa la 
		// cantidad de seguntos que le hemos pasado en el Constructor
		Thread.sleep(segundos);
		return "Hilo Callable";
	}

}
