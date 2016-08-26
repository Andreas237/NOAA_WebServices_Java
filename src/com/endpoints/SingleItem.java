package com.endpoints;

import org.json.simple.JSONObject;

/**
 * Version: 1
 * Author: Andreas Slovacek
 * Date: 11 August 2016
 * Description: This class takes JSON input for a Single Item and populates fields
 * Detail: 	Call setter methods on the fields found in a "Single Item"
 * 			Reference here - https://www.ncdc.noaa.gov/cdo-web/webservices/v2#gettingStarted
 * 
 * 	"id": "GSOY",
	"name": "Global Summary of the Year",
	"datacoverage": 1,
	"mindate": "1763-01-01",
	"maxdate": "2015-01-01"
*/
public class SingleItem {
	

	/**********************************************************/		
	// Non-static vars
	/**********************************************************/
	protected Double datacoverage;
	protected String id;
	protected String name;
	protected String maxdate;
	protected String mindate;
	
	
	

	
	
	/**********************************************************/
	// constructors
	/**********************************************************/
	/**
	 * Function: printAllFields 
	 * Purpose: print all fields on the object
	 * Parameters: none
	 * Returns: none
	 * Throws [Exception(s)]: none
	*/
	public SingleItem(JSONObject obj){
		
		setId( (String) obj.get( "id" ) );
		setName( (String) obj.get("name") );
		
		
		/*
		 * Check that the fields exist then set them
		 */
		if(  obj.get("datacoverage") != null){
			Double temp;
			
			
			// The API returns both Double and Long for Datacoverage
			if( obj.get("datacoverage").getClass().equals( new Long(1).getClass() )  ){
				temp =  ( (Long) obj.get("datacoverage")).doubleValue() ;
			}// end if( obj.get("datacoverage").getClass().equals( new Long(1).getClass() )  )
			else{
				temp = (Double) obj.get("datacoverage") ;
			}// end else
			
			setDatacoverage( temp );
		}// end if( ( obj.get("datacoverage") != null)


		if( obj.get("mindate") != null ){ setMindate( (String) obj.get("mindate") ); }
		if( obj.get("datacoverage") != null ){ setMaxdate( (String) obj.get("maxdate") ); }
		
		

	}// end SingleItem(JSONObject obj)
	
	
	
	
	/**********************************************************/
	// getters
	/**********************************************************/
	protected Double getDatacoverage(){    return this.datacoverage;}    // returns the member variable datacoverage
	protected String getId(){    return this.id;}    // returns the member variable id
	protected String getName(){    return this.name;}    // returns the member variable name
	protected String getMaxdate(){    return this.maxdate;}    // returns the member variable maxdate
	protected String getMindate(){    return this.mindate;}    // returns the member variable mindate
	
	
	
	/**********************************************************/
	// setters
	/**********************************************************/
	protected void setDatacoverage( Double datacoverage ){    this.datacoverage = datacoverage; }    // sets the member variable datacoverage
	protected void setId( String id ){ this.id = id; }    // sets the member variable id
	protected void setName( String name ){ this.name = name; }    // sets the member variable name
	protected void setMaxdate( String maxdate ){ this.maxdate = maxdate; }    // sets the member variable maxdate
	protected void setMindate( String mindate ){ this.mindate = mindate; }    // sets the member variable mindate
	
	
	
	
	
	/**********************************************************/
	// action methods (?)
	/**********************************************************/
	
	
	/**
	 * Function: printAllFields 
	 * Purpose: print all fields on the object
	 * Parameters: none
	 * Returns: none
	 * Throws [Exception(s)]: none
	*/
	protected void printAllFields(){
		System.out.println( "Datacoverage: " + getDatacoverage() ) ;
		System.out.println( "Id: " + getId() ) ;
		System.out.println( "Name: " + getName() ) ;
		System.out.println( "Maxdate: " + getMaxdate() ) ;
		System.out.println( "Mindate: " + getMindate() ) ;
	}// end protected void printAllFields()
	
	
	
	
	
	/**
	 * Function: print functions 
	 * Purpose: print each field
	 * Parameters: none
	 * Returns: none
	 * Throws [Exception(s)]: none
	*/
	protected void printDatacoverage( ){ System.out.println( this.datacoverage) ; }    // print the member variable datacoverage
	protected void printId( ){ System.out.println( this.id) ; }    // print the member variable id
	protected void printName( ){ System.out.println( this.name) ; }    // print the member variable name
	protected void printMaxdate( ){ System.out.println( this.maxdate) ; }    // print the member variable maxdate
	protected void printMindate( ){ System.out.println( this.mindate) ; }    // print the member variable mindate
	
	
	
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	
	/**********************************************************/
	// inner classes and functions
	/**********************************************************/
	
}// end public class SingleItem
