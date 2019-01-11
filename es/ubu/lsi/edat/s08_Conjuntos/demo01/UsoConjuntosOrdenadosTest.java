package es.ubu.lsi.edat.s08_Conjuntos.demo01;

import java.util.List;
import java.util.TreeSet;
import es.ubu.lsi.edat.datos.GeneradorEnteros;

public class UsoConjuntosOrdenadosTest {

	public static void main(String[] args)	{
		
		List<Integer> list = GeneradorEnteros.listaAleatoria(10);
		
		// Create a new TreeSet object:
		TreeSet<Integer> ts = new TreeSet<>(list);
		System.out.println("The whole set is: " + ts);
		
		// Display the first and the last:
		System.out.println("The first element: " + ts.first());
		System.out.println("The last element: " + ts.last());

		Integer buscado = list.get(list.size()/2);
		System.out.println("The searched element: " + buscado); 
		
		// Display the headSet and the tailSet:
		System.out.println("The headSet: " + ts.headSet(buscado)); // Menores que el buscado (EXCLUIDO)
		System.out.println("The tailSet: " + ts.tailSet(buscado)); // Mayores que el buscado (INCLUIDO)
		
	} 


}
