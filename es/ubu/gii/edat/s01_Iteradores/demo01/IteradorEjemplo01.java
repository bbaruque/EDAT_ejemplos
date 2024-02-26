package es.ubu.gii.edat.s01_Iteradores.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Test program for lots of collections.
 */
class IteradorEjemplo01 {

	/**
	 * Llamadas a los dos tipos de iteracion de ejemplo.
	 */
	public static void printCollection( Collection<?> c ) {

		printCollectionIterator(c);
		printCollectionForEach(c);

	}

	/**
	 * Metodo que permite el recorrido de CUALQUIER TIPO de colección.
	 * Esto es posible gracias al patrón del Iterador: todas las colecciones 
	 * estan obligadas a implementar un método que permite obtener un iterador
	 * sobre su contenido.
	 * 
	 * @param c - Colección a imprimir
	 */
	
	public static void printCollectionIterator ( Collection<?> c )  {

		System.out.print(c.getClass()); // Tipo de la coleccion (no influye en el metodo para poder RECORRERLA)
		System.out.print(" - Recorrido con iterador: ");
		
		Iterator<?> it = c.iterator(); 

		while(it.hasNext())
			System.out.print( it.next() + " " );

		System.out.println( );

	}

	/**
	 * El bucle for-each utiliza de forma INTERNA un iterador.
	 * Es la forma resumida de escribir el mismo proceso del método printCollectionIterator.
	 * A efectos prácticos, funciona de la misma forma.
	 * 
	 * @param c
	 */
	public static void printCollectionForEach ( Collection<?> c )  {

		System.out.print(c.getClass()); // Tipo de la coleccion (no influye en el metodo para poder RECORRERLA)
		System.out.print (" - Recorrido con for-each: ");
		
		for( Object val : c )
			System.out.print( val + " " );

		System.out.println( );
		
	}


	/**
	 * Método principal para el programa de prueba de los metodos de recorrido.
	 * 
	 * @param args
	 */
	public static void main( String [ ] args ) {

		/** PRUEBA CON CLASES DEFINIDAS EN JAVA **/
		// En este caso, se prueban con objetos String
		
		// Se crean varias COLECCIONES de diferentes tipos para las pruebas.
		// (Las particularidades de cada tipo de colección se verán más adelante en esta misma asignatura).
		
		List<String> l1 = new ArrayList<>( );
		l1.add( "Jack" );
		l1.add( "Jill" );
		l1.add( "Bill" );
		
		// Se realizan copias del contenido de l1 para las pruebas 
		List<String> l2 = new LinkedList<String>( l1 );
		Set<String>  s1 = new TreeSet<String>( l1 );
		Set<String>  s2 = new HashSet<String>( l1 );

		// Se realiza una prueba de la iteracion en cada coleccion (algunas ordenan su contenido)
		printCollection( l1 );   // Jack Jill Bill
		printCollection( l2 );   // Jack Jill Bill
		printCollection( s1 );   // Bill Jack Jill
		printCollection( s2 );   // Some unspecified order

		
		/** PRUEBA CON CLASES DEFINIDAS POR EL USUARIO **/
		// En este caso, se prueban con objetos SimpleStudent

		// Se crean varias COLECCIONES de diferentes tipos para las pruebas.
		// (Las particularidades de cada tipo de colección se verán más adelante en esta misma asignatura).
		List<EstudianteSimple> stud1 = new ArrayList<EstudianteSimple>( );
		stud1.add( new EstudianteSimple( "Bob", 0 ) );
		stud1.add( new EstudianteSimple( "Joe", 1 ) );
		stud1.add( new EstudianteSimple( "Bob", 2 ) ); 

		// Este tipo de Colección necesita que los objetos contenidos se puedan ordenar.
		// (Se verá como se define esto en la siguiente práctica)
		Set<EstudianteSimple>  stud2 = null;
		try{
			stud2 = new TreeSet<EstudianteSimple>( stud1 );  
		}catch(Exception e){
			System.out.println(e);
		}
		
		Set<EstudianteSimple>  stud3 = new HashSet<EstudianteSimple>( stud1 ); 
		
		
		// Se realiza una prueba de la iteracion en cada coleccion
		
		printCollection( stud1 ); // Bob Joe Bob
		// printCollection( stud2 ); // Esta coleccion no se puede crear (se explicará como se utiliza mas adelante) 
		printCollection( stud3 ); // Orden no especificado
		
	}
}
