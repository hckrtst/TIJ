/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evengenerator3;

import evenints.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author sanket
 */
public class EvenGenerator3 extends IntGenerator{

    private int evenVal = 0;
    private Lock lock = new ReentrantLock();
    
    public static void main(String[] args) {
        System.out.println("EvenGenerator start");
        EvenChecker.test(new EvenGenerator3(), 8);
    }

    @Override
    public int next() {
        // Silly way to increment so as to induce
        // errors
        lock.lock();
        // MUST put a try finally to ensure unlocking!
        try {
            ++evenVal;
            ++evenVal;
            return evenVal;
        } finally {
            lock.unlock();
        }
   }
}
