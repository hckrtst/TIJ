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
package listexample1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Sanket K
 */
public class ListExample1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List cities = new ArrayList();
        
        cities.add("New Orleans");
        cities.add("Santa Barbara");
        cities.add(2124); // this is legit since no type specified
        cities.add("Miami");
        cities.add("San Diego");
        cities.add("Münich");
        
        
        Iterator it = cities.iterator();
        System.out.print(it.toString()+ "=");
        while(it.hasNext()) {
            // Note:
            // 1. casting needed since no type specified in list declaration
            // 2. toString needed since without it we will see a runtime exception
            /*
            Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
            */
            String s = (String) (it.next()).toString();            
            System.out.print(s + ",");
        }
        System.out.println("");
        
        List<String> smallNations = new ArrayList<>();//CopyOnWriteArrayList<>();
        List<String> islands = new ArrayList<>();
        
        islands.add("Cyprus");
        islands.add("Iceland");
        islands.add("Fiji");
        //islands.add(3456);// We cannot add this now since String specified     
        
       
        it = islands.iterator();
        System.out.print(it.toString()+ "=");
        while(it.hasNext()) {
            // no toString needed
            String s = (String) it.next();
            System.out.print(s + ",");
        }
        System.out.println("");
        
        smallNations.add("Kuwait");
        smallNations.add("Monaco");
        smallNations.add("Singapore");
        
        it = smallNations.iterator();
        System.out.print(it.toString()+ "=");
        while(it.hasNext()) {
            // no toString needed
            String s = (String) it.next();
            
            System.out.print(s + ",");
        }
        System.out.println("");
        
        
        System.out.println("Add all test");
        smallNations.addAll(0, islands);
        
        it = smallNations.iterator();
        System.out.print(it.toString()+ "=");
        while(it.hasNext()) {
            // no toString needed
            String s = (String) it.next();
            
            System.out.print(s + ",");
        }
        System.out.println("");        
    }    
}
/*
If we forget to update
it = smallNations.iterator(); in last step we get exception
run:
java.util.ArrayList$Itr@19509443=New Orleans,Santa Barbara,2124,Miami,San Diego,Münich,
java.util.ArrayList$Itr@7935c7b0=Cyprus,Iceland,Fiji,
java.util.ArrayList$Itr@39c931fb=Kuwait,Monaco,Singapore,
Add all test
Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:859)
	at java.util.ArrayList$Itr.next(ArrayList.java:831)
	at listexample1.ListExample1.main(ListExample1.java:105)
java.util.ArrayList$Itr@39c931fb=Java Result: 1

run:
java.util.ArrayList$Itr@19509443=New Orleans,Santa Barbara,2124,Miami,San Diego,Münich,
java.util.ArrayList$Itr@7935c7b0=Cyprus,Iceland,Fiji,
java.util.ArrayList$Itr@39c931fb=Kuwait,Monaco,Singapore,
Add all test
java.util.ArrayList$Itr@47f07360=Cyprus,Iceland,Fiji,Kuwait,Monaco,Singapore,

*/

