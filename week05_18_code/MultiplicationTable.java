import java.util.Arrays;

public class MultiplicationTable {
	
	public static void main(String[] args) {
	
		// create an empty new array set
		int[][] set = new int[9][9];
		
		// fill in integers in this set
		for (int i=0; i < 9; i++) {
			for (int j=0; j < 9; j++) {
				set[i][j] = (i+1)*(j+1);
			}
		}
		
		// print out the set
		for (int i=0; i <= 9; i++) {
			
			// first line plus the dash line
			if (i ==0) {
				System.out.println("   "+Arrays.toString(set[0]).replaceAll("[\\[|\\]|\\, ]", "  "));
				for (int j=0;j<(set[0].length*5+4);j++) {System.out.print("-");}
				System.out.println("");
			}
			
			// rest of the set
			else {
				System.out.print(i+" | ");
				for (int l=0;l<9;l++) {
					if (set[i-1][l] < 10) {
						System.out.print(" "+set[i-1][l]+"   ");
					}
					else {
						System.out.print(set[i-1][l]+"   ");
					}
				}
				System.out.println("");
				}
			
		}
	}
}
