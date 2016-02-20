// dvt

/* 4. Напишете програма, която 
 * чете от конзолата две цели числа (integer) 
 * и отпечатва, колко числа има между тях, 
 * такива, че остатъкът им от деленето на 5 да е 0. */

package java1;

import java.util.Scanner;

public class MyJava {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int lowEnd, highEnd, i, numbers = 0;
		
		System.out.print("Low end: "); lowEnd = read.nextInt();
		System.out.print("High end: "); highEnd = read.nextInt();
		if (lowEnd > highEnd) return;
		
		for (i = lowEnd; i <= highEnd; ++i){
			if (i % 5 == 0) numbers += 1;
		}
		
		System.out.println(numbers + " numbers can be divided by 5.");
		
	}

}
