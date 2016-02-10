// dvt32.

/* 5.    Напишете метод, който 
 * проверява дали елемент, 
 * намиращ се на дадена позиция от масив, 
 * е по-голям, или съответно по-малък от двата му съседа. */

package myJava;

import java.util.Scanner;

public class myClass {
	
	public static void checkArrayElement(int i, int[] arr){
		// lots of if-s
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);	
		
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; ++i){
			System.out.print("arr["+i+"]: "); arr[i] = read.nextInt();
		}
		
		System.out.print("\nEnter index: "); int index = read.nextInt();
		
		checkArrayElement(index, arr);
				
	}


}
