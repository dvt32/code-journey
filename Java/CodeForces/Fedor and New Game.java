// http://codeforces.com/problemset/problem/467/B

import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		int k = read.nextInt();
		
		// Enter armies
		int[] x = new int[m+2];
		for (int i = 1; i <= (m+1); ++i) {
			x[i] = read.nextInt();
		}
		
		/*
		 *  Calculate number of Fedor's friends;
		 */
		String fedorArmyBinary = Integer.toBinaryString( x[m+1] );
		int fedorFriendCount = 0;
		for (int i = 1; i < (m+1); ++i) {
			// Add extra 0's in front of armyBinary or fedorArmyBinary to compare bits of each number
			String armyBinary = Integer.toBinaryString( x[i] );
			if (fedorArmyBinary.length() > armyBinary.length()) {
				armyBinary = 
					String.join(
						"", 
						Collections.nCopies( (int)Math.abs(armyBinary.length()-fedorArmyBinary.length()), "0" )
					) + armyBinary;
			}
			else {
				fedorArmyBinary = 
					String.join(
						"", 
						Collections.nCopies( (int)Math.abs(armyBinary.length()-fedorArmyBinary.length()), "0" )
					) + fedorArmyBinary;
			}
			
			// Calculate number of different bits
			int differentBitCount = 0;
			for (int j = 0; j < armyBinary.length(); ++j) {
				if ( armyBinary.charAt(j) != fedorArmyBinary.charAt(j) ) {
					differentBitCount++;
				}
			}
			
			if (differentBitCount <= k) {
				fedorFriendCount++;
			}
		}
		
		System.out.println(fedorFriendCount);
		
		// Close scanner
		read.close();
	}
	
}
