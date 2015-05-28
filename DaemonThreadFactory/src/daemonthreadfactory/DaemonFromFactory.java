/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanket
 * So why in god's name would you ever wanna make
 * your own threadfactory.
 * The popular consensus seems to be that you might want
 * to control certain things about the threads such as default priority/naming etc..
 * Here is one from Apache which has a nice little write-up
 * https://commons.apache.org/proper/commons-lang/javadocs/api-3.0/org/apache/commons/lang3/concurrent/BasicThreadFactory.html
 */
public class DaemonFromFactory implements Runnable{

    @Override
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Intrrupted");
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                new DaemonThreadFactory()
        );
        
        for (int i=0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        
        System.out.println("All daemons started yo");
        
        long startMillis = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(700);
        } catch (InterruptedException ex) {
            System.out.println("Don't interrupt me now");
        }
        long endMillis = System.currentTimeMillis();
        
        System.out.println((endMillis - startMillis) + " ms has passed..."
                + "bye now");
        
    }
    
}
