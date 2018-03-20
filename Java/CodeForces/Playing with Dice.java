// http://codeforces.com/problemset/problem/378/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int a = read.nextInt();
		int b = read.nextInt();
		
		int firstPlayerWinCount = 0;
		int drawCount = 0;
		int secondPlayerWinCount = 0;
		
		for (int x = 1; x <= 6; ++x) {
			int firstDifference = Math.abs(a - x);
			int secondDifference = Math.abs(b - x);
			
			if (firstDifference < secondDifference) {
				firstPlayerWinCount++;
			}
			else if (firstDifference > secondDifference) {
				secondPlayerWinCount++;
			}
			else {
				drawCount++;
			}
		}
		
		System.out.println(firstPlayerWinCount + " " + drawCount + " " + secondPlayerWinCount);
		
		// Close scanner
		read.close();
	}
	
}
