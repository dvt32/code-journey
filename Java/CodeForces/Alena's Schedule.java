// http://codeforces.com/problemset/problem/586/A
// Don't ask me how I came up with this mess, lol... but it works.

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
		}
		
		int pairCount = 0;
		
		int i = 0;
		while (i < n && a[i] == 0) {
			i++;
		}
		
		while (i < n) {
			if (a[i] == 1) {
				pairCount++;
			}
			else if (a[i] == 0) {
				if (i == n-1) {
					break;
				}
				else if (a[i+1] == 0) {
					while (i < n && a[i] == 0) {
						i++;
					}
					i--;
				}
				else {
					pairCount++;
				}
			}
			i++;
		}
		
		System.out.println(pairCount);
		
		// Close scanner
		read.close();
	}

}
