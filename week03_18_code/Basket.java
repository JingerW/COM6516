/** Basket.java
*
* Part of lab class for COM6516
* Written by Mark Stevenson mark.stevenson@sheffield.ac.uk
* Based on code written by Steve Maddock
* Last modified 19 September 2014
*
*/

public class Basket {

    public Basket(Item[] it) {
	items = it;
    }

    public double total() {
	double tot = 0.0;
	for (int i = 0; i < items.length; i++) {
	    tot += items[i].getPrice();
	} //for
	return tot;
    } 
		
    private Item[] items;
}
