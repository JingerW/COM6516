/** 
* Shape.java
*
* A simple class used in week 4 to implement an abstract superclass
* 
* @version 1.1 26 August 2011
* 
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk)
*/

import sheffield.*;

public abstract class Shape {
	
	// instance fields
	// these could be implemented as protected (as shown in the lecture notes)
	// or more safely as private, with getX and getY methods as shown here
	private double x;
	private double y;

	public Shape() {
		this(0.0, 0.0);
	}
	public Shape(double x, double y){
		setPosition(x, y);
	}
	
	public void setPosition(double xval, double yval) {
		x=xval;
		y=yval;
	}
	
	public double getX()
		{ return x; }
	
	public double getY()
		{ return y; }
		
	public abstract double area();	
	public abstract void draw(EasyGraphics g);

}