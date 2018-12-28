// https://codeforces.com/problemset/problem/92/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		int i = 1;
		while (m - i >= 0) {
			m -= i;
			i++;
			if (i > n) {
				i = 1;
			}
		}
		
		System.out.println(m);
		
		// Close scanner
		read.close();
	}

}
