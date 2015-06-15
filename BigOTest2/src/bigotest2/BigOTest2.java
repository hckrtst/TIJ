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
package bigotest2;

/**
 *
 * @author Sanket K
 */
public class BigOTest2 {

    public void basicBigOComputation() {
        //9 steps below
        int a = 1;
        int b = 34;
        int c = 27;
        int x = 0;
        int y = 0;
        int z = 0;
        int d = 0;
        int e = 0;
        final int N = 20;
        
        // N * 3N = 3N^2 steps
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 3 steps below
                x = i + j;
                y = i * j;
                z = j * j;
            }
        }
        
        // 2N
        for (int k = 0; k < N; k++) {
            d = k * 10 + 100;
            e = y * c;
        }
        
        // TOTAL time = 9 + 3N^2 + 2N
        // if N is large then this will be approx. N^2
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        BigOTest2 obj = new BigOTest2();
        obj.basicBigOComputation();
    }
    
}
