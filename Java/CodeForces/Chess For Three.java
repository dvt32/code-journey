// https://codeforces.com/problemset/problem/893/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		if (a[0] == 3) {
			System.out.println("NO");
		}
		else if (n == 1) {
			System.out.println("YES");
		}
		else {
			int playerOne = a[0];
			int playerTwo = 3;
			int spectator = (a[0] == 1) ? 2 : 1;

			String result = "YES";
			for (int i = 1; i < n; ++i) {
				if (spectator == a[i]) {
					result = "NO";
					break;
				}
				
				playerOne = a[i];
				playerTwo = spectator;
				spectator = 6 - playerOne - playerTwo;
			}
			
			System.out.println(result);
		}
		
		// Close scanner
		read.close();
	}

}
