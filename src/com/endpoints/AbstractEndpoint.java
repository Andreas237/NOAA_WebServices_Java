/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 		9 August 2016 - printResults() and printSingleItem() functions not available since
 * 						the classes set this master classes values.  Should create a new object for
 * 						for each value added to the results and the fields should be in the singleItem class.
 * 						Metadata will set the other values
 * 						
 */

package com.endpoints;

import org.json.simple.JSONObject;
import java.util.ArrayList;

/**
 * Version: 1
 * Author: Andreas Slovacek
 * Date: 27 July 2016
 * Description: Implements the endpoints, getters, setters
 * Detail: All endpoints have this many fields at most
*/
public abstract class AbstractEndpoint {
	

	
	/**********************************************************/		
	// Non-static vars
	/**********************************************************/
	// Objects
	public SingleItem singleItem;
	public ArrayList<SingleItem> results;
	public MetaData metadata;
	
	
	// Results
	
	protected Integer count;
	protected Double datacoverage; 
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


	
	/**********************************************************/
	// action methods (?)
	/**********************************************************/
	
	/**
	 * Function: printResults 
	 * Purpose: dthis function prints all the items in the results ArrayList
	 * Parameters: None.  Uses this.results
	 * Returns: None
	 * Throws None
	*/
	public void printResults(){
		
	}// end printResults
	
	
	
	
	/**
	 * Function: printResults 
	 * Purpose: This function prints the fields in a Single Item
	 * Parameters: None.  Uses this.results
	 * Returns: None
	 * Throws None
	*/
	public void printSingleItem( SingleItem so){
		// System.out.println( this.getId() );
	}// end printResults
	
	
	
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	
	/**********************************************************/
	// inner classes and functions
	/**********************************************************/
	/**
	 * Version: 1
	 * Author: Andreas Slovacek
	 * Date: 02 August 2016
	 * Description: This class takes JSON input for a Single Item and populates fields
	 * Detail: 	Call setter methods on the fields found in a "Single Item"
	 * 			Reference here - https://www.ncdc.noaa.gov/cdo-web/webservices/v2#gettingStarted
	*/
	protected class SingleItem{
		
		public SingleItem(JSONObject obj){
						
			setDatasetid( (String) obj.get( "id" ) );
			setName( (String) obj.get("name") );
			setDatascoverage( (Double)(obj.get("datacoverage")) );
			setMindate( (String) obj.get("mindate") );
			setMaxdate( (String) obj.get("maxdate") );

		}// end SingleItem(JSONObject obj)
	}// end class SingleItem


	
	
	/**
	 * Version: 1
	 * Author: Andreas Slovacek
	 * Date: 03 August 2016
	 * Description: This class takes JSON input for a Metadata Item and populates fields
	 * Detail: 	Call setter methods on the fields found in a "Single Item"
	 * 			Reference here - https://www.ncdc.noaa.gov/cdo-web/webservices/v2#gettingStarted
	*/
	protected class MetaData{
		
		public MetaData(JSONObject obj){
			JSONObject resultset = new JSONObject( obj );
			setLimit( (Integer) obj.get("limit") );
			setCount( (Integer) obj.get("count") );
			setOffset( (Integer) obj.get("offset") );
		}// end MetaData
	}// end class MetaData


	
	/**
	 * Version: 1
	 * Author: Andreas Slovacek
	 * Date: 02 August 2016
	 * Description: This class takes JSON input for a Collection of items with metadata as defined and populates fields
	 * Detail: 	Call setter methods on the fields found in a "Single Item"
	 * 			Reference here - https://www.ncdc.noaa.gov/cdo-web/webservices/v2#gettingStarted
	*/
	class CollectionWithMetadata{
		
	} // end class CollectionWithMetadata
	
	
	
	

}// end abstract class AbstractEndpoint
