// https://codeforces.com/problemset/problem/1151/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = Integer.parseInt( read.nextLine() );
		String s = read.nextLine();
		
		int minOperationCount = Integer.MAX_VALUE;
		for (int i = 0; i <= n-4; ++i) {
			String substring = s.substring(i, i+4);

			char substringFirstChar = substring.charAt(0);
			char substringSecondChar = substring.charAt(1);
			char substringThirdChar = substring.charAt(2);
			char substringFourthChar = substring.charAt(3);
			
			int backwardDistanceToA = Math.abs( substringFirstChar - 'A' );
			int forwardDistanceToA = Math.abs( 26 - backwardDistanceToA );
			
			int backwardDistanceToC = Math.abs( substringSecondChar - 'C' );
			int forwardDistanceToC = Math.abs( 26 - backwardDistanceToC );
			
			int backwardDistanceToT = Math.abs( substringThirdChar - 'T' );
			int forwardDistanceToT = Math.abs( 26 - backwardDistanceToT );
			
			int backwardDistanceToG = Math.abs( substringFourthChar - 'G' );
			int forwardDistanceToG = Math.abs( 26 - backwardDistanceToG );
			
			int operationCount = 
				Math.min(forwardDistanceToA, backwardDistanceToA) +
				Math.min(forwardDistanceToC, backwardDistanceToC) +
				Math.min(forwardDistanceToT, backwardDistanceToT) +
				Math.min(forwardDistanceToG, backwardDistanceToG);
			
			minOperationCount = Math.min(minOperationCount, operationCount);
		}
		
		System.out.println(minOperationCount);

		// Close scanner
		read.close();
	}

}
