// http://codeforces.com/problemset/problem/581/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		
		int maxFashionableDays = 0;
		while (a > 0 && b > 0) {
			a--;
			b--;
			maxFashionableDays++;
		}
		System.out.print(maxFashionableDays + " ");
		
		if (a > 0) {
			System.out.print(a / 2);
		}
		else {
			System.out.print(b / 2);
		}
		
		// Close scanner
		read.close();
	}
	
}
