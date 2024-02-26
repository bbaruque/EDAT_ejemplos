package es.ubu.gii.edat.s02a_Comparacion.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import es.ubu.gii.edat.s02a_Comparacion.demo01.SimpleStudent;

/**
 * Test program for lots of collections.
 */
class OrderingExample {

	/**
	 * Metodo que permite el recorrido de CUALQUIER TIPO de coleccion.
	 * Esto es posible gracias al patron del Iterador: todas las colecciones 
	 * estan obligadas a implementar un metodo que permite obtener un iterador
	 * sobre su contenido.
	 * 
	 * @param c - Coleccion a imprimir
	 */

	public static void printCollection ( Collection<?> c )  {

		// Tipo de la coleccion (no influye en el metodo para poder RECORRERLA)
		System.out.print(c.getClass() + " - ");

		Iterator<?> it = c.iterator(); 

		while(it.hasNext())
			System.out.print( it.next() + " " );

		System.out.println( );

	}


	public static void main( String [ ] args ) {


		/** PRUEBA CON CLASES DEFINIDAS EN JAVA **/
		// En este caso, se prueban con objetos String

		List<String> l1 = new ArrayList<String>( );
		l1.add( "Jack" );
		l1.add( "Jill" );
		l1.add( "Bill" );

		printCollection( l1 ); // Orden en que se insertaron: Jack Jill Bill

		// Orden DEFINIDO de los objetos String (implementan interfaz Comparable)
		Collections.sort( l1 );  
		printCollection( l1 ); // Orden alfabetico: Bill Jack Jill

		// Orden MODIFICADO de los objetos String (se da prioridad a este sobre el orden definido de la clase)
		Collections.sort(l1, Collections.<String>reverseOrder( ));
		printCollection( l1 ); // Orden alfabetico inverso:  Jill Jack Bill

		l1.add( "joe" );
		l1.add( "bob" );
		l1.add( "hal" );

		// Orden DEFINIDO de los objetos String (implementan interfaz Comparable)
		Collections.sort(l1); 
		printCollection(l1);  // Orden alfabetico SEPARANDO mayusculas de minusculas: Bill Jack Jill bob hal joe 

		// Orden MODIFICADO de los objetos String (se da prioridad a este sobre el orden definido de la clase)
		Collections.sort(l1, new IgnoreCase( ) );
		printCollection( l1 ); // Orden alfabetico IGNORANDO mayusculas de minusculas: Bill bob hal Jack Jill joe

		/** PRUEBA CON CLASES DEFINIDAS POR EL USUARIO **/
		// En este caso, se prueban con objetos SimpleStudent

		List<SimpleStudent> stud1 = new ArrayList<SimpleStudent>( );
		stud1.add( new SimpleStudent( "Bob", 0 ) );
		stud1.add( new SimpleStudent( "Joe", 1 ) );
		stud1.add( new SimpleStudent( "Bob", 2 ) ); // duplicate
		stud1.add( new SimpleStudent( "hal", 3 ) );
		stud1.add( new SimpleStudent( "joe", 4 ) ); // 
		stud1.add( new SimpleStudent( "bob", 5 ) ); // duplicate

		// En este caso SI podemos almacenar objetos de la clase SimpleStudent en esta coleccion
		// (comparar con Iteratortest01.java en la practica anterior).
		// Ahora SimpleStudent SI implementa la interfaz Comparable
		// (Veremos mas detalles mas adelante en esta asignatura)
		Set<SimpleStudent>  stud2 = new TreeSet<SimpleStudent>( stud1 );  

		printCollection( stud1 ); 
		printCollection( stud2 ); 

		// Orden DEFINIDO de los objetos String (implementan interfaz Comparable)
		Collections.sort( stud1 );  
		printCollection( stud1 ); // Solo se tiene en cuenta el nombre del estudiante (y no su ID)

		/* TODO - Ejercicio para el alumno:
		 * 
		 * Debajo de este comentario se pretende realizar la ordenacion de los objetos definidos por el usuario que representan
		 * a los alumnos de la misma forma que en el caso anterior se ordenan solo los nombres.
		 *
		 * ¿Por qué aparece un error de compilación al emplear la misma ordenación que arriba en ambos casos?
		 * ¿Cómo se podría solucionar?  
		 * 
		 * Ten en cuenta que en cada caso el error que aparece es por una razon diferente.
		 */

		// Orden MODIFICADO de los objetos String (se da prioridad a este sobre el orden definido de la clase)
//		Collections.sort(stud1, Collections.<String>reverseOrder( ));
//		printCollection( stud1 ); // Orden DEFINIDO inverso

		// Orden alfabetico IGNORANDO mayusculas de minusculas (se da prioridad a este sobre el orden definido de la clase)
//		Collections.sort(stud1, new IgnoreCase( ) );
//		printCollection( stud1 ); // Orden alfabetico IGNORANDO mayusculas de minusculas: Bill bob hal Jack Jill joe

	}

}
