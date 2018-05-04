package es.ubu.lsi.edat.s08_Conjuntos.demo04;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
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
	private static final int numMediciones = 20;

	private static List<Integer> lista = new LinkedList<>();
	private static Set<Integer> tabla = new HashSet<>();
	private static SortedSet<Integer> arbol = new TreeSet<>();

	public static void main(String[] args) {

		contieneExiste();
		contieneNoExiste();

	}

	/**
	 * Se pretende comparar la complejidad algor�tmica entre realizar una busqueda
	 * por un elemento en:
	 * 
	 * - Lista
	 * - Set implementado como Tabla Hash
	 * - Set implementado como Arbol Binario de Busqueda
	 * 
	 *  Se busca por un elemento que estar� contenido en la colecci�n
	 *  (tiene menos complejidad que el que NO est�)
	 */
	private static void contieneExiste() {

		System.out.println("Busqueda elem SI existe");
		System.out.println("tamano,lista,mapa,arbol");

		for (int i=0; i < tamMax; i = i+(tamMax/numMediciones)) {

			llenaColecciones(i);

			Long iniL = System.nanoTime();
			boolean contenido = lista.contains(i-1);
			Long endL = System.nanoTime();
			assert contenido;

			Long iniT = System.nanoTime();
			contenido = tabla.contains(i-1);
			Long endT = System.nanoTime();
			assert contenido;

			Long iniA = System.nanoTime();
			contenido = arbol.contains(i-1);
			Long endA = System.nanoTime();
			assert contenido;

			System.out.println(i+", "+(endL-iniL)+", "+(endT-iniT)+", "+(endA-iniA));

		}

	}

	/**
	 * Se pretende comparar la complejidad algor�tmica entre realizar una busqueda
	 * por un elemento en:
	 * 
	 * - Lista
	 * - Set implementado como Tabla Hash
	 * - Set implementado como Arbol Binario de Busqueda
	 * 
	 *  Se busca por un elemento que NO estar� contenido en la colecci�n
	 *  (tiene m�s complejidad que el que est�)
	 */
	private static void contieneNoExiste() {
		
		System.out.println("Busqueda elem NO existe");
		System.out.println("tamano,lista,mapa,arbol");

		
		for (int i=0; i < tamMax; i = i+(tamMax/numMediciones)) {

			llenaColecciones(i);

			Long iniL = System.nanoTime();
			boolean contenido = lista.contains(i+50);
			Long endL = System.nanoTime();
			assert (contenido == false);
			
			Long iniT = System.nanoTime();
			contenido = tabla.contains(i+50);
			Long endT = System.nanoTime();
			assert (contenido == false);

			Long iniA = System.nanoTime();
			contenido = arbol.contains(i+50);
			Long endA = System.nanoTime();
			assert (contenido == false);

			System.out.println(i+", "+(endL-iniL)+", "+(endT-iniT)+", "+(endA-iniA));

		}
		
	}

	private static void llenaColecciones (int tamano) {

		lista.clear();
		tabla.clear();
		arbol.clear();

		for(int i=0; i<tamano; i++) {
			lista.add(i);
		}

		Collections.shuffle(lista);

		tabla.addAll(lista);
		arbol.addAll(lista);

		assert tamano == lista.size();
		assert tamano == tabla.size();
		assert tamano == arbol.size();
		
	}
}
