/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicthreads;

/**
 *
 * @author sanket
 */
public class BasicThreads{
    private Thread child;
    /*
        Constructors have no return values
    */
    public BasicThreads() {
        System.out.println("Construct BasicThreads"); 
        child = new Thread(new Producer());
        child.start();
        
    }
    
    public void interruptChild() {
        System.out.println("Interrupting child");
        child.interrupt();
        
    }     
    
    public void joinChild() {
        System.out.println("Joining");
        try {
            // CyclicBarrier is a better approach
            child.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted when trying to join");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Producer p = new Producer(); / /cannot create this here
        BasicThreads base = new BasicThreads();
                
        try {
            Thread.sleep(4000);
            base.interruptChild();
            base.joinChild();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done main thread");
        }
        
    }
    
    private class Producer implements Runnable{
        private int count = 0;
        
        @Override
        public void run() {
          while (count < 10) {  
            System.out.println("Running thread now...iteration " + count++ );
            try {
                Thread.sleep(1000);
            }  catch (InterruptedException e) {
                System.out.println("Failed to sleep");
                e.printStackTrace();
                
            }
            
          }
          
          
        }
    }
      
}