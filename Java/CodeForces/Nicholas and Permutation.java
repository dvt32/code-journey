// http://codeforces.com/problemset/problem/676/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
				
		int minIndex = -1;
		int maxIndex = -1;
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			if (a == 1) {
				minIndex = i;
			}
			if (a == n) {
				maxIndex = i;
			}
		}
		
		int firstDifference = Math.abs((n-1) - maxIndex);
		int secondDifference = Math.abs(minIndex - (n-1));
		int thirdDifference = Math.abs(0 - maxIndex);
		int fourthDifference = Math.abs(minIndex - 0);
		
		int maxDifference = Math.max(
			Math.abs(minIndex - maxIndex),
			Math.max(
				firstDifference, 
				Math.max(
					secondDifference, 
					Math.max(
						thirdDifference, 
						fourthDifference
					)
				)
			)	
		);
		
		System.out.println(maxDifference);
		
		// Close scanner
		read.close();
	}

}
