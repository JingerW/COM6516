/*
 * Customer.java  	1.1 12/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* Simplified Customer class
* Based on code written by Steve Renals <s.renals@dcs.shef.ac.uk>
*
* @version 1.1 12 October 2010
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/
 
public class Customer {

    // constructor
    public Customer(String nm, String addr) {
        name = nm;
        address = addr;
        totalSpend = 0.0;
    }

    // methods
    public void addToSpend(double x) {
        totalSpend += x;
    }

    public String toString() {
        return("Customer1[name=\"" + name + "\",address=\"" + address + "\",totalSpend=" + totalSpend + "]");
    }

    // accessors
    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getTotalSpend() { return totalSpend; }

    // instance fields
    private String name;
    private String address;
    private double totalSpend;
    
}