/*
 * PublicationTest.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* PublicationTest.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
*/

public class PublicationTest{
    public static void main(String[ ] args){
    		Publication p1 = new Publication();
    		System.out.println(p1.toString());
	
    		Book b1 = new Book("Bleak House","C.Dickens",789,195,9);
    		System.out.println(b1.toString());
	
    		System.out.println(p1.getTitle());
    		System.out.println(b1.getTitle());

    }
}
