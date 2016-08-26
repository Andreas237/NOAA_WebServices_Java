package com.main;

import java.util.ArrayList;

/**
 * Version: 1
 * Author: Andreas Slovacek
 * Date: 25 August 2016
 * Description: Gives the user interface for choosing an endpoint
 * Detail: [paragraphs if needed- what does this object do, why and how]
*/
public class Selector {
	

	
	/**********************************************************/		
	// Non-static vars
	/**********************************************************/
	private ArrayList<String> fieldList;
	private Integer returnVal;
	
	
	/**********************************************************/
	// constructors
	/**********************************************************/
	/**
	 * Function: Name 
	 * Purpose: Present a list of endpoints for the user to choose from
	 * Parameters: ArrayList of fields
	 * Returns: The number from the field list
	*/
	public Selector( ArrayList<String> fields){
		if( fields.size() == 0 ){ this.returnVal = 0; }
		else
		{
			this.fieldList = fields;
		}
		
	}
	
	
	/**********************************************************/
	// getters
	/**********************************************************/
	
	
	/**********************************************************/
	// setters
	/**********************************************************/
	
	
	/**********************************************************/
	// action methods (?)
	/**********************************************************/
	
	/**********************************************************/
	// logical methods
	/**********************************************************/
	
	
	
	/**********************************************************/
	// inner classes and functions
	/**********************************************************/
	
	
}// end class	
