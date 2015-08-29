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
package convert2bin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sanket K
 */
public class Convert2bin {
    
    /*
    * Limitation: does not work for negatives yet
    * Does not scale easily for conversion to another base
    */
    public String simpleConvert(int input) {
        if (input < 0) {
            return null;
        }
        long t1 = System.nanoTime();
        // Assume max size is 32
        int size = 32;
        int step = 1;
        int [] collector = new int[size];
        
        while (size > 0) {
            int t = ((input & step) != 0)?1:0;
            System.out.print(t + " ");
            step = step * 2;
            size--;
            collector[size] = t;
        }
        System.out.println("Done in " + (System.nanoTime() - t1) + " nano seconds");
        return Arrays.toString(collector);
    }
    
    public String divByX(int input, int radix) {
        if (input < 0) {
            return null;
        }
        long t1 = System.nanoTime();
        List collector = new ArrayList();
        int quotient = input;
        int remainder = 0;
        while (quotient > 0) {
            remainder = quotient % radix;
            quotient = quotient / radix;
            collector.add(remainder);
        }
        
        Collections.reverse(collector);
        System.out.println("Done in " + (System.nanoTime() - t1) + " nano seconds");
        return (Arrays.toString(collector.toArray()));        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = -45;
        Convert2bin o = new Convert2bin();
        System.out.println("Method 1: brute force conversion");
        System.out.println("\nResult = " + o.simpleConvert(120));
        System.out.println("\nResult = " + o.simpleConvert(12));
        System.out.println("\nResult = " + o.simpleConvert(2220));
        
        System.out.println("Method2: divide by radix");
        System.out.println("\nResult = " + o.divByX(120, 2));
        System.out.println("\nResult = " + o.divByX(12, 2));
        System.out.println("\nResult = " + o.divByX(2220, 2));
        
        System.out.println("\nResult = " + o.divByX(120, 3));
        System.out.println("\nResult = " + o.divByX(12, 3));
        System.out.println("\nResult = " + o.divByX(2220, 3));
        
        
    }    
}
