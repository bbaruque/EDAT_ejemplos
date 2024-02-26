package es.ubu.gii.edat.s08_Conjuntos.demo03;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ConjuntoPersonas {

	public static void main(String[] args) {

		System.out.println("\n*** HASHSET ***\n");
		
		Set<Persona> tabla = new HashSet<>(); 
		
		// Persona no tiene bien definido hashCode.
		// A pesar de que no debería, se insertan 2 individuos con el mismo DNI.
		// Para el Set, solo son 2 objetos diferentes (aunque representen la misma persona).
		tabla.add(new Persona("11111111","Harry"));
		tabla.add(new Persona("11111111","Harry"));
		
		System.out.println(tabla);
		
		// Por otro lado, al no tener definido equals(), no es capaz de
		// reconocer que ya contiene a una persona con esos datos
		System.out.println("Contiene a Harry?: "+tabla.contains(new Persona("11111111","Harry")));
		
		// Comprobamos la diferencia con un HashSet definido EXACTAMENTE IGUAL,
		// pero empleando datos de tipo Persona, bien definidos en cuanto a hashCode
		Set<Persona_hashCode> tablaHC = new HashSet<>();
		
		tablaHC.add(new Persona_hashCode("11111111","Harry"));
		tablaHC.add(new Persona_hashCode("11111111","Harry2"));
		
		// El Set se comporta de la manera esperada:
		System.out.println(tablaHC);
		System.out.println("Num. Elem:"+tablaHC.size());
		System.out.println("Contiene a Harry?: "+tablaHC.contains(new Persona_hashCode("11111111","Harry")));
		
		/////// Realizamos la prueba con el TreeSet

		System.out.println("\n*** TREESET ***\n");
		
		Set<Persona> arbol = new TreeSet<>(); 
		
		// Persona no esta definida como Comparable.
		// En este caso, ni siquiera se puede insertar la 2º persona (no conoce el orden en que debería insertarla)
		try {
			arbol.add(new Persona("11111111","Harry"));
		}catch(ClassCastException cce) {
			System.out.println("Lanzada ClassCastException !!!!");
		}
		
		/* Dos opciones:
		 * 
		 *  1.- Facilitar un Comparator al instanciar el TreeSet
		 *  2.- Insertar elementos que implementen Comparable (aunque no se facilite el comparador)
		 */
		
		// Opcion 1 ////////////////////
		Set<Persona> arbolComparador = new TreeSet<>(new Comparator<Persona>(){
			@Override
			public int compare(Persona a, Persona b) {
				return a.getDNI().compareTo(b.getDNI());
			}
		}); 

		try {
			arbolComparador.add(new Persona("11111111","Harry"));
			arbolComparador.add(new Persona("22222222","Hermione"));
			arbolComparador.add(new Persona("33333333","Ron"));
			arbolComparador.add(new Persona("11111111","Harry"));
		}catch(ClassCastException cce) {
			System.out.println("Lanzada ClassCastException !!!!");
		}

		// El Set se comporta de la manera esperada:
		System.out.println(arbolComparador);
		System.out.println("Num. Elem:"+arbolComparador.size());
		System.out.println("Contiene a Harry?: "+arbolComparador.contains(new Persona_hashCode("11111111","Harry")));
		
		// Opcion 2 ////////////////////
		Set<Persona_Comparable> arbolDeComparables = new TreeSet<>(); 

		try {
			arbolDeComparables.add(new Persona_Comparable("11111111","Harry"));
			arbolDeComparables.add(new Persona_Comparable("22222222","Hermione"));
			arbolDeComparables.add(new Persona_Comparable("33333333","Ron"));
			arbolDeComparables.add(new Persona_Comparable("11111111","Harry"));
		}catch(ClassCastException cce) {
			System.out.println("Lanzada ClassCastException !!!!");
		}

		// El Set se comporta de la manera esperada:
		System.out.println(arbolDeComparables);
		System.out.println("Num. Elem:"+arbolDeComparables.size());
		System.out.println("Contiene a Harry?: "+arbolDeComparables.contains(new Persona_Comparable("11111111","Harry")));
		
	}

}
