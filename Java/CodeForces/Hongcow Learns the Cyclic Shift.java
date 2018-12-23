// https://codeforces.com/problemset/problem/745/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		String newWord = s;
		
		int wordCount = 0;
		do {
			wordCount++;
			newWord = newWord.substring(1) + newWord.charAt(0);
		}
		while (!newWord.equals(s));
		
		System.out.println(wordCount);
		
		// Close scanner
		read.close();
	}

}
