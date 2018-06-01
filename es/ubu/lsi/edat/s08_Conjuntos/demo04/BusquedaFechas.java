package es.ubu.lsi.edat.s08_Conjuntos.demo04;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.TreeSet;
import es.ubu.lsi.edat.datos.GeneradorFechas_8;

public class BusquedaFechas {

	private static NavigableSet<LocalDateTime> conjuntoFechas = new TreeSet<>();
	
	public static int iniciaFechas(){
		
		conjuntoFechas.addAll(GeneradorFechas_8.getFechasAleatorias(10));
		
		// Observar como las fechas se devuelven de forma ORDENADA 
		// Se emplea un NavigableSet y las fechas implementan Comparable 
		
		System.out.println(conjuntoFechas);
		return conjuntoFechas.size(); 
		
	}
	
	public static void main(String args[]){
		iniciaFechas();
		
		LocalDateTime buscada = GeneradorFechas_8.getFechaAleatoria();
		LocalDateTime anterior = conjuntoFechas.lower(buscada);
		LocalDateTime posterior = conjuntoFechas.higher(buscada);
		
		System.out.println("La fecha inmediatamente anterior a "+buscada+" es: "+anterior);
		System.out.println("La fecha inmediatamente posterior a "+buscada+" es: "+posterior);
	}
	
}
