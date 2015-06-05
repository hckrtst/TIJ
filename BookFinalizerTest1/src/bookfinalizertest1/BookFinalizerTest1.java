/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookfinalizertest1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanket
 */
public class BookFinalizerTest1 {
    boolean checkedOut = false;

    public BookFinalizerTest1(boolean checkOut) {
        checkedOut = checkOut;
    }
    void checkIn() {
        System.out.println("Checking in");
        checkedOut = false;
    }
    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error: still checked out!");
            checkIn();
        }
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(BookFinalizerTest1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookFinalizerTest1 novel = new BookFinalizerTest1(true);
        novel.checkIn();
        
        // force leak
        new BookFinalizerTest1(true);
        // try to force gc
        System.out.println("Force gc");
        System.gc();
    }
}
