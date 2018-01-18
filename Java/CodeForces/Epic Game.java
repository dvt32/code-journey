// http://codeforces.com/problemset/problem/119/A

import java.util.Scanner;

public class Solution {
	
	public static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); } 

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		int b = read.nextInt();
		int n = read.nextInt();
		
		boolean isSimonsTurn = true;
		while (n >= 0) {
			n -= (isSimonsTurn) ? gcd(a, n) : gcd(b, n);
			isSimonsTurn = !isSimonsTurn;
		}
		
		int winner = (isSimonsTurn) ? 0 : 1;
		
		System.out.println(winner);
		
		// Close scanner
		read.close();
	}
	
}
