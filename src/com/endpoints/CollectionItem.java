/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 		09 August 2016 - printResults() and printSingleItem() functions not available since
 * 						the classes set this master classes values.  Should create a new object for
 * 						for each value added to the results and the fields should be in the singleItem class.
 * 						Metadata will set the other values
 * 		11 August 2016 - moved buildJSONObject from EndpointObject
 * 		17 August 2016 - Added "hasResults" function
 * 						
 */

package com.endpoints;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Version: 1
 * Author: Andreas Slovacek
 * Date: 27 July 2016
 * Description: Implements the endpoints, getters, setters
 * Detail: All endpoints have this many fields at most
*/
public class CollectionItem{



	/**********************************************************/		
	// Non-static vars
	/**********************************************************/
	// Objects
	public SingleItem singleItem;
	public ArrayList<SingleItem> results;
	public JSONObject CollectionItemJSON;
	
	
	// Results
	
	protected Integer count;
	protected Double datacoverage; // Single Item datacoverage
	protected String datasetid;    //Required. Accepts a single valid dataset id. Data returned will be from the dataset specified.
	protected String datatypeid;    //Optional. Accepts a valid data type id or a chain of data type ids seperated by ampersands. Data returned will contain all of the data type(s) specified.
	protected String enddate;    //Required. Accepts valid ISO formated date (YYYY-MM-DD) or date time (YYYY-MM-DDThh:mm:ss). Data returned will be before the specified date.
	protected String includemetadata;    //Optional. Defaults to true, used to improve response time by preventing the calculation of result metadata.
	protected Integer limit;    //Optional. Defaults to 25, limits the number of results in the response. Maximum is 1000.
	protected String locationid;    //Optional. Accepts a valid location id or a chain of location ids seperated by ampersands. Data returned will contain data for the location(s) specified.
	protected String maxdate;	// Maximum date for result/single item
	protected String mindate;	// Minimum date for result/single item 
	protected String name;
	protected Integer offset;    //Optional. Defaults to 0, used to offset the resultlist. The example would begin with record 24.
	protected String sortfield;    //Optional. The field to sort results by. Supports id, name, mindate, maxdate, and datacoverage fields.
	protected String sortorder;    //Optional. Which order to sort by, asc or desc. Defaults to asc.
	protected String startdate;    //Required. Accepts valid ISO formated date (YYYY-MM-DD) or date time (YYYY-MM-DDThh:mm:ss). Data returned will be after the specified date.
	protected String stationid;    //Optional. Accepts a valid station id or a chain of of station ids seperated by ampersands. Data returned will contain data for the station(s) specified.
	protected String units;    //Optional. Accepts the literal strings 'standard' or 'metric'. Data will be scaled and converted to the specified units. If a unit is not provided then no scaling nor conversion will take place.
	
	
	/**********************************************************/
	// constructors
	/**********************************************************/
	
	
	/**
	 * Function: CollectionItem(JSONObject obj) 
	 * Purpose: Constructor that takes a JSON Object and
	 * 			updates associated member variables
	 * Parameters: JSONObject obj
	*/
	public CollectionItem(JSONObject obj) {
		
		// TODO: create results ArrayList
		// Call "SingleItem" consturctor
		
		// Get Metadata	
	}// end public CollectionItem(JSONObject obj)
	
	
	
	
	
	/**
	 * Function: CollectionItem(String inString) 
	 * Purpose: Takes a string Object and
	 * 			updates associated member variables
	 * Parameters: String inString - JSON format with CollectionItem
	 * 								fields
	*/
	public CollectionItem(String inString) {
		
		this.buildJSONObject(inString);

		this.setMetaData( (JSONObject) this.CollectionItemJSON.get("metadata") );
		
		// Call "SingleItem" consturctor
		this.results = new ArrayList<SingleItem>();
		this.buildResults(this.results, this.CollectionItemJSON );

	}// end public CollectionItem(JSONObject obj)
	
	
	
	
	/**********************************************************/
	// getters
	/**********************************************************/
	protected Integer getCount(){	return this.count; }	
	protected Double getDatacoverage(){	return this.datacoverage; } // return the value of this object in datacoverage
	protected String getDatasetid(){    return this.datasetid ;}  // return the value of this object in datasetid
	protected String getDatatypeid(){    return this.datatypeid ;}  // return the value of this object in datatypeid
	protected String getEnddate(){    return this.enddate ;}  // return the value of this object in enddate
	protected String getIncludemetadata(){    return this.includemetadata ;}  // return the value of this object in includemetadata
	protected String getMaxdate(){	return this.maxdate;}	 // return the value of this object in maxdate
	protected String getMindate(){	return this.mindate;}	// return the value of this object in maxdate
	protected String getName(){    return this.name; }  // return the value of this object in name
	protected Integer getLimit(){    return this.limit ;}  // return the value of this object in limit
	protected String getLocationid(){    return this.locationid ;}  // return the value of this object in locationid
	protected Integer getOffset(){    return this.offset ;}  // return the value of this object in offset
	protected String getSortfield(){    return this.sortfield ;}  // return the value of this object in sortfield
	protected String getSortorder(){    return this.sortorder ;}  // return the value of this object in sortorder
	protected String getStartdate(){    return this.startdate ;}  // return the value of this object in startdate
 	protected String getStationid(){    return this.stationid ;}  // return the value of this object in stationid
	protected String getUnits(){    return this.units ;}  // return the value of this object in units
	
	
	/**********************************************************/
	// setters
	/**********************************************************/	
	protected void setCount( Integer count){	this.count = count; }  // set the value of this object in count
	protected void setDatascoverage( Double datacoverage){		this.datacoverage = datacoverage; }
	protected void setDatasetid( String datasetid){    this.datasetid = datasetid;}  // set the value of this object in datasetid
	protected void setDatatypeid( String datatypeid){    this.datatypeid = datatypeid;}  // set the value of this object in datatypeid
	protected void setEnddate( String enddate){    this.enddate = enddate;}  // set the value of this object in enddate
	protected void setIncludemetadata( String includemetadata){    this.includemetadata = includemetadata;}  // set the value of this object in includemetadata
	protected void setLimit( Integer limit){    this.limit = limit;}  // set the value of this object in limit
	protected void setLocationid( String locationid){    this.locationid = locationid;}  // set the value of this object in locationid
	protected void setMaxdate(String maxdate){	this.maxdate = maxdate;}	 // set the value of this object in maxdate
	protected void setMindate(String mindate){	this.mindate = mindate;}	// set the value of this object in maxdate	
	protected void setName( String name){	this.name = name;}// set the value of this object in name
	protected void setOffset( Integer offset){    this.offset = offset;}  // set the value of this object in offset
	protected void setSortfield( String sortfield){    this.sortfield = sortfield;}  // set the value of this object in sortfield
	protected void setSortorder( String sortorder){    this.sortorder = sortorder;}  // set the value of this object in sortorder
	protected void setStartdate( String startdate){    this.startdate = startdate;}  // set the value of this object in startdate
	protected void setStationid( String stationid){    this.stationid = stationid;}  // set the value of this object in stationid
	protected void setUnits( String units){    this.units = units;}  // set the value of this object in units

	protected void setMetaData(JSONObject obj){
		JSONObject resultset = new JSONObject( obj );
		
		setLimit( (Integer) obj.get("limit") );
		setCount( (Integer) obj.get("count") );
		setOffset( (Integer) obj.get("offset") );
	}// end MetaData

	
	
	
	
	
	
	
	/**********************************************************/
	// action methods
	/**********************************************************/
	
	
	/**
	 * Function: buildJSONObject 
	 * Purpose: Takes a string object and using the JSON parser
	 * 			turns it into a JSON Object
	 * Parameters: String inStr - JSON format with CollectionItem
	 * 								fields
	*/
	public void buildJSONObject( String inStr){
		JSONParser parser = new JSONParser();
		
		try{
			//System.out.println(inStr);
			CollectionItemJSON =  (JSONObject) parser.parse(inStr) ;
			
		}// end try
		catch( ParseException pe){
			System.out.println("Damn- Parse Exception in ..");
			pe.printStackTrace();
			System.exit(1);
		}// end catch( ParseException pe)		
	}// end void buildJSONObject( JSONObject obj)
	
	
	
	
	
	
	/**
	 * Function: buildResults
	 * Purpose: Take a collection of "Results" and ArrayList to put
	 * 			them in; iterate through them creating records
	 * Parameters: 	ArrayList<SingleItem> results - empty array list
	 * 				JSONObject collection - collection of "Results"
	 * 					from source
	*/
	private void buildResults(ArrayList<SingleItem> results, JSONObject collection){
		// System.out.println("Now in:\tFile \" CollectionItem.java \" \tFunction \"buildResults\"");	
		// System.out.println("\n\nResult: " + collection.get("results").toString() );
		// System.out.println("\nResults 0: " + resultArray.get(0) );
		
		
		
		JSONArray resultArray = (JSONArray) collection.get("results");

		
		
		// Loop through the array, add each result as SingleItem to result
		for( Integer i = 0; i < resultArray.size(); i++ ){
			results.add( new SingleItem( (JSONObject)resultArray.get(i) ) );
		}// end for( Integer i = 0; i < resultArray.size(); i++ )
		
	}// end private void buildResults
	
	
	
	
	
	
	
	/**********************************************************/
	// data test methods
	/**********************************************************/
	
	
	
	/**
	 * Function: printMetadata
	 * Purpose: Print the metadata fields in the object
	 */
	protected void printMetadata(){
		System.out.println("----- Metadata -----");
		System.out.println( "Limit: " + getLimit() );
		System.out.println( "Count: " + getCount() );
		System.out.println( "Offset: " + getOffset() );
	}// end public void printMetadata()
	
	
	
	
	/**
	 * Function: printTheCollection
	 * Purpose: Prints the Metadata and any results
	 */
	public void printTheCollection(){
		
		String sep = "------------------------------" ;
		
		
		// Print the Metadata
		System.out.println(sep);
		this.printMetadata();
		
		// If the results array has items print them
		if( results.size() > 0 ){

			for( SingleItem s : this.results ){
				System.out.println(sep);
				s.printAllFields();
				
			}// end for( SingleItem s : this.results )
			
		}// end if( results.size() > 0 )
		
	}// end public void printTheCollection
	
	
	
	
	
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	/**
	 * Function: hasResults
	 * Purpose: Take a collection JSON object and check whether it has
	 * 			results in it
	 * Parameters: 	JSONObject collection - collection of "Results"
	 * 
	*/
	protected boolean hasResults( JSONObject obj){
		boolean answer = false ;
		
		if( obj.get("results") != null ){ answer = true; }
		
		return answer;
	}// end public boolean hasResults( JSONObject obj)



	
	
	
	

}// end class CollectionItem
