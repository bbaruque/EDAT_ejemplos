package es.ubu.lsi.edat.s04_Lineales.demo01;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUsoColas {

	Deque<Integer> colaArrayEnteros;
	Deque<Integer> colaEnlazadaEnteros;
	Deque<Character> colaArrayCaracteres;
	Deque<Character> colaEnlazadaCaracteres;

	@Before
	public void setUp() throws Exception {

		colaArrayEnteros  = new ArrayDeque<Integer>(10); // Observar diferencia en el constructor
		colaEnlazadaEnteros  = new LinkedList<Integer>();

		colaArrayCaracteres  = new ArrayDeque<Character>(10); // Observar diferencia en el constructor
		colaEnlazadaCaracteres  = new LinkedList<Character>();

	}

	@After
	public void tearDown() throws Exception {
		colaArrayEnteros.clear();
		colaEnlazadaEnteros.clear();
		colaArrayCaracteres.clear();
		colaEnlazadaCaracteres.clear();
	}

	private void rellenaColas(){
		for(int i=0; i<10; i++){
			colaArrayEnteros.offer(i);
			colaEnlazadaEnteros.offer(i);
			colaArrayCaracteres.offer((char)(i+'a'));
			colaEnlazadaCaracteres.offer((char)(i+'a'));

		}
		
		System.out.println(colaArrayEnteros);
		System.out.println(colaEnlazadaEnteros);
		System.out.println(colaArrayCaracteres);
		System.out.println(colaEnlazadaCaracteres);
		
	}

	@Test
	public void testInsercion1() {

		System.out.println("-- testInsercion 1 --");

		// Insertando siempre por el final de la cola
		for(int i=0; i<10; i++){
			colaArrayEnteros.offer(i);
			colaEnlazadaEnteros.offer(i);
			colaArrayCaracteres.offer((char)(i+'a'));
			colaEnlazadaCaracteres.offer((char)(i+'a'));

		}

		System.out.println(colaArrayEnteros);
		System.out.println(colaEnlazadaEnteros);
		System.out.println(colaArrayCaracteres);
		System.out.println(colaEnlazadaCaracteres);
	}
	
	@Test
	public void testInsercion2() {

		System.out.println("-- testInsercion 2 --");

		// Insertando siempre por el principio de la cola
		for(int i=0; i<10; i++){
			colaArrayEnteros.offerFirst(i);
			colaEnlazadaEnteros.offerFirst(i);
			colaArrayCaracteres.offerFirst((char)(i+'a'));
			colaEnlazadaCaracteres.offerFirst((char)(i+'a'));
		}

		// Mismo resultado
		System.out.println(colaArrayEnteros);
		System.out.println(colaEnlazadaEnteros);
		System.out.println(colaArrayCaracteres);
		System.out.println(colaEnlazadaCaracteres);

	}

	@Test
	public void testInsercion3() {

		System.out.println("-- testInsercion 3 --");

		// En este caso siempre se inserta por el final
		for(int i=0; i<10; i++){
			colaArrayEnteros.offerLast(i);
			colaEnlazadaEnteros.offerLast(i);
			colaArrayCaracteres.offerLast((char)(i+'a'));
			colaEnlazadaCaracteres.offerLast((char)(i+'a'));
		}

		System.out.println(colaArrayEnteros);
		System.out.println(colaEnlazadaEnteros);
		System.out.println(colaArrayCaracteres);
		System.out.println(colaEnlazadaCaracteres);

	}

	// Tener en cuenta que NO se permite insertar por otra posicion que no sea
	// la cabeza o la cola.
	// Tampoco se permiten modificar posiciones intermedias

	@Test
	public void testAcceso() {

		System.out.println("-- testAcceso --");

		rellenaColas();

		// Se pueden acceder solamente a las posiciones
		// primera y última de la estructura (útil para implementar pilas o colas)

		// Comprobamos que siempre se accede al mismo elemento (el acceso no modifica la cola)
		for(int i=0; i<3; i++){

			System.out.print(" colaArrayEnteros (cabeza): "+ colaArrayEnteros.element() );
			System.out.print(" - colaArrayEnteros (cabeza): "+ colaArrayEnteros.peek() );
			System.out.print(" - colaEnlazadaEnteros (cabeza): "+ colaEnlazadaEnteros.element() );
			System.out.print(" - colaEnlazadaEnteros (cabeza): "+ colaEnlazadaEnteros.peek() );

			System.out.print(" - colaArrayCaracteres (cabeza): "+ colaArrayCaracteres.element() );
			System.out.print(" - colaArrayCaracteres (cabeza): "+ colaArrayCaracteres.peek() );
			System.out.print(" - colaEnlazadaCaracteres (cabeza): "+ colaEnlazadaCaracteres.element() );
			System.out.print(" - colaEnlazadaCaracteres (cabeza): "+ colaEnlazadaCaracteres.peek() );

			System.out.print("\n");
		}

		// Comprobamos que siempre se accede al mismo elemento (el acceso no modifica la cola)
		for(int i=0; i<3; i++){

			System.out.print(" colaArrayEnteros (cola): "+ colaArrayEnteros.getLast() );
			System.out.print(" - colaArrayEnteros (cola): "+ colaArrayEnteros.peekLast() );
			System.out.print(" - colaEnlazadaEnteros (cola): "+ colaEnlazadaEnteros.getLast() );
			System.out.print(" - colaEnlazadaEnteros (cola): "+ colaEnlazadaEnteros.peekLast() );

			System.out.print(" - colaArrayCaracteres (cola): "+ colaArrayCaracteres.getLast() );
			System.out.print(" - colaArrayCaracteres (cola): "+ colaArrayCaracteres.peekLast() );
			System.out.print(" - colaEnlazadaCaracteres (cola): "+ colaEnlazadaCaracteres.getLast() );
			System.out.print(" - colaEnlazadaCaracteres (cola): "+ colaEnlazadaCaracteres.peekLast() );

			System.out.print("\n");
		}

	}
	
	@Test
	public void testBorrado() {

		System.out.println("-- test Borrado --");

		rellenaColas();
		
		for(int i=0; i<5; i++){
			
			System.out.println("colaArrayEnteros (poll):"+colaArrayEnteros.poll());
			System.out.println("colaArrayEnteros (remove):"+colaArrayEnteros.remove());

			System.out.println("colaEnlazadaEnteros (poll):"+colaEnlazadaEnteros.poll());
			System.out.println("colaEnlazadaEnteros (remove):"+colaEnlazadaEnteros.remove());
			
			System.out.println("colaArrayCaracteres (poll):"+colaArrayCaracteres.poll());
			System.out.println("colaArrayCaracteres (remove):"+colaArrayCaracteres.remove());
			
			System.out.println("colaEnlazadaCaracteres (poll):"+colaEnlazadaCaracteres.poll());
			System.out.println("colaEnlazadaCaracteres (remove):"+colaEnlazadaCaracteres.remove());

			System.out.println(colaArrayEnteros);
			System.out.println(colaEnlazadaEnteros);
			System.out.println(colaArrayCaracteres);
			System.out.println(colaEnlazadaCaracteres);
			
		}
		
	}

	// La principal diferencia entre emplear una nomenclatura u otra en las operaciones
	// sobre las colas (la que hereda de Collection o la propia de las colas) es que
	// un juego de métodos (Collection) lanza una excepción si la operación no es posible 
	// mientra que el otro (Cola) simplemente devuelve un valor especial (null).
	@Test
	public void testValoresEspeciales() {

		// Se trabaja sobre colas VACIAS
		// El acceso no podrá devolver un valor
		
		System.out.println("-- test Valores Especiales --");
		
		try{
			colaArrayEnteros.element();
		}catch(Exception e){
			System.out.println("Acceso a colaArrayEnteros - Lanza: "+e);
		}
		System.out.println("Acceso a colaArrayEnteros - Devuelve: "+colaArrayEnteros.peek());
		
		try{
			colaArrayEnteros.remove();
		}catch(Exception e){
			System.out.println("Borrado en colaArrayEnteros - Lanza: "+e);
		}
		System.out.println("Borrado en colaArrayEnteros - Devuelve: "+colaArrayEnteros.poll());
		
		try{
			colaEnlazadaEnteros.element();
		}catch(Exception e){
			System.out.println("Acceso a colaEnlazadaEnteros - Lanza: "+e);
		}
		System.out.println("Acceso a colaEnlazadaEnteros - Devuelve: "+colaEnlazadaEnteros.peek());
		
		try{
			colaArrayEnteros.remove();
		}catch(Exception e){
			System.out.println("Borrado en colaEnlazadaEnteros - Lanza: "+e);
		}
		System.out.println("Borrado en colaEnlazadaEnteros - Devuelve: "+colaEnlazadaEnteros.poll());
		
	}
	

}
