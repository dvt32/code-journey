// https://codeforces.com/problemset/problem/1148/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		int c = read.nextInt();
		
		long maxLength = 
			(long) c * 2 + 
			(long) Math.min(a, b) * 2 + 
			(a != b ? 1 : 0);
		
		System.out.println(maxLength);
	
		// Close scanner
		read.close();
	}

}
