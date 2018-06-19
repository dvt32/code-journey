// http://codeforces.com/problemset/problem/488/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt();
		
		int temp = a;
		int b = 0;
		while (b == 0) {
			boolean isLucky = String.valueOf(temp).contains("8");
			if (isLucky) {
				int difference = Math.abs(a - temp);
				b = (difference > 0) ? difference : 0;
			}
			temp++;
		}

		System.out.println(b);
			
		// Close scanner
		read.close();
	}
}
