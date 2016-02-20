// dvt

/* 3. Напишете програма, 
 * която чете от конзолата поредица от цели числа 
 * и отпечатва най-малкото и най-голямото от тях. */

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[] myArr = new int[10];
		int num, numMax, numMin;
		
		numMax = numMin = myArr[0];
		
		System.out.print("Numbers = "); int n = read.nextInt(); System.out.println();
		
		for (int i = 0; i < n; ++i){
			System.out.print("Number " + i + ": "); myArr[i] = read.nextInt();
			if (myArr[i] > numMax) { numMax = myArr[i]; }
			if (myArr[i] < numMin) { numMin = myArr[i]; }
		}
		
		System.out.printf("\nBiggest number: %d%n", numMax);
		System.out.printf("Smallest number: %d", numMin);
		
	}

}