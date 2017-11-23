// http://codeforces.com/problemset/problem/155/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int firstNumber = read.nextInt();
		int minScore = firstNumber;
		int maxScore = firstNumber;
		int amazingPerformanceCount = 0;
		
		for (int i = 1; i < n; ++i) {
			int number = read.nextInt();
			if (number < minScore) {
				minScore = number;
				amazingPerformanceCount++;
			}
			else if (number > maxScore) {
				maxScore = number;
				amazingPerformanceCount++;
			}
		}
		
		System.out.println( amazingPerformanceCount );
		
		// Close scanner
		read.close();
	}
	
}
