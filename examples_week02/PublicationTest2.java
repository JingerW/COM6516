/*
 * PublicationTest2.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* PublicationTest2.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
*/

public class PublicationTest2{
    public static void main(String[ ] args){

    		Publication p1 = new Publication("Richard III","W. Shakespeare", 12345, 22 );
    		Book b1 = new Book("Bleak House","C. Dickens", 78910, 195, 10 );

    		System.out.println(p1.toString());
    		System.out.println(b1.toString());

    		System.out.println(p1.getAuthor());
    		System.out.println(b1.getAuthor());

    		System.out.println(p1.getTitle());
    		System.out.println(b1.getTitle());

    }
}
