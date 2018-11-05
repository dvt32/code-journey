// http://codeforces.com/problemset/problem/996/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int billCount = 0;
		
		while (n - 100 >= 0) {
			 n -= 100;
			 billCount++;
		}
		while (n - 20 >= 0) {
			 n -= 20;
			 billCount++;
		}
		while (n - 10 >= 0) {
			 n -= 10;
			 billCount++;
		}
		while (n - 5 >= 0) {
			 n -= 5;
			 billCount++;
		}
		while (n - 1 >= 0) {
			 n -= 1;
			 billCount++;
		}
		
		System.out.println(billCount);
		
		// Close scanner
		read.close();
	}

}
