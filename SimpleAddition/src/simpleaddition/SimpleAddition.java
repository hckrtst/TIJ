/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleaddition;

/**
 *
 * @author sanket
 * sanket$ javap -c build/classes/simpleaddition/SimpleAddition.class

* Compiled from "SimpleAddition.java"
public class simpleaddition.SimpleAddition {
  simpleaddition.SimpleAddition();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_0
       6: putfield      #2                  // Field myInt:I
       9: aload_0
      10: dup
      11: getfield      #2                  // Field myInt:I
      14: iconst_1
      15: iadd
      16: putfield      #2                  // Field myInt:I
      19: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_2
       1: istore_1
       2: iinc          1, 1
       5: new           #3                  // class simpleaddition/SimpleAddition
       8: dup
       9: invokespecial #4                  // Method "<init>":()V
      12: astore_2
      13: return
}
 */
public class SimpleAddition {
    private int myInt = 0;
    SimpleAddition() {
        myInt++;
    }
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        int localInt = 2;
        localInt += 1;
        
        SimpleAddition s = new SimpleAddition();
    }
}
