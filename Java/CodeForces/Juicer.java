// http://codeforces.com/problemset/problem/709/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int b = read.nextInt();
		int d = read.nextInt();
		
		int emptyWasteCount = 0;
		int juiceSum = 0;
		
		for (int i = 0; i < n; ++i) {
			int a = read.nextInt();
			if (a <= b) {
				juiceSum += a;
			}
			if (juiceSum > d) {
				juiceSum = 0;
				emptyWasteCount++;
			}
		}
		
		System.out.println(emptyWasteCount);
		
		// Close scanner
		read.close();
	}
	
}
