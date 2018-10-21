/*
 * RealEstate.java
 * Copyright (c) University of Sheffield 2011
 */
 
public class RealEstate extends Asset implements Insurable{
    public RealEstate(double v) 
    { value=v;}	
	
    public double getPremium() {
	// insurance premium is 5% of the value		
	return value*0.05;	
    }
}
