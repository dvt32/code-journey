// PAA Practice 29.09.2016 - dvt32

// 1. GCD Implementation - version 1

public class Solution {
	
	static int getGreatestCommonDivisor(int a, int b) {
		int greatestCommonDivisor;
		while (b != 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		greatestCommonDivisor = a;
		return greatestCommonDivisor;
	}
	
	public static void main(String[] args) {
		System.out.println(
				getGreatestCommonDivisor(21, 6)
		);
	}
}
