// dvt32

/* 7. Напишете програма, която 
 * чете пет числа и 
 * отпечатва най-голямото от тях. 
 * 
 * Забележка: трябва да използвате конструкция "if", 
 * която до момента не сме разгледали. */

package java1;

import java.util.Scanner;

public class MyJava {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int[] arr = new int[5];
		int arrMax = arr[0];
		
		for (int i = 0; i < 5; ++i){
			System.out.print("Number " + i + ": "); 
			arr[i] = read.nextInt();
			if (arr[i] > arrMax) {arrMax = arr[i];}
		}
		
		System.out.printf("%narrMax = %1$d", arrMax);		
		
	}

}
