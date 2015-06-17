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
        while(it.hasNext()) {
            // Note:
            // 1. casting needed since no type specified in list declaration
            // 2. toString needed since without it we will see a runtime exception
            /*
            Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
            */
            String s = (String) (it.next()).toString();
            
            System.out.println(s);
        }
        
        List<String> islands = new ArrayList<>();
        
        islands.add("Cyprus");
        islands.add("Iceland");
        islands.add("Fiji");
        //islands.add(3456);// We cannot add this now since String specified     
        
    }
    
}
