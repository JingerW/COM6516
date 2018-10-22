import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BallsAndBuckets {
	
	private Ball[] balls;
	private int[] buckets;
	
	public BallsAndBuckets(int ball, int bucket) {
		balls  = new Ball[ball];
		buckets = new int[bucket];
	}
	
	public Ball[] pathTaken() {
		Arrays.fill(buckets, 0);
		for (int i=0;i<balls.length;i++) {
			int times = 0;
			int end = 1;
			String[] path = new String[buckets.length-1];
			while (times < buckets.length-1) {
				Random n = new Random();
				if (n.nextInt(2) == 0) {
					path[times] = "L";
					end = end;
				}
				else {
					path[times] = "R";
					end += 1;
				}
				times += 1;
			}
			//System.out.println(end);
			//System.out.println(Arrays.toString(path));
			balls[i] = new Ball(end, path);
			buckets[end-1] += 1;
		}
		return balls;
	}
	
	public int[] getBuckets() {
		return buckets;
	}
	
	public ArrayList modal() {
		int max = 0;
		ArrayList maxb = new ArrayList();
		for (int i=0;i<buckets.length-1;i++) {
			if (buckets[i] > max && maxb.isEmpty()) { 
				max = buckets[i];;
				maxb.add(i+1);
				} 
			else if (buckets[i] > max && !maxb.isEmpty()) {
				maxb.clear();
				maxb.add(i+1);
				max = buckets[i];
			}
			else if (buckets[i] == max ) {
				maxb.add(i+1);
			}
			else {
				continue;
			}
		}
		return maxb;
	}
	
	public double mean() {
		double total = 0;
		double totalb =0;
		for (int i=0;i<buckets.length;i++) {
			if (buckets[i] != 0) {
				total += i+1;
				totalb += 1;
			}
			else {
				total = total;
				totalb = totalb;
			}
		}
		//System.out.println(total/totalb);
		double mean = Math.round((total/totalb)*100.0)/100.0;
		
		return mean;
	}
	
	private static int ask(String b) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		
		while (num == 0) {
			System.out.println("Please enter the number of "+b+": ");
			if (in.hasNextInt()) {
				num = in.nextInt();
				if (num < 0) {
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
	
	public static void main(String[] args) {
		
//		for (int i=0;i<ball.length;i++) {
//			System.out.println(ball[i].getPaths());
//			System.out.println(ball[i].getEnds());
//		}
//		
//		System.out.println(bb.modal());
//		System.out.println(bb.mean());
		
		int numballs = BallsAndBuckets.ask("balls");
		int numbuckets = BallsAndBuckets.ask("buckets");

		BallsAndBuckets bb = new BallsAndBuckets(numballs,numbuckets);
		
		Ball[] ball = bb.pathTaken();
		
		System.out.println("\nPath taken by each ball: ");
		
		for (int i=0;i<ball.length;i++) {
			System.out.println(ball[i].getPaths());
		}
		
		System.out.println("\nDistribution of balls: ");
		
		int[] ends = bb.getBuckets();
		for (int i=0;i<numbuckets;i++) {
			if (ends[i] == 0) {
				System.out.print("_");
			}
			else {
				System
			}
		}
	
	}
	
}


