/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varargstest;

class A{}

/**
 *
 * @author sanket
 */
public class VarargsTest {
    static void printArray(Object... args) {
        //System.out.println("Object is type = " + args.getClass().getName());
        System.out.println(">");
        for (Object o: args) {
            System.out.print(o + " ");
        }
        System.out.println("\n<");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printArray(new Object[] {
            new Integer(30), new Float(2.34), new String("(I used to give a...)")
        });
        printArray(new A());
        printArray(2, 3, 4, 5, "hello", 2.4567, new A(), new Object[] { new String("jay z")}, "coldplay");
        printArray(new String[] {"Hello brooklyn"});
    }    
}
/* output
>
30 2.34 (I used to give a...) 
<
>
varargstest.A@62a23d38 
<
>
2 3 4 5 hello 2.4567 varargstest.A@2a36bb87 [Ljava.lang.Object;@6f51b1b7 coldplay 
<
>
Hello brooklyn 
<
*/
