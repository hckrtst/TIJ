/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigotest1;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author sanket
 */
public class BigOTest1 {
    public long iterativeSum(int n) {
        if (n > 0) {
            // See what happens if sum is int
            long sum = 0;
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            for (i=0; i < n; i++) {
                sum+=i;
            }
            System.out.println("Iterations " + i + " time = " + (System.currentTimeMillis() - currentTimeMillis));
            return sum;
        }
        return 0;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigOTest1 test = new BigOTest1();
        System.out.println("Sum = " + test.iterativeSum(400000));
        
    }
    
}
