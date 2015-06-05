/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overloadedctortest;

/**
 *
 * @author sanket
 */
public class OverloadedCtorTest {

    OverloadedCtorTest() {
        System.out.println("default ctor called");
    }
       
    OverloadedCtorTest(int arg) {
        this(); // this must be first call -- not same as super()
        System.out.println("Ctor called with arg = " + arg);        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new OverloadedCtorTest(20000);
    }
    
}
