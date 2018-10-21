/*
 * MagazineArticle.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* MagazineArticle.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
*/

public class MagazineArticle extends Publication {
	// method
	public String toString(){
		return super.toString() + "[magazineName=" + magazineName + 
		",volume=" + volume + ",issue=" + issue + "startPage=" + 
		startPage + "]";
    	}
    	
    	// instance fields
    	private String magazineName;
	private int volume;
	private int issue;
	private int startPage;
}
