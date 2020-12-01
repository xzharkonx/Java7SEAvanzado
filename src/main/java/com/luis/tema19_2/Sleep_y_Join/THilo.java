package com.luis.tema19_2.Sleep_y_Join;

public class THilo  extends Thread{
	
	private int id;
	public THilo(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println("[T] Ejecutándose hilo THREAD de id -->" + id);
		}
	}
	
}
