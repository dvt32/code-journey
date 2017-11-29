// http://codeforces.com/problemset/problem/599/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int d1 = read.nextInt();
		int d2 = read.nextInt();
		int d3 = read.nextInt();
		
		int minDistance = Math.min(
			d1 + d2 + d3, // home -> the first shop -> the second shop -> home
			Math.min(
				d1 + d2 + d2 + d1, // home -> the first shop -> the second shop  -> the first shop -> home
				Math.min(
					d3 + d3 + d1 + d1, // home -> the second shop -> home -> the first shop -> home
					d3 + d2 + d2 + d3  // home -> the second shop -> the first shop -> the second shop -> home
				)
			)
		);
		
		System.out.println(minDistance);
		
		// Close scanner
		read.close();
	}
	
}
