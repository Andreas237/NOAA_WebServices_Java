package com.requests;

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
 * Method:
 * 			i) Received parameters
 * 			ii) Get the Stream
 * 			iii) 
 * 
 * References:
 * 		- Java URL tutorial: http://alvinalexander.com/java/edu/pj/pj010011
 */



public class ReadJSONInput {
  
	
	// 1: We'll need this stuff.
	private URL myURL; // URL handler
	private InputStream is = null; // input handler
	private DataInputStream dis = null; //
	private String s;
	
	
	// Set from constructor call
	public String baseURL;
	public String token;
	public ArrayList<String> endpointsList;
	
	
	public ReadJSONInput(String baseURL, String token, ArrayList<String> endpointsList){
		
		this.baseURL = new String(baseURL);
		this.token = new String (token);
		this.endpointsList = new ArrayList<String>( endpointsList );

		
		dis = GetStream();
		readStream();
		closeStream();
		
		
	}// end ReadJSONInput constructor
	
	
	
	
	/*
	 * @fn ReadStream
	 * @purpose THis function takes teh stream reader and try block
	 */
	protected DataInputStream GetStream(){
		DataInputStream dis = new DataInputStream(null);
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

		
		return dis;
	}// end GetStream
	
	
	private void readStream() {
		//------------------------------------------------------------//
        // Step 5:                                                    //
        //------------------------------------------------------------//
        // Now just read each record of the input stream, and print   //
        // it out.  Note that it's assumed that this problem is run   //
        // from a command-line, not from an application or applet.    //
        //------------------------------------------------------------//
		try{	
			while ((s = this.dis.readLine()) != null) {
	            System.out.println(s);
	         }// end while ((s = this.dis.readLine()) != null)
		}// end try
			catch (IOException ioe){
				System.out.println("Damn- IO exception..");
				ioe.printStackTrace();
				System.exit(1);
			}// end IOException
	}// end ReadStream
	
	
	
	/**
	 * Function: closeStream 
	 * Purpose: This function closes the stream associated with this object
	 * Throws IOException: make sure the stream is open
	*/
	private void closeStream(){
		try {
            is.close();
         } catch (IOException ioe) {
            // just going to ignore this one
         }// end catch (IOException ioe)
	}// end closeStream
	
}// end class ReadJSONInput







