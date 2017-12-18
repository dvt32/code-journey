// http://codeforces.com/problemset/problem/61/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String a = read.nextLine();
		String b = read.nextLine();
		
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) != b.charAt(i)) {
				output.append("1");
			}
			else {
				output.append("0");
			}
		}
		
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
	
}
