// https://codeforces.com/problemset/problem/1061/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int S = read.nextInt();
		
		System.out.println( (int) Math.ceil( (double) S / n) );

		// Close scanner
		read.close();
	}

}
