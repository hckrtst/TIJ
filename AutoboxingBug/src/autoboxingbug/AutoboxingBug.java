/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoboxingbug;

import java.util.Comparator;

/**
 *
 * @author sanket
 */
public class AutoboxingBug {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Example from "Effective Java" by Joshua Bloch
        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return first < second ? -1 : (first == second ? 0 : 1);// there is a bug here!
            }
        };
        System.out.println("Expected value is 0, actual value is... " + naturalOrder.compare(new Integer(42), new Integer(42)));
    }
    
}
/* output
Expected value is 0, actual value is... 1
*/
