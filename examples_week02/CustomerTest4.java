/*
 * CustomerTest4.java  	1.1 12/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* Test code for Customer class Based on code written by Steve Renals
* <s.renals@dcs.shef.ac.uk> and Richard Clayton (r.h.clayton@sheffield.ac.uk)
* 
* @version 1.2 7 October 2015
* 
* @author Mark Stevenson (mark.stevenson@sheffield.ac.uk)
*/

public class CustomerTest4 {
    public static void main(String[] args) {

	// create a new customer
        Customer firstCustomer = new Customer("A. Client", "Sheffield");

	// create a customer with identical instance fields
        Customer secondCustomer = new Customer("A. Client", "Sheffield");

	if (firstCustomer == secondCustomer) {
	    System.out.println("using ==: "+firstCustomer+" and "+secondCustomer+" are equal!\n");
	} else {
	    System.out.println("using ==: "+firstCustomer+" and "+secondCustomer+" are not equal!\n");
	} // if/else
    }
}