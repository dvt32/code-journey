// http://forums.bgdev.org/index.php?showtopic=47444

/*

1. Напишете програма, която изчислява щастливо частно на два вектора - A и B.

Щастливо частно е: A[0]/B[0] - A[1]/B[1] - A[2]/B[2] - ... - A[n]/B[n].

Програмата трябва да чете от стандартния вход:
- едно число N - броя на елементите на векторите и
- N на на брой числа - тези на първия вектор, след което още
- N числа - тези на втория.

Реализирайте програмата с функция, която приема 2 вектора и връща double.

Пр.Вход:
3
8 25 9
4 5 -2

Изход:
1.5

*/

#include <iostream>
#include <vector>

double happyQuotient(std::vector<int> A, std::vector<int> B) {
	if (!A.empty() && !B.empty()) {
		double result = (double)A[0] / B[0];
		for (int i = 1; i < A.size(); ++i) {
			result -= (double)A[i] / B[i];
		}
		return result;
	}
}

int main()
{
	std::vector<int> A, B;
	int N, element;

	std::cout << "Enter N: "; std::cin >> N;

	// Enter elements for vector 'A'
	for (int i = 0; i < N; ++i) {
		std::cout << "Enter element for vector 'A': "; std::cin >> element;
		A.push_back(element);
	}

	// Enter elements for vector 'B'
	for (int i = 0; i < N; ++i) {
		std::cout << "Enter element for vector 'B': "; std::cin >> element;
		B.push_back(element);
	}

	// Get happy quotient and print end result
	std::cout << "Happy quotient: " << happyQuotient(A, B) << std::endl;

	return 0;
}
