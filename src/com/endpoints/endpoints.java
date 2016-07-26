/**
 * Author: Andreas Slovacek
 * Created Date: 10 June 2016
 * Last Modified: 25 July 2016
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

import com.endpoints.datasets;

public class endpoints extends datasets {
	
	public ArrayList<String> endpointList;
	private String baseURL = "http://www.ncdc.noaa.gov/cdo-web/api/v2";
	
/**
 * Purpose: to 
* @fn endpoints: constructor
* @var endpointList: list of endpoints from the site
*/
	
	
	public endpoints(){
		endpointList = new ArrayList<String>();
		endpointList.add("/datasets");
		endpointList.add("/datacategories");
		endpointList.add("/datatypes");
		endpointList.add("/locationcategories");
		endpointList.add("/locations");
		endpointList.add("/stations");
		endpointList.add("/data");
		
	}// end endpoints()
	
	
	
	/*
	 * @fn setupEndpoints
	 * @input void
	 * @return endpointList ArrayList<String>
	 * @Purpose sets up a list of endpoints 
	 */
	public ArrayList<String> setupEndpoints( ){
		endpointList = new ArrayList<String>();
		endpointList.add("/datasets");
		endpointList.add("/datacategories");
		endpointList.add("/datatypes");
		endpointList.add("/locationcategories");
		endpointList.add("/locations");
		endpointList.add("/stations");
		endpointList.add("/data");
		
		return endpointList;
		
	}// end endpoints()
	
	
}// End class endpoints



 

/*
Create classes for each endpoint to handle
OR
Generalize all endpoints?  identify and create template class....
* Datasets, Data Categories have the same parameters
*/