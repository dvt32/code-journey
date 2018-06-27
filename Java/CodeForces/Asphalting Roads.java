// http://codeforces.com/problemset/problem/583/A

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		boolean hasBeenAsphalted_h[] = new boolean[n+1];
		boolean hasBeenAsphalted_v[] = new boolean[n+1];
		for (int i = 1; i <= n*n; ++i) {
			int h = read.nextInt();
			int v = read.nextInt();
			
			if (!hasBeenAsphalted_h[h] && !hasBeenAsphalted_v[v]) {
				hasBeenAsphalted_h[h] = true;
				hasBeenAsphalted_v[v] = true;
				System.out.print(i + " ");
			}
			else {
				continue;
			}
		}
		
		// Close scanner
		read.close();
	}
}
