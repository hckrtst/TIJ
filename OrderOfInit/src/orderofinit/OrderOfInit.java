/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderofinit;
// For why this class cannot be declared as public see
// http://docs.oracle.com/javase/specs/jls/se8/html/jls-7.html#jls-7.6

class Window {
    Pane p = new Pane();
    Pane p2;
    public Window(int i) {
        System.out.println("Window ctor for window " + i);
        p2 = new Pane();
    }
    
    private class Pane {
        Pane() {
            System.out.println("Window's Pane ctor()");
        }
    }    
}

class Roof {
    Roof() {
        System.out.println("Roof ctor");
    }
}
class Room {
    static Roof roof = new Roof();
    Room() {
        System.out.println("Room ctor");
        
    }
}
class House {
    Window w1 = new Window(1);
    Window w2;
    Room r1 = new Room();
    Room r2 = new Room();    
    House() {
        System.out.println("House ctor()");
        w2 = new Window(2);        
    }
    
    public void enter() {
        System.out.println("Enter house");
    }
    Window w3 = new Window(3);
    
}

/**
 *
 * @author sanket
 */
public class OrderOfInit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Create a house");
        House h = new House();
        h.enter();
    }    
}
