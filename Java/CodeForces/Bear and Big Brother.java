// http://codeforces.com/problemset/problem/791/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = read.nextInt(); // Limak's weight
		int b = read.nextInt(); // Bob's weight
		
		int yearCount = 0;
		while (a <= b) {
			a = a*3;
			b = b*2;
			yearCount++;
		}
		
		System.out.println(yearCount);
		
		// Close scanner
		read.close();
	}
	
}
