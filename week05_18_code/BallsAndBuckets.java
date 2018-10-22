import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BallsAndBuckets implements Cloneable{
	
	/*
	 * private instances
	 * balls: (Ball array) contains each ball's path and ended bucket.
	 * buckets: (int array) contains final bucket condition.
	 */
	private Ball[] balls;
	private int[] buckets;
	
	
	/*
	 * Constructor
	 */
	public BallsAndBuckets(int ball, int bucket) {
		this.balls  = new Ball[ball];
		this.buckets = new int[bucket];
	}
	
	/*
	 * simulate the paths of each ball
	 * @name pathTaken
	 * @return Ball array
	 */
	public Ball[] pathTaken() {
		
		// initial buckets with filling it with 0
		Arrays.fill(buckets, 0);
		
		// loop for simulate path
		for (int i=0;i<balls.length;i++) {
			int times = 0;
			int end = 1;
			
			// new string array path for each ball
			String[] path = new String[buckets.length-1]; 
			while (times < buckets.length-1) {
				Random n = new Random();
				if (n.nextInt(2) == 0) {      // determine direction
					path[times] = "L";        // save direction
				}
				else {
					path[times] = "R";
					end += 1;                 // ball goes left, ended bucket do not change; goes right, ended bucket plus one
				}
				times += 1;
			}
			balls[i] = new Ball(end, path);   // save in Ball class array
			buckets[end-1] += 1;              // save ended buckets
		}
		return balls;
	}
	
	
	/*
	 * get bucket condition
	 * @name getBuckets
	 * @return int array
	 */
	public int[] getBuckets() {
		return buckets;
	}
	
	
	/*
	 * get modal bucket
	 * @name modal
	 * @param int array buc bucket condition
	 * @return one or more modal buckets
	 */
	public List<Integer> modal(int[] buc) {
		// new instance for storing maximum number and modal
		int max = 0;
		List<Integer> maxb = new ArrayList<Integer>();
		
		// searching for maximum
		for (int i=0;i<buc.length-1;i++) {
			
			// current bucket has more balls than maximum number and this is the first time encounter
			if (buc[i] > max && maxb.isEmpty()) { 
				max = buc[i];;		// update maximum number
				maxb.add(i+1);		// add this position into modal
			}
			
			// new maximum has found so clear modal list and put in new one.
			else if (buc[i] > max && !maxb.isEmpty()) {	
				maxb.clear();
				maxb.add(i+1);
				max = buc[i];
			}
			
			// same number with maximum; put in modal
			else if (buc[i] == max ) {
				maxb.add(i+1);
			}
			
			else {
				continue;
			}
		}
		return maxb;
	}
	
	/*
	 * get mean bucket
	 * @name mean
	 * @param int array buc bucket condition
	 * @return double int
	 */
	public double mean(int[] bu) {
		double total = 0;
		double totalb =0;
		
		// the sum of the number of balls in each bucket multiplied by the bucket number
		// divided by the total number of balls
		for (int i=0;i<bu.length;i++) {
			total += (bu[i]*i);
			totalb += bu[i];
		}
		System.out.println("total: "+total);
		System.out.println("total balls: "+totalb);
		
		// rounded to 2 decimal places
		double mean = Math.round((total/totalb)*100.0)/100.0;
		return mean;
	}
	
	/*
	 * interface for user to input
	 * will not allow any type except for integer and also forbid negative number
	 * @name ask
	 * @param string b ball or bucket
	 */
	private static int ask(String b) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		
		while (num == 0) {
			System.out.println("Please enter the number of "+b+": ");
			if (in.hasNextInt()) {		// is entered object an integer
				num = in.nextInt();
				if (num < 0) {			// is this number positive
					System.out.println("Must be a positive number! Please enter again: ");
					num = 0;
				}
				else {
					break;
				}
				in.nextLine();
			}
			else {
				System.out.println("Not a valid number! Please enter again: ");
				in.nextLine();
			}
		}
		return num;
	}
	
	/*
	 * draw distribution diagram
	 * @name distribution
	 * @param BallsAndBuckets class object
	 */
	public void distribution(int[] bu) {

		List<Integer> modal = this.modal(bu);
		
		// while there are still different numbers in the bucket array, loop and draw
		while (Arrays.stream(bu).distinct().count() != 1) {
			int m = bu[modal.get(0)-1];
			for (int i=1;i<=bu.length;i++) {
				if (modal.contains(i) && bu[i-1] != 0) {		// check from the top
					System.out.print(" * ");						// draw * on this position
					bu[i-1] -= 1;								// minus one from bucket
				}
				else if (m == 1) {								// if modal of this bucket is 1 means this is the bottom level
					System.out.print(" _ ");						// draw "_"
				}
				else {
					System.out.print("   ");
				}
			}
			System.out.println("");
			modal = this.modal(bu);								// recalculate modal for the next level
			
		}
	}
	
	/*
	 * main running function
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		
		// ask for number of balls and buckets
		int numballs = BallsAndBuckets.ask("balls");
		int numbuckets = BallsAndBuckets.ask("buckets");

		// create new class for BallsaAndBuckets
		BallsAndBuckets bb = new BallsAndBuckets(numballs,numbuckets);
		
		// simulate and displace the path
		Ball[] ball = bb.pathTaken();
		System.out.println("\nPath taken by each ball: ");
		for (int i=0;i<ball.length;i++) {
			System.out.println(ball[i].getPaths());
		}
		
		// create a clone for bucket so that we can save it for later
		int[] buc2 = (int[]) bb.getBuckets().clone();
		
		// draw distribution diagram
		System.out.println("\nDistribution of balls: \n");
		bb.distribution(bb.getBuckets());
		System.out.println(Arrays.toString(buc2));
		
		// get modal and mean bucket
		System.out.println("\nThe modal bucket is: "+bb.modal(buc2));
		System.out.println("The mean bucket is: "+bb.mean(buc2));

		
		
	}
	
}


