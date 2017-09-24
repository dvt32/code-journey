// http://codeforces.com/problemset/problem/118/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		final String VOWELS = "aeiouy";
		StringBuilder output = new StringBuilder();
		
		String line = read.nextLine().toLowerCase();
		for (int i = 0; i < line.length(); ++i) {
			char currentChar = line.charAt(i);
			boolean isVowel = VOWELS.contains( String.valueOf(currentChar) );
			if (isVowel) {
				continue;
			}
			else {
				output.append("." + currentChar);
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}

}
