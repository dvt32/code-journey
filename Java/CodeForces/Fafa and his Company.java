// https://codeforces.com/problemset/problem/935/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int numberOfWays = 0;
		for (int i = 1; i <= n/2; ++i) {
			if (n % i == 0) {
				numberOfWays++;
			}
		}
		
		System.out.println(numberOfWays);
		
		// Close scanner
		read.close();
	}

}
