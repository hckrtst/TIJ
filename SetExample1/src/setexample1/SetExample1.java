/*
 * The MIT License
 *
 * Copyright 2015 Sanket K.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package setexample1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sanket K
 */
public class SetExample1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("A set of strings");
        Set<String> agents = new HashSet<>();
        
        agents.add("James Bond");
        agents.add("Remington Steele");
        
        for (String s: agents) {
            System.out.println(s);
        }
        
        //clear the set
        agents.clear();
        
        if (agents.isEmpty()) {
            System.out.println("Set is now empty");
        }        
        

        System.out.println("\nTry a generic set");
        // Generic set
        Set objs = new HashSet<>();
        
        objs.add("simple string");
        objs.add(98753);
        objs.add(2.34567);
        
        for (Object o: objs) {
            System.out.println(o);
        }
        
        
        // Tree set
        System.out.println("\nTry a tree set");
        Set ts = new TreeSet<>();
        ts.add(27865);
        ts.add(123);
        /*
        Trying to add float will result in an exception since integers and 
        floats are not comparable to each other
        Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
	at java.lang.Double.compareTo(Double.java:49)
	at java.util.TreeMap.put(TreeMap.java:568)
	at java.util.TreeSet.add(TreeSet.java:255)
	at setexample1.SetExample1.main(SetExample1.java:76)
        */
        // ts.add(3.14); 
        ts.add(345);
        ts.add(10);
        ts.add(1);
        
        for (Object i : ts) {
            System.out.println(i);
        }
        
        
    }    
}
/*
run:
A set of strings
Remington Steele
James Bond
Set is now empty

Try a generic set
98753
2.34567
simple string

if we try to add a float to ts then we get

Try a tree set
Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
	at java.lang.Double.compareTo(Double.java:49)
	at java.util.TreeMap.put(TreeMap.java:568)
	at java.util.TreeSet.add(TreeSet.java:255)
	at setexample1.SetExample1.main(SetExample1.java:76)


*/