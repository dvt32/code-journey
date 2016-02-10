// dvt

/* 2. Напишете програма, която 
 * отпечатва на конзолата числата от 1 до N, 
 * които не се делят на 3 и 7. 
 * 
 * Числото N се чете от стандартния вход. */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("N = "); int N = read.nextInt();
		
		for (int number = 1; number <= N; ++number){
			if (number % 3 != 0 && number % 7 != 0){
				System.out.printf("%d ", number);
			}
		}
		
	}

}