// dvt

/* 8. Напишете програма, 
 * която за дадено цяло число N, пресмята сумата:

S = 1+(1!/x)+(2!/(x^2)) + ... + (n!/(x^n))

*/

package introJava;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int i, j, factorial = 1;
		
		double S = 1; // result
		
		System.out.print("N = "); int N = read.nextInt();
		System.out.print("x = "); int x = read.nextInt();
		
		for (i = 1; i <= N; ++i){
			factorial *= i;
			S += factorial / Math.pow(x, i);
		}
		
		// Print sum
		System.out.printf("%nS = %f", S);
		
		
	}

}
