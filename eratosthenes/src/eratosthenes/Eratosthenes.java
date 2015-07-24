/*
 * The MIT License
 *
 * Copyright 2015 Sanket K.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eratosthenes;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sanket K
 */
public class Eratosthenes {
    
    /*
    * Pick candidate
    * Start eliminating multiple of candidates until we are at n
    * pick next available candidate
    * rinse and repeat
    */
    public void sieve(int n) {
        ArrayList<Integer> pile = new ArrayList<>();
        // Create a list
        for (int i = 2; i <= n; i++) {
            pile.add(i);
        }
        System.out.println("Our initial list = " + pile);
        
        try {
        Iterator<Integer> it = pile.iterator();
        while (it.hasNext()) {
            Integer cand = it.next();
            System.out.println("cand = " + cand);
            int mult = cand;
            Iterator<Integer> it2 = it;
            while (it2.hasNext()) {
                if ((cand * mult) < n) {
                System.out.println("Remove " + (cand*mult));
                pile.remove(i);
                mult++;
                }
            }
            while ((cand * mult) < n) {
                System.out.println("Remove " + (cand*mult));
                Integer i = new Integer(cand*mult);
                pile.remove(i);
                mult++;
            }            
        }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final = " + pile);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Eratosthenes e = new Eratosthenes();
        e.sieve(20);
    }
                
    
}
