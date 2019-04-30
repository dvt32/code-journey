// https://codeforces.com/problemset/problem/893/B

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
	
		int maxDivisor = Integer.MIN_VALUE;
		for (int divisor = n; divisor >= 1; --divisor) {
			if (n % divisor == 0) {
				String divisorInBinary = Integer.toBinaryString(divisor);
				if (divisorInBinary.length() % 2 != 0) {
					int k = (divisorInBinary.length() / 2) + 1;
					boolean isBeautiful = true;
					for (int i = 0; i < k; ++i) {
						if (divisorInBinary.charAt(i) != '1') {
							isBeautiful = false;
							break;
						}
					}
					if (isBeautiful) {
						for (int i = k; i < divisorInBinary.length(); ++i) {
							if (divisorInBinary.charAt(i) != '0') {
								isBeautiful = false;
								break;
							}
						}
						if (isBeautiful) {
							maxDivisor = divisor;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(maxDivisor);
		
		// Close scanner
		read.close();
	}

}
