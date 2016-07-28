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
		String baseURL = new String("http://www.ncdc.noaa.gov/cdo-web/api/v2");
		String token = new String("xdRtVRjotxEKXVgzXgCgadmAWrHkKFrr");
		ArrayList<String> endpointsList = (new EndpointsList() ).setupEndpoints() ; // get the list of endpoints	
		

		ReadJSONInput rbis = new ReadJSONInput(baseURL,token, endpointsList.get(0) );			
		
		EndpointObject EpObj = new EndpointObject( rbis.getStreamReturn() );
		
		System.out.println("RUN FINISHED");
	}// End public static void main
	
}// end main class