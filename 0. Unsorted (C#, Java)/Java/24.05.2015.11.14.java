// dvt

/* 1. Напишете програма, която 
 * отпечатва на конзолата числата от 1 до N. 
 * 
 * Числото N се чете от стандартния вход. */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("N = "); int N = read.nextInt();
		
		for (int number = 1; number <= N; ++number){
			System.out.printf("%d ", number);
		}
		
	}

}