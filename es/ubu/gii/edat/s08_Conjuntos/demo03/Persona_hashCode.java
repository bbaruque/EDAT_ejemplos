package es.ubu.gii.edat.s08_Conjuntos.demo03;

public class Persona_hashCode extends Persona {

	public Persona_hashCode(String dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDNI() == null) ? 0 : getDNI().hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (getDNI() == null) {
			if (other.getDNI() != null)
				return false;
		} else if (!getDNI().equals(other.getDNI()))
			return false;
		return true;
	}

}
