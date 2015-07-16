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

import java.util.Arrays;

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
        
        return Arrays.toString(collector);
    }
    
    public String divByX() {
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = -45;
        Convert2bin o = new Convert2bin();
        System.out.println("\nResult = " + o.simpleConvert(120));
        System.out.println("\nResult = " + o.simpleConvert(12));
        System.out.println("\nResult = " + o.simpleConvert(2220));     
        
    }    
}
