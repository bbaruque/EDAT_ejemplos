package es.ubu.lsi.edat.s03_Rendimiento.demo01;

public class PruebasRendimiento {

	/**
	 * 
	 * @param A
	 * @return
	 */
	static int maximo(int[] A) {

		// Para probar numero de operaciones
		int numComp = 0;

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
