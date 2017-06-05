package es.ubu.lsi.edat.s00_tutorial.demo02;

/**
 * Clase que permite la prueba del plugin de Moodle
 * para la autocorrecion de practicas en Java.
 * 
 * @author bbaruque
 *
 */
public class MiClase {

	/**
	 * Metodo de prueba.
	 * 
	 * @return Devuelve siempre true
	 */
	public boolean dimeLaVerdad(){
		return true;
	}
	
	/**
	 * Metodo de prueba.
	 * 
	 * @return Devuelve siempre false
	 */
	public boolean mienteme(){
		return false;
	}
	
	/**
	 * Metodo de prueba.
	 * 
	 * @return Devuelve siempre 5
	 */
	public int highFive(){
		return 5;
	}
	
	/**
	 * Metodo de prueba.
	 * 
	 * Lanza siempre una excepcion
	 */
		
	public void excepcion() throws Exception{
		throw new Exception("Esta excepcion se lanza como prueba. Aqui se encontrara el mensaje correspondiente a la pila de excepcion.");
	}
	
	/**
	 * Metodo de prueba.
	 * 
	 * @return sumatorio de los 10 primeros numeros enteros.
	 */
	public int sumatorio(){
		int s = 0;
		for (int i=0; i<10; i++){
			s = s +i;
		}
		return s;
	}
	
	/**
	 * Metodo de prueba.
	 * Permite identificar el caso en el que se introduce codigo duplicado.
	 * 
	 * @return
	 */
	public int sumatorioDuplicado(){
		int s = 0;
		for (int i=0; i<10; i++){
			s = s +i;
		}
		return s;
	}
}
