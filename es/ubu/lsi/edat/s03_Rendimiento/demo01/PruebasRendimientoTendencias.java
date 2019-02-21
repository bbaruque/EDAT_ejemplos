package es.ubu.lsi.edat.s03_Rendimiento.demo01;

public class PruebasRendimientoTendencias extends PruebasRendimiento {
	
	public static void main(String[] args) {
		
		// Tamaño máximo de la prueba (irá aumentando desde 0  aeste valor)
		int fin = 200;
		
		// Determinamos el tamaño de cada una de las pruebas intermedias
		int incremento = fin/10;

		// Se va aumentando el tamaño del array sobre el que se realizan las pruebas
		for (int i=0; i<=fin; i=i+incremento ) {
			
			System.out.print("\nTamaño del problema,"+i);
			
			int[] A = generaArray(i);
			maximo(A);
			cuadrado(i);

		}
		
	}
	

}
