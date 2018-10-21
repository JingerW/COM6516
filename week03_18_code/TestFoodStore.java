/*
 * Jingjing Wang COM6516
 */

import java.util.Scanner;
import java.math.*;

public class TestFoodStore {
	
	/*
	public static void main(String[] arg) {
		
		FoodStore MyFoodStore = new FoodStore(10);
		
		System.out.println("contains "+MyFoodStore.getAmountStored());
	}
	*/
	
	private static Scanner in;

	public static void main(String[] arg) {
		
		in = new Scanner(System.in);
		
		// new food store starts with 0 amount
		FoodStore FoodStore = new FoodStore(0);
		
		// input from user
		boolean continues = true;
		int timeDeposit = 0;
		int timeWithdraw = 0;
		int timeRefused = 0;
		
		// while user doesn't press p to exit, loop continues
		while (continues) {
			
			System.out.println("Food Store now contains " + FoodStore.getAmountStored());
			System.out.println("Please enter an amount you want to deposit or withdraw (To finish please press p): ");
			
			// check user has input a valid number
			if (in.hasNextInt()) {
				
				// read amount
				int amount = in.nextInt();
				in.nextLine();
				
				// positive number call deposit; negative number check if stock is enough first, if not refuse transaction
				if (amount >= 0) {
					FoodStore.depositFood(amount);
					timeDeposit += 1;
				}
				else if (amount < 0 && Math.abs(amount) <= FoodStore.getAmountStored()){
					FoodStore.withdrawFood(Math.abs(amount));
					timeWithdraw += 1;
				}
				else {
					System.out.println("Stored amount is not enough for you to withdraw.");
					timeRefused += 1;
				}
			}
			
			// user press p to exit
			else if (in.hasNext("p")) {
				continues = false;
				
				// show results
				System.out.println("Finished.");
				System.out.println("Food Store contains :" + FoodStore.getAmountStored());
				System.out.println("Total deposited amount :" + FoodStore.getAmountDeposited());
				System.out.println("Number of times deposited :" + timeDeposit);
				System.out.println("Total withdrawed amount :" + FoodStore.getAmountWithdrawed());
				System.out.println("Number of times withdrawed :" + timeWithdraw);
				System.out.println("Number of times transaction refused :" + timeRefused);
				
				in.nextLine();
			}
			
			// not a valid input
			else {
				System.out.println("Please enter a valid number or to finish please press 'p'.");
				in.nextLine();
			}
			
		}
	}
}
