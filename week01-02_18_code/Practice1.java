import sheffield.*;
import java.math.*;

public class Practice1 {	
	public static void main( String[] arg){
		EasyReader file = new EasyReader ("timings.txt");
		
		// read timings
		int count = file.readInt();
		double[] times = new double[count];
		
		for (int i=0;i<count;i++) {
			double t = file.readDouble();
			times[i] = t;
		}
		
		// set inits
		double diameter = 0.665;
		double circumference = Math.PI * diameter;
		double[] instSpeed = new double[count];
		double[] kmh = new double[count];
		double distance = 0, maxSpeed = 0, totalTime = 0;
		
		// calculate
		for (int i=0;i<count;i++) {
			instSpeed[i] = circumference/times[i];
			// convert to km/h
			kmh[i] = instSpeed[i] * (18/5);
			
			// max speed
			if (kmh[i] > maxSpeed){maxSpeed = kmh[i];}
			
			// total distance
			distance += kmh[i];
			
			// total time
			totalTime += times[i];
		}
		
		System.out.println(totalTime/60.0);
}}