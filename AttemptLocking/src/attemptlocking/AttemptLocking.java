/*
 * Attempt Locking adpoted from TIJ
 */
package attemptlocking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author sanket
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    
    public void untimed() {
        boolean captured;
        captured = lock.tryLock();
        try {
            System.out.println("captured = " + (captured?"yay":"nay"));
        } finally {
            if (captured) {
                // Always finally unlock
                lock.unlock();
            }
        }
    }
    
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("trylock captured = " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("Lock acquired");
            }
        }.start();
        
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
