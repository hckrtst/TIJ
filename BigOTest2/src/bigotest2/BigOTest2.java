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

import java.util.concurrent.TimeUnit;

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
    
    public void logarithmicTimeSample(int num) {
        System.out.println("Got input = " + num);
        int max = 10000;
        int i = 0;
        while (num > 0) {
            i++;
            num /= 2;
            System.out.println("Step " + i + " value = " + num);            
        }
        System.out.println("Final value = " + num);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        BigOTest2 obj = new BigOTest2();
        //obj.basicBigOComputation();
        obj.logarithmicTimeSample(10);
        obj.logarithmicTimeSample(1000);
        obj.logarithmicTimeSample(10000000);
        obj.logarithmicTimeSample(999999999);
    }
    
}
/*output
run:
Got input = 10
Step 1 value = 5
Step 2 value = 2
Step 3 value = 1
Step 4 value = 0
Final value = 0
Got input = 1000
Step 1 value = 500
Step 2 value = 250
Step 3 value = 125
Step 4 value = 62
Step 5 value = 31
Step 6 value = 15
Step 7 value = 7
Step 8 value = 3
Step 9 value = 1
Step 10 value = 0
Final value = 0
Got input = 10000000
Step 1 value = 5000000
Step 2 value = 2500000
Step 3 value = 1250000
Step 4 value = 625000
Step 5 value = 312500
Step 6 value = 156250
Step 7 value = 78125
Step 8 value = 39062
Step 9 value = 19531
Step 10 value = 9765
Step 11 value = 4882
Step 12 value = 2441
Step 13 value = 1220
Step 14 value = 610
Step 15 value = 305
Step 16 value = 152
Step 17 value = 76
Step 18 value = 38
Step 19 value = 19
Step 20 value = 9
Step 21 value = 4
Step 22 value = 2
Step 23 value = 1
Step 24 value = 0
Final value = 0
Got input = 999999999
Step 1 value = 499999999
Step 2 value = 249999999
Step 3 value = 124999999
Step 4 value = 62499999
Step 5 value = 31249999
Step 6 value = 15624999
Step 7 value = 7812499
Step 8 value = 3906249
Step 9 value = 1953124
Step 10 value = 976562
Step 11 value = 488281
Step 12 value = 244140
Step 13 value = 122070
Step 14 value = 61035
Step 15 value = 30517
Step 16 value = 15258
Step 17 value = 7629
Step 18 value = 3814
Step 19 value = 1907
Step 20 value = 953
Step 21 value = 476
Step 22 value = 238
Step 23 value = 119
Step 24 value = 59
Step 25 value = 29
Step 26 value = 14
Step 27 value = 7
Step 28 value = 3
Step 29 value = 1
Step 30 value = 0
Final value = 0
*/
