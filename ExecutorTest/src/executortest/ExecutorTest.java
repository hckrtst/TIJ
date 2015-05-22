/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executortest;
import java.util.concurrent.*;

/**
 *
 * @author sanket
 */
public class ExecutorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Demo of basic Executor service");
        /*
            It is not recommended to use cachedThreadPool in production
            See http://dev.bizo.com/2014/06/cached-thread-pool-considered-harmlful.html
        */
        // ExecutorService exec = Executors.newCachedThreadPool();
        /*
         From javadoc
        Creates a thread pool that reuses a fixed number of threads 
        operating off a shared unbounded queue, using the provided ThreadFactory to 
        create new threads when needed. At any point, at most nThreads threads will be active processing tasks. 
        If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available. 
        If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks. 
        The threads in the pool will exist until it is explicitly shutdown.
        */
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 6; i++) {
            exec.execute(new LiftOff());
            
        }
        System.out.println("Done now");
        
        exec.shutdown();// prevent new threads from being
                        // submitted to executor
    }
    
}
