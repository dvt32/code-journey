// https://codeforces.com/problemset/problem/1043/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		int maxVotesForElodreipByOnePerson = Integer.MIN_VALUE;
		int elodreipVoteCount = 0;
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = read.nextInt();
			elodreipVoteCount += a[i];
			maxVotesForElodreipByOnePerson = Math.max(a[i], maxVotesForElodreipByOnePerson);
		}
		
		int k = maxVotesForElodreipByOnePerson;
		while (true) {
			int awrukVoteCount = 0;
			for (int j = 0; j < n; ++j) {
				awrukVoteCount += (k - a[j]);
			}
			if (awrukVoteCount > elodreipVoteCount) {
				System.out.println(k);
				break;
			}
			k++;
		}
		
		// Close scanner
		read.close();
	}

}
