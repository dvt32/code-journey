// http://codeforces.com/problemset/problem/25/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		int evenNumberCount = 0;
		int oddNumberCount = 0;
		int lastEvenNumberIndex = 0;
		int lastOddNumberIndex = 0;
		
		for (int i = 0; i < n; ++i) {
			int number = read.nextInt();
			if (number % 2 == 0) {
				evenNumberCount++;
				lastEvenNumberIndex = i+1;
			}
			else {
				oddNumberCount++;
				lastOddNumberIndex = i+1;
			}
		}
		
		if (evenNumberCount > oddNumberCount) {
			System.out.println(lastOddNumberIndex);
		}
		else {
			System.out.println(lastEvenNumberIndex);
		}
		
		// Close scanner
		read.close();
	}
	
}
