// https://codeforces.com/problemset/problem/420/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String name = read.nextLine();
		
		final String SYMMETRIC_LETTERS = "AHIMOTUVWXY";

		boolean isPalindrome = new StringBuilder(name).reverse().toString().equals(name);
		boolean allLettersSymmetric = true;
		for (int i = 0; i < name.length(); ++i) {
			char c = name.charAt(i);
			if ( !( SYMMETRIC_LETTERS.contains( Character.toString(c) ) ) ) {
				allLettersSymmetric = false;
				break;
			}
		}
		
		boolean matchesMirrorReflection = ( isPalindrome && allLettersSymmetric );
		
		System.out.println( matchesMirrorReflection ? "YES" : "NO" );
		
		// Close scanner
		read.close();
	}

}
