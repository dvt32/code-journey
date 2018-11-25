// http://codeforces.com/problemset/problem/200/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		double p_sum = 0;
		for (int i = 0; i < n; ++i) {
			p_sum += read.nextInt();
		}
		
		System.out.println( p_sum / n );
		
		// Close scanner
		read.close();
	}

}
