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
 
#include <iostream>
#include <string>
#include <algorithm>

std::string getBinaryRepresentationOf(int number) {
	std::string result = "";
	while (number != 0) {
		int currentBinaryDigit = number % 2;
		number /= 2;
		result += std::to_string(currentBinaryDigit);
	}
	std::reverse(result.begin(), result.end());
	return result;
}

int main() {
	int numberOfTestcases;

	std::cin >> numberOfTestcases;

	for (int i = 0; i < numberOfTestcases; ++i) {
		int number;
		int sumOfBinaryDigits = 0;
		std::cin >> number;
		for (int j = 1; j <= number; ++j) {
			std::string numberToBinary = getBinaryRepresentationOf(j);
			for (int k = 0; k < numberToBinary.length(); ++k) {
				int currentDigit = numberToBinary[k] - '0';
				sumOfBinaryDigits += currentDigit;
			}
		}
		std::cout << sumOfBinaryDigits << std::endl;
	}

	return 0;
}
