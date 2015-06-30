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
package sortingexamples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanket K
 */
public class SortingExamples {
    List<Integer> data;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        SortingExamples obj = new SortingExamples();
        
        System.out.println("Unsorted list = " + obj.getUnsorted());
        
        System.out.println("Sorted list = " + obj.insertionSort(obj.getUnsorted()));
    }

    public SortingExamples() {
        this.data = new ArrayList<>();
        
        // TODO add random numbers in a loop
        data.add(100);
        data.add(34);
        data.add(39);
        data.add(3);       
    }
    
    public List<Integer> getUnsorted() {
        return data;
    }
    
    public List<Integer> insertionSort(List<Integer> unsorted) {
        List<Integer> sorted = unsorted;
        for (int i = 1; i < unsorted.size(); i++) {
            int j = i;
            int testvar = unsorted.get(i);
            while (j > 0 && unsorted.get(j-1) > unsorted.get(j) ) {
                unsorted.set(j, unsorted.get(j-1));
                j = j-1;
            }
            unsorted.set(j, testvar);
        }
        return sorted;
    }    
}
