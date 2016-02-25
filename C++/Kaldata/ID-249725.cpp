// https://www.kaldata.com/forums/topic/249725-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89-%D0%B7%D0%B0-%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B0/

/*

Задача: Сега приложите наученото до момента и напишете програма, която изисква от потребителя 
да въведе в конзолата 10 числа в едномерен масив и накрая да изведе, колко на брой са отрицателните числа в масива.

*/

#include <iostream>

int main() {
	double arr[10];
	int numberOfNegativeValues = 0;

	// Enter values & get number of negative values
	for (int i = 0; i < 10; ++i) {
		std::cout << "arr[" << i << "]: "; std::cin >> arr[i];
		if (arr[i] < 0) {
			numberOfNegativeValues++;
		}
	}

	// Print end result
	std::cout << "Number of negative values: " << numberOfNegativeValues << std::endl;

	return 0;
}
