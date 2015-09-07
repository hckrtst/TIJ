/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotester;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sanket K<hckrtst@gmail.com>
 */
public class IOTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Como estas...type something");
        int a = 0;
        try {
        a = System.in.read();
        } catch(IOException ex) {
            System.out.println("Bad user!");            
        }
        System.out.println("You said:" + (char)a);
        
        System.out.print("Type some more: ");
        int b = 0,c = 0;
        
        Scanner sc;
        sc = new Scanner(System.in);
        try {
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println("You typed " + b + " and " + c);
        } catch (InputMismatchException ex) {
            System.out.println("Bad user!");
            
        }       
    }   
}
