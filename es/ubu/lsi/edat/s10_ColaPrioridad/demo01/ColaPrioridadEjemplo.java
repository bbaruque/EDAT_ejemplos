package es.ubu.lsi.edat.s10_ColaPrioridad.demo01;

import java.util.PriorityQueue;

public class ColaPrioridadEjemplo {

	public static void main(String[] args) {

		// Se genera una cola de prioridad para almacenar caracteres
		// Al no definir ningún orden específico, se elige el orden alfabético (ascendente)
		PriorityQueue<Character> colaPrioridad = new PriorityQueue<Character>(); 
		
		// Se almacenan elementos aleatorios
		for(int i=0;i<10;i++){
			colaPrioridad.offer( (char) (Math.random()*26 + 'a') );
		}
		
		// Se comprueba que los elementos preservan un cierto orden. 
		// El orden NO es completo, pero el contenido conforma un montículo (el menor está en la cabecera) 
		System.out.println("Contenido cola: "+ colaPrioridad);

		// Se puede comprobar que al ir extrayendo los elementos, 
		// SIEMPRE se extrae el menor elmento que queda contenido.
		// El orden en que se extrae es por tanto el orden alfabético completo
		while(!colaPrioridad.isEmpty()){
			System.out.println("Elem. extraido: " + colaPrioridad.poll());
			// En cada extracción se puede ver como se reorganiza la cola para colocar
			// el menor elemento en la cabeza, para extraerlo en el siguiente paso
			System.out.println("Contenido cola: "+ colaPrioridad);
		}

	}

}
