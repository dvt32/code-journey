// http://codeforces.com/problemset/problem/4/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int w = read.nextInt();
		if (w > 2 && w % 2 == 0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}

}
