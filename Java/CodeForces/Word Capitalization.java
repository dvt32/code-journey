// http://codeforces.com/problemset/problem/281/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String word = read.nextLine();
		
		if ( word.charAt(0) != Character.toUpperCase(word.charAt(0)) ) {
			word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
		}
		
		System.out.println(word);
		
		// Close scanner
		read.close();
	}
	
}
