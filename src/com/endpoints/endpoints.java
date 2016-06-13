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

class endpoints extends datasets {
	
	protected ArrayList<String> endpointList;
	private String baseURL = "http://www.ncdc.noaa.gov/cdo-web/api/v2";
	
	/**
	 * @fn endpoints: constructor
	 * @var endpointList: list of endpoints from the site
	 */
	endpoints(){
		endpointList = new ArrayList<String>();
		endpointList.add("/datasets");
		endpointList.add("/datacategories");
		endpointList.add("/datatypes");
		endpointList.add("/locationcategories");
		endpointList.add("/locations");
		endpointList.add("/stations");
		endpointList.add("/data");
		
	}// end endpoints()
	
	
	
}// End class endpoints



 

/*
Create classes for each endpoint to handle
OR
Generalize all endpoints?  identify and create template class....
* Datasets, Data Categories have the same parameters
*/