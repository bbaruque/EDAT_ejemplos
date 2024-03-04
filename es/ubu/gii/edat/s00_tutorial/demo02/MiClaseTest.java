package es.ubu.gii.edat.s00_tutorial.demo02;

import junit.framework.TestCase;

public class MiClaseTest extends TestCase{

	MiClase myClass = new MiClase();
	
	public void testVerdad() {
		assertTrue("Primer Test. Se esperaba el resultado verdadero",myClass.dimeLaVerdad());
		System.out.println("Primer test superado satisfactoriamente.");
	}
	
	public void testMentira() {
		assertFalse("Segundo Test. Se esperaba el resultado falso",myClass.mienteme());
		System.out.println("Segundo test superado satisfactoriamente.");
	}

	public void testMeEnganaste() {
		assertTrue("Tercer Test. Ha devuelto algo, pero no coincide con lo que queriamos.", myClass.mienteme());
		System.out.println("Tercer test superado satisfactoriamente.");
	}
	
	public void testDameCinco() {
		assertEquals("Cuarto test. Se esperaba un '5' como respuesta.", 5, myClass.highFive());
		System.out.println("Cuarto test superado satisfactoriamente.");
	}
	
	public void testDameSeis() {
		assertEquals("Quinto test. Se esperaba un '6' como respuesta.", 6, myClass.highFive());
		System.out.println("Quinto test superado satisfactoriamente.");
	}
	
	public void testExplota() throws Exception {
		myClass.excepcion();
	}
	
}
