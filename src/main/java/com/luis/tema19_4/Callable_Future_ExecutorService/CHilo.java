package com.luis.tema19_4.Callable_Future_ExecutorService;

import java.util.concurrent.Callable;

public class CHilo implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Hilo Callable";
	}

}
