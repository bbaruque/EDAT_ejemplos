package es.ubu.lsi.edat.s06_Mapas.demo01;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Test;

/**
 * Clase de ejemplo que permite mostrar las operaciones individuales de
 * inserción, modificación y consulta de datos dentro de un HashMap de Java.
 * La operaciones tendrán el mismo resultado en otras clases que implementen
 * el interfaz Map (aunque podrá variar su complejidad algorítmica).
 * 
 * @author bbaruque
 *
 */
public class UsoMapasTest {

	private HashMap<Integer,String> mapa = new HashMap<Integer,String>(); 
	
	public void setUp() {
		mapa.put(1, "uno");
		mapa.put(2, "dos");
		mapa.put(3, "tres");
		mapa.put(4, "cuatro");
		mapa.put(5, "cinco");
		mapa.put(6, "seis");
		mapa.put(7, "siete");
	}

	@After
	public void tearDown() throws Exception {
		mapa.clear();
	}

	@Test
	public void testContainsValue() {
		
		setUp(); // Se rellena el mapa con 7 elementos
		
		// Solo indica si se contienen o no los valores sobre
		// los que se consulta. No modifica el contenido del mapa.
		assertTrue(mapa.containsValue("uno"));
		assertTrue(mapa.containsValue("seis"));
		
		assertFalse(mapa.containsValue("estás?"));
		assertFalse(mapa.containsValue(26));
		
	}

	@Test
	public void testContainsKey() {
		
		setUp(); // Se rellena el mapa con 7 elementos
		
		// Solo indica si se contienen o no los valores sobre
		// los que se consulta. No modifica el contenido del mapa.
		assertTrue(mapa.containsKey(1));
		assertTrue(mapa.containsKey(6));
		
		assertFalse(mapa.containsKey(85));
		assertFalse(mapa.containsKey("estás?"));
		
	}

	@Test
	public void testGet() {
		
		setUp();
		
		System.out.println(" -- Consultando en un mapa -- ");

		// Se consultan por varias claves
		for(int i=0; i<5; i++){
			// Se genera la clave sobre la que se va a consultar de forma aleatoria
			int clave = (int) Math.floor(Math.random()*mapa.size());
			System.out.println("Conslutando por la clave --> "+clave+": "+mapa.get(clave));
		}
		
		int clave = 25;
		System.out.println("Consultando por una clave que NO se encuentra insertada -->"+clave+": "+mapa.get(clave));
		
		assertEquals(7, mapa.size());
		System.out.println("El mapa no se modifica: "+mapa);
		
	}

	@Test
	public void testPut() {

		System.out.println(" -- Insertando en un mapa -- ");

		mapa.put(1, "uno");
		mapa.put(2, "dos");
		mapa.put(3, "tres");
		mapa.put(23, "veintitres");
		mapa.put(4, "cuatro");
		mapa.put(5, "cinco");
		mapa.put(6, "seis");

		// El tamaño del mapa representa el numero de pares clave-valor
		assertEquals(7, mapa.size());

		/* Observar que en las tablas hash NO tiene por qué conservarse
		 * el orden en el que se insertan los elementos (el 23 aparece al final)
		 * Depende de la función hash que busque posición para la clave que se
		 * inserta */
		System.out.println("Mapa: "+mapa);

	}

	@Test
	public void testPut_Overwrite() {

		System.out.println(" -- Insertando en un mapa (sobreescribiendo) -- ");

		setUp(); // Se rellena el mapa con 7 elementos
		
		// Se incluyen pares con la misma clave, pero distinto valor
		
		// Se devuelve el antiguo valor asociado a esa misma clave
		assertEquals("uno", mapa.put(1, "otro uno"));
		assertEquals("cinco", mapa.put(5, "otro cinco"));
		
		// Si se inserta una clave no contenida, el valor devuelto es null
		assertNull(mapa.put(0, "cero"));

		assertEquals(8, mapa.size());

		System.out.println("Mapa: "+mapa);
	}

	@Test
	public void testRemoveObject() {
		
		System.out.println(" -- Borrando en un mapa -- ");
		
		setUp(); // Se rellena el mapa con 7 elementos
		System.out.println("Mapa: "+mapa);
		
		// Se eliminan algunos de los elementos
		// Al hacerlo se devuelve como resultado el valor
		// asociado a la clave y se eliminan ambos
		
		assertEquals("tres", mapa.remove(3));
		assertEquals("uno", mapa.remove(1));
		System.out.println("Mapa: "+mapa);
		
		// Si se pide eliminar por una clave inexistente, se devuelve null
		assertNull(mapa.remove(82));
		
	}

	@Test
	public void testKeySet() {
		
		System.out.println(" -- Accediendo al mapa como a una colección (claves) -- ");
		
		setUp(); // Se rellena el mapa con 7 elementos
		System.out.println("Mapa: "+mapa);
		
		// Veremos los Set más adelante en la asignatura
		// Descienden de Collection
		Set<Integer> claves = mapa.keySet();

		// Se pueden iterar como cualquier coleccion
		for (Integer i : claves)
			System.out.print(" "+i);
		
		System.out.println(" ");
	}

	@Test
	public void testValues() {
		
		System.out.println(" -- Accediendo al mapa como a una colección (valores) -- ");
		
		setUp(); // Se rellena el mapa con 7 elementos
		System.out.println("Mapa: "+mapa);
		
		Collection<String> valores = mapa.values();

		// Se pueden iterar como cualquier coleccion
		for (String s : valores)
			System.out.print(" "+s);
		
		System.out.println(" ");
	}
	
	@Test
	public void testEntradas() {
		
		System.out.println(" -- Accediendo al mapa como a una colección (entradas) -- ");
		
		setUp(); // Se rellena el mapa con 7 elementos
		System.out.println("Mapa: "+mapa);
	
		// Se obtiene una coleccion de entradas (son objetos que contienen cada par de clave-valor)
		// Es la forma de poder relacionar ambos al recorrer el contenido del mapa
		Collection<Map.Entry<Integer, String>> entradas = mapa.entrySet();

		// Se pueden iterar como cualquier coleccion
		for (Map.Entry<Integer, String> e : entradas)
			System.out.println(e);
		
	}
	
}
