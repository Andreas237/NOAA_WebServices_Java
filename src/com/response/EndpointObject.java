/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 		2 August 2016 - buildJSONObject(String) updated and has begun breaking down the string to
 * 						its JSON components
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
	ArrayList<String> fieldList; // fields within a result
	ArrayList<String> metadataFieldList; // metadata fields
	
	
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
		this.metadataFieldList = buildMetadataFieldList();
		
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
	 * Function: buildMetadataFieldList
	 * Purpose: Sets up the fields as a list
	 * Returns: ArrayList<String> of fields
	*/
	private ArrayList<String> buildMetadataFieldList(){
		ArrayList<String> metadataFieldList = new ArrayList<String>();
		
		metadataFieldList.add("metadata");
		metadataFieldList.add("resultset");

		
		return metadataFieldList;
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
			//System.out.println(inStr);
			JSONObject obj =  (JSONObject) parser.parse(inStr) ;
			System.out.println("Made it past parser...");
			// setDatasetid( (String)obj.get(datasetid) );
			System.out.println("\n\nPrinting various things:");
			
			System.out.println( "\nobj.get(\"metadata\") = " + obj.get("metadata") + "\n" );
			System.out.println( "\nobj.get(\"results\") = " + obj.get("results") + "\n" );
			
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println("\t\tTrying to reference JSON Array Value");
			System.out.println("-----------------------------------------------------------");
			JSONArray resultArray = (JSONArray) obj.get("results");
			System.out.println( resultArray.get(0) );
			
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println("\t\tTrying to populate SingleItem (derived from AbstractEndpoint)");
			System.out.println("-----------------------------------------------------------");
			singleItem = new SingleItem( (JSONObject) resultArray.get(0) ); 
			System.out.println("from result array, maxdate = " + this.getMaxdate() );
			
			
			
		}// end try
		catch( ParseException pe){
			System.out.println("Damn- Parse Exception..");
			pe.printStackTrace();
			System.exit(1);
		}// end catch( ParseException pe)
	
		
		
		// Get the corresponding JSON  fields and set the member
		
		
	}// end void buildJSONObject( JSONObject obj)
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	
	/**********************************************************/
	// inner classes and functions
	/**********************************************************/
	

}// end class EndpointObject
