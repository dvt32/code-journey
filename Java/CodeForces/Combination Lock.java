// http://codeforces.com/problemset/problem/540/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String lockedCombination = read.nextLine();
		String unlockedCombination = read.nextLine();
		
		int minNumberCount = 0;
		for (int i = 0; i < n; ++i) {
			int lockedChar = Character.getNumericValue( lockedCombination.charAt(i) );
			int unlockedChar = Character.getNumericValue( unlockedCombination.charAt(i) );
			
			if (lockedChar > unlockedChar) {
				int firstDifference = (lockedChar - unlockedChar);
				int secondDifference = (10 - lockedChar + unlockedChar);
				minNumberCount += Math.min(firstDifference, secondDifference);
			}
			else if (lockedChar < unlockedChar) {
				int firstDifference = (unlockedChar - lockedChar);
				int secondDifference = (10 - unlockedChar + lockedChar);
				minNumberCount += Math.min(firstDifference, secondDifference);
			}
		}
		
		System.out.println( minNumberCount );
		
		// Close scanner
		read.close();
	}
	
}
