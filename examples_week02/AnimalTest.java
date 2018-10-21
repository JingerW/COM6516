/*
 * AnimalTest.java  	1.0 01/10/2010
 *
 * Copyright (c) University of Sheffield 2011
 */

/** 
* AnimalTest.java
*
* Test class to demonstrate inheritance
* 
* @version 1.1 01 October 2010
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
* Original code written by Guy Brown
*
*/

public class AnimalTest {
    public static void main(String[] args) {
	Cow daisy = new Cow();
	Pig wilbur = new Pig();
	Animal animal = new Animal();
	animal.talk();
	animal = daisy;
	animal.talk();
	animal = wilbur;
	animal.talk();
    }
}