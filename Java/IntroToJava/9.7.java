// dvt32

/*

9.7. Напишете метод, който 
отпечатва цифрите на дадено десетично число в обратен ред. 

Например 256, трябва да бъде отпечатано като 652.

*/

import java.util.Scanner;

public class mainClass {
	
	public static void printInReverseOrder(int number) {
		String numberToString = Integer.toString(number);
		for (int i = numberToString.length()-1; i >= 0; --i) {
			System.out.print(numberToString.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("Enter integer: "); int number = read.nextInt();
		
		printInReverseOrder(number);
	}
}
