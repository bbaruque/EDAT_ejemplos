package es.ubu.lsi.edat.s08_Conjuntos.demo02;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.util.*;

/**
 * En este caso se desea tener 2 conjuntos separados:
 * 
 * Uno para los elementos que están duplicados 
 * (sin importar en numero de veces que lo estén)
 * 
 * Y otro para los elementos que aparezca una única vez
 * 
 */
public class FindDupsSeparated {
    public static void main(String[] args) {
    	
    	// Se instancian cada uno de los conjuntos
        Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();

        // Para cada palabra 
        for (String a : args)
            if (!uniques.add(a)) // Se intenta añadir sobre el conjunto de los unicos
                dups.add(a); // Si no se puede, se añade sobre los duplicados

        // Destructive set-difference
        uniques.removeAll(dups); // Para que el conjunto solo tenga únicos, 
        // habrá que eliminar a todos aquellos que se han insertado en los
        // duplicados (para estar en duplicados, es porque inicialmente
        // estaban en los únicos.

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}
