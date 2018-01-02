// http://codeforces.com/problemset/problem/478/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int sum = 0;
		for (int i = 0; i < 5; ++i) {
			sum += read.nextInt();
		}
		
		if (sum % 5 == 0 && sum != 0) {
			int answer = (sum / 5);
			System.out.println(answer);
		}
		else {
			System.out.println("-1");
		}
		
		// Close scanner
		read.close();
	}
	
}
