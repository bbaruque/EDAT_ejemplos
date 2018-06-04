package es.ubu.lsi.edat.s08_Conjuntos.demo04;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import es.ubu.lsi.edat.datos.GeneradorFechas_8;

public class BusquedaFechas {

	private static NavigableSet<LocalDateTime> conjuntoFechas = new TreeSet<LocalDateTime>();
	
	public static int iniciaFechas(){
		

		List<LocalDateTime> listaFechas = GeneradorFechas_8.getFechasAleatorias(10);

		// Observar como las fechas se geenran de forma ALEATORIA

		conjuntoFechas.addAll(listaFechas);
		System.out.println(listaFechas);
		
		// Observar como las fechas se almacenan en el conjunto de forma ORDENADA 
		// Se emplea un NavigableSet y las fechas implementan Comparable 
		
		System.out.println(conjuntoFechas);
		return conjuntoFechas.size(); 
		
	}
	
	public static void main(String args[]){

		iniciaFechas();
		
		// Se prueba a buscar sobre una fecha que NO tiene por que estar incluida en el conjunto
		LocalDateTime buscada = GeneradorFechas_8.getFechaAleatoria();
		LocalDateTime anterior = conjuntoFechas.lower(buscada);
		LocalDateTime posterior = conjuntoFechas.higher(buscada);
		
		System.out.println("La fecha inmediatamente anterior a "+buscada+" es: "+anterior);
		System.out.println("La fecha inmediatamente posterior a "+buscada+" es: "+posterior);
		
	}
	
}
