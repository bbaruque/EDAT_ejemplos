package es.ubu.gii.edat.s10_ColaPrioridad.demo01;

import java.util.Collections;
import java.util.PriorityQueue;

public class ColaPrioridadInversaEjemplo {

	public static void main(String[] args) {

		// Se configura la cola de prioridad para conservar el orden inverso (ordenando del mayor al menor)
		PriorityQueue<Character> colaPrioridad_inversa = new PriorityQueue<Character>(Collections.reverseOrder());
		
		for(int i=0; i<10; i++){
			colaPrioridad_inversa.offer( (char) (Math.random()*26 + 'a') );
			System.out.println("Contenido cola: "+ colaPrioridad_inversa);
		}
		
		System.out.println("Contenido cola: "+ colaPrioridad_inversa);
	
		while(!colaPrioridad_inversa.isEmpty()){
			System.out.println("Elem. extraido: " + colaPrioridad_inversa.poll());
			System.out.println("Contenido cola: "+ colaPrioridad_inversa);
		}
		
	}

}
