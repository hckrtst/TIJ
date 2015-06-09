/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtest1;

/**
 *
 * @author sanket
 */
public class StringTest1 {
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = "Jekyll";
        String s2 = "jekyll";
             
        // While this might work it is *not* recommended 
        System.out.println("Using =="); 
        System.out.println("s1 and s2 are " + ((s2 == s1)?"same":"different"));
        System.out.println("Using equals");
        System.out.println("s1 and s2 are " + ((s1.equals(s2))?"same":"different"));
        System.out.println("Using equalsIgnoreCase");
        System.out.println("s1 and s2 are " + ((s1.equalsIgnoreCase(s2))?"same":"different"));
        System.out.println("Using compareTo");
        System.out.println("s1 and s2 are " + ((s1.compareTo(s2) == 0)?"same":"different"));       
    }    
}
/* output
Using ==
s1 and s2 are different
Using equals
s1 and s2 are different
Using equalsIgnoreCase
s1 and s2 are same
Using compareTo
s1 and s2 are different
*/
