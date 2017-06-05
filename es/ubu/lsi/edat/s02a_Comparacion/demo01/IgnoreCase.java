package es.ubu.lsi.edat.s02a_Comparacion.demo01;

import java.util.Comparator;

/**
 * Illustrates use of Comparator for ignoring case distinctions.
 */
public class IgnoreCase implements Comparator<String> {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare( String s1, String s2 ) {
        return s1.compareToIgnoreCase( s2 );
    }
	
}
