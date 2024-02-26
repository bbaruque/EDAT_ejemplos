package es.ubu.gii.edat.s02a_Comparacion.demo01;

/**
 * Clase que ilustra como se puede convertir una clase propia
 * en una que contenga un orden NATURAL predeterminado.
 * 
 * Para ello debe implementar el interfaz Comparable (incluido en Java)
 * e implementar el metodo CompareTo
 *
 * En este caso, solo se tiene en cuenta el nombre para su ordenacion.
 * 
 * Se puede comparar con la clase SimpleStudent.java de la practica
 * anterior para ver las diferencias.
 * 
 */
public class SimpleStudent implements Comparable<SimpleStudent> {
	
    String name;
    int id;    
        
    public SimpleStudent( String n, int i ) {
        name = n;
        id = i;
    }

    @Override
    public String toString( ) {
        return name + " - " + id;
    }
    
    @Override
    public int compareTo( SimpleStudent other ) {
        return name.compareTo( other.name );
    }

    /* TODO
     * 
     * Para que el ejemplo fuera completamente correcto, se necesitaría
     * que la clase de SimpleStudent redefiniera el método 'equals()' de manera
     * consistente con la comparación. 
     * Es decir, si los objetos de la clase SimpleStudent se ordenan por el atributo
     * 'name', se debería definir que dos objetos de esa clase son iguales si ese
     * mismo atributo es igual. En java se necesitan definir ambas operaciones 
     * (comparación e igualdad).
     * 
     * Sucedería algo similar con el método 'hashCode()'. Se verá en detalle este método
     * más adelante en la asigatura.
     *  
     **/
    
}