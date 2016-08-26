/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 		02 August 2016 - buildJSONObject(String) updated and has begun breaking down the string to
 * 						its JSON components
 * 		09 August 2016 - Test "Trying to populate SingleItem (derived from CollectionItem)" runs
 * 						if result(0) not used... Interesting...
 * 		12 August 2016 - moving buildJSONObject to CollectionItem
 */


package com.response;

import com.endpoints.CollectionItem;

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
 * Detail:	This class is called in ReadJSONInput
 * 			Passed the string with the response as a parameter
 * 			Use JSON API to parse into EndpointObject fields
*/
public class EndpointObject {

	
	
	/**********************************************************/		
	// Non-static vars
	/**********************************************************/
	private ArrayList<String> fieldList; // fields within a result
	private ArrayList<String> metadataFieldList; // metadata fields
	private JSONObject thisJson; // input JSON from stream
	private CollectionItem Collection; // The collection
	
	
	
	
	
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

		this.Collection = new CollectionItem(inputResponseString);
		
		this.Collection.printTheCollection();
		
		//System.out.println( getDatasetid() );
		
	}// end EndpointObject(String inputResponseString)
	
	
	
	
	
	
	
	/**********************************************************/
	// getters
	/**********************************************************/
	
	public ArrayList<String> getFieldList(){			return this.fieldList; }
	public ArrayList<String> getMetadataFieldList(){	return this.metadataFieldList; }
	public JSONObject getThisJson(){					return this.thisJson; }
	public CollectionItem getCollectionItem(){  		return this.Collection;	}
	


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

	
	

}// end class EndpointObject
