// https://www.hackerrank.com/challenges/java-biginteger

import java.util.Scanner;
import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Enter & validate input
		BigInteger a = new BigInteger(read.nextBigInteger().toString());
		if (a.compareTo(BigInteger.ZERO) == -1) { read.close(); return; }
		BigInteger b = new BigInteger(read.nextBigInteger().toString());
		if (b.compareTo(BigInteger.ZERO) == -1) { read.close(); return; }
	
		// Print end result
		System.out.println(a.add(b));
		System.out.println(a.multiply(b));
				
		// Close scanner
		read.close();
	}
}
