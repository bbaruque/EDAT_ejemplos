package es.ubu.lsi.edat.s04_Lineales.demo03;

import java.util.Iterator;
import java.util.List;

/**
 * Clase de demostración que incluye dos métodos para realizar un recorrido sobre una lista.
 * Ambos métodos realizan exactamente el mismo recorrido, 
 * solo varia la complejidad algorítmica que proporciona cada uno.
 * 
 * Se propone al alumno razonar el motivo de estas diferencias.
 * 
 * @author bbaruque
 *
 */
public class ComplejidadRecorrido {

	public static void recorreIterador(List<Integer> lista){
		
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()){
			it.next();
		}
		
	}
	
	public static void recorreForYGet(List<Integer> lista){

		for(int i=0; i<lista.size(); i++){
			lista.get(i);
		}
		
	}
	
}
