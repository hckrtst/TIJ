/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotester;

import java.io.BufferedReader;
import java.io.Console;
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
        System.out.println("Start typing again miho!");
        try {
            while((line = bufferedReader.readLine()) != null && line.length() > 0) {
                System.out.println("Got line = " + line);
            }
        } catch (IOException ex) {
            Logger.getLogger(IOTester.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // NOTE: if we close the bufferedReader then subsequently we cannot open console!!!!
            // This because if we close the input stream then the console will not be available to
            // VM anymore
            // See http://stackoverflow.com/questions/20982664/why-does-system-console-return-null-for-a-command-line-app
            /*
            try {
                 bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(IOTester.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
        
        /* 
            To exercise this run directly from command line
            cd /home/tintin/workspace/TIJ/IOTester/build/classes
            [tintin@daredevil classes]$ java iotester.IOTester
            Como estas...type something
        */
        
        // This will still work since we did not close output stream
        //System.out.println("Test printing something");
        
        //Read console (won't work from IDE)
        Console console = System.console();
        
        if (console == null) {
            System.out.println("No console found");
        } else {
            String s = console.readLine("Type something:");
            System.out.println("You typed: " + s);
        }
    }   
}
