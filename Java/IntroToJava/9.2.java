// dvt32

/*

9.2. Създайте метод getMax() с два целочислени (int) параметъра, 
който връща по-голямото от двете числа. 

Напишете програма, която:
- прочита три цели числа от конзолата и 
- отпечатва най-голямото от тях, използвайки метода getMax().

*/

import java.util.Scanner;

public class mainClass {
	
	public static int getMax(int a, int b) {
		if (a > b) return a;
		else return b;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("Enter 'a': "); int a = read.nextInt();
		System.out.print("Enter 'b': "); int b = read.nextInt();
		System.out.print("Enter 'c': "); int c = read.nextInt();
		
		int largestNumber = getMax(getMax(a,b), c);
		
		System.out.println("\n" + "Largest number: " + largestNumber);
	}
}
