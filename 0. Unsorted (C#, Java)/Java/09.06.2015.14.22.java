// dvt32

/* Да се напише програма, която преобразува: 
		- 4. десетично число в двоично.
		- 5. двоично число в десетично.
		- 6. десетично число в шестнадесетично.
		- 7. шестнадесетично число в десетично.
		- 8. шестнадесетично число в двоично.
		- 9. двоично число в шестнадесетично. 
*/


import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		// Decimal to binary
		int decNumber;
		String decToBin = "";
		
		System.out.print("Enter decimal number: "); decNumber = read.nextInt();
		
		while (decNumber > 0){
			int binary = decNumber % 2;
			decNumber /= 2;
			decToBin += Integer.toString(binary);
		}
		
		System.out.println("To binary: " + decToBin);
		
		// Binary to decimal
		String binNumber = "";
		int binToDecimal;
		
		System.out.print("Enter binary number: "); binNumber = read.nextLine();
		
		
		
		

	}

}
