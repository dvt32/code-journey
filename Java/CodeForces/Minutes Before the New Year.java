// https://codeforces.com/problemset/problem/1283/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int t = read.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int h = read.nextInt();
			int m = read.nextInt();
			int minutesTillNewYear = 24*60 - h*60 - m;
			System.out.println(minutesTillNewYear);
		}
		
		// Close scanner
		read.close();
	}

}
