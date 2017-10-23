// http://codeforces.com/problemset/problem/617/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int x = Integer.parseInt( read.nextLine() );

		int minStepCount = 0;
		while (x > 0) {
			if (x >= 5) {
				minStepCount++;
				x -= 5;
			}
			else if (x >= 4) {
				minStepCount++;
				x -= 4;
			}
			else if (x >= 3) {
				minStepCount++;
				x -= 3;
			}
			else if (x >= 2) {
				minStepCount++;
				x -= 2;
			}
			else if (x >= 1) {
				minStepCount++;
				x -= 1;
			}
		}
		
		System.out.println( minStepCount );
		
		// Close scanner
		read.close();
	}
	
}
