// http://codeforces.com/problemset/problem/474/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		final String KEYBOARD_LETTERS = "qwertyuiopasdfghjkl;zxcvbnm,./";
		
		String shiftDirection = read.nextLine();
		String message = read.nextLine();
		
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < message.length(); ++i) {
			char c = message.charAt(i);
			for (int j = 0; j < KEYBOARD_LETTERS.length(); ++j) {
				if (KEYBOARD_LETTERS.charAt(j) == c) {
					if (shiftDirection.equals("L")) {
						output.append( KEYBOARD_LETTERS.charAt(j+1) );
					}
					else {
						output.append( KEYBOARD_LETTERS.charAt(j-1) );
					}
					break;
				}
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
