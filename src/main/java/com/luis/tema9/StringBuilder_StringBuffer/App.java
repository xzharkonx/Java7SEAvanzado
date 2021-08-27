 package com.luis.tema9.StringBuilder_StringBuffer;

public class App {

	public static void main(String[] args) {
		
		// No es recomendable hacer una contatenación con el simbolo +
		// en un String debido a que implicitamente creando un StringBuilder
		// creando un String y llamando al método toString().
		
		// Para este tipo de concatenación se deben usar 2 tipos de clase en particulares
		// una de ellas es el StringBuilder y la otra es el StringBuffer.
		
		// ¿Cuál es la principal diferiencia entre estás 2 Clases?
		// Es más rápido utilizar un StringBuilder que un StringBuffer
		// Y esto es debido a lo que es la sincronización cuando manejamos hilos.
		
		// StringBuilder por defecto no tienen métodos Sincronos, es decir, no hace
		// una seguridad cuando trabajamos con hilos, el método como se le conoce
		// no es tree-safe en cambio StringBuffer si es tree-safe...
		// ¿Como nos damos cuenta?, porque alguno de sus métodos en StringBuffer presenta
		// la palabra "synchronized" que básicamente lo que me permite es darme una seguridad
		// que solamente ese proceso va a ser ejecutado por un único hilo al mismo tiempo
		// por lo tanto estoy protegiendo los recursos que puedan compartirse en una aplicación.
		
		// Mientras que StringBuilder lo único que está haciendo es que presenta los mismo métodos
		// pero no presenta ningún método con la palabra "synchronized", es decir, varios hilos
		// podrían ejecutar el método y cambiar los valores entre uno y otro.
		
		// Estos conceptos de lo que son hilos, sincronización o concurrencia son otros temas más avanzados.
		
		// ¿Cuando es recomendable usar cada uno?
		
		// Cuando la integridad del mensaje es importante es recomendable utilizar un StringBuffer porque
		// tiene métodos Sincronos, es decir, va a haber una protección frente a un ambiente de hilos.
		
		// Si no importa la sincronia de nuestros mensajes podríamos utilizar un StringBuilder.
		
		// Es por eso que StringBulder es mucho más rápido que un StringBuffer.
		
		System.out.println("\n-----------StringBuilder------------");
		// EL StringBuilder tiene algunas peculiaridades.
		StringBuilder sb = new StringBuilder();
		// sb.append("Ingeniero").append(" Luis Eduardo");
		
		// Puede imprimise así:
		// System.out.println(sb);
		// También puede imprimirse así:
		// System.out.println(sb.toString());
		
		// El valor por defecto de la capacidad de un StringBuilder es de 16.
		System.out.println(sb.capacity());
		
		// StringBuilder tiene una capacidad inicial de 16 pero es dinámico
		// y podemos añadirle la capacidad, se recomienda que el valor sea múltiplo de 4
		// en arquitecturas de 64 bits para la JVM (Java Virtual Machine) y debemos 
		// colocarlo si conocemos más o menos la capâcidad de nuestros valores
		// para que nos de más rendimiento.
		StringBuilder sbCapacidad = new StringBuilder(32);
		System.out.println(sbCapacidad.capacity());

		// Que pasaría si colocamos un String inicial.
		StringBuilder sbStringInicial = new StringBuilder("Luis Eduardo");
		System.out.println(sbStringInicial.capacity());
		System.out.println(sbStringInicial.toString());
		// Vemos que nos da 28, debido a lo siguiente:
		// por defecto es 16, sin embargo al momento que yo le inidco un String
		// me está redimencionando la capacidad inicial y sería la suma de 
		// 16 más la cantidad de caracteres de está palabra.
		
		// Y si yo quisiera  obtener realmente el tamaño de lo que está contenido
		// bastaría con utilizar el método length()
		System.out.println(sbStringInicial.length());
		
		// Adicionalmente si nosotros deseamos que la palabra esté en orden inverso
		// que es muy común en algunas entrevistas podríamos utilizar el método
		// reverse()
		System.out.println(sbStringInicial.reverse());
		
		// Si deseamos borrar todo el contenido bastará con utilizar el métod
		// de setLength(0)
		sbStringInicial.setLength(0);
		// Imprimimos el contenido y vemos que está vacio.
		System.out.println("¿El String está vació?: "+ sbStringInicial.toString());
		
		
		
		System.out.println("\n-----------StringBuffer------------");
		// Entonces si cambiamos el StringBuilder por el StringBuffer veremos que la 
		// implementación es la misma.
		
		StringBuffer sbuffer = new StringBuffer("Luis Eduardo");
		System.out.println(sbuffer.capacity());
		System.out.println(sbuffer.length());

		// Esto es debido a que ambas Clases extienden (heredan) de la Clase AbstractStringBuilder
		// Por eso es que es fácil hacer una implementación con la otra.
		
	}

}
