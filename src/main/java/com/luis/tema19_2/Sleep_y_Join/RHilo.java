package com.luis.tema19_2.Sleep_y_Join;

public class RHilo implements Runnable{
	
	private int id;
	public RHilo(int id) {
		this.id = id;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("[R] Ejecutándose hilo RUNNABLE de id -->" + id);
		}

	}
	
}
