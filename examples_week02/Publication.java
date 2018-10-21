/*
 * Publication.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* Publication.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

public class Publication {
		
	// in the example class, two constructors are provided, and each has a
	// different signature
	
	// the Java virtual machine will invoke the correct constructor depending on
	// the arguments that are supplied
		
	// the first constructor sets the instance fields of the class to default
	// values if no arguments are supplied
	public Publication(){
		title = "default";
		author = "default";
		isbn = 0;
		numPages = 0;
	}
	
	// the second constructor sets the instance fields to values specified in
	// the arguments supplied
	public Publication( String t, String a, int i, int n ){
		title = t;
		author = a;
		isbn = i;
		numPages = n;
	}
	
	
	// methods
	public String toString() {
		return(this.getClass().getName() + "[title\"" + title + "\",author=\"" + author + "\",isbn=" + isbn + ",numPages=" + numPages + "]");
	}

	public int getNumPages(){ return numPages;}
	
	public String getTitle() { return title; }
		
	public String getAuthor() { return author; }

	// instance fields
	private int numPages;
	private int isbn;
	private String title; 
	private String author;
    }
