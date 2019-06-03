// https://codeforces.com/problemset/problem/365/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int goodNumberCount = 0;
		for (int i = 0; i < n; ++i) {
			String number = String.valueOf( read.nextInt() );
			boolean isGoodNumber = true;
			for (int j = 0; j <= k; ++j) {
				if ( !number.contains(String.valueOf(j)) ) {
					isGoodNumber = false;
					break;
				}
			}
			if (isGoodNumber) {
				goodNumberCount ++;
			}
		}
		
		System.out.println(goodNumberCount);
		
		// Close scanner
		read.close();
	}

}
