package es.ubu.lsi.edat.s04_Lineales.demo01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

public class UsoListasTest {

	List<Integer> listaArrayEnteros;
	List<Integer> listaEnlazadaEnteros;
	List<Character> listaArrayCaracteres;
	List<Character> listaEnlazadaCaracteres;

	@Before
	public void setUp() throws Exception {

		listaArrayEnteros  = new ArrayList<Integer>(10); // Observar diferencia en el constructor
		listaEnlazadaEnteros  = new LinkedList<Integer>();

		listaArrayCaracteres  = new ArrayList<Character>(10); // Observar diferencia en el constructor
		listaEnlazadaCaracteres  = new LinkedList<Character>();

	}

	@After
	public void tearDown() throws Exception {
		listaArrayEnteros.clear();
		listaEnlazadaEnteros.clear();
		listaArrayCaracteres.clear();
		listaEnlazadaCaracteres.clear();
	}

	private void rellenaListas(){
		for(int i=0; i<10; i++){
			listaArrayEnteros.add(i);
			listaEnlazadaEnteros.add(i);
			listaArrayCaracteres.add((char)(i+'a'));
			listaEnlazadaCaracteres.add((char)(i+'a'));

		}
		
		System.out.println(listaArrayEnteros);
		System.out.println(listaEnlazadaEnteros);
		System.out.println(listaArrayCaracteres);
		System.out.println(listaEnlazadaCaracteres);
		
		
	}

	@Test
	public void testInsercion1() {

		System.out.println("-- testInsercion 1 --");

		// Insertando siempre por el final de la lista
		for(int i=0; i<10; i++){
			listaArrayEnteros.add(i);
			listaEnlazadaEnteros.add(i);
			listaArrayCaracteres.add((char)(i+'a'));
			listaEnlazadaCaracteres.add((char)(i+'a'));

		}

		System.out.println(listaArrayEnteros);
		System.out.println(listaEnlazadaEnteros);
		System.out.println(listaArrayCaracteres);
		System.out.println(listaEnlazadaCaracteres);
		
	}
	
	@Test
	public void testInsercion2() {

		System.out.println("-- testInsercion 2 --");

		// Indicando en que punto insertar
		// En este caso siempre se inserta por el inicio (pila)
		for(int i=0; i<10; i++){
			listaArrayEnteros.add(0, i);
			listaEnlazadaEnteros.add(0, i);
			listaArrayCaracteres.add(0, (char)(i+'a'));
			listaEnlazadaCaracteres.add(0, (char)(i+'a'));
		}

		System.out.println(listaArrayEnteros);
		System.out.println(listaEnlazadaEnteros);
		System.out.println(listaArrayCaracteres);
		System.out.println(listaEnlazadaCaracteres);
		
	}

	@Test
	public void testInsercion3() {

		System.out.println("-- test Insercion 3 --");

		rellenaListas();

		// Indicando en que punto insertar
		// En este caso siempre se inserta por el centro
		for(int i=0; i<10; i++){
			listaArrayEnteros.add(5, i);
			listaEnlazadaEnteros.add(5, i);
			listaArrayCaracteres.add(5, (char)(i+'a'));
			listaEnlazadaCaracteres.add(5, (char)(i+'a'));
		}

		System.out.println(listaArrayEnteros);
		System.out.println(listaEnlazadaEnteros);
		System.out.println(listaArrayCaracteres);
		System.out.println(listaEnlazadaCaracteres);
		
	}

	@Test
	public void testModificacion() {

		System.out.println("-- testModificacion --");

		rellenaListas();

		// Indicando en que punto se modifica
		// En este caso siempre se modifica la misma posicion
		for(int i=0; i<10; i++){
			listaArrayEnteros.set(5, i);
			listaEnlazadaEnteros.set(5, i);
			listaArrayCaracteres.set(5, (char)(i+'a'));
			listaEnlazadaCaracteres.set(5, (char)(i+'a'));
		}

		// Observese la diferencia con testInsercion3()
		System.out.println(listaArrayEnteros);
		System.out.println(listaEnlazadaEnteros);
		System.out.println(listaArrayCaracteres);
		System.out.println(listaEnlazadaCaracteres);
		
	}

	@Test
	public void testAcceso() {

		System.out.println("-- testAcceso --");

		rellenaListas();

		// Se pueden acceder a los elementos de la colección por el indice
		// empleado al insertarlos (no se podrá en todas las colecciones)
		for(int i=0; i<10; i++){
			int pos = (int) (Math.random()*10);
			System.out.print("pos: "+pos);
			System.out.print(" - listaArrayEnteros: "+ listaArrayEnteros.get(pos) );
			System.out.print(" - listaEnlazadaEnteros: "+ listaEnlazadaEnteros.get(pos) );
			System.out.print(" - listaArrayCaracteres: "+ listaArrayCaracteres.get(pos) );
			System.out.print(" - listaEnlazadaCaracteres: "+ listaEnlazadaCaracteres.get(pos) );
			System.out.print("\n");
			
		}

	}
	
	
	@Test
	public void testEliminacion() {

		System.out.println("-- testEliminacion --");

		rellenaListas();

		for(int i=0; i<10; i++){
			
			System.out.println(listaArrayEnteros);
			System.out.println(listaEnlazadaEnteros);
			System.out.println(listaArrayCaracteres);
			System.out.println(listaEnlazadaCaracteres);
			
			// Se elimina indicando la POSICION a eliminar
			// Se puede combinar con el metodo indexOf() para pedir eliminar un elemento (ver testCombinaciones())
			// El método remove() devuelve el objeto eliminado
			int pos = (int) (Math.random()*listaArrayEnteros.size());
			System.out.print("pos: "+pos);
			System.out.print(" - listaArrayEnteros: "+ listaArrayEnteros.remove(pos) );
			System.out.print(" - listaEnlazadaEnteros: "+ listaEnlazadaEnteros.remove(pos) );
			System.out.print(" - listaArrayCaracteres: "+ listaArrayCaracteres.remove(pos) );
			System.out.print(" - listaEnlazadaCaracteres: "+ listaEnlazadaCaracteres.remove(pos) );
			System.out.print("\n");
		}

		// El eliminar de una posición inexistente devuelve una excepcion
		try{
			listaArrayEnteros.remove(0);
		}catch(IndexOutOfBoundsException iob){
			System.out.println("Lanzado IndexOutOfBoundsException");
			
		}
		
		
		
	}
	
	@Test
	public void testBusquedaPosicion() {

		System.out.println("-- testBusqueda --");

		testInsercion3();
		
		// Se permite buscar por contenido para obtener su posicion
		// Es una operación POCO EFICIENTE ya que debe recorrer la estructura entera
		for(int i=0; i<5; i++){
			
			int elem = (int) (Math.random()*listaArrayEnteros.size());
			System.out.print(" elem: "+elem + " (primera aparicion)");
			System.out.print(" - listaArrayEnteros: "+ listaArrayEnteros.indexOf(elem) );
			System.out.print(" - listaEnlazadaEnteros: "+ listaEnlazadaEnteros.indexOf(elem) );
			
			// Se busca por ELEMENTO y devuelve su POSICION
			System.out.print(" elem: "+(elem+'a')+ " (primera aparicion)");
			System.out.print(" - listaArrayCaracteres: "+ listaArrayCaracteres.indexOf(elem+'a') );
			System.out.print(" - listaEnlazadaCaracteres: "+ listaEnlazadaCaracteres.indexOf(elem+'a') );
			System.out.print("\n");
			
			
			System.out.print(" elem: "+elem + " (ultima aparicion)");
			System.out.print(" - listaArrayEnteros: "+ listaArrayEnteros.lastIndexOf(elem) );
			System.out.print(" - listaEnlazadaEnteros: "+ listaEnlazadaEnteros.lastIndexOf(elem) );

			// Se busca por ELEMENTO y devuelve su POSICION
			System.out.print(" elem: "+(elem+'a')+ " (primera aparicion)");
			System.out.print(" - listaArrayCaracteres: "+ listaArrayCaracteres.lastIndexOf(elem+'a') );
			System.out.print(" - listaEnlazadaCaracteres: "+ listaEnlazadaCaracteres.lastIndexOf(elem+'a') );
			System.out.print("\n");
		}

	}	
	
	@Test
	public void testSublistas() {

		System.out.println("-- testSublistas --");

		rellenaListas();

		// Las sublistas se definen exactamente como una lista
		// No se modifica el contenido de la lista inicial
		List<Integer> sublAE = listaArrayEnteros.subList(0, 5);
		List<Integer> sublEE = listaEnlazadaEnteros.subList(0, 5);
		List<Character> sublAC = listaArrayCaracteres.subList(0, 5);
		List<Character> sublEC = listaEnlazadaCaracteres.subList(0, 5);
		
		System.out.println(sublAE);
		System.out.println(sublEE);
		System.out.println(sublAC);
		System.out.println(sublEC);

		// ¡CUIDADO! Si se modifica la lista inicial, se modifica la sublista 
		// (es una VISTA sobre la lista inicial, no son colecciones independientes)
		
		listaArrayEnteros.set(2, 666);
		listaEnlazadaEnteros.set(2, 666);
		listaArrayCaracteres.set(2, 'X');
		listaEnlazadaCaracteres.set(2, 'X');

		System.out.println(sublAE);
		System.out.println(sublEE);
		System.out.println(sublAC);
		System.out.println(sublEC);
		
		// Viceversa también se cumple: ver el metodo testCombinaciones()
	}
	
	@Test
	public void testListIterator() {

		System.out.println("-- testListIterator --");

		rellenaListas();

		// Se contruye un iterador que se inicia en la ultima posicion de la lista
		ListIterator <Integer> itAE = listaArrayEnteros.listIterator(listaArrayEnteros.size());
		while(itAE.hasPrevious()){
			System.out.print(itAE.previous());
		}
		System.out.print("\n");

		// Se contruye un iterador que se inicia en la ultima posicion de la lista
		ListIterator <Integer> itEE = listaEnlazadaEnteros.listIterator(listaArrayEnteros.size());
		while(itEE.hasPrevious()){
			System.out.print(itEE.previous());
		}
		System.out.print("\n");
		
		// Se contruye un iterador que se inicia en la ultima posicion de la lista
		ListIterator <Character> itAC = listaArrayCaracteres.listIterator(listaArrayEnteros.size());
		while(itAC.hasPrevious()){
			System.out.print(itAC.previous());
		}
		System.out.print("\n");
		
		// Se contruye un iterador que se inicia en la ultima posicion de la lista
		ListIterator <Character> itEC = listaEnlazadaCaracteres.listIterator(listaArrayEnteros.size());
		while(itEC.hasPrevious()){
			System.out.print(itEC.previous());
		}
		System.out.print("\n");
		
	}
	
	// TODO - comprobar el funcionamiento de add() y remove() de ListIterator
	
	@Test
	public void testCombinaciones() {
		
		System.out.println("-- test Combinaciones --");

		rellenaListas();
		
		// Borrado de un elemento del que no conocemos la posicion por adelantado
		listaEnlazadaCaracteres.remove(listaEnlazadaCaracteres.indexOf('f'));
		System.out.println("Borrado de la f: "+listaEnlazadaCaracteres);

		// Borrado de una sublista dento de nuestra sublista		
		listaArrayCaracteres.subList(2, 4).clear();
		System.out.println("Borrado de la pos 2 (incluido) a 4 (excluido): " + listaArrayCaracteres);
		
		// Sublista entre dos elementos de los que no conocemos la posicion por adelantado
		List<Character> subl = listaArrayCaracteres.subList(listaArrayCaracteres.indexOf('f'), listaArrayCaracteres.indexOf('i'));
		System.out.println("Sublista entre f (incluido) e i (excluido): "+subl);
		
	}

}
