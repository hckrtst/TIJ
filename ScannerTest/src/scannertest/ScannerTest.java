/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannertest;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Sanket K<hckrtst@gmail.com>
 */
public class ScannerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String source = "she sells C shells at the sea shore";
        
        System.out.println("Take 1: split on space");
        Scanner s1 = new Scanner(source);
        while (s1.hasNext()) {
            System.out.println("Token = " + s1.next());
        }
        
        System.out.println("\n\nTake 2: split on a pattern");
        s1 = new Scanner(source);
        s1.useDelimiter(Pattern.compile("\\s+s"));
        while (s1.hasNext()) {
            //next() scans for String by default
            // for fun, try to use nextInt instead :)
            System.out.println("Token = " + s1.next());
        }
        
        
        
        
    }
    
}
