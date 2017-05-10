/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 		01 September 2016 - Hit's every endpoint		
 */

package com.main;


// NET libs
import java.net.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// JSON Library
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// My classes
import com.endpoints.*;
import com.requests.*;
import com.response.EndpointObject;






class main {
	
	public static void main(String[] args) throws IOException{
		
		
		// Stuff from me
		//TODO Should be moved to a setup class.  Change "Endpoints" to "URLSetup"
		String baseURL = new String("https://www.ncdc.noaa.gov/cdo-web/api/v2");
		String token = new String("xdRtVRjotxEKXVgzXgCgadmAWrHkKFrr");
		ArrayList<String> endpointsList = (new EndpointsList() ).setupEndpoints() ; // get the list of endpoints	
		

		
		
		// Create a JSON Object designed for this site
		ReadJSONInput rbis = new ReadJSONInput(baseURL,token, endpointsList.get( 5 ) );	
		// Prints the object and fields
		EndpointObject EpObj = new EndpointObject( rbis.getStreamReturn() );
		
		String sepStart = "\n\n\n-------------------------------------\n";
		String sepEnd = "\n-------------------------------------";
		for( int i = 0; i < endpointsList.size(); i++ ){
			System.out.println( sepStart + endpointsList.get( i ).toString() + sepEnd);
			rbis = new ReadJSONInput(baseURL,token, endpointsList.get( i ) );
			EpObj = new EndpointObject( rbis.getStreamReturn() );
		}
		
		System.out.println("RUN FINISHED");
	}// End public static void main
	
}// end main class