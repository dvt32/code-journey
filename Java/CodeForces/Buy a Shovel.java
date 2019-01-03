// https://codeforces.com/problemset/problem/732/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int k = read.nextInt();
		int r = read.nextInt();
			
		int shovelCount = 1, k_copy = k;
		while (k % 10 != 0 && k % 10 != r) {
			k += k_copy;
			shovelCount++;
		}
		
		System.out.println(shovelCount);
		
		// Close scanner
		read.close();
	}

}
