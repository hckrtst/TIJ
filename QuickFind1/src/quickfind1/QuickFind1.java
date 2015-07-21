/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickfind1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Pair{
    int p;
    int q;

    public Pair(int _p, int _q) {
        p = _p;
        q = _q;
    }
    
    public int getP() {
        return p;
    }
    
    public int getQ() {
        return q;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append("<");
      sb.append(p);
      sb.append(",");
      sb.append(q);
      sb.append(">");

      return sb.toString();          
    }
    // TODO implement other methods as needed        
}

/**
 *
 * @author sanket
 */
public class QuickFind1 {
    int N;
   
    int getN(HashSet<Pair> data) {
        int max = 0;
        for (Pair o : data) {
            int p = o.getP();
            int q = o.getQ();
            max = p>max?p:max;
            max = q>max?q:max;
        }
        // add 1 to ensure correct upper bound
        return (max + 1);
    }
    /*
    * We use an array
    */
    /**
     *
     * @param input
     * @param data
     */
    public int[] simple(HashSet<Pair> data) {
        // first we figure out how big of an array we need based on 
        // the max value in pairs
        // This is an extra iteration
        // we incur :(
        int N = getN(data);
        
        // Next we create an array of ints
        // with unique values
        int[] items;
        items = new int[N];
        for(int i=0; i < N; i++) {
            items[i] = i;
        }
        
        // Now we iterate through each pair
        
        for(Pair o: data) {
            int p = o.getP();
            int q = o.getQ();
            // cache the current value at p
            int t = items[p];
            if (items[p] == items[q]) {
                System.out.println("same");
                continue;
            }
            
            for (int i=0; i < N; i++) {
                if (items[i] == t) {
                    System.out.println("Replacing " + items[i] + " with " + items[q]);
                    items[i] = items[q];
                }
            }
            
            System.out.println(o);
            
        }
        System.out.println(Arrays.toString(items));
        return items;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }    
}
