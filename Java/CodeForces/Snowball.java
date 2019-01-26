// https://codeforces.com/problemset/problem/1099/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int w = read.nextInt();
		int h = read.nextInt();
		int u1 = read.nextInt();
		int d1 = read.nextInt();
		int u2 = read.nextInt();
		int d2 = read.nextInt();
		
		int i = h;
		while (i != 0) {
			w += i;
			
			if (i == d1) {
				w = Math.max(0, w-u1);
			}
			else if (i == d2) {
				w = Math.max(0, w-u2);
			}
				
			i--;
		}
		
		System.out.println(w);
		
		// Close scanner
		read.close();
	}

}
