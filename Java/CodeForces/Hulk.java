// http://codeforces.com/problemset/problem/705/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		StringBuilder output = new StringBuilder("I hate ");
		for (int i = 2; i <= n; ++i) {
			if (i % 2 == 0) {
				output.append("that I love ");
			}
			else {
				output.append("that I hate ");
			}
		}
		output.append("it");
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
