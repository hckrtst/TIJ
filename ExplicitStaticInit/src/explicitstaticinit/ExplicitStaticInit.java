/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explicitstaticinit;
class Cup {
    public Cup(int marker) {
        System.out.println("Cup-" + marker);
    }
    
    void f(int marker) {
        System.out.println("f-" + marker);
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    public Cups() {
        System.out.println("Cups");
    }    
}
/**
 *
 * @author sanket
 */
public class ExplicitStaticInit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("In main");
        Cups.cup1.f(1);
        Cups cups1 = new Cups();
        Cups cups2 = new Cups();        
    }
    
    static Cups cups3 = new Cups();
    
}
