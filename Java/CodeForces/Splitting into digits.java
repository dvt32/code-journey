// https://codeforces.com/problemset/problem/1104/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int k = n;
		System.out.println(k);
		
		for (int i = 0; i < k; ++i) {
			System.out.print("1 ");
		}
		
		// Close scanner
		read.close();
	}

}
