// http://codeforces.com/problemset/problem/897/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine(); // escape newline
		
		StringBuilder s = new StringBuilder( read.nextLine() );
		
		for (int i = 0; i < m; ++i) {
			String[] parameters = read.nextLine().split(" ");
			int l = Integer.parseInt(parameters[0]);
			int r = Integer.parseInt(parameters[1]);
			char c1 = parameters[2].charAt(0);
			char c2 = parameters[3].charAt(0);
			
			for (int j = l-1; j < r; ++j) {
				if (s.charAt(j) == c1) {
					s.setCharAt(j, c2);
				}
			}
		}
		
		System.out.println(s);
		
		// Close scanner
		read.close();
	}
}
