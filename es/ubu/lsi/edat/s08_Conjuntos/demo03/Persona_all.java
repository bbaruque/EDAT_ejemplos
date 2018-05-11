package es.ubu.lsi.edat.s08_Conjuntos.demo03;

public class Persona_all extends Persona_hashCode implements Comparable<Persona>{

	public Persona_all(String getDNI, String nombre) {
		super(getDNI, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Persona o) {
		return this.getDNI().compareTo(o.getDNI());
	}

	
}
