// https://codeforces.com/problemset/problem/32/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String s = read.nextLine();
		
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char currentChar = s.charAt(i);
			if (currentChar == '.') {
				output.append("0");
			}
			else {
				char nextChar = s.charAt(i+1);
				if (nextChar == '.') {
					output.append("1");
				}
				else {
					output.append("2");
				}
				i++; // skip next character
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}

}
