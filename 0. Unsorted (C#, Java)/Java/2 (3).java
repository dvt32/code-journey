// dvt

/* 2. Напишете програма, която 
 * показва знака (+ или -) 
 * от частното на две реални числа, 
 * без да го пресмята.
 */


package myJava;

import java.util.Scanner;

public class dvt {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		double a, b;
		
		// BG LOCALIZED - MUST ENTER DOUBLE IN THIS FORMAT: 0,00
		
		System.out.print("a = "); a = read.nextDouble();
		System.out.print("b = "); b = read.nextDouble();
		
		if (a < 0 && b < 0) {System.out.print("+");}
		if (a > 0 && b > 0) {System.out.print("+");}
		if (a > 0 && b < 0) {System.out.print("-");}
		if (a < 0 && b > 0) {System.out.print("-");}
	}

}
