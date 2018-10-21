/*
 * CustomerTest1.java  	1.1 12/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* Test code for Customer class
* Based on code written by Steve Renals <s.renals@dcs.shef.ac.uk>
*
* @version 1.1 12 October 2010
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

public class CustomerTest1 {
    public static void main(String[] args) {

	// create a new customer
        Customer firstCustomer = new Customer("A. Client", "Sheffield");

	// print out customer information
        System.out.println(firstCustomer.toString());
 
	// This code will also work, because the java compiler automatically
	// invokes the toString method when an object is referred to or
	// concatenated with a string
	System.out.println(firstCustomer);

	// use method add to customer spend
        firstCustomer.addToSpend(59.99);

	// print out modified customer information
        System.out.println(firstCustomer.toString());
    }
}