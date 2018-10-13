// http://codeforces.com/problemset/problem/1011/A

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		int k = read.nextInt();
		
		// Clear buffer
		read.nextLine();
		
		char[] s = read.nextLine().toCharArray();
		Arrays.sort(s);

		int minWeight = (s[0] - 'a') + 1;	
		k--;
		for (int i = 1, j = 0; i < n; ++i) {
			if (k == 0) {
				break;
			}
			int currentLetterWeight = (s[i] - 'a') + 1;
			if (s[i] - s[j] >= 2) {
				minWeight += currentLetterWeight;
				k--;
				j = i;
			}
		}
		
		if (k == 0) {
			System.out.println(minWeight);
		}
		else {
			System.out.println("-1");
		}

		// Close scanner
		read.close();
	}

}
