package es.ubu.lsi.edat.s06_Mapas.demo02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FreqTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		
		String[] args = {"esto", "es", "una", "prueba",
				"y", "prueba", "de", "que", "funciona",
				"la", "prueba", "es", "que", "funciona"};
		
		Freq.main(args);
		
	}

}
