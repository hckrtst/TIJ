/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slowautoboxing;

/**
 *
 * @author sanket
 */
public class SlowAutoboxing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Long sum = 0L;
        System.out.println("Example using autoboxing");
        long startTime = System.currentTimeMillis();
        System.out.println("Start: time = " + startTime);
        for (long i = 0; i < Integer.MAX_VALUE; i++ ) {
            sum += i;
        }
        System.out.println("Sum = " + sum + " Time in ms = " + 
                (System.currentTimeMillis() - startTime));
        System.out.println("\n\n");
        
        long sum2 = 0L;
        System.out.println("Example using primitives");
        startTime = System.currentTimeMillis();
        System.out.println("Start: time = " + startTime);
        for (long i = 0; i < Integer.MAX_VALUE; i++ ) {
            sum2 += i;
        }
        System.out.println("Sum = " + sum + " Time in ms = " + 
                (System.currentTimeMillis() - startTime));
    }
    
}
/* output
Example using autoboxing
Start: time = 1433703035210
Sum = 2305843005992468481 Time in ms = 8314



Example using primitives
Start: time = 1433703043524
Sum = 2305843005992468481 Time in ms = 1371
*/
