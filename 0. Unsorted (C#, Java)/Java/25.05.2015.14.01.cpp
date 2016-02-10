// dvt

/* 5. Напишете програма, която 
 * чете от конзолата числото N 
 * и отпечатва сумата 
 * на първите N члена от редицата на Фибоначи: 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, ... */


package jvProject;

import java.util.Scanner;

public class javaClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int a = 0, b = 1, c = 1, N, i = 1;
		
		System.out.print("N = "); N = read.nextInt();
		
		while (i <= N){
			c = b+a;
			System.out.print(c + " ");
			a = b;
			b = c;
			++i;
		}

	}

}
