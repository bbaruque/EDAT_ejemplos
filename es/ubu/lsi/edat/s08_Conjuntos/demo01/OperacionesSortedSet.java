package es.ubu.lsi.edat.s08_Conjuntos.demo01;

import java.util.TreeSet;

public class OperacionesSortedSet {

	public static void main(String[] args)	{
		
		// Create a new TreeSet object:
		TreeSet<Integer> ts = new TreeSet<Integer>();

		// TODO - Se puede probar a añadir más elmentos

		// Add some elements:
		ts.add(new Integer(5));
		ts.add(new Integer(4));
		ts.add(new Integer(9));

		// Display the first and the last:
		System.out.println("The first element: " + ts.first());
		System.out.println("The last element: " + ts.last());

		// Display the headSet and the tailSet:
		System.out.println("The headSet: " + ts.headSet(ts.last()));
		System.out.println("The tailSet: " + ts.tailSet(ts.last()));
	}

	/*
	Output:
	The first element: 4
	The last element: 9
	The headSet: [4, 5]
	The tailSet: [9]
	 */

}
