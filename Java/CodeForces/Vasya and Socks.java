// http://codeforces.com/problemset/problem/460/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int m = read.nextInt();
		
		int answer = 0;
		while (n != 0) {
			n--;
			answer++;
			if (answer % m == 0) {
				n++;
			}
		}
	
		System.out.println(answer);
		
		// Close scanner
		read.close();
	}
	
}
