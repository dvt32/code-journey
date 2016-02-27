// dvt32

/*

9.3. Напишете метод, който:
- връща английското наименование на последната цифра от дадено число. 

Примери: 
- за числото 512 отпечатва "two"; 
- за числото 1024 – "four".

*/

import java.util.Scanner;

public class mainClass {
	
	public static String getEnglishNameOfLastDigit(int number) {
		int lastDigit = number % 10;
		String englishName = null;
		
		switch (lastDigit) {
		case 0:
			englishName = "zero"; 
			break;
		case 1:
			englishName = "one";
			break;
		case 2:
			englishName = "two";
			break;
		case 3:
			englishName = "three";
			break;
		case 4:
			englishName = "four";
			break;
		case 5:
			englishName = "five";
			break;
		case 6:
			englishName = "six";
			break;
		case 7:
			englishName = "seven";
			break;
		case 8:
			englishName = "eight";
			break;
		case 9:
			englishName = "nine";
			break;
		default:
			break;
		}
		
		return englishName;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("Enter an integer: "); int number = read.nextInt();
		
		String englishNameOfLastDigit = getEnglishNameOfLastDigit(number);
		
		System.out.println("\n" + "Last digit: " + englishNameOfLastDigit);
	}
}