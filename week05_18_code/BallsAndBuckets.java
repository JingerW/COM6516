import java.util.Arrays;
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
	
	public int modal() {
		int max = 0;
		int maxb = 0;
		for (int i=0;i<buckets.length-1;i++) {
			if (buckets[i] > max) { 
				max = buckets[i];;
				maxb = i+1;
				} 
			else {
				max = max;
				maxb = maxb;
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
	
	public static void main(String[] args) {
		
		BallsAndBuckets bb = new BallsAndBuckets(3,5);
		
		Ball[] ball = bb.pathTaken();
		
		for (int i=0;i<ball.length;i++) {
			System.out.println(ball[i].getPaths());
			System.out.println(ball[i].getEnds());
		}
		
		System.out.println(bb.modal());
		System.out.println(bb.mean());
		
		Scanner in = new Scanner(System.in);
		int numBalls = 0, numBuckets = 0;
		
		while (numBalls != 0) {
			System.out.println("Please enter the number of balls: ");
			if (in.hasNextInt()) {
				numBalls = in.nextInt();
				in.nextLine();
			}
			else {
				System.out.println("Not a valid number! Please enter again: ");
				in.nextLine();
			}
		}
		
		
		
		
		
		
	}
	
}

