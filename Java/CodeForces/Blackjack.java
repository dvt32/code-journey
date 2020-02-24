// https://codeforces.com/problemset/problem/104/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		if (n <= 10 || n >= 22) {
			System.out.println("0");
		}
		else {
			n -= 10;
			if (n == 10) {
				System.out.println("15");
			}
			else {
				System.out.println("4");
			}
		}
		
		// Close scanner
		read.close();
	}

}
