/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 
 */


package com.response;

import com.endpoints.AbstractEndpoint;

import java.util.ArrayList;

//JSON Library
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



/**
 * Version: 1
 * Author: Andreas
 * Date: 27 July 2016
 * Description: Takes the string from the response and parses it
 * Detail:	This class is called in Process
 * 			Passed the string with the response as a parameter
 * 			Use JSON API to parse into EndpointObject fields
*/
public class EndpointObject extends AbstractEndpoint{

	
	
	/**********************************************************/		
	// Non-static vars
	/**********************************************************/
	ArrayList<String> fieldList;
	
	
	/**********************************************************/
	// constructors
	/**********************************************************/
	/**
	 * Function: EndpointObject 
	 * Purpose: Constructor that parses an input JSON string
	 * Parameters: String inputResponseString - JSON from URL
	*/
	public EndpointObject(String inputResponseString){
		// Setup the field list
		this.fieldList = buildFieldList();
		// Fill in the inherited memeber variables
		buildJSONObject( inputResponseString );
		
		System.out.println( getDatasetid() );
		
	}// end EndpointObject(String inputResponseString)
	
	
	
	/**********************************************************/
	// getters
	/**********************************************************/
	
	
	/**********************************************************/
	// setters
	/**********************************************************/
	
	
	/**********************************************************/
	// action methods (?)
	/**********************************************************/
	
	
	/**
	 * Function: buildFieldList
	 * Purpose: Sets up the fields as a list
	 * Returns: ArrayList<String> of fields
	*/
	private ArrayList<String> buildFieldList(){
		ArrayList<String> fieldList = new ArrayList<String>();
		fieldList.add("datasetid");
		fieldList.add("datatypeid");
		fieldList.add("locationid");
		fieldList.add("stationid");
		fieldList.add("startdate");
		fieldList.add("enddate");
		fieldList.add("units");
		fieldList.add("sortfield");
		fieldList.add("sortorder");
		fieldList.add("limit");
		fieldList.add("offset");
		fieldList.add("includemetadata");
		
		return fieldList;
	}// end ArrayList<String> buildFieldList()
	
	
	
	
	
	/**
	 * Function: buildJSONObject 
	 * Purpose: Takes a JSON object and fills in the fields 
	 * 			inherited from the ABstractEndpoints class 
	 * Parameters: String inStr - JSON format with AbstractEndpoint
	 * 								fields
	*/
	private void buildJSONObject( String inStr){
		JSONParser parser = new JSONParser();
		// Object obj = ;
		
		try{
			JSONObject obj =  (JSONObject) parser.parse(inStr) ;
			
			setDatasetid( (String)obj.get(datasetid) );
		}// end try
		catch( ParseException pe){
			System.out.println("Damn- Parse Exception..");
			pe.printStackTrace();
			System.exit(1);
		}// end catch( ParseException pe)
		
		
		// Add the fields to the object
//		for( int i = 0; i < this.fieldList.size(); i++){
	//		obj.putIfAbsent( fieldList.get(i), null);
		//}// end for( int i = 0; i < this.fieldList.size(); i++)
		
		
		
		// Get the corresponding JSON  fields and set the member
		
		
	}// end void buildJSONObject( JSONObject obj)
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	
	/**********************************************************/
	// inner classes and functions
	/**********************************************************/
	

}// end class EndpointObject
