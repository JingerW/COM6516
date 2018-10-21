/*
 * PublicationTest3.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* PublicationTest3.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
*/

public class PublicationTest3{
    public static void main(String[ ] args){

    	// we can declare a Publication object to point at a Book
	Publication p1 = new Book("Richard III","W. Shakespeare", 12345, 22, 11 );
       // but not the other way round
       //Book b1 = new Publication("Bleak House","C. Dickens", 78910, 195 );
		
       System.out.println(p1.toString());
       //System.out.println(b1.toString());
		
       System.out.println(p1.getAuthor());
       //System.out.println(b1.getAuthor());
		
       //System.out.println(b1.getTitle());
       //System.out.println(b1.getTitleAuthor());
    }
}
