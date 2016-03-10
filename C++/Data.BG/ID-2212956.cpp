// http://forums.data.bg/index.php?showtopic=2212956

/* Напишете програма, която въвежда цяло число N и определя колко четни и колко нечетни цифри участват в записа му.  */

#include <iostream>

int main()
{
	int number,
		currentDigit,
		numberOfEvenDigits = 0,
		numberOfOddDigits = 0;

	std::cout << "Enter N: "; std::cin >> number;

	while (number != 0) {
		currentDigit = number % 10;
		if (currentDigit % 2 == 0) 
		{
			numberOfEvenDigits++;
		}
		else 
		{
			numberOfOddDigits++;
		}
		number /= 10;
	}

	std::cout << "Number of even digits: " << numberOfEvenDigits << std::endl;
	std::cout << "Number of odd digits: " << numberOfOddDigits << std::endl;

	return 0;
}	
