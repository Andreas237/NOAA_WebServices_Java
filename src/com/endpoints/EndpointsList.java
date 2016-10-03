/**
 * Author: Andreas Slovacek
 * Created Date: 10 June 2016
 * Last Modified: 25 July 2016
 * 
 * 
 * Change log:
 * 	01 September 2016 - Removed "/data" from being added in EndpointsList(), ArrayList<String> setupEndpoints( ),
 * 						
 * 
 */

package com.endpoints;


import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class EndpointsList {
	
	public ArrayList<String> endpointList;
	private String baseURL = "http://www.ncdc.noaa.gov/cdo-web/api/v2";
	
/**
 * Purpose: to 
* @fn Endpoints: constructor
* @var endpointList: list of Endpoints from the site
*/
	
	
	public EndpointsList(){
		endpointList = new ArrayList<String>();
		endpointList.add("/datasets");
		endpointList.add("/datacategories");
		endpointList.add("/datatypes");
		endpointList.add("/locationcategories");
		endpointList.add("/locations");
		endpointList.add("/stations");
		// endpointList.add("/data");
		
	}// end Endpoints()
	
	
	
	/*
	 * @fn setupEndpoints
	 * @input void
	 * @return endpointList ArrayList<String>
	 * @Purpose sets up a list of Endpoints 
	 */
	public ArrayList<String> setupEndpoints( ){
		endpointList = new ArrayList<String>();
		endpointList.add("/datasets");
		endpointList.add("/datacategories");
		endpointList.add("/datatypes");
		endpointList.add("/locationcategories");
		endpointList.add("/locations");
		endpointList.add("/stations");
		// endpointList.add("/data");
		
		return endpointList;
		
	}// end Endpoints()
	
	
}// End class Endpoints



 

/*
Create classes for each endpoint to handle
OR
Generalize all Endpoints?  identify and create template class....
* Datasets, Data Categories have the same parameters
*/