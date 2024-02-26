package es.ubu.gii.edat.s03_Rendimiento.demo01;

public class PruebasRendimiento {

	/**
	 * 
	 * @param A
	 * @return
	 */
	static int maximo(int[] A) {

		// Para llevar la cuenta del numero de operaciones
		int numComp = 0;

		// Bucle extraido de las transparencias de Teoría (Tema 2)
		int maximoActual = 0;

		for (int i=1; i<A.length; i++) {
			numComp++;
			if (A[maximoActual] < A[i]) {
				maximoActual = i;
			}
		}

		System.out.print(",Numero de Comparaciones,"+numComp);

		return maximoActual;

	}

	/**
	 * 
	 * @param n
	 */
	static int cuadrado(int n) {

		// Para llevar la cuenta del numero de operaciones
		// Bucle extraido de las transparencias de Teoría (Tema 2)
		int sum = 0;
		for (int i=1; i<=n; i++)
			for (int j=1; j<=n; j++)
				sum++;

		System.out.print(",Numero de Incrementos,"+sum);

		return sum;
		
	}

	public static void main(String[] args) {

		int tamanoProblema = 5;

		int[] A = generaArray(tamanoProblema);
		
		maximo(A);
		cuadrado(tamanoProblema);

	}

	/**
	 * Metodo auxiliar que genera un array del tamaño pedido con contenido aleatorio.
	 * 
	 * @param tamano
	 * @return
	 */
	protected static int[] generaArray(int tamano) {
		int[] A = new int[tamano];
		for(int i = 0; i < A.length; i++) {
			A[i] = (int)(Math.random()*0+9);
		}
		return A;
	}

}
