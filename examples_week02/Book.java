/*
 * Book.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* Book.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
*/

public class Book extends Publication {
	public Book( String a, String t, int i, int n, int c ){
		super(a, t, i, n);
		numChapters = c;
	}
	
	// methods
	public String getTitle() { return super.getTitle(); }
		
	public String getAuthor() { return super.getAuthor(); }

	public String toString(){
		return super.toString() + "[numChapters=" + numChapters + "]";
    	}

    	// instance fields
    	private int numChapters;
}
