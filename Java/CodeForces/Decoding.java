// http://codeforces.com/problemset/problem/746/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		read.nextLine();
		
		String s = read.nextLine();
		
		StringBuilder decryptedWord = new StringBuilder();
		for (int i = n-1; i >= 0; --i) {
			char c = s.charAt(i);
			decryptedWord.insert( decryptedWord.length()/2,  c );
		}
		
		System.out.println(decryptedWord);
		
		// Close scanner
		read.close();
	}
}
