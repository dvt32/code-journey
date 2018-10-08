// http://codeforces.com/problemset/problem/938/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = Integer.parseInt( read.nextLine() );
		StringBuilder s = new StringBuilder( read.nextLine() );
		
		final String VOWELS = "aeiouy";
		
		boolean stillRemovingVowels = true;
		while (stillRemovingVowels) {
			stillRemovingVowels = false;
			for (int i = 0; i < s.length()-1; ++i) {
				boolean isVowel = ( VOWELS.contains(String.valueOf(s.charAt(i))) );
				boolean isVowelNextChar = ( VOWELS.contains(String.valueOf(s.charAt(i+1))) );
				if (isVowel && isVowelNextChar) {
					s.deleteCharAt(i+1);
					stillRemovingVowels = true;
					break;
				}
			}
			if (!stillRemovingVowels) {
				break;
			}
		}
		
		System.out.println(s);
		
		// Close scanner
		read.close();
	}

}
