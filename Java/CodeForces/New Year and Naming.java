// https://codeforces.com/problemset/problem/1284/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		read.nextLine();
		String[] s = read.nextLine().split(" ");
		String[] t = read.nextLine().split(" ");
		
		int q = read.nextInt();
		for (int i = 0; i < q; ++i) {
			int y = read.nextInt();
			y--; // indices are 0-based
			System.out.println( s[y % n] + t[y % m] );
		}
		
		// Close scanner
		read.close();
	}

}
