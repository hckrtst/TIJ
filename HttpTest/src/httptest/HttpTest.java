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
            url = new URL("https://www.duckduckgo.com");
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
            System.out.println("Got response = " + resp);
            
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
Sending GET to https://www.duckduckgo.com
Got response = 200
Response --->
<!DOCTYPE html><!--[if IEMobile 7 ]> <html lang="en_US" class="no-js iem7"> 
<![endif]--><!--[if lt IE 7]> <html class="ie6 lt-ie10 lt-ie9 lt-ie8 lt-ie7 no-js" lang="en_US"> <![endif]--><!--[if IE 7]>    
<html class="ie7 lt-ie10 lt-ie9 lt-ie8 no-js" lang="en_US"> <![endif]--><!--[if IE 8]>    
<html class="ie8 lt-ie10 lt-ie9 no-js" lang="en_US"> <![endif]--><!--[if IE 9]>    
<html class="ie9 lt-ie10 no-js" lang="en_US"> <![endif]--><!--[if (gte IE 9)|(gt IEMobile 7)|!(IEMobile)|!(IE)]><!--><html class="no-js" lang="en_US"><!--<![endif]-->  
<head>    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8;charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=1" />
<meta name="HandheldFriendly" content="true"/><link rel="canonical" href="https://duckduckgo.com/">
.....snip...
BUILD SUCCESSFUL (total time: 1 second)
*/
