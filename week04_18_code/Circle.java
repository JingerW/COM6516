/*
 * Circle.java  	1.0 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */
 
 
/** 
* Circle.java
*
* A simple class used in week 4 to implement a Circle subclass
* 
* @version 1.1 26 August 2011
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

import sheffield.*;

public class Circle extends Shape {
	
	private static final int NUM_STEPS = 100;
	private double radius;

	public Circle(double x, double y, double r)
		{ 
		super(x, y);
		radius=r; 
		}
		
	public double area()
		{ return Math.PI*radius*radius; }
		
	public void draw(EasyGraphics g) {
		g.moveTo(getX(),getY()+radius);
		for (int i=0; i<=NUM_STEPS; i++) 
			{
			double w = i*2*Math.PI/NUM_STEPS;
			g.lineTo(getX()+radius*Math.sin(w),
				getY()+radius*Math.cos(w));
			}
		}
}