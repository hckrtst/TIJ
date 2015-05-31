/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenints;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author sanket
 */
public class EvenChecker implements Runnable{
    private IntGenerator gen;
    private final int id;
    public EvenChecker(IntGenerator g, int identity) {
        gen = g;
        id = identity;
    }
    @Override
    public void run() {
        while (!gen.isCanceled()) {
            int val = gen.next();
            if (val % 2 != 0) {
                System.out.println("id(" + id + ") " + val + " is not even...bail!");
                gen.cancel();
            }
        }
    }
    
    //method to test even checker
    public static void test(IntGenerator gp, int count) {
        System.out.println("Testing...");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i < count ; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }
       
}
