/*
 * TypeCast.java  	1.0 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* TypeCast.java
* 
* illustrates casting between integer and double
*
* @version 1.1 26 August 2011
		   1.2 20 September 2012 -- added additonal comments
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

public class TypeCast{
	
	public static void main(String[] args){
		
		// declare some integers to store example numbers
		int integer1 = 4;
		int integer2 = 5;
		
		// calculate the average of these numbers using integer arithmetic
		// this is OK becuase all operands are integers. Try changing the
		// denominator from 2 to 2.0 to see what happens when we have a floating
		// point operand.
		int average1 = (integer1 + integer2) / 2;
		
		// now we repeat the calculation in four different ways, returning a
		// floating point result each time
		
		// (1) all operands are integers, result is converted to floating point
		// after the calculation has been done
		double average2 = (integer1 + integer2) / 2;
		
		// (2) one operand is floating point, so all operands are promoted to 
		// floating point before the calculation is done
		double average3 = (integer1 + integer2) / 2.0;
		
		// (3) using a cast, force promotion of the denominator to floating point
		double average4 = (integer1 + integer2) / (double) 2;
		
		// (4) using a cast, force promotion of all operands to floating point
		double average5 = (double) (integer1 + integer2) / 2;

		// now print out the result of each average calculation
		System.out.println( "int ..... ("+integer1+"+"+integer2+")/2 =         "+average1 );
		System.out.println( "double .. ("+integer1+"+"+integer2+")/2 =         "+average2 );
		System.out.println( "double .. ("+integer1+"+"+integer2+")/2.0 =       "+average3 );
		System.out.println( "double .. ("+integer1+"+"+integer2+")/(double)2 = "+average4 );
	    System.out.println( "double .. (double)("+integer1+"+"+integer2+")/2 =  "+average5 );
	}
}
