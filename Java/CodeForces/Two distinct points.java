// https://codeforces.com/problemset/problem/1108/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int q = read.nextInt();
		
		for (int i = 0; i < q; ++i) {
			int l1 = read.nextInt();
			int r1 = read.nextInt();
			int l2 = read.nextInt();
			int r2 = read.nextInt();
			
			int a = 0;
			int b = 0;
			
			if (l1 != r2) {
				a = l1;
				b = r2;
			}
			else {
				a = l1;
				b = Math.min(l2, r2);
				if (b == a) { b++; }
			}
			
			System.out.println(a + " " + b);
		}
		
		// Close scanner
		read.close();
	}

}
