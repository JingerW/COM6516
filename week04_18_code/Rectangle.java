/*
 * Rectangle.java  	1.0 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */
 
 
/** 
* Circle.java
*
* A simple class used in week 4 to implement a Rectangle subclass
* 
* @version 1.1 26 August 2011
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

import sheffield.*;

public class Rectangle extends Shape {

	private double width, height;

	public Rectangle(double x, double y, double w, double h)
		{
		super(x, y);
		width = w;
		height = h; 
		}

	public double area() { return width * height; }
	
	public void draw(EasyGraphics g) {
		g.moveTo(getX(),getY());
		g.lineTo(getX()+width, getY());
		g.lineTo(getX()+width, getY()+height);
		g.lineTo(getX(),getY()+height);
		g.lineTo(getX(), getY());
		}
	}
