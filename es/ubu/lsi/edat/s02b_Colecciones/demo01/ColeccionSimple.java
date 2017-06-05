package es.ubu.lsi.edat.s02b_Colecciones.demo01;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Clase de demostraci�n de c�mo se puede implementar una Collection
 * definida por el usuario.
 * En la asignatura de EDAT realizaremos varias implementaciones bas�ndonos en �sta. 
 * 
 * @author bbaruque
 *
 * @param <T>
 */
public class ColeccionSimple<T> extends AbstractCollection<T> 
implements Iterable<T> { // Esto �ltimo no es necesario incluirlo expl�citamente porque AbstractCollection YA implementa Iterable
	//TODO: Comprobar que al eliminar el implements de la cabecera de la clase, esta sigue funcionando correctamente.

	T [] contenido; // Datos sobre los que va a trabajar la colecci�n

	public ColeccionSimple (T [] contenido){
		this.contenido = contenido;
	}

	/* Metodos que obliga a implementar la clase AbstractCollection para
	 * implementar una coleccion NO MODIFICABLE (son solo 2 + Iterator)
	 * En ese caso, la coleccion nos sirve para almacenar datos (que se pasan en el constructor)
	 * para consultar luego sobre ellos.
	 */
	
	@Override
	public Iterator<T> iterator() {
		return new IteradorSencillo();
	}

	@Override
	public int size() {
		return contenido.length;
	}

	/**
	 * Notese que el resto de metodos que se detallan para el interfaz Collection
	 * (remove, contains, ...) ya se encuentran definidos en la clase AbstractCollection.
	 * Su contenido es el que se incluye en las transparencias asociadas en la presente sesion
	 * de practicas. 
	 * 
	 * Todos ellos se basan en el uso de la clase que implementa Iterator. Sus implementaciones son
	 * por lo tanto, poco eficiencientes computacionalmente (probablemente realicen mas operaciones 
	 * de las necesarias). Veremos a lo largo del curso como se pueden obtener implementaciones 
	 * mas eficientes.
	 */
	
	/** Metodo necesario para que la coleccion sea MODIFICABLE.
	 * En ese caso, debe ser posible a�adir elementos a la coleccion.
	 *  
	 * Para poder elminiarlos, habría que implementar el metodo remove en la propia clase o 
	 * en el iterador.
	 */
	    
	// Si no se necesita una coleccion modificable, este metodo no necesita definirse. 
	@Override
	public boolean add(T elemento){

		//Contenido del metodo a�adir
		//...

		// La excepci�n se lanza solo si la colecci�n es no modificable
		// Si el m�todo tuviera un contenido, se eliminar�a esta l�nea.
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Clase privada que permite implementar un Iterator asociado a
	 * la clase ColeccionSimple. 
	 * Puesto que los iteradores están muy relacionados con la clase sobre
	 * la que permiten iterar, se suelen definir como clases anidadas y privadas. 
	 * 
	 * @author bbaruque
	 *
	 * @param <T>
	 */
	private class IteradorSencillo implements Iterator<T>{

		int cursor = 0;
		
		@Override
		public boolean hasNext() {
			return cursor < contenido.length;
		}

		@Override
		public T next() {
			T devolver = (T) contenido[cursor];
			cursor++;
			return devolver;
		}

		@Override
		public void remove(){
			// La excepci�n se lanza solo si la colecci�n es no modificable
			// Si el m�todo tuviera un contenido, se eliminar�a esta l�nea.

			throw new UnsupportedOperationException();
		}
		
	}

}
