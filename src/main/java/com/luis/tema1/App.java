package com.luis.tema1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Persona p = new Alumno();
        int n = p.sumar(1);
        //int n = Persona.sumar(1);
        System.out.println(n);
        
        // Observa que sale 3.
        // Cuando yo tengo 2 métodos iguales de instancia, uno sobreescribe al otro.
        // Es decir, la Subclase sobreescribe a la Clase mayor.
        
        //CASOS - métodos no static y no static (Ambos/Todos los métodos que son iguales
        // o son static o no lo son, pero no puede ser 1 y 1):
        
        //CASOS: En los que se sobreescribe el método sumar() que está en ambas clases:
        
        //1.- La Subclase sobreescribe Clase mayor.
        //Persona p = new Alumno();
        
        //2.- La Subclase sobreescribe Clase mayor.
        //Alumno p = new Alumno();
        
        //CASOS: En los que NO se sobreescribe el método sumar()
        
        //1.- La Clase principal trabaja sobre su propio método.
        //Persona p = new Persona();
        
        
        
    }
}
