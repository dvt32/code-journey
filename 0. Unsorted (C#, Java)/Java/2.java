// dvt32

/* 
2. Да се напише програма, която 
чете два масива от конзолата 
и проверява дали са еднакви.
 */

import java.util.Arrays;
import java.util.Scanner;

public class myClass {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		boolean arraysAreEqual = true;
		
		int[] A = new int[5];
		int[] B = new int[5];
		
		// Enter A elements
		for (int i = 0; i < A.length; ++i){
			System.out.print("A["+i+"]: "); A[i] = read.nextInt();
		}
		
		// Aesthetics
		System.out.println();
		
		// Enter B elements
		for (int i = 0; i < B.length; ++i){
			System.out.print("B["+i+"]: "); B[i] = read.nextInt();
		}
		
		// Compare arrays to see if they're identical
		for (int i = 0; i < 5; ++i){
			if (A[i] != B[i]) {
				arraysAreEqual = false;
				break;
			}
		}
		
		// Print result
		System.out.println("\nArrays are equal = " + arraysAreEqual);
	}
}
