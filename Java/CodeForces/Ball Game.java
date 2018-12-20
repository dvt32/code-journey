// https://codeforces.com/problemset/problem/46/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int currentChildNumber = 1;
		int step = 1;
		
		for (int i = 0; i < n-1; ++i) {
			if (currentChildNumber + step > n) {
				currentChildNumber = step - (n-currentChildNumber);
			}
			else {
				currentChildNumber += step;
			}
			step++;
			System.out.print(currentChildNumber + " ");
		}
		
		// Close scanner
		read.close();
	}

}
