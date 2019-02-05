// https://codeforces.com/problemset/problem/712/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		while (n % 10 == 0) {
			n /= 10;
		}
		
		if ( Integer.parseInt( new StringBuilder(String.valueOf(n)).reverse().toString() ) == n ) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
