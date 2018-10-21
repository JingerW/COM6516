/*
 * CustomerTest3.java  	1.1 12/10/2010
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

public class CustomerTest3 {
    public static void main(String[] args) {

	// create a new customer
        Customer firstCustomer = new Customer("A. Client", "Sheffield");

	// create another new customer
        Customer secondCustomer = new Customer("B. Client", "Leeds");
	
	// use method add to customer spend
        firstCustomer.addToSpend(59.99);
	secondCustomer.addToSpend(99.99);

	// print out modified customer information
        System.out.println("First :"+firstCustomer.toString());
	System.out.println("Second:"+secondCustomer.toString());
    }
}