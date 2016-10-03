package com.requests;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;

import com.endpoints.EndpointsList;
import com.requests.ReadJSONInput;


public class ReadJSONInputTest {

	// Member Variables
	private String baseURL = new String("http://www.ncdc.noaa.gov/cdo-web/api/v2");
	private String token = new String("xdRtVRjotxEKXVgzXgCgadmAWrHkKFrr");
	private ArrayList<String> endpointsList = (new EndpointsList() ).setupEndpoints() ; // get the list of endpoints
	
	private ReadJSONInput rbis;
	private DataInputStream dis = null; //
	private String endpoint = null;
	private String endpointType = null;
	private InputStream is = null; // input handler
	private String s = null;
	private String streamReturn = null; // returned 
	private URL myURL; // URL handler
	
	
	
	/**
	 * Constructor test
	 * If the baseURL, token, endpoint and endPointType are filled in then this succeeds
	 */
	@Test
	public void testReadJSONInput() {
		rbis = new ReadJSONInput(baseURL,token, endpointsList.get( 5 ) );
		
		assertNotNull("ERROR: this.baseURL is NULL after constructor", this.baseURL);
		assertNotNull("ERROR: this.token is NULL after constructor", this.token);
		assertNotNull("ERROR: this.endpoint is NULL after constructor", this.endpoint);
		assertNotNull("ERROR: -- is NULL after constructor", this.endpointType);
		
	}

	
	
	@Test
	public void testGetStream() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetStreamReturn() {
		fail("Not yet implemented"); // TODO
	}

}
