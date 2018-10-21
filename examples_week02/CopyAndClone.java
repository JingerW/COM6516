/*
 * CopyAndClose.java  	1.1 12/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* Examples of problems associated with copying variables and objects
*
* @version 1.1 12 October 2010
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

 
public class CopyAndClone{
    public static void main(String[] args){
	// declare 2 integer variables, one as a copy of the other	
	int variable = 42;
	int copy = variable;
	System.out.println("Initial values of variable="+variable+", and copy="+copy);

	// change value of first integer variable 
	variable += 1000;
	System.out.println("Adding 1000 to variable");
	System.out.println("and the new values are variable="+variable+", copy="+copy+"\n");

	// something different happens with arrays because the array name
	// is a reference
	int arr1[] = {1,2,3,4,5};
	int arr1copy[] = arr1;
	System.out.println("Initial values of array1 and copy");
	for (int i = 0; i <= 4; i++)
		System.out.println("arr1["+i+"]="+arr1[i]+", arr1copy["+i+"]="+arr1copy[i]);

	arr1[2] = 1000;
	System.out.println("\nSetting arr1[2]=1000, the new values of arr1 and copy are");

	for (int i = 0; i <= 4; i++)
	    System.out.println("arr1["+i+"]="+arr1[i]+", arr1copy["+i+"]="+arr1copy[i]);

	// instead we can clone arr1
	arr1[2] = 3;
	arr1copy = (int[]) arr1.clone();
	arr1[2] = 1000;
	System.out.println("\nIf we create a clone of arr1, and set arr1[2]=1000, the new values of arr1 and copy are");

	for (int i = 0; i <= 4; i++)
	    System.out.println("arr1["+i+"]="+arr1[i]+", arr1copy["+i+"]="+arr1copy[i]);

	// however if we have a multidimensional array that contains
	// references to other objects cloning can result in problems
	int arr2[][] = {{1,2,3},{4,5,6}};
	int arr2copy[][] = (int[][]) arr2.clone();
	System.out.println("\nHowever, a 2-dimensional array contains references that are not cloned");
	for (int row = 0; row <= 1; row++) 
		for (int col = 0; col <= 2; col++)
			System.out.println("row="+row+", col="+col+" : arr2[row][col]="+arr2[row][col]+" : arr2copy[row][col]="+arr2copy[row][col]);

	arr2copy[0][0] = 1000;
	System.out.println("\nAfter setting arr2copy[0][0] = 1000");
	for (int row = 0; row <= 1; row++) 
		for (int col = 0; col <= 2; col++)
			System.out.println("row="+row+", col="+col+" : arr2[row][col]="+arr2[row][col]+" : arr2copy[row][col]="+arr2copy[row][col]);

    }
}