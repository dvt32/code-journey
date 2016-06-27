/*
 * Задача D.
 * 
Да разгледаме естественото число n, представено в двоичен запис. 
С B(n) да означим сумата от цифрите му. 
Например, за n = 19(10) = 10011(2) имаме B(19)=3. 

Напишете програма, която по зададено n пресмята сумата S = B(1) + B(2) + … + B(n).

Вход

Програмата обработва няколко тестови примера. 
За всеки от тях, от един ред на стандартния вход се въвежда естествено число n. 

Изход

За всеки тестов пример на един ред от стандартния изход да се изведе намерената сума S.

Ограничения
1 ≤ n ≤ 1000000

Пример
Вход								Изход
1								1612
387

 */

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int numberOfTestcases = read.nextInt();
		for (int i = 0; i < numberOfTestcases; ++i) {
			int number = read.nextInt();
			int sumOfBinaryDigits = 0;
			for (int j = 1; j <= number; ++j) {
				String numberToBinary = Integer.toString(j, 2);
				for (int k = 0; k < numberToBinary.length(); ++k) {
					int currentDigit = Character.getNumericValue(numberToBinary.charAt(k));
					sumOfBinaryDigits += currentDigit;
				}
				
			}
			System.out.println(sumOfBinaryDigits);
		}
		
		// Close scanner
		read.close();
	}
}
