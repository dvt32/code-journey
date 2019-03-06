// https://codeforces.com/problemset/problem/989/A

// With help of https://codeforces.com/blog/entry/59968

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		String result = "NO";
		for (int i = 0; i < s.length()-2; ++i) {
			char firstChar = s.charAt(i);
			char secondChar = s.charAt(i+1);
			char thirdChar = s.charAt(i+2);
			boolean areLetters = (firstChar != '.' && secondChar != '.' && thirdChar != '.');
			if (areLetters) {
				if (firstChar != secondChar && firstChar != thirdChar && secondChar != thirdChar) {
					result = "YES";
					break;
				}
			}
		}
		
		System.out.println(result);
		
		// Close scanner
		read.close();
	}

}
