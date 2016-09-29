// PAA Practice 29.09.2016 - dvt32

/*
 * Намиране на най-малко общо кратно. 
Намирането на най-малко общо кратно става лесно, като се изчисли стойността на израза: 
 a*b/gcd(a,b)
 */

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
	
	// Get LCM
	static int getLeastCommonMultiple(int a, int b) {
		int leastCommonMultiple = (a * b) / getGreatestCommonDivisor(a, b);
		return leastCommonMultiple;
	}
	
	
	public static void main(String[] args) {
		System.out.println(
				getLeastCommonMultiple(6, 21)
		);
	}
}
