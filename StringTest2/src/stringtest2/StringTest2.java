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
package stringtest2;

/**
 *
 * @author Sanket K
 */
public class StringTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String src = " This is crazy\n"
                + "This is a practice string";
        
        // Basic StringBuilder tests
        String s = null;
        StringBuilder sb = new StringBuilder();
        sb.append("Tintin met with ");
        sb.append("\n Calculus at the bell tower. \n"
        );
        
        // The java docs say that NullPointerException should be thrown
        // but it looks like the implementation handles it
        sb.append(s);
        
        sb.append("\n The beginning of the number is: ");
        
        // We can append a float as well
        sb.append(23.45);
        
        System.out.println(sb.toString());
        
        // We can use format strings to print 
        System.out.printf("PI is %2.2f\n", 3.14159);                
    }
    
}
