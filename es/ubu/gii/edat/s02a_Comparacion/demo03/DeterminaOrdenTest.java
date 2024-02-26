package es.ubu.gii.edat.s02a_Comparacion.demo03;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class DeterminaOrdenTest {

	DeterminaOrden<Integer> detO;
	
	@Test
	public void testDeterminaOrden() {
		
		detO = new DeterminaOrden<Integer>(); // Se instancia SIN COMPARADOR
		System.out.println("Orden por defecto.");
		
		// Compara en el orden normal (Los elementos que se le pasan tienen definido un orden por defecto)
		assertTrue(detO.comparar(5, 3) > 0); // Se comprueba si el 5 sería mayor que el 3 según ese orden
		System.out.println("El 5 se considera MAYOR que el 3.");
		
	}

	@Test
	public void testDeterminaOrdenComparatorOfE() {
		
		detO = new DeterminaOrden<Integer>(Comparator.reverseOrder()); // Se instancia CON COMPARADOR que devuelve el orden contrario
		System.out.println("Orden indicado por el programador.");
		
		// Compara en el orden que se ha indicado en el comparador
		// Se va a emplear esta segunda forma de comparación, al haberla incluido al construir la clase como un comparador
		assertTrue(detO.comparar(5, 1) < 0); // Se comprueba si el 5 sería menor que el 3 según ese orden
		System.out.println("El 5 se considera MENOR que el 1.");

	}

}
