// http://codeforces.com/problemset/problem/472/A

import java.util.Scanner;

public class Solution {
	
	// https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
	public static boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i*i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
			
		return true;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		boolean foundValidCompositeNumbers = false;
		int x = 0, y = 0;
		for (x = 4; x < n; ++x) {
			for (y = 4; y < n; ++y) {
				if (!isPrime(x) && !isPrime(y)) {
					if ( (x + y) == n ) {
						foundValidCompositeNumbers = true;
						break;
					}
				}
			}
			
			if (foundValidCompositeNumbers) {
				break;
			}
		}
		
		System.out.println(x + " " + y);
		
		// Close scanner
		read.close();
	}
	
}
