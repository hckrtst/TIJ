/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytest1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sanket
 */
public class ArrayTest1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr1 = new int[(new Random(100).nextInt(90))];
        System.out.println(Arrays.toString(arr1));        
    }    
}
