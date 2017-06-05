package es.ubu.lsi.edat.s08_Conjuntos.demo01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class OperacionesConjunto {

	List<Integer> lista = (List<Integer>) Arrays.asList(1,2,3,4,5,6,6,6,7,8,1,9);
	List<Integer> listaSub = (List<Integer>) Arrays.asList(1,2,6,6,9,9);
	
	@Test
	public void pruebaInsercion(){
		
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.addAll(lista);
		System.out.println("lista: "+lista);
		System.out.println("conjunto: "+conjunto);
		
	}
	
	@Test
	public void pruebaUnion(){
		
		System.out.println("-- Prueba union --");
		
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.addAll(lista);
		
		System.out.println("conjunto: "+conjunto);
		conjunto.addAll(listaSub);
		System.out.println("conjunto + listaSub: "+conjunto);
		
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.addAll(lista);

		System.out.println("lista2: "+lista2);
		lista2.addAll(listaSub);
		System.out.println("lista2 + listaSub: "+lista2);
		
	}
	
	@Test
	public void pruebaDiferencia(){
				
		System.out.println("-- Prueba diferencia --");
		
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.addAll(lista);
		
		System.out.println("conjunto: "+conjunto);
		conjunto.removeAll(listaSub);
		System.out.println("conjunto - listaSub: "+conjunto);
		
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.addAll(lista);

		System.out.println("lista2: "+lista2);
		lista2.removeAll(listaSub);
		System.out.println("lista2 - listaSub: "+lista2);
		
	}

	@Test
	public void pruebaInterseccion(){
				
		System.out.println("-- Prueba interseccion --");
		
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.addAll(lista);
		
		System.out.println("conjunto: "+conjunto);
		conjunto.retainAll(listaSub);
		System.out.println("conjunto intersec. listaSub: "+conjunto);
		
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.addAll(lista);

		System.out.println("lista2: "+lista2);
		lista2.retainAll(listaSub);
		System.out.println("lista2 intersec. listaSub: "+lista2);
		
	}
	
}
