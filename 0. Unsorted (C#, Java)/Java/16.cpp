// dvt

/* 
16. Напишете програма, която по дадено число N отпечатва случайно число между 1 и N.
*/

import java.util.Scanner;
import java.util.Random;

public class myJavaClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		Random getRandomNumber = new Random();
		
		System.out.print("N = "); int N = read.nextInt(); if (N<1) return;
		int randomNumber = getRandomNumber.nextInt(N);
		System.out.println("Your random number is: " + randomNumber);
			
	}

}
