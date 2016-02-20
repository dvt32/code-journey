// dvt

/* 
 * Напишете програма, която преобразува дадено число от
 *  	12. десетична в двоична бройна система.
 *		13. двоична в десетична бройна система.
 *		14. десетична в шестнайсетична бройна система.
 *		15. шестнайсетична в десетична бройна система.
*/

import java.util.Scanner;

public class myJavaClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// 12 - Decimal to Binary
		System.out.print("Enter decimal number: "); int a = read.nextInt();
		String decToBin = Integer.toBinaryString(a);
		System.out.println("To binary: " + decToBin);
		read.nextLine();
		
		// 13 - Binary to Decimal
		System.out.print("Enter binary number: "); String b = read.nextLine();
		int binToDec = Integer.parseInt(b, 2);
		System.out.println("To decimal: " + binToDec);
		
		// 14 - Decimal to Hexadecimal
		System.out.print("Enter decimal number: "); int c = read.nextInt();
		String decToHex = Integer.toHexString(c);
		System.out.println("To hexadecimal: " + decToHex);
		read.nextLine();
		
		// 15 - Hexadecimal to Decimal
		System.out.print("Enter hexadecimal number: "); String d = read.nextLine();
		int hexToDec = Integer.parseInt(d, 16);
		System.out.println("To decimal: " + hexToDec);
		

	}

}
