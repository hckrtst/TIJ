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
import java.util.Arrays;


/**
 *
 * @author Sanket K
 */
public class Eratosthenes {
    
    public void sieve(int n) {
        int [] data = new int[n+1];
        
        // Create the initial dataset
        // skip over 0 and 1
        for (int i = 2; i <= n; i++) {
            data[i] = i;
        }
        System.out.println("Our initial list = " + Arrays.toString(data));
        
        int index = 2;
        int candidate;
               
        while(index <= n) {
            System.out.println("Index = " + index);
            candidate = data[index];
            if (0 == candidate) {
                index++;
                continue;
            }
            if(candidate * candidate > (n+1)) {
                System.out.println("Stopping now since all "
                        + "remaining numbers are prime");
                break;
            }
            
            // picked candidate
            System.out.println("candidate = " + candidate);
            int candidate_index = index + candidate;
            System.out.println("Zero out all multiples of " + candidate);
            System.out.println("candidate_index = " + candidate_index);
            
            while ((candidate_index <= n)) {
                if (0 != data[candidate_index]) {
                    data[candidate_index] = 0;
                }
               candidate_index += candidate;
               System.out.println("candidate_index = " + candidate_index);
            }
            index++;                        
        }
        System.out.println("Final = " + Arrays.toString(data));                
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Eratosthenes e = new Eratosthenes();
        e.sieve(30);
        
    }
                
    
}
