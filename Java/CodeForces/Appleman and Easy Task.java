// http://codeforces.com/problemset/problem/462/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine();
		
		String[] board = new String[n];
		for (int i = 0; i < n; ++i) {
			board[i] = read.nextLine();
		}
		
		boolean hasOnlyEvenNumberOfSpecialAdjacentCells = true;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int numberOfSpecialAdjacentCells = 0;
				
				boolean hasSpecialLeftAdjacentCell = (j-1 >= 0 && board[i].charAt(j-1) == 'o');
				boolean hasSpecialRightAdjacentCell = (j+1 < n && board[i].charAt(j+1) == 'o');
				boolean hasSpecialUpperAdjacentCell = (i-1 >= 0 && board[i-1].charAt(j) == 'o');
				boolean hasSpecialLowerAdjacentCell = (i+1 < n && board[i+1].charAt(j) == 'o');
				
				if (hasSpecialLeftAdjacentCell) { numberOfSpecialAdjacentCells++; }
				if (hasSpecialRightAdjacentCell) { numberOfSpecialAdjacentCells++; }
				if (hasSpecialUpperAdjacentCell) { numberOfSpecialAdjacentCells++; }
				if (hasSpecialLowerAdjacentCell) { numberOfSpecialAdjacentCells++; }
				
				if (numberOfSpecialAdjacentCells % 2 != 0) {
					hasOnlyEvenNumberOfSpecialAdjacentCells = false;
					break;
				}
			}
			if (!hasOnlyEvenNumberOfSpecialAdjacentCells) {
				break;
			}
		}
		
		if (hasOnlyEvenNumberOfSpecialAdjacentCells) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
