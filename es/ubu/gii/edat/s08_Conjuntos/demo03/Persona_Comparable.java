package es.ubu.gii.edat.s08_Conjuntos.demo03;

public class Persona_Comparable 
extends Persona
implements Comparable<Persona>{

	public Persona_Comparable(String dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}

	// Las personas serán comparables por su DNI
	@Override
	public int compareTo(Persona o) {
		return this.getDNI().compareTo(o.getDNI());
	}

}
