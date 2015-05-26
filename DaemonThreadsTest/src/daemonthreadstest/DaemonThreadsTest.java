/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadstest;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanket
 */
public class DaemonThreadsTest implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i=0; i < 30; i++) {
            Thread daemon;
            daemon = new Thread(new DaemonThreadsTest());
            // if you comement below line the program will continue forever even though
            // main thread exist
            daemon.setDaemon(true); // must call before start!
            daemon.start();
        }
        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(80);
        } catch (InterruptedException ex) {
            Logger.getLogger(DaemonThreadsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Done");
    }
    
    public void run() {
        
        while(true) {
            
            try {
                TimeUnit.MILLISECONDS.sleep(60);
                System.out.println(Thread.currentThread() + " says hola!");
            }catch (InterruptedException e) {
                System.out.println("Interrupted me!");
            }

        }
    }
    
}