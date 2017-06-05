package es.ubu.lsi.edat.s02a_Comparacion.demo03;

import java.util.Comparator;

/**
 * Clase 'dummy' que ejemplifica solamente cómo se configura una clase
 * contenedora de datos para soportar la ordenación interna de sus elementos.
 * 
 * Esta clase no realiza ninguna operación a parte de mostrar cómo se puede configurar
 * esta característica a partir de los interfaces 'Comparable' y 'Comparator'.
 * 
 * @author bbaruque
 *
 * @param <E>
 */
public class DeterminaOrden<E> {

	Comparator<E> comparadorInterno;
	
	public DeterminaOrden() {
		/** Constructor sin comparador.
		 * El emplear este constructor implica que los elementos a
		 * insertar en la estructura deberán implementar el interfaz 
		 * 'Comparable'
		 */
	}
	
	public DeterminaOrden(Comparator <E> comparadorParametro) {
		/** Constructor con comparador.
		 * El en este caso se empleará el comparador facilitado, incluso aunque los objetos implementen Comparable.
		 */
		this.comparadorInterno = comparadorParametro;
	}
	
	/**
	 * Metodo que permite comparar dos elementos pasados por parámetro.
	 * @param o1
	 * @param o2
	 * @return
	 * @throws ClassCastException
	 */
	@SuppressWarnings("unchecked")
	protected int comparar(E o1, E o2) throws ClassCastException{            
		if (comparadorInterno != null)      // Si hay un comparador, se emplea                          
			return comparadorInterno.compare(o1,o2);
		else  // Si no, hay que suponer que sean Comparable        
			return ((Comparable<E>) o1).compareTo(o2);
		// Si no se cumple alguna de las anteriores, se lanzará la excepción de ClassCastException
		// indicando que no existe un orden definido para trabajaro con los elementos indicados
	}
	
}
