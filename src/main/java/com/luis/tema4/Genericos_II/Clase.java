package com.luis.tema4.Genericos_II;

// Tenemos los siguientes genericos:

// E - Element (used extensively by the Java Collections Framework).
// K - Key.
// N - Number.
// T - Type.
// V - Value.
// S,U,V etc. - 2nd, 3rd, 4th types 

// Sin embargo nosotros podemos definir de la siguiente manera, es 
// recomendable utilizar una letra mayúscula. Podemos tener n Estereotipos
// entre el operador diamante.

//Mira que hemos creado nuestros propios estereotipos: USER y PASS
public class Clase<K,T,V,E,USER,PASS> {
	
	// Nosotros podemos optar entre los estereotipos.
	private K objetoK;
	private T objetoT;
	private V objetoV;
	private E objetoE;

	private USER objetoUSER;
	private PASS objetoPASS;
	
	// Mira que aquí hemos creado nuestros propios genericos por lo tanto
	// los parametros que le pasemos serán genericos (no necesariamente, podemos pasarle otros)
	// pero esto le servira para saber a que objeto asignarle el tipo que
	// hemos declarado en el Diamante <> al momento de hacer la instancia
	// de está clase.
	public Clase(K objetoK, T objetoT, V objetoV, E objetoE,
			USER objetoUSER, PASS objetoPASS) {
		super();
		this.objetoK = objetoK;
		this.objetoT = objetoT;
		this.objetoV = objetoV;
		this.objetoE = objetoE;
		
		this.objetoUSER = objetoUSER;
		this.objetoPASS = objetoPASS;
	}
	
	public void mostrarTipo() {
		System.out.println("------------------------------------------------------");
		System.out.println("K es un: " + objetoK.getClass().getSimpleName());
		System.out.println("T es un: " + objetoT.getClass().getSimpleName());
		System.out.println("V es un: " + objetoV.getClass().getSimpleName());
		System.out.println("E es un: " + objetoE.getClass().getSimpleName());
		
		System.out.println("USER es un: " + objetoUSER.getClass().getSimpleName());
		System.out.println("PASS es un: " + objetoPASS.getClass().getSimpleName());
	}
}
