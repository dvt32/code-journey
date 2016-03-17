// http://forums.data.bg/index.php?showtopic=2213379

/*
Дадена е двумерна числова матрица А, с размерност NxN. 
Напишете програма, която проверява дали матрицата е „магически квадрат”, 
т.е. сумата по всички редове и по всички стълбове е една и съща. 
*/

#include <iostream>

int main() {
	const int N = 3;
	const int magicSum = (N * (N*N + 1)) / 2;
	int A[N][N];
	int sumOfElements = 0;
	bool isMagicSquare;

	// Enter values
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			std::cout << "Enter A["<<i<<"]["<<j<<"]: "; std::cin >> A[i][j];
			// Calculate sum of current row
			sumOfElements += A[i][j];	
		}
		// Check if sum on this row is equal to magicSum
		if (sumOfElements == magicSum) 
		{
			isMagicSquare = true;
		}	
		else 
		{
			isMagicSquare = false;
		}
		// Reset sum counter, in order to calculate the next row's sum
		sumOfElements = 0;
	}

	// Print end result
	std::cout << std::endl << "Is the matrix a magic square? (0 - false, 1 - true): " << isMagicSquare << std::endl;

	return 0;
}
