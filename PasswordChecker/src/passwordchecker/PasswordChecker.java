/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordchecker;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Sanket K<hckrtst@gmail.com>
 */
public class PasswordChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console cons;
        cons = System.console();
        if (cons != null) {
            char[] passwd = null;
            try {
                passwd = cons.readPassword("Enter secret password:");
                System.out.println("Password entered :" + new String(passwd));
            } finally {
                // shred password from memory
                if (passwd != null) {
                    Arrays.fill(passwd, ' ');
                }                                
            }
            
        } else {
            System.out.println("No console");
        }
    }
    
}
