// http://codeforces.com/problemset/problem/733/A

import java.util.Scanner;

public class Solution {
	
	public static boolean isConsonant(char c) {
		return ( 
			c != 'A' && 
			c != 'E' && 
			c != 'I' && 
			c != 'O' && 
			c != 'U' && 
			c != 'Y' 
		);
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String str = read.nextLine();
		
		int currentConsonantSequenceLength = 0;
		int maxConsonantSequenceLength = 0;
		
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if ( isConsonant(c) ) {
				currentConsonantSequenceLength++;
			}
			
			if ( !isConsonant(c) || (i == str.length()-1) ) {
				if (currentConsonantSequenceLength > maxConsonantSequenceLength) {
					maxConsonantSequenceLength = currentConsonantSequenceLength;
				}
				currentConsonantSequenceLength = 0;
			}
		}
		
		int minJumpAbilityNeeded = maxConsonantSequenceLength + 1;
		System.out.println( minJumpAbilityNeeded );
		
		// Close scanner
		read.close();
	}
	
}
