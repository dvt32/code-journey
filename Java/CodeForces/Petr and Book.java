// http://codeforces.com/problemset/problem/139/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] pagesRead = new int[7];
		for (int i = 0; i < 7; ++i) {
			pagesRead[i] = read.nextInt();
		}
		
		int currentDayOfWeek = 0;
		while (n > 0) {	
			for (int i = 0; i < 7; ++i) {
				n -= pagesRead[i];
				currentDayOfWeek = (currentDayOfWeek == 7) ? 1 : currentDayOfWeek+1;
				if (n <= 0) {
					break;
				}
			}
		}
		
		System.out.println(currentDayOfWeek);
		
		// Close scanner
		read.close();
	}

}
