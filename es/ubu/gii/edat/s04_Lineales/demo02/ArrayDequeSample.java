package es.ubu.gii.edat.s04_Lineales.demo02;
/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
/**
 *ArrayDequeSample.java creates and prints the contents of an ArrayDeque.
 */
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * En esta clase se muestra brevemente un ejemplo de uso del interfaz Deque.
 * En concreto se emplea la clase ArrayDeque.
 *
 */

public class ArrayDequeSample {
	
	
    public static void main(String[] args) {
    	
    	// Instanciación de la clase
        ArrayDeque<String> aDeque = new ArrayDeque<> ();    
 
        // Se insertan 3 elementos por la cabecera: e -> aDeque
        aDeque.addFirst("tea");     
        aDeque.addFirst("milk");
        aDeque.addFirst("coffee");
        
        // Se inserta el último elemento por la cola:aDeque <- e
        aDeque.addLast("sugar");    
 
        // Iteración sobre los contenidos de la lista //
        /* Se puede comprobar que los añadidos por la cabecera, aparecen en la iteración
         * en el orden inverso (FIFO). En ese caso, está actuando igual que haría una PILA.  */
        for( Iterator<String> itr =  aDeque.iterator(); itr.hasNext(); ) {    
            System.out.println(itr.next());    
        }
        System.out.println();

        // Se añaden dos nuevos elementos. El primero por la cabeza, el segundo por la cola.
        aDeque.addFirst("juice");  
        aDeque.addLast("honey");

        // Se comprueba que los últimos insertados, efectivamente, son el primer
        // y el último elemento de la cola.
        System.out.println("First Element : " + aDeque.getFirst());    
        System.out.println("Last Element : " + aDeque.getLast());    

        // Se prueba a eliminar los últimos elementos añadidos.
        /*El método para eliminarlos además devuelve el elemento eliminado
         * De esa forma, se puede obtener el comportamiento de la pila.*/
        System.out.println("First Element(Removed):"+aDeque.removeFirst());  
        System.out.println("Last Element Removed:"+aDeque.removeLast());    
    
        /* Se prueba a realizar la eliminación empleando el método propio
         * de la pila: "pop". Se puede comprobar que el elemento extraido
         * es el que se situaba en la cabecera.*/
        System.out.println("Popped Element : " + aDeque.pop());    
        System.out.println("Size of Array Deque: " + aDeque.size());   

    }
}
