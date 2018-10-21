/** Item.java
*
* Part of lab class for COM6516
* Written by Mark Stevenson mark.stevenson@sheffield.ac.uk
* Based on code written by Steve Maddock and Richard Clayton
*
*/

  public class Item 
  {
	public Item(String n, double p) {
	name = n; price = p;
	}
	
	public String getName() { return name; }
	public double getPrice() { return price; }
	
        // using ukp to denote pounds sterling as unicode pound symbol 
        // does not display properly in MS Command Window  
	public String toString() { return (name + " = ukp" + price); }
		
	// equals method to be added here
	//public boolean equals(Object obj) {
		// check if identical objects
		// must be false if parameter is null
		// must be false if objects have different classes
		// now we can cast and do something specific for Item
		//}
		
	// instance fields
	private final double price;
	private final String name;
	
	public static void main( String[] args){
		String TESTNAME = "testObject";
		double TESTPRICE = 10.0;
		Item testObject = new Item(TESTNAME,TESTPRICE);
		System.out.println("Name:");
		System.out.println("Actual field " + testObject.getName());
		System.out.println("Expected " + TESTNAME);
		System.out.println("Price:");
		System.out.println("Actual field " + testObject.getPrice());
		System.out.println("Expected " + TESTPRICE);
	}
}
