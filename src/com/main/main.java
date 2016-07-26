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

class main {
	
	public static void main(String[] args) throws IOException{
		
		
		// Stuff from me
		String baseURL = new String("http://www.ncdc.noaa.gov/cdo-web/api/v2");
		String token = new String("xdRtVRjotxEKXVgzXgCgadmAWrHkKFrr");
		ArrayList<String> endpointsList = (new endpoints() ).setupEndpoints() ; // get the list of endpoints		
		
		for(int i = 0; i < endpointsList.size(); i++ ){
			System.out.println( "#" + i + ":\t" + endpointsList.get(i) );
		}

		ReadJSONInput rbis = new ReadJSONInput(baseURL,token, endpointsList );
		
			
		
	}// End public static void main
	
}// end main class