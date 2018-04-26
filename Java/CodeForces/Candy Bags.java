// http://codeforces.com/problemset/problem/334/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int a = 1;
		int b = (int) Math.pow(n, 2);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; j += 2) {
				System.out.print(a + " " + b + " ");
				a++;
				b--;
			}
			System.out.println();
		}
		
		// Close scanner
		read.close();
	}
	
}
