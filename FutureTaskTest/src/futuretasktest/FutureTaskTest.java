/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuretasktest;

import java.util.ArrayList;
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
public class FutureTaskTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        
        // If the limit is increased you may see a out of mem error!
        // There is a limit to how many threads JVM can create!
        for (int i=0; i < 1999; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch(InterruptedException e) {
                System.out.println(e);
                return; // ?
            } catch(ExecutionException e) {
                System.out.println(e);
            } finally {
                System.out.println("Cleaning up");
                exec.shutdown();
            }
        }
        
        System.out.println("Bye");
        
    }
    
}

class TaskWithResult implements Callable<String> {
    private int id;
    
    public TaskWithResult(int id) {
        this.id = id;
    }
    
    @Override
    public String call() {
        System.out.println("Enter id " + id);
        try {
            TimeUnit.MILLISECONDS.sleep(700);
        } catch (InterruptedException ex) {
            Logger.getLogger(TaskWithResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Result of TaskWithResult " + id;
    }
}
