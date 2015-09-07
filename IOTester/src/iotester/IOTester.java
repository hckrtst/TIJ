/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanket K<hckrtst@gmail.com>
 */
public class IOTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Simply read a byte at a time, type more than one character 
        // and see what happens
        System.out.println("Como estas...type something");
        int a = 0;
        try {
        a = System.in.read();
        } catch(IOException ex) {
            System.out.println("Bad user!");            
        }
        System.out.println("You said:" + (char)a);
        
        
        // Read two integers from standard input
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
        
        // Read a line at a time now
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        try {
            while((line = bufferedReader.readLine()) != null && line.length() > 0) {
                System.out.println("Got line = " + line);
            }
        } catch (IOException ex) {
            Logger.getLogger(IOTester.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(IOTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }   
}
