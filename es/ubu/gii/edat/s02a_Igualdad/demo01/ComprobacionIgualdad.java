package es.ubu.gii.edat.s02a_Igualdad.demo01;

import es.ubu.gii.edat.s02a_Comparacion.demo01.SimpleStudent;

public class ComprobacionIgualdad {

	public static void main(String[] args) {
		
		int entero1, entero2;
		char caracter1, caracter2;
		String cadena1, cadena2;
		
		/* Igualdad del mismo objeto (apuntan ambos a la misma dirección de memoria) */
		entero1 = entero2 = 25;
		caracter1 = caracter2 = 'c';
		cadena1 = cadena2 = "hello, friend";

		System.out.println("Igualdad entre enteros: " + (entero1 == entero2));
		System.out.println("Igualdad entre caracteres: " + (caracter1 == caracter2));
		System.out.println("Igualdad entre cadenas: " + (cadena1 == cadena2));

		/* Igualdad de objetos (apuntan diferentes direcciones de memoria) */
		entero1 = 25;
		entero2 = 25;
		caracter1 = 'c';
		caracter2 = 'c';
		cadena1 = new String("hello, friend");
		cadena2 = new String("hello, friend");
		
		System.out.println("Igualdad entre enteros: " + (entero1 == entero2));
		System.out.println("Igualdad entre caracteres: " + (caracter1 == caracter2));
		System.out.println("Igualdad entre cadenas (con ==): " + (cadena1 == cadena2));	
		
		System.out.println("Igualdad entre cadenas (con equals): " + (cadena1.equals(cadena2)));
		
		/* Comparación de objetos */
		
		// Comprobar que esta linea da como resultado un error de compilación
//		System.out.println("Comparación entre cadenas: " + (cadena1 < cadena2));	
		System.out.println("Comparación entre cadenas: " + (cadena1.compareTo(cadena2)));
	
		
		SimpleStudent estudiante1 = new SimpleStudent("Bob",1);
		SimpleStudent estudiante2 = new SimpleStudent("Bob",1);
		
		System.out.println("Igualdad entre estudiantes (con ==): "+(estudiante1 == estudiante2));
		System.out.println("Igualdad entre estudiantes (con equals): "+(estudiante1.equals(estudiante2)));
		
	}

}
