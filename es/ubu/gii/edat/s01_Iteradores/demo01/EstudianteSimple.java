package es.ubu.gii.edat.s01_Iteradores.demo01;

/**
 * Ejemplo de clase definida por el usuario.
 * Como se puede ver en las pruebas, las colecciones 
 * son capaces de almacenar objetos de cualquier clase.
 * 
 * Es importante también que, si se conoce la clase de los
 * objetos que se van a almacenar en una coleccion, se identifiquen
 * en el código empleando la genericidad. (ver IteratorTest01.java)
 * 
 */

class EstudianteSimple {
	
    String name;
    int id;    
        
    public EstudianteSimple( String n, int i )  {
        name = n;
        id = i;
    }

    public String toString( )   {
        return name + " - " + id;
    }
    
}