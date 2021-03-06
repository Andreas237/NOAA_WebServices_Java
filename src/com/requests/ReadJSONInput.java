/**
 * Author: Andreas Slovacek
 * Created: 25 July 2016
 * 
 * Change log:
 * 
 * 		27 July 2016 - 	i) Componentized the calls to outside URL
 * 						ii) readStream() returns a string to the class.  This will be sent to another object
 */


package com.requests;


//NET libs
import java.net.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;




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
	private DataInputStream dis = null; //
	private String endpointType = null;
	private InputStream is = null; // input handler
	private String s = null;
	private String streamReturn = null; // returned 
	private URL myURL; // URL handler
	
	
	// Set from constructor call
	protected String baseURL = null;
	protected String token = null;
	protected String endpoint = null;
	
	
	
	
	
	
	
	/**
	 * Function: ReadJSONInput 
	 * Purpose: constructor that calls all the processing funcitons in this class 
	 * Parameters: [optional] [type what they are bring]
	 * Returns: [what is sent back and type]
	 * Throws [Exception(s)]: [description]
	*/
	public ReadJSONInput(String baseURL, String token, String endpoint){
		
		this.baseURL = new String(baseURL);
		this.token = new String (token);
		this.endpoint = new String( endpoint );
		this.endpointType = new String( endpoint.replace("'/", "") );

		
		dis = GetStream();
		this.streamReturn = readStream();
		closeStream();
				
		
	}// end ReadJSONInput constructor
	
	
	
	
	
	
	/*
	 * @fn ReadStream
	 * @purpose THis function takes teh stream reader and try block
	 */
	protected DataInputStream GetStream(){
		
		
		DataInputStream dis = new DataInputStream(null);
		
		
		try{

			/*
			 * Create a URL with an endpoint
			 */
			myURL = new URL(baseURL + endpoint); // throws MalformedURLException

			
			// System.out.println("Trying to print myURL.......");
			// System.out.println(myURL);
			// System.out.println("Printed myURL");
		
		
		

			/*
			 *  Open a URL connections
			 */
			URLConnection connection = (URLConnection) myURL.openConnection();
			connection.setRequestProperty("token",token);
			
			
			// System.out.println("Getting content...");
			// System.out.println(connection.getDoOutput() );
			
			
			/* 
			 * actual open stream
			 */
			// System.out.println("Trying to open Stream....");
			is = connection.getInputStream(); // throws IOException
			// System.out.println("Stream opened");
		
			
			
		
			/*
			 * Convert InputStream to buffered DataInputStream.
			 * reading will be faster, and readline is easy
			 */
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
	
	
	
	
	
	
	/**
	 * Function: readStream 
	 * Purpose: Reads from data input stream and prints the result
	 * Parameters: Use class memeber variable dis
	 * Returns: string value returned from stream
	*/
	private String readStream() {

		/*
		 * Read each record from the input
		 */
		String streamString = new String();
		try{	
			while ((s = this.dis.readLine()) != null) {
				streamString = streamString + s;
	         }// end while ((s = this.dis.readLine()) != null)
		}// end try
			catch (IOException ioe){
				System.out.println("Damn- IO exception..");
				ioe.printStackTrace();
				System.exit(1);
			}// end IOException
		
		// System.out.println("Stream:\n---------------------------------\n" + streamString);
		return streamString;
	}// end ReadStream
	
	
	
	
	
	
	/**
	 * Function: getStreamReturn 
	 * Purpose: Return the streamReturn variable as string
	 * Parameters: none
	 * Returns: String streamReturn
	*/
	public String getStreamReturn(){
		return this.streamReturn;
	}// end processStream
	
	
	
	
	
	
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







