package es.ubu.lsi.edat.s08_Conjuntos.demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * @author bbaruque
 *
 */
public class ComplejidadBusqueda {

	private static final int tamMax = 1000000; 
	private static final int numMediciones = 10;

	private static List<Integer> lista = new ArrayList<>();
	private static Set<Integer> tabla = new HashSet<>();
	private static SortedSet<Integer> arbol = new TreeSet<>();

	public static void main(String[] args) {

		contieneExiste();
		contieneNoExiste();

	}

	/**
	 * Se pretende comparar la complejidad algorítmica entre realizar una busqueda
	 * por un elemento en:
	 * 
	 * - Lista
	 * - Set implementado como Tabla Hash
	 * - Set implementado como Arbol Binario de Busqueda
	 * 
	 *  Se busca por un elemento que estará contenido en la colección
	 *  (tiene menos complejidad que el que NO está)
	 */
	private static void contieneExiste() {

		System.out.println("Busqueda elem SÍ existe");
		System.out.println("Tamaño,lista,mapa,arbol");

		for (int i=0; i < tamMax; i = i+(tamMax/numMediciones)) {

			llenaColecciones(i);

			Long iniL = System.nanoTime();
			lista.contains(i-1);
			Long endL = System.nanoTime();

			Long iniT = System.nanoTime();
			tabla.contains(i-1);
			Long endT = System.nanoTime();

			Long iniA = System.nanoTime();
			arbol.contains(i-1);
			Long endA = System.nanoTime();

			System.out.println(i+", "+(endL-iniL)+", "+(endT-iniT)+", "+(endA-iniA));

		}

	}

	/**
	 * Se pretende comparar la complejidad algorítmica entre realizar una busqueda
	 * por un elemento en:
	 * 
	 * - Lista
	 * - Set implementado como Tabla Hash
	 * - Set implementado como Arbol Binario de Busqueda
	 * 
	 *  Se busca por un elemento que NO estará contenido en la colección
	 *  (tiene más complejidad que el que está)
	 */
	private static void contieneNoExiste() {
		
		System.out.println("Busqueda elem NO existe");
		System.out.println("Tamaño,lista,mapa,arbol");

		
		for (int i=0; i < tamMax; i = i+(tamMax/numMediciones)) {

			llenaColecciones(i);

			Long iniL = System.nanoTime();
			lista.contains(i+50);
			Long endL = System.nanoTime();

			Long iniT = System.nanoTime();
			tabla.contains(i+50);
			Long endT = System.nanoTime();

			Long iniA = System.nanoTime();
			arbol.contains(i+50);
			Long endA = System.nanoTime();

			System.out.println(i+", "+(endL-iniL)+", "+(endT-iniT)+", "+(endA-iniA));

		}
		
	}

	private static void llenaColecciones (int tamaño) {

		lista.clear();
		tabla.clear();
		arbol.clear();

		for(int i=0; i<tamaño; i++) {
			lista.add(i);
		}

		Collections.shuffle(lista);

		tabla.addAll(lista);
		arbol.addAll(lista);

	}
}
