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
package recurse1;

/**
 *
 * @author Sanket K
 */
public class Recurse1 {
    
    // This is buggy, will cause inifinite recusrion on even numbers
    public static int productBuggy(int n)
    {
        //System.out.println("call productBuggy(" + n + ")");
        if(n == 1) {
            //System.out.println("return 1");
            return 1;
        }            
        else {
            return n * productBuggy(n - 2);
        }
    }
    
    public static int factorialInt(int n)
    {
        System.out.println("call factorialInt(" + n + ")");
        if(n == 0) {
            System.out.println("return 1");
            return 1;
        }            
        else {
            
            int out =  n * factorialInt(n - 1);
            System.out.println("Got result = " + out);
            return out;
        }
    }
    
    public static long factorialLong(int n)
    {
        System.out.println("call factorialLong(" + n + ")");
        if(n == 0) {
            System.out.println("return 1");
            return 1;
        }            
        else {
            
            long out =  n * factorialLong(n - 1);
            System.out.println("Got result = " + out);
            return out;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // This will cause the numbers to keep going in the negative direction
        // eventually we hit an output error
        /*
        call productBuggy(-7528)
	at java.nio.charset.CharsetEncoder.encode(CharsetEncoder.java:579)
	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:271)
	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
	at java.io.PrintStream.write(PrintStream.java:526)
	at java.io.PrintStream.print(PrintStream.java:669)
	at java.io.PrintStream.println(PrintStream.java:806)
	at recurse1.Recurse1.productBuggy(Recurse1.java:35)
        */
        // If we remove the print statements we eventually hit a stack overflow
        /*
        Exception in thread "main" java.lang.StackOverflowError
	at recurse1.Recurse1.productBuggy(Recurse1.java:41)
	at recurse1.Recurse1.productBuggy(Recurse1.java:41)
        */
        //System.out.println("Product is " + Recurse1.productBuggy(6));
        
        // This causes us to get 0 because the numbers get too big
        /*
        call factorialInt(3)
        call factorialInt(2)
        call factorialInt(1)
        call factorialInt(0)
        return 1
        Got result = 1
        Got result = 2
        Got result = 6
        Got result = 24
        Got result = 120
        Got result = 720
        Got result = 5040
        Got result = 40320
        Got result = 362880
        Got result = 3628800
        Got result = 39916800
        Got result = 479001600
        Got result = 1932053504
        Got result = 1278945280
        Got result = 2004310016
        Got result = 2004189184
        Got result = -288522240
        Got result = -898433024
        Got result = 109641728
        Got result = -2102132736
        Got result = -1195114496
        Got result = -522715136
        Got result = 862453760
        Got result = -775946240
        Got result = 2076180480
        Got result = -1853882368
        Got result = 1484783616
        Got result = -1375731712
        Got result = -1241513984
        Got result = 1409286144
        Got result = 738197504
        Got result = -2147483648
        Got result = -2147483648
        Got result = 0
        Got result = 0
        */
        System.out.println("Factorial of 600 is " + Recurse1.factorialInt(600));
        
        //Same function works well here
        /*
        call factorialInt(6)
        call factorialInt(5)
        call factorialInt(4)
        call factorialInt(3)
        call factorialInt(2)
        call factorialInt(1)
        call factorialInt(0)
        return 1
        Got result = 1
        Got result = 2
        Got result = 6
        Got result = 24
        Got result = 120
        Got result = 720
        Factorial is 720
        */
        System.out.println("Factorial is " + Recurse1.factorialInt(6));
        
        // Large numbers cause the system out to misbehave
        /*
        call factorialInt(56572)
	at java.io.PrintStream.write(PrintStream.java:526)
	at java.io.PrintStream.print(PrintStream.java:669)
	at java.io.PrintStream.println(PrintStream.java:806)
	at recurse1.Recurse1.factorialInt(Recurse1.java:47)
        */
        
        //System.out.println("Factorial is " + Recurse1.factorialInt(60000));
        
        
        // This is still not possible recusively
        /*
        call factorialLong(1)
            call factorialLong(0)
            return 1
            Got result = 1
            Got result = 2
            Got result = 6
            Got result = 24
            Got result = 120
            Got result = 720
            Got result = 5040
            Got result = 40320
            Got result = 362880
            Got result = 3628800
            Got result = 39916800
            Got result = 479001600
            Got result = 6227020800
            Got result = 87178291200
            Got result = 1307674368000
            Got result = 20922789888000
            Got result = 355687428096000
            Got result = 6402373705728000
            Got result = 121645100408832000
            Got result = 2432902008176640000
            Got result = -4249290049419214848
            Got result = -1250660718674968576
            Got result = 8128291617894825984
            Got result = -7835185981329244160
            Got result = 7034535277573963776
            Got result = -1569523520172457984
            Got result = -5483646897237262336
            Got result = -5968160532966932480
            Got result = -7055958792655077376
            Got result = -8764578968847253504
            Got result = 4999213071378415616
            Got result = -6045878379276664832
            Got result = 3400198294675128320
            Got result = 4926277576697053184
            Got result = 6399018521010896896
            Got result = 9003737871877668864
            Got result = 1096907932701818880
            Got result = 4789013295250014208
            Got result = 2304077777655037952
            Got result = -70609262346240000
            Got result = -2894979756195840000
            Got result = 7538058755741581312
            Got result = -7904866829883932672
            Got result = 2673996885588443136
            Got result = -8797348664486920192
            Got result = 1150331055211806720
            Got result = -1274672626173739008
            Got result = -5844053835210817536
            Got result = 8789267254022766592
            Got result = -3258495067890909184
            Got result = -162551799050403840
            Got result = -8452693550620999680
            Got result = -5270900413883744256
            Got result = -7927461244078915584
            Got result = 6711489344688881664
            Got result = 6908521828386340864
            Got result = 6404118670120845312
            Got result = 2504001392817995776
            Got result = 162129586585337856
            Got result = -8718968878589280256
            Got result = 3098476543630901248
            Got result = 7638104968020361216
            Got result = 1585267068834414592
            Got result = -9223372036854775808
            Got result = -9223372036854775808
            Got result = 0
            Got result = 0
            Got result = 0
            Got result = 0
            Got result = 0
        */
        System.out.println("Factorial of 600 is " + Recurse1.factorialLong(600));
        
    }
    
}
