/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author sanket
 */
public class HttpTest {
    // pretend to be Firefox 30
    private final String UA = "Firefox/30.0";
    
    public void Get() {
        
        URL url = null;        
        
        try {
            // To use https we need to use HttpsURLConnection instead
            //url = new URL("https://www.google.com/search" + "?q=" + "java");
            url = new URL("http://api.duckduckgo.com/?q=java&format=json");
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            
            
        } catch (IOException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        conn.setRequestProperty("User-Agent", UA);
        
        try {
            System.out.println("Sending GET to " + url);
            int resp = conn.getResponseCode();
            System.out.println("Response code = " + resp);
            
        } catch (IOException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String line = null;
        StringBuilder response = new StringBuilder();
        
        try {
            while (null != (line = in.readLine())) {
                response.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        System.out.println("Response --->\n"+ response);
    }
    
    public void Post() {
        System.out.println("Not supported yet");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HttpTest o = new HttpTest();
        o.Get();
    }  
    
}
/* output
Sending GET to http://api.duckduckgo.com/?q=java&format=json
Response code = 200
Response --->
{"DefinitionSource":"","Heading":"Java","ImageWidth":0,"RelatedTopics":[{"Result":"<a href=\"https://duckduckgo.com/Java\">Java</a> An island of Indonesia. 
With a population of 143 million, Java is the home of ...
*/
