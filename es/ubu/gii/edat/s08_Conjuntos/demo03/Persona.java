package es.ubu.gii.edat.s08_Conjuntos.demo03;

public class Persona {

	private String DNI;
	private String Nombre;
	
	public Persona (String dni, String nombre) {
		
		this.DNI = dni;
		this.Nombre = nombre;
		
	}
	
	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", Nombre=" + Nombre + "]";
	}
	
}
