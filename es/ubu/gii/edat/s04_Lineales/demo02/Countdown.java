package es.ubu.gii.edat.s04_Lineales.demo02;

import java.util.*;

/**
 * El siguiente ejemplo ha sido obtenido del Java Collections Framework Trail (Oracle).
 * 
 * En el siguiente programa de ejemplo, se emplea una cola para implementar un reloj de cuenta atrás.
 * Se cargan en la cola todos los valores enteros desde el numero especificado por parámetro en la 
 * ejecución del programa hasta 0. Después los valores son extraidos de la cola (y se imprimen en pantalla)
 * en intervalos de 1 segundo.
 * 
 * El programa es artificial en el sentido de que se podría programar el mismo comportamiento sin
 * necesidad de emplear una cola, pero permite ilustrar el uso de una cola como almacenamiento
 * temporal de elementos a la espera de ser procesados.
 * 
 **/

 /**  
 * In the following example program, a queue is used to implement a countdown timer. 
 * The queue is preloaded with all the integer values from a number specified on the 
 * command line to zero, in descending order. Then, the values are removed from the 
 * queue and printed at one-second intervals. 
 * 
 * The program is artificial in that it would be more natural to do the same thing 
 * without using a queue, but it illustrates the use of a queue to store elements prior 
 * to subsequent processing.
 * 
 */

public class Countdown {
    public static void main(String[] args) throws InterruptedException {
        int time = Integer.parseInt(args[0]);
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = time; i >= 0; i--)
            queue.add(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }
    }
}