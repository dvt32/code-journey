// http://codeforces.com/problemset/problem/908/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		String s = read.nextLine();
		
		int minNumberOfCardsToFlip = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if ( "aeiou13579".contains(String.valueOf(c)) ) {
				minNumberOfCardsToFlip++;
			}
		}
		
		System.out.println(minNumberOfCardsToFlip);
		
		// Close scanner
		read.close();
	}
}
