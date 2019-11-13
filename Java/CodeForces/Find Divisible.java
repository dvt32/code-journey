// https://codeforces.com/problemset/problem/1096/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = read.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int l = read.nextInt();
			int r = read.nextInt();

			int x = l;
			int y = 2 * l;
			
			System.out.println(x + " " + y);
		}
		
		// Close scanner
		read.close();
	}

}
