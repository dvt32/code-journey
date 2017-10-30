// http://codeforces.com/problemset/problem/122/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		read.close();
		
		int[] luckyNumbers = new int[] { 4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777 };
		
		for (int luckyNumber : luckyNumbers) {
			if (n % luckyNumber == 0) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
	
}
