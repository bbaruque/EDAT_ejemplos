package es.ubu.lsi.edat.s03_Rendimiento.demo01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * Clase que pretende servir como ejemplo para la realización de análisis
 * de la complejidad algortimica de un programa (o parte de él).
 * 
 * Las salidas de datos se han formateado de manera que cumplen con el formato .csv
 * Basta con almacenarlas en un fichero de texto para luego poder importar esos datos
 * a una hoja de cálculo y realizar las operaciones y gráficas que sean necesarias. 
 * 
 * @author bbaruque
 *
 */

public class TestRendimientoSimple {

	// Numero maximo de elementos que se quiere probar a trabajar
	int limiteElementos = 10000;
	// Numero de mediciones que se quieren obtener por cada prueba
	int paso = limiteElementos/10;
	
	// Lista sobre la que se trabajará
	List<Integer> listaTrabajo;
	
	public void comprobacionDisjuntos(){

		double inicio, fin;
		
		List<Integer> listaTrabajo1, listaTrabajo2;
		
		System.out.println("Tiempos de ejecución para comprobación de disjuntos en diferentes tamaños de lista: ");
		System.out.println("Las colecciones son DISJUNTAS: ");
		
		for(int i=1; i<limiteElementos; i=i+paso){
			
			// Se generan dos listas DISJUNTAS
			listaTrabajo = this.listaAleatoria(i); // Lista con elementos no repetidos
			listaTrabajo1 = listaTrabajo.subList(0, i/2); // Listas con la mitad del contenido cada una
			listaTrabajo2 = listaTrabajo.subList(i/2, i);
			
			inicio = System.currentTimeMillis();
			boolean dis = Collections.disjoint(listaTrabajo1, listaTrabajo2);
			fin = System.currentTimeMillis(); 
			
			assertTrue(dis);
			
			System.out.println("Num.Elem,"+i+",tiempo(ms),"+(fin-inicio));

		}
		
	}
	
	public void comprobacionNoDisjuntos(){

		double inicio, fin;
		
		List<Integer> listaTrabajo1, listaTrabajo2;
		
		System.out.println("Tiempos de ejecución para comprobación de disjuntos en diferentes tamaños de lista: ");
		System.out.println("Las colecciones son NO DISJUNTAS: ");
		
		for(int i=1; i<limiteElementos; i=i+paso){
			
			// Se generan dos listas aleatorias
			listaTrabajo1 = this.listaAleatoria(i);
			listaTrabajo2 = this.listaAleatoria(i);
			
			// Se asegura que al menos tienen un elemento en comun
			listaTrabajo2.set(i/2, listaTrabajo1.get(0));
			
			inicio = System.currentTimeMillis();
			boolean dis = Collections.disjoint(listaTrabajo1, listaTrabajo2);
			fin = System.currentTimeMillis(); 
			
			assertFalse(dis);
			
			/*
			 *  Se puede comprobar como a pesar de ser exactamente el mismo método,
			 *  cuando se comprueba que 2 colecciones NO son DISJUNTAS, se tarda siempre
			 *  un tiempo mucho menor que en comprobar que S�? lo son. 
			 *  
			 *  En el primer caso, basta con encontrar un elemento que NO SEA coincidente en ambas.
			 *  En el segundo, hace falta comprobar TODOS los elementos.
			 *  
			 *  De ahí que se insista en diferenciar los análisis con los casos extremos 
			 *  y con los casos medios.
			 */
			
			System.out.println("Num.Elem,"+i+",tiempo(ms),"+(fin-inicio));

		}
		
	}

	/**
	* Se repiten los dos tests que vemos arriba solamente incrementando el numero de elementos
	* que se incluyen en ambas listas. De esta forma, se puede comprobar la progresión del tiempo
	* que se tarda en finalizar cada test en función del tamaño de las estructuras empleadas.
	*/
	@Test 
	public void testIncremental(){
		
		limiteElementos = 10;
		
		while(true){
			
			limiteElementos = limiteElementos * 10;
			paso = limiteElementos/10;
			
			comprobacionDisjuntos();
			comprobacionNoDisjuntos();
			
		}
		
	}
	
	/**
	 * Permite generar una lista de enteros aleatorios del tamaño solicitado.
	 * 
	 * Los numeros generdos estarán en el rango del 0 al tamaño solicitado.
	 * Se asegura que no habrá elementos duplicados en la lista generada. 
	 * 
	 * @param tamano
	 * @return
	 */
	private List<Integer> listaAleatoria (int tamano){
		
		Set<Integer> aleatoria = new HashSet<Integer>();
		
		while(aleatoria.size() < tamano){
			
			int aleat = (int) (Math.random()*(tamano*10));
			aleatoria.add(aleat);
			
		}
		
		List<Integer> lista = new ArrayList<Integer>(tamano);
		lista.addAll(aleatoria);
		
		return  lista;
		
	}
	
}
