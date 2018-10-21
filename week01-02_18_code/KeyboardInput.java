/*
 * KeyboardInput.java  	1.0 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */

import sheffield.*;

/** 
* KeyboardInput.java
* 
* This class provides a template for reading input from the keyboard using the
* EasyReader class in the sheffield package
* 
* @version 1.1 19 September 2011
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

public class KeyboardInput {
	public static void main(String[] args){
		
		// step 1, create a new EasyReader object to model the keyboard
		EasyReader keyboard = new EasyReader();
		
		// step 2, prompt the user to input values for a, b, and c and 
		// store these as doubles
		double a = keyboard.readDouble("Input a value for a: ");
		double b = keyboard.readDouble("Input a value for b: ");
		double c = keyboard.readDouble("Input a value for c: ");

		// step 3, display the values that hae been entered
		System.out.println("You entered a="+a+", b="+b+", c="+c);
	}
}

			