/*
 The MIT License (MIT)

Copyright (c) 2015 Sanket Khidkikar

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package anagramtester;

import java.util.Scanner;

/**
 *
 * @author Sanket K
 */
public class AnagramTester {

    /*
    * Test if two strings have the same letters
    * @param first String
    * @param second String
    * @return boolean
    */
    private static boolean performFreqAnalysis(String first, String second) {
        
        return false;
    }
   
    /*
    compare two strings
    @param first String
    @param second String
    */
    public static boolean check(String first, String second) {
        // first check if they are the same length
        // This should be a O(1)
        if (first.length() == second.length()) {
            // check if equal
            // this should be O(first.lenth + second.length)
            if (first.equals(second)) {
                return true;
            }            
        } else {
            return performFreqAnalysis(first, second);
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is the first string? ");
        String first = scan.nextLine();
        System.out.println("");
        System.out.println("You entered : " + first);
        
        System.out.print("What is the second string? ");
        String second = scan.nextLine();
        System.out.println("");
        System.out.println("You entered : " + second);
        
        System.out.println("Checking if the strings are anagrams");
        System.out.println(" The result is : " + 
                AnagramTester.check(first, second));
        
    }
    
}
