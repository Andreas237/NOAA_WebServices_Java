/**
 * Author: Andreas Slovacek
 * Created: 27 July 2016
 * 
 * Change log:
 * 
 */

package com.endpoints;

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
	protected String datasetid;    //Required. Accepts a single valid dataset id. Data returned will be from the dataset specified.
	protected String datatypeid;    //Optional. Accepts a valid data type id or a chain of data type ids seperated by ampersands. Data returned will contain all of the data type(s) specified.
	protected String locationid;    //Optional. Accepts a valid location id or a chain of location ids seperated by ampersands. Data returned will contain data for the location(s) specified.
	protected String stationid;    //Optional. Accepts a valid station id or a chain of of station ids seperated by ampersands. Data returned will contain data for the station(s) specified.
	protected String startdate;    //Required. Accepts valid ISO formated date (YYYY-MM-DD) or date time (YYYY-MM-DDThh:mm:ss). Data returned will be after the specified date.
	protected String enddate;    //Required. Accepts valid ISO formated date (YYYY-MM-DD) or date time (YYYY-MM-DDThh:mm:ss). Data returned will be before the specified date.
	protected String units;    //Optional. Accepts the literal strings 'standard' or 'metric'. Data will be scaled and converted to the specified units. If a unit is not provided then no scaling nor conversion will take place.
	protected String sortfield;    //Optional. The field to sort results by. Supports id, name, mindate, maxdate, and datacoverage fields.
	protected String sortorder;    //Optional. Which order to sort by, asc or desc. Defaults to asc.
	protected String limit;    //Optional. Defaults to 25, limits the number of results in the response. Maximum is 1000.
	protected String offset;    //Optional. Defaults to 0, used to offset the resultlist. The example would begin with record 24.
	protected String includemetadata;    //Optional. Defaults to true, used to improve response time by preventing the calculation of result metadata.

	
	
	/**********************************************************/
	// constructors
	/**********************************************************/
	
	
	/**********************************************************/
	// getters
	/**********************************************************/
	protected String getDatasetid(){    return this.datasetid = datasetid;}  // return the value of this object in datasetid
	protected String getDatatypeid(){    return this.datatypeid = datatypeid;}  // return the value of this object in datatypeid
	protected String getLocationid(){    return this.locationid = locationid;}  // return the value of this object in locationid
	protected String getStationid(){    return this.stationid = stationid;}  // return the value of this object in stationid
	protected String getStartdate(){    return this.startdate = startdate;}  // return the value of this object in startdate
	protected String getEnddate(){    return this.enddate = enddate;}  // return the value of this object in enddate
	protected String getUnits(){    return this.units = units;}  // return the value of this object in units
	protected String getSortfield(){    return this.sortfield = sortfield;}  // return the value of this object in sortfield
	protected String getSortorder(){    return this.sortorder = sortorder;}  // return the value of this object in sortorder
	protected String getLimit(){    return this.limit = limit;}  // return the value of this object in limit
	protected String getOffset(){    return this.offset = offset;}  // return the value of this object in offset
	protected String getIncludemetadata(){    return this.includemetadata = includemetadata;}  // return the value of this object in includemetadata
	
	
	/**********************************************************/
	// setters
	/**********************************************************/	
	protected void setDatasetid( String datasetid){    this.datasetid = datasetid;}  // return the value of this object in datasetid
	protected void setDatatypeid( String datatypeid){    this.datatypeid = datatypeid;}  // return the value of this object in datatypeid
	protected void setLocationid( String locationid){    this.locationid = locationid;}  // return the value of this object in locationid
	protected void setStationid( String stationid){    this.stationid = stationid;}  // return the value of this object in stationid
	protected void setStartdate( String startdate){    this.startdate = startdate;}  // return the value of this object in startdate
	protected void setEnddate( String enddate){    this.enddate = enddate;}  // return the value of this object in enddate
	protected void setUnits( String units){    this.units = units;}  // return the value of this object in units
	protected void setSortfield( String sortfield){    this.sortfield = sortfield;}  // return the value of this object in sortfield
	protected void setSortorder( String sortorder){    this.sortorder = sortorder;}  // return the value of this object in sortorder
	protected void setLimit( String limit){    this.limit = limit;}  // return the value of this object in limit
	protected void setOffset( String offset){    this.offset = offset;}  // return the value of this object in offset
	protected void setIncludemetadata( String includemetadata){    this.includemetadata = includemetadata;}  // return the value of this object in includemetadata


	
	/**********************************************************/
	// action methods (?)
	/**********************************************************/
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	
	/**********************************************************/
	// inner classes and functions
	/**********************************************************/

}// end abstract class AbstractEndpoint
