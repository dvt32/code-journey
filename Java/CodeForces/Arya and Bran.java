// http://codeforces.com/problemset/problem/839/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		int aryaCandyCount = 0;
		int branCandyCount = 0;
		int minDayIndex = 0;
		
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			aryaCandyCount += a;
			
			int numberOfCandiesGivenToBran = Math.min(8, aryaCandyCount);
			
			aryaCandyCount -= numberOfCandiesGivenToBran;
			branCandyCount += numberOfCandiesGivenToBran;
			
			minDayIndex++;
			
			if (branCandyCount >= k) {
				break;
			}
		}
		
		if (branCandyCount >= k) {
			System.out.println(minDayIndex);
		}
		else {
			System.out.println("-1");
		}
		
		// Close scanner
		read.close();
	}
	
}
