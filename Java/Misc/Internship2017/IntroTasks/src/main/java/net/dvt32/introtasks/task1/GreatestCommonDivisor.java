package net.dvt32.introtasks.task1;

/**
* This program calculates the Greatest Common Divisor (GCD) & 
* Least Common Multiple (LCM) of two integers, using Euclid's algorithm.
*
* @author  Dimitar Trifonov (dvt32)
*/
public class GreatestCommonDivisor {
	/**
	 * This method calculates the GCD of two integers.
	 * 
	 * @param a	the first integer
	 * @param b the second integer
	 * @return The greatest common divisor of the two integers.
	 */
	public static int getGreatestCommonDivisor(int a, int b) {
		while (b != 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		int greatestCommonDivisor = a;
		return greatestCommonDivisor;
	}
	
	/**
	 * This method calculates the LCM of two integers, by first calculating their GCD.
	 * 
	 * @param a The first integer
	 * @param b The second integer
	 * @return The least common multiple of the two integers.
	 */
	public static int getLeastCommonMultiple(int a, int b) {
		int leastCommonMultiple = (a * b) / getGreatestCommonDivisor(a, b);
		return leastCommonMultiple;
	}
}
