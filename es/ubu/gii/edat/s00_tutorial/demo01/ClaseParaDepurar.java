package es.ubu.gii.edat.s00_tutorial.demo01;

import java.util.LinkedList;
import java.util.List;

public class ClaseParaDepurar {

	/**
	 * Constructor por defecto de la clase.
	 * Modificado para insertar un mensaje cuando se haya construido.
	 */
	public ClaseParaDepurar() {
		System.out.println("construyendo clase");
	}

	/**
	 * Metodo para sumar los 100 primeros numeros enteros 
	 * 
	 * @return
	 */

	public double echaCuentas() {
		
		double suma;
		List<Double> lista;
		
		lista = new LinkedList<>();
		for (int i = 0; i<100;i++){
			lista.add((double)i);
		}
		suma = 0.0;
		for (Double valor : lista){
			suma +=valor;
		}
		return suma;
	}
}
