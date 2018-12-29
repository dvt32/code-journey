// https://codeforces.com/problemset/problem/1077/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = read.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int a = read.nextInt();
			int b = read.nextInt();
			int k = read.nextInt();
			
			long result = 0;
			if (k % 2 == 1) {
				result += (long) ((k/2)+1) * a;
				result -= (long) (k/2) * b;
			}
			else {
				result += (long) (k/2) * a;
				result -= (long) (k/2) * b;
			}
			
			System.out.println(result);
		}
		
		// Close scanner
		read.close();
	}

}
