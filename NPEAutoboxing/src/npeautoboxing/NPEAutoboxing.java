/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npeautoboxing;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanket
 */
public class NPEAutoboxing {
    static Integer i;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Now watch some magic...");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException ex) {
            Logger.getLogger(NPEAutoboxing.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ready?");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException ex) {
            Logger.getLogger(NPEAutoboxing.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i == 42) {
            System.out.println("This is boring...nothing happened");
        }
    }
    
}
/* output
Now watch some magic...
Ready?
Exception in thread "main" java.lang.NullPointerException
	at npeautoboxing.NPEAutoboxing.main(NPEAutoboxing.java:34)
Java Result: 1
*/
