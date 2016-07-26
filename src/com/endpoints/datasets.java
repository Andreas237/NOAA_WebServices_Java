/**
 * Author: Andreas Slovacek
 * Created Date: 10 June 2016
 * Last Modified: 25 July 2016
 */

package com.endpoints;


import java.util.*;


/** 
* Purpose: This class processes the Datasets endpoint found at 
* https://www.ncdc.noaa.gov/cdo-web/webservices/v2#datasets
* 
* Called by endpoints.java to handle this endpoint
*/

/** NOTE: ENDPOINTS Class SHOULD BE ABSTRACT/VIRTUAL AND HAVE ALL THE METHODS, VARS ETC NEEDED FOR *AN* ENDPOINT.
 * 		Each named endpoint will have an interface/ derived class.
**/

class datasets{
	
	//TODO Make these private and
	// Parameters
	private String datatypeid; 	//	Optional. Accepts a valid data type id or a chain of data type ids seperated by ampersands.
	private String locationid; 	//  Optional. Accepts a valid location id or a chain of location ids seperated by ampersands.
	private String stationid;	// 	Optional. Accepts a valid station id or a chain of of station ids seperated by ampersands.
	private Date startdate; 	// 	Optional. Must be in yyyy-mm-dd format
	private Date enddate; 		// 	Optional. Must be in yyyy-mm-dd format
	private String sortfield; 	// 	Optional. The field to sort results by. Supports id, name, mindate, maxdate, and datacoverage fields
	private Integer limit;		//	Optional. Defaults to 25, limits the number of results in the response. Maximum is 1000
	private Integer offset;		//	Optional. Defaults to 0, used to offset the resultlist. The example would begin with record 24
	
	
	protected String getDatatypid(){ return datatypeid;} 
	protected String getLocationid(){ return locationid;}
	protected String getStationid(){ return stationid;}
	protected Date getStartdate(){ return startdate;}
	protected Date getEnddate(){ return enddate;}
	protected Integer getLimit(){ return limit;}
	protected Integer getOffset(){ return offset;}
	
	protected void setDatatypid(String in){ this.datatypeid = in;} 
	protected void setLocationid(String in){ this.locationid = in;}
	protected void setStationid(String in){ this.stationid = in;}
	protected void setStartdate(Date in){ this.startdate = in;}
	protected void setEnddate(Date in){ this.enddate = in;}
	protected void setLimit(Integer in){ this.limit = in;}
	protected void setOffset(Integer in){ this.offset = in;}
	
}