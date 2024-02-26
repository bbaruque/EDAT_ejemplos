package es.ubu.gii.edat.s06_Mapas.demo03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		String[] args = {"src/es/ubu/lsi/edat/sesion06/demo02/dictionary.txt", "5"};
		Anagrams.main(args);
	}

}
