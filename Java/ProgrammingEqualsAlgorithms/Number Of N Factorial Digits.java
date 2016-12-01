// digitsnf.c

/*

Задача: Дадени са целите числа a1, a2, ..., an. Да се намери броят на цифрите на произведението

P = a1.a2.….an.

В частност, ако ai = i, за i = 1,2,...,n, то се търси броят на цифрите на P = 1.2 ... n = n!.

 */

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		/* Based on formula
		 	digitCount = 1 + (sum of log10(i) for i from 1 to 'n' inclusive)
		 */
	
		double digitCount = 0;
		for (int i = 1; i <= n; ++i) {
			digitCount += Math.log10(i);
		}
		digitCount++;
		
		System.out.println((long) digitCount);
		
		// Close scanner
		read.close();
		
	}

}
