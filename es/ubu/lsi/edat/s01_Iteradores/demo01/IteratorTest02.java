package es.ubu.lsi.edat.s01_Iteradores.demo01;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest02 {

	/**
	 * Metodo que permite realizar el filtrado de objetos en cualquier
	 * instancia de la clase Collections. 
	 * 
	 * Gracias a que todas (las predefinidas en Java) implementan un iterador
	 * con el metodo "remove", se puede realizar este proceso sin importar el 
	 * tipo de coleccion con el que se trabaja.
	 * 
	 * Nótese también como se pueden emplear los métodos del iterador dentro
	 * de la sintaxis del bulce for.
	 * 
	 * @param c - Coleccion sobre la que se desea filtrar
	 */
	public static void filtrado(Collection<?> c) {

		System.out.println("Filtrando una coleccion de tipo: "+c.getClass());

		for (Iterator<?> it = c.iterator(); it.hasNext(); )
			if (!condicion(it.next()))
				it.remove();
	}

	/**
	 * Metodo para evaluar si se cumple la condicion indicada arriba.
	 * 
	 * 
	 * @param object
	 * @return
	 */
	public static boolean condicion(Object object){
		
		Integer num;

		// Se intenta convertir el objeto que se pide comprobar a entero.
		// En caso de que no sea posible, se considera que no cumple la condicion
		try{
			num = (Integer) object;
		}catch (ClassCastException e){
			return false;
		}
		
		// Se comprueba si el numero es Par.
		return (num%2 == 0);
		
	}

	/**
	 * Metodo principal para la prueba del iterador
	 * 
	 * @param args
	 */
	public static void main(String args[]){

		// Se crean varias COLECCIONES de diferentes tipos para las pruebas.
		// (Las particularidades de cada tipo de colección se verán más adelante en esta misma asignatura).

		List<Integer> l1 = new ArrayList<Integer>(10);

		// Se rellenan con numeros enteros aleatorios entre 0 y 100
		for(int i=0;i<10; i++){
			l1.add((int) (Math.random()*100));
		}

		Set<Integer> s1 = new HashSet<Integer>(l1);

		// Se comprueba el contenido de ambas colecciones
		// (Se puede hacer de forma sencilla gracias a que todas implementan el interfaz Iterable)
		// Aunque ambas tienen los mismos elementos, no tienen por que aparecer en el mismo ORDEN
		System.out.println(l1);
		System.out.println(s1); 

		// Se realiza el filtrado de objetos (eliminando los impares)
		filtrado(l1);
		filtrado(s1);

		// Se comprueba de nuevo el contenido de ambas colecciones
		System.out.println(l1);
		System.out.println(s1);
		
	}

}
