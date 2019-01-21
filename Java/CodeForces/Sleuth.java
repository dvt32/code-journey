// https://codeforces.com/problemset/problem/49/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String question = read.nextLine();
	
		final String VOWELS = "AEIOUYaeiouy";
		
		question = question.substring(0, question.length()-1).trim();
		char lastLetter = question.charAt(question.length()-1);
		
		if (VOWELS.contains(String.valueOf(lastLetter))) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	
		// Close scanner
		read.close();
	}

}
