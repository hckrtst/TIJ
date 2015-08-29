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
        //array of primitives
        int[] arr1 = new int[(new Random(100).nextInt(20))];
        System.out.println(Arrays.toString(arr1));
        
        //array of objects with all integers
        Random rand = new Random(45);
        Integer[] arr2 = new Integer[rand.nextInt(99)];
        System.out.println("Length of arr2 = " + arr2.length);
        for(int i=0; i < arr2.length; i++ ) {
            arr2[i] = rand.nextInt(); //autoboxing
        }
        System.out.println("arr2 defined as " + arr2.toString());
        System.out.println("arr2 contains: " + Arrays.toString(arr2));
        
        //array of objects with positive integers only
        System.out.println("Length of arr2 = " + arr2.length);
        for(int i=0; i < arr2.length; i++ ) {
            arr2[i] = rand.nextInt(300);// autoboxing
        }
        System.out.println("arr2 defined as " + arr2.toString());
        System.out.println("arr2 contains: " + Arrays.toString(arr2));
        
        
    }    
}
/* output
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Length of arr2 = 39
arr2 defined as [Ljava.lang.Integer;@333c339f
arr2 contains: [-266757034, -558198634, -1479180815, 1291932175, 139016263, -1060690493, -2144326810, 1103906788, -1736199309, -1659301456, -1069543858, 1796981181, 890944477, -167868515, -1334895884, -258813267, -98051325, -1057710835, 755710695, -966924531, 1542522762, -142433128, -88706747, -935899800, -1814942438, -990912001, -687964356, 695655098, -597897593, 1016589185, 2066468046, 419110362, -959633872, -1944892308, -1307600429, -240265677, 1812359340, 565132534, -1751794876]
Length of arr2 = 39
arr2 defined as [Ljava.lang.Integer;@333c339f
arr2 contains: [261, 161, 82, 74, 73, 91, 77, 293, 22, 71, 159, 280, 272, 62, 112, 213, 166, 105, 238, 13, 31, 260, 213, 114, 110, 251, 293, 42, 24, 18, 147, 1, 175, 171, 194, 271, 47, 249, 233]
*/