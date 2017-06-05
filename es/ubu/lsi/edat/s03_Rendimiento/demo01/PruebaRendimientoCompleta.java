package es.ubu.lsi.edat.s03_Rendimiento.demo01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class PruebaRendimientoCompleta {

	static List<Integer> listaTrabajo; // Lista sobre la que se trabajará
	
	public static void testOrdenacion(int limiteElementos, int paso) {
		
		double inicio, fin;
		
		System.out.println("Tiempos de ejecución para Ordenacion de diferentes tamaños de lista: ");
		
		// Se repiten las operaciones de medición, cada vez con un numero diferente de elementos en la lista
		
		for(int i=1; i<limiteElementos; i=i+paso){
			
			// Se genera una lista aleatoria
			listaTrabajo = listaAleatoria(i);
			
			/*
			 * Para comprobar el tiempo que se emplea en completar la llamada
			 * a la función, se almacena el instante de tiempo (en milisegundos) 
			 * antes de la llamada en una variable y en otra el instante en que se
			 * ha acabado la instruccion.
			 * 
			 * http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#currentTimeMillis--
			 */
			
			inicio = System.currentTimeMillis();
			Collections.sort(listaTrabajo); // Se ordena la lista aleatoria generada
			fin = System.currentTimeMillis(); 

			/*
			 * Para conocer el lapso de tiempo que ha discurrido, simplemente se
			 * calcula la diferencia de ambas variables. 
			 */
			
			System.out.println("Num.Elem,"+i+",tiempo(ms),"+(fin-inicio));
			
		}
		
	}

	public static void testBusqueda(int limiteElementos, int paso){

		double inicio, fin;
		
		System.out.println("Tiempos de ejecución para Busqueda en diferentes tamaños de lista: ");
		
		for(int i=1; i<limiteElementos; i=i+paso){
		
			// Se genera la lista
			listaTrabajo = listaAleatoria(i);
			
			// Se elige un elemento contenido en la lista de forma aleatoria
			int posBuscado = (int) Math.round((Math.random())*(i-1));
			int buscado = listaTrabajo.get(posBuscado);
			
			/* Para poder emplear la busqueda binaria, la lista
			 * debe estar ordenada de forma previa a la llamada.
			 * 
			 * Si no se quiere que la ordenacion se tenga en cuenta
			 * a la hora de analizar la busqueda, se puede dejar fuera
			 * de las instrucciones medidas.
			 */
			Collections.sort(listaTrabajo);
			
			/*
			 *  En este caso, al ser el tiempo necesario muy pequeño, se intenta medir
			 *  el tiempo en nanosegundos. No es una práctica muy aconsejada, ya que la
			 *  JVM no asegura que la frecuencia de actualización se pueda mantener.
			 *  
			 *  Se puede revisar en:
			 *  http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#nanoTime--
			 */
			
			inicio = System.nanoTime();
			int pos = Collections.binarySearch(listaTrabajo, buscado);
			fin = System.nanoTime(); 
			
			assertTrue(buscado == listaTrabajo.get(pos));
			
			System.out.println("Num.Elem,"+i+",tiempo(ns),"+(fin-inicio));

		}
		
	}

	public static void testDisjuntos(int limiteElementos, int paso){

		double inicio, fin;
		
		List<Integer> listaTrabajo1, listaTrabajo2;
		
		System.out.println("Tiempos de ejecución para comprobación de disjuntos en diferentes tamaños de lista: ");
		System.out.println("Las listas son DISJUNTAS: ");
		
		for(int i=1; i<limiteElementos; i=i+paso){
			
			// Se generan dos listas DISJUNTAS
			listaTrabajo = listaAleatoria(i); // Lista con elementos no repetidos
			listaTrabajo1 = listaTrabajo.subList(0, i/2); // Listas con la mitad del contenido cada una
			listaTrabajo2 = listaTrabajo.subList(i/2, i);
			
			inicio = System.currentTimeMillis();
			boolean dis = Collections.disjoint(listaTrabajo1, listaTrabajo2);
			fin = System.currentTimeMillis(); 
			
			assertTrue(dis);
			
			System.out.println("Num.Elem,"+i+",tiempo(ms),"+(fin-inicio));

		}
		
	}
	
	public static void testNoDisjuntos(int limiteElementos, int paso){

		double inicio, fin;
		
		List<Integer> listaTrabajo1, listaTrabajo2;
		
		System.out.println("Tiempos de ejecución para comprobación de disjuntos en diferentes tamaños de lista: ");
		System.out.println("Las listas son NO DISJUNTAS: ");
		
		for(int i=1; i<limiteElementos; i=i+paso){
			
			// Se generan dos listas aleatorias
			listaTrabajo1 = listaAleatoria(i);
			listaTrabajo2 = listaAleatoria(i);
			
			// Se asegura que al menos tienen un elemento en comun
			listaTrabajo2.set(i/2, listaTrabajo1.get(listaTrabajo1.size()-1));
			
			inicio = System.currentTimeMillis();
			boolean dis = Collections.disjoint(listaTrabajo1, listaTrabajo2);
			fin = System.currentTimeMillis(); 
			
			assertFalse(dis);
			
			/*
			 *  Se puede comprobar como a pesar de ser exactamente el mismo método,
			 *  cuando se comprueba que 2 colecciones NO son DISJUNTAS, se tarda siempre
			 *  un tiempo mucho menor que en comprobar que si lo son. 
			 *  
			 *  En el primer caso, basta con encontrar un elemento coincidente en ambas.
			 *  En el segundo, hace falta comprobar TODOS los elementos.
			 *  
			 *  De ahí que se insista en diferenciar los análisis con los casos extremos 
			 *  y con los casos medios.
			 */
			
			System.out.println("Num.Elem,"+i+",tiempo(ms),"+(fin-inicio));

		}
		
	}

	/**
	 * Simplemente repite todos los test anteriores aumentando cada vez
	 * el tamaño de la lista sobre la que se trabaja. De esa forma se puede
	 * comprobar el tiempo que tarda en finalizar cada uno en función del 
	 * tamaño de la colección de datos a emplear. 
	 * 
	 * Permite realizar 
	 * 
	 */
	public static void main(String args[]){
		
		int limiteElementos = 10;
		int paso = 10;
		
		while(true){

			// Numero maximo de elementos que se quiere probar a trabajar
			limiteElementos = limiteElementos * 10;
			// Numero de mediciones que se quieren obtener por cada prueba
			paso = limiteElementos/10;
			
			testOrdenacion(limiteElementos, paso);
			testBusqueda(limiteElementos, paso);
			testDisjuntos(limiteElementos, paso);
			testNoDisjuntos(limiteElementos, paso);
			
		}
		
	}
	
	/**
	 * Permite generar una lista de enteros aleatorios del tamaño solicitado.
	 * 
	 * Los numeros generdos estaráne en el rango del 0 al tamaño solicitado.
	 * Se asegura que no habrá elementos duplicados en la lista generada. 
	 * 
	 * @param tamano
	 * @return
	 */
	private static List<Integer> listaAleatoria (int tamano){
		
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
