// http://codeforces.com/problemset/problem/750/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int k = read.nextInt();
		
		int numberOfSolvedProblems = 0;
		int sum = 0;
		for (int i = 1; i <= n; ++i) {
			sum += 5*i;
			if (sum + k > 240) {
				break;
			}
			else {
				numberOfSolvedProblems++;
			}
		}
		
		System.out.println(numberOfSolvedProblems);
		
		// Close scanner
		read.close();
	}
}
