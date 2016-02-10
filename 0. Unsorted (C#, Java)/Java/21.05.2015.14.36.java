// dvt

/* 1. Да се напише if-конструкция, 
 * която изчислява стойността на две целочислени променливи и 
 * разменя техните стойности, 
 * ако стойността на първата променлива е по-голяма от втората.
 */


package myJava;

import java.util.Scanner;

public class dvt {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a, b, temp;
		
		System.out.print("a = "); a = read.nextInt();
		System.out.print("b = "); b = read.nextInt();
		
		if (a > b){
			temp = a;
			a = b;
			b = temp;
			System.out.println(
					"a > b! The values have been switched!\n" 
							+ "a = " + a + " b = " + b);
		}
	}

}
