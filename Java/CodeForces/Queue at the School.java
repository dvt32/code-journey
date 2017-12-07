// http://codeforces.com/problemset/problem/266/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int t = read.nextInt();
		
		read.nextLine(); // clear buffer
		
		char[] s = read.nextLine().toCharArray();	
	
		while (t != 0) {
			for (int i = 0; i < n-1; ++i) {
				if (s[i] == 'B' && s[i+1] == 'G') {
					s[i] = 'G';
					s[i+1] = 'B';
					i++;
				}
			}
			t--;
		}
		
		System.out.println( s );
		
		// Close scanner
		read.close();
	}
	
}
