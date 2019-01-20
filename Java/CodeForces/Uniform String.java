// https://codeforces.com/problemset/problem/1092/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = read.nextInt();
		for (int i = 0; i < t; ++i) {
			int n = read.nextInt();
			int k = read.nextInt();

			StringBuilder output = new StringBuilder();
			while (output.length() < n) {
				for (char c = 'a'; c < (char) 'a' + k; ++c) {
					if (output.length() == n) {
						break;
					}
					output.append(String.valueOf(c));
				}
			}
			
			System.out.println(output);
		}
	
		// Close scanner
		read.close();
	}

}
