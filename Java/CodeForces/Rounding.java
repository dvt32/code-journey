// http://codeforces.com/problemset/problem/898/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		long n = read.nextLong();
		
		int lastDigit = (int) (n % 10);
		if (lastDigit == 0) {
			System.out.println(n);
		}
		else {
			int absUp = Math.abs(10 - lastDigit);
			int absDown = Math.abs(10 - absUp);
			if (absUp < absDown) {
				System.out.println(n + absUp);
			}
			else {
				System.out.println(n - absDown);
			}
		}
		
		// Close scanner
		read.close();
	}
}
