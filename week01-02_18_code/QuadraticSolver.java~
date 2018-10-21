/*
 * QuadraticSolver.java  	1.1 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */

import java.math.*;
 
/** 
* QuadraticSolver.java
* solves quadratic equations for x given a*x*x + b*x + c = 0
* the code should be modified so that a, b, and c are input by the user
* 
* @version 1.1 26 August 2011
* 
* @author Mark Stevenson (mark.stevenson@sheffield.ac.uk) 
* @author (based on code written by Richard Clayton)
*/

public class QuadraticSolver {	
	public static void main( String[] arg){
			
		// default values for coefficients a, b, and c
		// initially, these are stored as both integers and float.
		int    aInt =    1,    bInt = 2, cInt =    1;
		double aFloat = 1, bFloat = 2, cFloat = 1;

		// declare variables to store the two values of x that satisfy the equation
		double x1, x2;

		// work out the solution with int types
		aInt -= 1/2;
		x1 = (-1 * bInt + Math.sqrt(bInt*bInt - 4 * aInt * cInt)) / (2 * aInt);
		x2 = (-1 * bInt - Math.sqrt(bInt*bInt - 4 * aInt * cInt)) / (2 * aInt);
		System.out.println("Solution with integer types is x1 = " + x1 + ", and x2 = " + x2 );

		// work out the solution with double types
		aFloat -= 0.5;
		x1 = (-1 * bFloat + Math.sqrt(bFloat*bFloat - 4 * aFloat * cFloat)) / (2 * aFloat);
		x2 = (-1 * bFloat - Math.sqrt(bFloat*bFloat - 4 * aFloat * cFloat)) / (2 * aFloat);
		System.out.println("Solution with double types is  x1 = " + x1 + ", and x2 = " + x2 );
		
	} //main
} // class QuadraticSolver