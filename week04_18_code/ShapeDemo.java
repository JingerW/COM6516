/*
 * ShapeDemo.java  	1.0 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */
 
 
/** 
* ShapeDemo.java
*
* A simple class used in week 4 to implement an abstract superclass
* 
* @version 1.1 26 August 2011
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

import sheffield.*;

public class ShapeDemo {

	public static void main(String[] args) {

		EasyGraphics g = new EasyGraphics(300,300,150,150);
                g.clear();
		Shape[] list = new Shape[5];
	
		// fill the array with shapes
		list[0] = new Rectangle(0,0,40,70);
		list[1] = new Circle(-40,-60,70);
		list[2] = new Circle(-40,40,30);
		list[3] = new Rectangle(20,30,90,50);
		list[4] = new Circle(0,0,30);
	
		// now update the display

		for (int i=0; i<5; i++)
			list[i].draw(g);
	}
}