// dvt

/* 3. Напишете програма, която 
 * намира най-голямото по стойност число, 
 * измежду три дадени числа. */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a, b, c, max;
		
		System.out.print("a = "); a = read.nextInt(); max = a;
		System.out.print("b = "); b = read.nextInt(); if (b > max) max = b;
		System.out.print("c = "); c = read.nextInt(); if (c > max) max = c;
		
		System.out.println("max = " + max);

	}

}
