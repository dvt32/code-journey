// http://codeforces.com/problemset/problem/732/A

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		int m = read.nextInt();

		// Check if 'm' is prime
		boolean mIsPrime = true;
		for (int i = 2; i < m; ++i) {
			if (m % i == 0) {
				mIsPrime = false;
				break;
			}
		}

		// Check if there are other primes between 'n' and 'm' and print end result
		if (mIsPrime) {
			int numberOfPrimesAfterN = 1;
			for (int i = n + 1; i < m; ++i) {
				if (numberOfPrimesAfterN > 1) {
					break;
				}

				boolean isPrime = true;
				for (int j = 2; j < i; ++j) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					numberOfPrimesAfterN++;
				}
			}

			if (numberOfPrimesAfterN == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}

		// Close scanner
		read.close();
	}

}
