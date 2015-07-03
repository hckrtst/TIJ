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
package regextest;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sanket K
 */
public class RegexTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "The lazy dog\\nsleeps in the yard.";
        
        System.out.println("\n\n ~~~ Splitting strings with regex ~~~");
        System.out.println("\nUsing string: " + s);
        System.out.println("\nSplit on \"\" ");
        System.out.println(Arrays.toString(s.split("")));
        
        System.out.println("\nSplit on non-word ");
        System.out.println(Arrays.toString(s.split("\\W")));
        
        String s2 = "Then came the downfall of the ninja";
        System.out.println("\n\nUsing string: " + s2);
        System.out.println("\nSplit on word n");
        System.out.println(Arrays.toString(s2.split("(n)+")));
        
               
        // Build a pattern and try to see if the pattern is matched in the 
        // source string
        // TODO - move to a static method
        String ps = ".*down.*";
        System.out.println("\nLooking for pattern: " + ps);
        Pattern p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s2);
        System.out.println("Found = " + m.matches());
        
        String s3 = "Hits by kei$ha are on sale?! Well that's not surprising! $$$ ";
        System.out.println("\nUsing string: " + s3);
                
        ps = ".*\\w+\\$\\w+.*";
        System.out.println("\nLooking for pattern: " + ps);
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s3);
        System.out.println("Found = " + m.matches());
        //System.out.println("Found between " + m.start() + " and " + m.end());
        // Notice that the following will not run
        while(m.find()) {
            System.out.println("Groups = " + m.group());
        }
        
        // We cannot use the matches() method to search for multiple occurrences of a regular expression. 
        // For this, we need to use the find(), start() and end() methods. 
        String s4 = "Tintin and snowy were skiing in the Chong chang region,\nwhen suddenly the gang of thugs came running";
        System.out.println("\nUsing string: " + s4);
        
        ps = "\\s+[\\w]+g+.*";
        System.out.println("\nLooking for pattern: " + ps);
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s4);
        System.out.println("Found = " + m.matches());
        while(m.find()) {
            System.out.println("Groups = " + m.group());
        }
        
        ps = "\\s+[\\w]+g+\\S+";
        System.out.println("\nLooking for pattern: " + ps);
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s4);
        System.out.println("Found = " + m.matches());
        while(m.find()) {
            System.out.println("Groups = " + m.group());
        }
        
        ps = "\\s+[\\w]+g+\\s+";
        System.out.println("\nLooking for pattern: " + ps);
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s4);
        System.out.println("Found = " + m.matches());
        while(m.find()) {
            System.out.println("Groups = " + m.group());
        }
        
        
        String s5 = "MyCompany Inc. Copyright 1998-2012";
        ps = ".*copyright\\s+";
        System.out.println("Length = " + s5.length());
        System.out.println("\nUsing string: " + s5);
        if (s5.matches("2015")) {
            System.out.println("Copyright is updated");
        } else {
            System.out.println("Copyright is not updated");
            
            s5 = s5.replaceAll("\\d+", "2015");
            System.out.println("Updated = " + s5);
        }
        
        
        System.out.println("\nLooking for pattern: " + ps);
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s5);
        //System.out.println("lookingAt = " + m.lookingAt());
        while(m.find()) {
            System.out.println("group(0) = " + m.group(0));
            
            System.out.println("Groups = " + m.group() + " starts at " + m.start() + " ends at " + m.end());
            s5 = s5.replaceFirst(ps, "2015");
        }
        System.out.println("String is now = " +s5);
        
        
    }
    
}
