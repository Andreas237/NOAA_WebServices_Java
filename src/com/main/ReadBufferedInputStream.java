package com.main;

/**
 * Author: Andreas Slovacek
 * Created: 25 July 2016
 * Last Modified: 25 July 2016
 */



//NET libs
import java.net.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

//JSON Library
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * 
 * Purpose: this class replaces the functionality built in main.java. This functionality
 * 			will be replaced with a streaming JSON API parser.
 * 
 * References:
 * 		- Java URL tutorial: http://alvinalexander.com/java/edu/pj/pj010011
 */



public class ReadBufferedInputStream {
	/**
	 * Java URL tutorial: http://alvinalexander.com/java/edu/pj/pj010011
	 */
	// 1: We'll need this stuff.
	URL myURL; // URL handler
	InputStream is = null; // input handler
	DataInputStream dis = null; //
	String s;
	
	
	ReadBufferedInputStream(String baseURL, String token, ArrayList<String> endpointsList){

		
		try{
		//------------------------------------------------------------//
        // Step 2:  Create the URL.                                   //
        //------------------------------------------------------------//
        // Note: Put your real URL here, or better yet, read it as a  //
        // command-line arg, or read it from a file.                  //
        //------------------------------------------------------------//
			System.out.println("Trying to print myURL.......");
			myURL = new URL(baseURL + endpointsList.get(0)); // throws MalformedURLException
		
			System.out.println(myURL);
			System.out.println("Printed myURL");
		
		
		
		//----------------------------------------------//
        // Step 3:  Open an input stream from the url.  //
        //----------------------------------------------//
			// Open a URL connections
			URLConnection connection = (URLConnection) myURL.openConnection();
			connection.setRequestProperty("token",token);
			System.out.println("Getting content...");
			System.out.println(connection.getDoOutput() );
			
			
			// actual open stream
			System.out.println("Trying to open Stream....");
			is = connection.getInputStream(); // throws IOException
			System.out.println("Stream opened");
		
		
		//-------------------------------------------------------------//
        // Step 4:                                                     //
        //-------------------------------------------------------------//
        // Convert the InputStream to a buffered DataInputStream.      //
        // Buffering the stream makes the reading faster; the          //
        // readLine() method of the DataInputStream makes the reading  //
        // easier.                                                     //
        //-------------------------------------------------------------//
			dis = new DataInputStream(new BufferedInputStream(is));
		
		
		
		//------------------------------------------------------------//
        // Step 5:                                                    //
        //------------------------------------------------------------//
        // Now just read each record of the input stream, and print   //
        // it out.  Note that it's assumed that this problem is run   //
        // from a command-line, not from an application or applet.    //
        //------------------------------------------------------------//
			while ((s = dis.readLine()) != null) {
	            System.out.println(s);
	         }
			
			
			
			}// end try
		
			catch (MalformedURLException mue){
				System.out.println("Damn- malformed URL..");
				mue.printStackTrace();
				System.exit(1);
			}// end MalformedURLException
			catch (IOException ioe){
				System.out.println("Damn- IO exception..");
				ioe.printStackTrace();
				System.exit(1);
			}// end IOException
			finally {
				//---------------------------------//
		        // Step 6:  Close the InputStream  //
		        //---------------------------------//
				try {
		            is.close();
		         } catch (IOException ioe) {
		            // just going to ignore this one
		         }// end catch (IOException ioe)
				
			}// end finally
		
		
	}// end ReadBufferedInputStream
	
	
}// end class ReadBufferedInputStream