// http://codeforces.com/problemset/problem/1005/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		String t = read.nextLine();
		
		int sLength = s.length();
		int tLength = t.length();
		int longestCommonSuffixLength = 0;
		
		for (int i = sLength-1, j = tLength-1; 
			 i >= 0 && j >= 0; 
			 --i, --j) 
		{
			if (s.charAt(i) == t.charAt(j)) {
				longestCommonSuffixLength++;
			}
			else {
				break;
			}
		}
		
		int moveCount = (sLength + tLength) - (2 * longestCommonSuffixLength);
		System.out.println(moveCount);
		
		// Close scanner
		read.close();
	}

}
