// dvt32

/*

9.4. Напишете метод, който:
- намира колко пъти дадено число се среща в даден масив. 

Методът трябва да приема като параметър масив от числа (int[]) и търсеното число (int).

Напишете програма, която проверява дали този метод работи правилно.

*/

import java.util.Scanner;

public class mainClass {
	
	public static int getNumberOfInstancesInArray(int[] arr, int number) {
		int numberOfInstances = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == number) {
				numberOfInstances++;
			}
		}
		return numberOfInstances;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Set array size and enter element values
		System.out.print("Enter array size: "); int arraySize = read.nextInt();
		int arr[] = new int[arraySize];
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Enter arr["+i+"]: "); arr[i] = read.nextInt();
		}
		
		// Enter which number to search for in array and get number of instances in the array
		System.out.print("Enter number to find in array: "); int number = read.nextInt();	
		int numberOfInstances = getNumberOfInstancesInArray(arr, number);
		
		// Print end result
		System.out.println("\n" + "Number of instances: " + numberOfInstances);
	}
}