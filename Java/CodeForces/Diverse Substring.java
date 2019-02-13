// https://codeforces.com/problemset/problem/688/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.nextLine();
		
		String s = read.nextLine();

		boolean foundDiverseSubstring = false;
		String diverseSubstring = "";
		for (int i = 0; i < n-1; ++i) {
			String substring = s.substring(i, i+2);
			if (substring.charAt(0) != substring.charAt(1)) {
				foundDiverseSubstring = true;
				diverseSubstring = substring;
				break;
			}
		}
		
		if (foundDiverseSubstring) {
			System.out.println("YES");
			System.out.println(diverseSubstring);
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
