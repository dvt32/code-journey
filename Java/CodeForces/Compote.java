// https://codeforces.com/problemset/problem/746/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		int c = read.nextInt();
		
		int maxSum = 0;
		while (a >= 1  && b >= 2 && c >= 4) {
			a--;
			b -= 2;
			c -= 4;
			maxSum += 7;
		}
		
		System.out.println(maxSum);
	
		// Close scanner
		read.close();
	}

}
