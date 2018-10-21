/** 
 * Fib.java
 * 
 * Illustrates iterative and recursive versions of the Fibonacci function
 * 
 * @version 1.3 * September 2015
 * 
 * @author Mark Stevenson  (mark.stevenson@sheffield.ac.uk)
 */


public class Fib {

    // Iterative version
    public static int fib(int n) {
	  int n0 = 1;
	  int n1 = 1;
	
	  if ((n == 1) || (n == 2))
	     return 1;
	  else {
	     int tot = 0;
	     for (int i=2; i < n; i++) {
     		tot = n0 + n1;
	    	n1 = n0;
		    n0 = tot;
	     } 
	     return tot;
	  }
    } 

    
    // Recursive version
    public static int fibr(int n) {
	  if ((n == 1) || (n == 2)) {
	     return 1;
	  }
	  else {
	      return fibr(n-1) + fibr(n-2);
	  }
    } 
    

    public static void main(String[] args) {
	
	  System.out.println("Iterative...");
	  for (int i=1; i<40;i++) {
	     System.out.println(i+": "+fib(i));
	  } 

	  System.out.println("\nRecursive...");
	  for (int i=1; i<40;i++) {
	     System.out.println(i+": "+fibr(i));
	  }
    } 
}
