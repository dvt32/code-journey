// dvt32.

/* 7.    Напишете метод, който 
 * отпечатва цифрите на дадено десетично число 
 * в обратен ред. 
 * 
 * Например 256, трябва да бъде отпечатано като 652. */

package myJava;

import java.util.Scanner;

public class myClass {
	
	public static int reverseNumber(int number){
		int reversed = 0;
		
		while (number != 0)
		{
			reversed = reversed * 10 + number % 10;
			number /= 10;
		}
		
		return reversed;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);	
		
		int number = read.nextInt();
		System.out.println(reverseNumber(number));			
	}


}
