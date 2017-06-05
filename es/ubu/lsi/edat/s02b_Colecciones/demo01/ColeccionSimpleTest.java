package es.ubu.lsi.edat.s02b_Colecciones.demo01;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ColeccionSimpleTest {

	ColeccionSimple<Integer> miColeccionInt;
	ColeccionSimple<Character> miColeccionChar;

	// Las colecciones solo almacenan Object
	// En lugar de tipos primitivos, se definen tipos de envoltura
	Integer [] contI ={0,1,2,3,4,5}; 
	Character [] contC ={'a','b','c','d','e'};

	/**
	 * Se ejecuta siempre antes de cada test
	 * En este caso, se construyen las colecciones
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		miColeccionInt = new ColeccionSimple<Integer>(contI);
		miColeccionChar = new ColeccionSimple<Character>(contC);
	}

	/**
	 * Se ejecuta siempre despu�s de cada test
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	/*
	 * A continuaci�n se prueban los metodos implementados por
	 * el usuario en la clase miColeccion
	 */
	@Test
	public void testTamano(){
		assertEquals(contI.length, miColeccionInt.size());
		assertEquals(contC.length, miColeccionChar.size());
	}

	
	@Test
	public void testIteracion() {

		// Iteracion sobre la coleccion de Enteros
		int i=0;
		Iterator<Integer> itI = miColeccionInt.iterator();
		while(itI.hasNext()){
			assertEquals(contI[i],itI.next());
			i++;					
		}

		// Iteracion sobre la coleccion de Caracteres
		// Escrita en la forma resumida (pero equivalente a la anterior)
		i=0;
		for (Character elemento: contC){
			assertEquals(contC[i], elemento);
			i++;					
		}
		
	}
	
	/*
	 * A continuacion se prueban otros metodos comunes a las colecciones.
	 * N�tese como a pesar de no haberlos definido expl�citamente, los metodos
	 * funcionan correctamente, por ser heredados de AbstractCollection.
	 * 
	 * Es muy posible que el programador quiera re-definirlos, puesto que los 
	 * que se ofrecen por defecto son poco eficientes.
	 */
	
	@Test
	public void testContenido(){
		
		assertTrue(miColeccionInt.contains(3));
		assertTrue(miColeccionInt.contains(5));
		assertFalse(miColeccionInt.contains(23));
		
		assertTrue(miColeccionChar.contains('c'));
		assertTrue(miColeccionChar.contains('a'));
		assertFalse(miColeccionChar.contains('z'));
		
	}

	@Test
	public void testVacio(){
		
		assertFalse(miColeccionInt.isEmpty());
		assertFalse(miColeccionChar.isEmpty());
		
	}

	@Test
	public void testArray(){
		
		assertArrayEquals( contI, miColeccionInt.toArray() );
		assertArrayEquals( contC, miColeccionChar.toArray() );
		
	}
	
	/* Puesto que la coleccion creada es NO MODIFICABLE
	 * el intentar a�adir o borrar lanzara la excepcion que
	 * indica que la operacion no esta disponible 
	 */
	
	@Test(expected=UnsupportedOperationException.class)
	public void testVaciar(){
		
		miColeccionInt.clear(); // Utiliza el metodo remove del Iterator (que no est� definido)
				
	}
	
}
