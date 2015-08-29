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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sanket K
 */
public class RegexTest {
    
    private void fixCopyrightDate(List<String> src) {
        //System.out.println(src);
        int year =  Calendar.getInstance().get(Calendar.YEAR);
                //(Calendar.get(Calendar.YEAR));
        System.out.println("Current year is: " + year);
        
        
        List<Integer> years = new ArrayList<>(); 
        
        try {
            for(String s: src) {
                // Assumption is that dates are 4 digit years xxxx - xxxx or just xxxx
                
                // If the fist number is curreny year, we're good
                // If the second number is (current year - 1) then repalce with current year (ex: 1998 - 2014 --> 1998 - 2015)
                // If the second number is less than (current - 1) then append current year (ex: 1998 - 2012 --> 1998 - 2012,2015)
                // If the first number is (current year - 1) then append current year like this  (2014 --> 2014-2015)
                // If the first number < (current year -1) then append current year like this (1996 --> 1996, 2015)
                if ( (null != s) && (s.matches("\\d{4}"))) {
                    if (Integer.parseInt(s) == 2015) {
                        System.out.println("Have 2015, nothing to do");
                        break;
                    }
                    years.add(Integer.parseInt(s));
                }
            }
        } catch (NumberFormatException e) {
            //System.out.println(e);
            
        }
        
        System.out.println("Got years = " + years);
    }
    
    public void runTest() {
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
        
        
        String s5 = "The source is copyright the authors etc etc.....\n"
                + "MyCompany Inc. Copyright (c) 1998 - 2012\n"
                + "COPYRIGHT for 1993     , 2000 \n"
                + " All right reserved 2015";
        //ps = "copyright.*(((\\d{4})\\s*[,-]+\\s*(\\d{4}))|(\\d{4}))";
        //ps = "copyright.*(\\d{4})\\s+?((-?|,?)\\s+(\\d{4}?))";
        ps = "copyright.*(\\d{4})\\s*(-?|,?)\\s*(\\d{4}?)";
        System.out.println("\nUsing string: " + s5);
        
        /*if (s5.matches("2015")) {
            System.out.println("Copyright is updated");
        } else {
            System.out.println("Copyright is not updated");
            
            s5 = s5.replaceAll("\\d+", "2015");
            System.out.println("Updated = " + s5);
        }*/
        
        
        System.out.println("\nLooking for pattern: " + ps);
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        m = p.matcher(s5);
        List<String> groups = new ArrayList<>();
        while(m.find()) {
            int i = 0;
            for (i =0; i <= m.groupCount(); i++) {
                System.out.print("[" + m.group(i) + "]");
                groups.add(m.group(i));                
            }
            System.out.println("");
            
            //s5 = s5.replaceFirst(ps, "2015");
        }
        fixCopyrightDate(groups);
        System.out.println("String is now = " +s5);
        
        
        //Understanding groups with regex
        String s6 = "\n\nOn Children - by Kahlil Gibran\n"
                + "Your children are not your children.\n" +
                "\n" +
                "They are the sons and daughters of Life's longing for itself.\n" +
                "\n" +
                "They come through you but not from you,\n" +
                "\n" +
                "And though they are with you, yet they belong not to you.\n" +
                "\n" +
                "\n" +
                "You may give them your love but not your thoughts.\n" +
                "\n" +
                "For they have their own thoughts.\n" +
                "\n" +
                "You may house their bodies but not their souls,\n" +
                "\n" +
                "For their souls dwell in the house of tomorrow,\n" +
                "which you cannot visit, not even in your dreams.\n" +
                "\n" +
                "You may strive to be like them, but seek not to make them like you.\n" +
                "\n" +
                "For life goes not backward nor tarries with yesterday.\n" +
                "\n" +
                "\n" +
                "You are the bows from which your children as living arrows are sent forth.\n" +
                "\n" +
                "The archer sees the mark upon the path of the infinite,\n" +
                "and He bends you with His might that His arrows may go swift and far.\n" +
                "\n" +
                "Let your bending in the archer's hand be for gladness;\n" +
                "\n" +
                "For even as He loves the arrow that flies,\n" +
                "so He loves also the bow that is stable.";
        
        System.out.println("\n\nSource string = " + s6);
        
        // (?m) tells Java to accept the anchors ^ and $ to match at the start 
        // and end of each line else they only match at the start/end of the 
        // entire string.
        ps = "(?m)^(\\S+)((\\s+)(\\S+))";
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s6);
        
        System.out.println("\n\nMatch from the beginning");
        // We need to do a check for m.find() or risk an IllegalStateException
        while(m.find()) {
            for (int i=0; i <= m.groupCount(); i++) {
                System.out.print("[" + m.group(i) + "]");
            }
            System.out.println("");
        }

        ps = "(?m)(\\S+)((\\s+)(\\S+)$)";
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s6);

        System.out.println("\n\nMatch from the end");
        // We need to do a check for m.find() or risk an IllegalStateException
        while(m.find()) {
            for (int i=0; i <= m.groupCount(); i++) {
                System.out.print("[" + m.group(i) + "]");
            }
            System.out.println("");
        }
         
        ps = "(\\S+)((\\s+)(\\S+)$)";
        p = Pattern.compile(ps, Pattern.CASE_INSENSITIVE);
        m = p.matcher(s6);

        System.out.println("\n\nMatch from the end of entire input");
        // We need to do a check for m.find() or risk an IllegalStateException
        while(m.find()) {
            for (int i=0; i <= m.groupCount(); i++) {
                System.out.print("[" + m.group(i) + "]");
            }
            System.out.println("");
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegexTest obj = new RegexTest();
        
        obj.runTest();
        
    }    
}
