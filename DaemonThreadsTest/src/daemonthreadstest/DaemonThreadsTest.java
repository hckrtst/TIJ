/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadstest;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author sanket
 */
public class DaemonThreadsTest implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i=0; i < 10; i++) {
            Thread daemon;
            daemon = new Thread(new DaemonThreadsTest());
        }
        
    }
    
    public void run() {
        int count = 0;
        while(true) {
            System.out.println("Worker " + (count++) + " says hola!");
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            }catch (InterruptedException e) {
                System.out.println("Interrupted me!");
            }

        }
    }
    
}