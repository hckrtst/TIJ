/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancesample1;

class Life {
    private int id;
    protected int baseGeneticCode;
    Life() {
        baseGeneticCode = 42;
        System.out.println("A life is beginning with code= " + baseGeneticCode);
        
    }
    
    // public by default
    void eat() {
        System.out.println("yum yum...can I have more?");
    }
    
    void multiply() {
        System.out.println("I was just waiting to multiply");
    }
    
    void move() {
        System.out.println("I'm just a single celled organims, can't move that far");
    }
}

class Ant extends Life {
    protected int antGeneticCode;
    Ant() {
        super();
        antGeneticCode = baseGeneticCode + 42;
        System.out.println("Ant created with code = " + antGeneticCode);
                
    }
    @Override
    void eat() {
        super.eat();
        System.out.println("Oh wait I'm an ant, I need to get some food for the colony");
    }
    
    @Override
    void multiply() {
        System.out.println("Try to multiply...well I'm just a soldier ant, let's leave that up to the queen");
    }
}

class FireAnt extends Ant {
    protected int fireAntGeneticCode;
    FireAnt() {
        fireAntGeneticCode = baseGeneticCode + antGeneticCode + 100;
        System.out.println("created fire ant with code = " + fireAntGeneticCode);
    }
    void warn() {
        System.out.println("Don't mess with me...I bite");
    }
}
/**
 *
 * @author sanket
 */
public class InheritanceSample1 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Life life = new Life();
        life.eat();
        life.multiply();
        // life.id = 0; // cannot do this - private
        Life ant = new Ant(); //Notice it is declared as Life
        ant.eat();
        ant.multiply();
        Life fireAnt = new FireAnt();
        fireAnt.eat();
        fireAnt.multiply();
        //fireAnt.warn();
        FireAnt fireAnt2 = new FireAnt();
        fireAnt2.eat();
        fireAnt2.multiply();
        fireAnt2.warn();
    }
    
}
/* output
A life is beginning with code= 42
yum yum...can I have more?
I was just waiting to multiply
A life is beginning with code= 42
Ant created with code = 84
yum yum...can I have more?
Oh wait I'm an ant, I need to get some food for the colony
Try to multiply...well I'm just a soldier ant, let's leave that up to the queen
A life is beginning with code= 42
Ant created with code = 84
created fire ant with code = 226
yum yum...can I have more?
Oh wait I'm an ant, I need to get some food for the colony
Try to multiply...well I'm just a soldier ant, let's leave that up to the queen
A life is beginning with code= 42
Ant created with code = 84
created fire ant with code = 226
yum yum...can I have more?
Oh wait I'm an ant, I need to get some food for the colony
Try to multiply...well I'm just a soldier ant, let's leave that up to the queen
Don't mess with me...I bite
*/
