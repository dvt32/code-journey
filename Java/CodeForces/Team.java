// http://codeforces.com/problemset/problem/231/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfImplementedProblems = 0;
		
		int n = read.nextInt();
		for (int i = 0; i < n; ++i) {
			int certainPeopleCount = ( read.nextInt() + read.nextInt() + read.nextInt() );
			if (certainPeopleCount >= 2) {
				numberOfImplementedProblems++;
			}
		}
		
		System.out.println( numberOfImplementedProblems );
		
		// Close scanner
		read.close();
	}
	
}
