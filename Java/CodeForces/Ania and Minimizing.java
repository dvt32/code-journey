// https://codeforces.com/problemset/problem/1230/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		read.nextLine();
		
		String s = read.nextLine();
		
		if (n == 1) {
			System.out.println( 
				(k == 1) ? "0" : s
			); 
		}
		else if (k == 0) {
			System.out.println(s);
		}
		else {
			StringBuilder sb = new StringBuilder(s);
			
			if (sb.charAt(0) != '1') {
				sb.setCharAt(0, '1');
				k--;
			}
			
			for (int i = 1; i < n && k != 0; ++i) {
				char c = sb.charAt(i);
				if (c != '0') {
					sb.setCharAt(i, '0');
					k--;
				}
			}
				
			System.out.println(sb);
		}

		// Close scanner
		read.close();
	}

}
