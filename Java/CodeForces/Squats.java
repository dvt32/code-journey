// https://codeforces.com/problemset/problem/424/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		
		int numberOfStandingHamsters = 0;
		int numberOfSittingHamsters = 0;
		
		String hamsterPositions = read.nextLine();
		for (int i = 0; i < n; ++i) {
			char hamsterPosition = hamsterPositions.charAt(i);
			if (hamsterPosition == 'X') {
				numberOfStandingHamsters++;
			}
			else {
				numberOfSittingHamsters++;
			}
 		}
		
		StringBuilder alteredHamsterPositions = new StringBuilder(hamsterPositions);
		int minChangeCount = 0;
		
		if (numberOfStandingHamsters > numberOfSittingHamsters) {
			while (numberOfStandingHamsters != numberOfSittingHamsters) {
				numberOfStandingHamsters--;
				numberOfSittingHamsters++;
				minChangeCount++;
			}
			for (int i = 0, j = 0; i < n && j < minChangeCount; ++i) {
				if (hamsterPositions.charAt(i) == 'X') {
					alteredHamsterPositions.setCharAt(i, 'x');
					j++;
				}
			}
		}
		else if (numberOfStandingHamsters < numberOfSittingHamsters) {
			while (numberOfStandingHamsters != numberOfSittingHamsters) {
				numberOfSittingHamsters--;
				numberOfStandingHamsters++;
				minChangeCount++;
			}
			for (int i = 0, j = 0; i < n && j < minChangeCount; ++i) {
				if (hamsterPositions.charAt(i) == 'x') {
					alteredHamsterPositions.setCharAt(i, 'X');
					j++;
				}
			}
		}
		
		System.out.println(minChangeCount);
		System.out.println(alteredHamsterPositions);
		
		// Close scanner
		read.close();
	}

}
