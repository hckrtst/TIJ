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
package reversetest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sanket K
 */
public class ReverseTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "To be or not to be, that is the question";
        List<String> data = new ArrayList<>();
        Pattern p = Pattern.compile("(\\w+|\\W+)");
        Matcher m = p.matcher(s);
        while(m.find()) {
            for (int i =0; i < m.groupCount(); i ++) {
                System.out.print("[" + m.group(i) + "]");
                data.add(m.group(i));
            }
            System.out.println("");
            
        }
        System.out.println("List contains: "+ data);
        Collections.reverse(data);
        System.out.println("Reversed list contains: "+ data);
        //System.out.println("Final output = " + data.);
        StringBuilder sb = new StringBuilder();
        for (String str: data) {
            if (null != str) {
                sb.append(str);
            }
        }
        System.out.println("Final output = " + sb.toString());        
    }    
}
