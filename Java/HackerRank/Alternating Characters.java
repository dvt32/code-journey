// https://www.hackerrank.com/challenges/alternating-characters

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {	
		Scanner read = new Scanner(System.in);
		
		int T = read.nextInt();
		if (T < 1 || T > 10) { 
			read.close(); 
			return; 
		}
		read.nextLine(); // Skip newline
		
		for (int i = 0; i < T; ++i) {
			String input = read.nextLine();
			if (input.length() > Math.pow(10,5) || input.length() < 1) {
				read.close();
				return;
			}
			int numberOfDeletions = 0;
			
			for (int j = 0; j < input.length()-1; ++j) {
				if (input.charAt(j) == input.charAt(j+1)) {
					numberOfDeletions++;
				}
			}
			
			// Print end result
			System.out.println(numberOfDeletions);
		}
		
		// Close scanner
		read.close();
	}
}
