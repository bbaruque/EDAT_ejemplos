package es.ubu.gii.edat.s04_Lineales.demo03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.ubu.gii.edat.datos.GeneradorEnteros;

/**
 * Test para comprobar la diferencia en complejidad de diferentes
 * tipos de recorridos sobre los diferentes tipos de Listas incluidas 
 * en el Java Collections Framework  
 * 
 * @author bbaruque
 *
 */
public class ComplejidadRecorridoTest {

	private final static int tamMax = 100000; 
	private final static int numMediciones = 10;
	
	List<Integer> lista;
	
	@Test
	public void testImprimeIter() {
		
		
		for (int i=0; i<=tamMax; i = i+(tamMax/numMediciones)){

			// TODO - Probar a intercambiar uno u otro tipo de lista para la misma iteracion
			// ¿A que se debe esta diferencia?
//			lista = new ArrayList<Integer> (GeneradorEnteros.listaAleatoria(i));
			lista = new LinkedList<Integer> (GeneradorEnteros.listaAleatoria(i));

			double ini = System.currentTimeMillis();
			ComplejidadRecorrido.recorreForYGet(lista);
			double fin = System.currentTimeMillis();
			
			System.out.println("Bucle for+get,"+i+",elem,"+(fin-ini)+",(ms)");

		}
		
		for (int i=0; i<=tamMax; i = i+(tamMax/numMediciones)){

			// TODO - Probar a intercambiar uno u otro tipo de lista para la misma iteracion
			// ¿A que se debe esta diferencia?
//			lista = new ArrayList<Integer> (GeneradorEnteros.listaAleatoria(i));
			lista = new LinkedList<Integer> (GeneradorEnteros.listaAleatoria(i));

			double ini = System.currentTimeMillis();
			ComplejidadRecorrido.recorreIterador(lista);
			double fin = System.currentTimeMillis();
			
			System.out.println("Iterador,"+i+",elem,"+(fin-ini)+",(ms)");
		}
	}

}
