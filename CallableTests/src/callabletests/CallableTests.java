/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callabletests;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanket
 */
public class CallableTests {

    
    /**
     * @param args the command line arguments
     * @return integer
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<Integer> future = executor.submit(new Callable() {

            @Override
            public Integer call() throws TimeoutException {
                int duration = (new Random()).nextInt(2000);
                if (duration > 700) {
                    throw new TimeoutException("Cannot sleep for so long");
                }
                return duration;
            }

        });

        System.out.println("Starting...");

        try {    
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableTests.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        System.out.println("Shut down executor");
        executor.shutdown();
        
        try { 
            System.out.println("Got result = " + future.get());
        } catch (InterruptedException | ExecutionException ex) {
            //Logger.getLogger(CallableTests.class.getName()).log(Level.SEVERE, null, ex);
            Throwable cause = ex.getCause();
            System.out.println(cause.getMessage());
            
        }
        
        System.out.println("Peace out!");
       
    }
    
}
