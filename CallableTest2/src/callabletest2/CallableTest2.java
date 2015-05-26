/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callabletest2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanket
 */

class MyCallable implements Callable<Integer> {
    int value;
    static int id = 0;
    int myId;
    public MyCallable(int i) {
        
        this.value = i;
        myId = id++;
        System.out.println("(" + myId + ") created");
        
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        
        TimeUnit.MILLISECONDS.sleep(1000);
        for (int i=0; i< value; i++) {
            sum += i;
        }
        System.out.println("(" + myId + ") Resume");
        
        //System.out.println("(" + myId + ") Sum in call =" + sum);
               
        return sum;
    }
    
    
}

public class CallableTest2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prefer to declare with interface
        List<Integer> sums = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future;
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        
        for (int i=1; i < 12; i++) {
            future = executor.submit(new MyCallable(i));
            futures.add(future);
        }
        
        for (Future<Integer> fs: futures) {
            try {
                sums.add(fs.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(CallableTest2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        executor.shutdown();
        try {
            // optional?
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableTest2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Got items:");
        for (Integer item:sums) {
            System.out.println(item);
        }
        
    }
    
}
