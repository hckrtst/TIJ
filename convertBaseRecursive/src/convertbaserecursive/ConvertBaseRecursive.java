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
package convertbaserecursive;

/**
 *
 * @author Sanket K
 */
public class ConvertBaseRecursive {
    String [] mapping = {"0", "1", "2" , "3" , "4", "5", "6",
        "7","8","9","A", "B", "C", "D", "E", "F"};
    
    public String toBase(int n, int radix) {
        StringBuilder sb = new StringBuilder();
        
        if (n < radix) {
            return mapping[n];  
        } else {
            sb.append(toBase(n/radix, radix));
            sb.append(n%radix); 
            return sb.toString();
        }        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int a = 280;
        ConvertBaseRecursive c = new ConvertBaseRecursive();
        System.out.println(a + " to bin is " + c.toBase(a, 2));
        
        int b = 877;
        System.out.println(b + " to bin is " + c.toBase(b, 2));
        
        System.out.println(3459 + " to hex is " + c.toBase(3459, 16));
        
        
    }
    
}
