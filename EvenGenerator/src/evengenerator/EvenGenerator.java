/*
    Demo to show threads colliding
 */
package evengenerator;

import evenints.*;

/**
 *
 * @author sanket
 */
public class EvenGenerator extends IntGenerator{
    private int evenVal = 0;
    
    public static void main(String[] args) {
        System.out.println("EvenGenerator start");
        EvenChecker.test(new EvenGenerator(), 8);
    }

    @Override
    public int next() {
        // Silly way to increment so as to induce
        // errors
        
        ++evenVal;
        // There can be a thread switch here...so that
        // the result will be odd instead of even
        ++evenVal;
        
        // If we were to do 
        // evenVal += 2;
        // it will run a while, but it will still eventually
        // have this issue since increment operation
        // is non-atomic!
        return evenVal;
    }
        
}
