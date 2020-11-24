package com.luis.tema17_1.File_Constructores;

import java.io.File;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		// Ya debemos de conocer algo de la clase File.
		// Pero ahora vamos a revisar los constructores que nos proporciona
		// esta Clase File.
		
		// Aquí estamos utiizando un timo de Constructor
		File f = new File("luis.txt");
		// Tenemos f que es el Objeto de File
		// Verificamos si el archivo existe o no. 
		// Sale false, como el archivo no existe sale false no hay ningún null
		System.out.println(f.exists());
		// Cuando le pasamos el nombre del archivo en el constructor creamos un
		// objeto en java que apunte o haga referencia a la ubicación de ese archivo.
		// Entonces crea el objeto pero no hay referencia.
		
		// Si es que etuviera el archivo, ok, se crearia el objeto y también existiría la
		// referencia.

		// Sin embargo, si colocamos a que busque el archivo pom, vemos que sale true porque
		// si existe el archivo y si esta encontrando la referencia.
		File fPom = new File("pom.xml");
		System.out.println(fPom.exists());
		
		// Y con esto podemos comprobar si no existe podemos crear el archivo
		
		if(!f.exists()) {
			// Y así lograriamos crear el archivo de manera exitosa.
			f.createNewFile();
			System.out.println("Archivo creado correctamente");
			// Solo tendríamos que hacer clic derecho en nuestro proyecto y hacer
			// refresh para que se vea en nuestro editor, ya que no se verá pero si
			// se habrá creado en el directorio.
		}
		
		// También podríamos comprobar si el archivo está oculto o no, para ello podemos
		// ocultar el archivo, buscandolo en su directorio y haciendo clic derecho y en propiedades
		// del archivo, en la pestaña de General le damos al check de oculto y le damos en aceptar.
		// System.out.println(f.isHidden());
		
		// ------------------------------------------------------------------------------------------------------------
		System.out.println("\n---------------------------------------------------------------------------");
		// Tenemos otro Constructor donde recibe el directorio padre pero tipo String y el directorio hijo tipo String
		
		// Creamos una carpeta haciendo clic en nuestro proyecto, luego en new Folder y creamos el directorio Archivos

		// Entonces apuntamos a la carpeta Archivos
		File f2 = new File("Archivos");
		// Aquí en archivos, indicamos una ruta padre y un archivo.
		File f3 = new File("Archivos","luisEduardo.txt");
		// O podriamos colocar otra carpeta dentro de esa carpeta
		File f4 = new File("Archivos","SubArhcivos");
		
		// Creamos el achivo y hacemos una impresión en pantalla para ver si a sido exitosa o no.
		System.out.println(f3.createNewFile());
		// Y sale true, vemos que efectivamente dentro de nuestro directorio Archivos el archivo luisEduardo.txt
		// Hacemos un refresh a nuestro proyecto para ver el archivo dentro del directorio.

		// Creamos la Subcarpeta ahora con mkdir()
		System.out.println(f4.mkdir());
		// Hacemos un refresh a nuestro proyecto para ver el la subcarpeta dentro del directorio Archivos.
		
		// ------------------------------------------------------------------------------------------------------------
		System.out.println("\n----------------------------------------------------------------------------------------");
		// Creamos un nuevo objeto para probar el constructor siguiente
		// Tenemos otro donde recibe el directorio padre pero de tipo File y el directorio hijo tipo String
		// Pasandole la insancia del Objeto f2 que este apuntaba a un directorio, con esto podemos señalar
		// ese directorio sin necesidad de pasarle un String.
		File f5 = new File(f2,"luisPorReferencia.txt");
		// Creamos el achivo y hacemos una impresión en pantalla para ver si a sido exitosa o no.
		System.out.println(f5.createNewFile());
		// Hacemos un refresh a nuestro proyecto para ver el archivo dentro del directorio.
		
		// Estos serían los Constructores más importantes de la Clase File.
		
		
	}

}
