// https://codeforces.com/problemset/problem/1146/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		int aCount = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == 'a') {
				aCount++;
			}
		}
		
		int halfOfCharactersCount = s.length() / 2;
		int result = s.length();
		while (aCount <= halfOfCharactersCount) {
			result--;
			halfOfCharactersCount = result / 2;
		}
		
		System.out.println(result);

		// Close scanner
		read.close();
	}

}
