/*
 * MagazineArticle.java
 *
 * Copyright (c) University of Sheffield 2011
 */

public class MagazineArticle extends Publication {

    // constructor
    public MagazineArticle(String t, String a, int i, int n, String m, int v, int j, int s) {
	super(t, a, i, n);
	magazineName = m;
	volume = v;
	issue = j;
	startPage = s;
    } 
	
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
