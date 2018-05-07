// http://codeforces.com/problemset/problem/149/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int k = read.nextInt();
		
		int[] growth = new int[12];
		for (int i = 0; i < 12; ++i) {
			growth[i] = read.nextInt();
		}
		
		Arrays.sort(growth);
		
		int flowerGrowth = 0;
		int monthIndex = 11; // indices go from 0 to 11 inclusive
		int minMonthCount = 0;
		
		while (flowerGrowth < k && monthIndex >= 0) {
			flowerGrowth += growth[monthIndex];
			minMonthCount++;
			monthIndex--;
		}
		
		if (flowerGrowth < k) {
			System.out.println("-1");
		}
		else {
			System.out.println(minMonthCount);
		}
		
		// Close scanner
		read.close();
	}
	
}
