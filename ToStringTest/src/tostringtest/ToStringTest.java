/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tostringtest;

class Cockatoo {
    static String sound = "Cockatooooo"; 
    
    @Override
    public String toString() {
        return sound;
    }
}

class Cat {
    static String sound = "meowwwwww";
    
    @Override
    public String toString() {
        return sound;
    }
}
/**
 *
 * @author sanket
 */
public class ToStringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cockatoo pet1 = new Cockatoo();
        Cat pet2 = new Cat();
        
        // When you put them close to each other you will get lots of noise
        for (int i = 0; i < 5; i++) {
            System.out.println(pet1);
            System.out.println(pet2);
            
            // Fails because Java does not allow operator overloading!
            // System.out.println(pet1 + pet2);
            
            // Works because we are concatenating strings
            System.out.println("" + pet1 + " " + pet2 );
        }
    }
    
}
