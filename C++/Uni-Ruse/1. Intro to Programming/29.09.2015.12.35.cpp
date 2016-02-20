/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 

Задача 3. 

Даден е двумерен масив А с m реда и n стълба. 

Да се напише програма, която:
- намира сумата на елементите в отделните редове на масива.

*/

#include "stdafx.h"
#include <iostream>

int main()
{
	int A[30][30], m, n, i, j, sumOfRow[30];

	// Set number of elements
	std::cout << "Enter number of rows: "; std::cin >> m;
	std::cout << "Enter number of columns: "; std::cin >> n; std::cout << std::endl;

	// Enter values for each element in the array and calculate the sum on each row
	for (i = 0; i < m; ++i){
		sumOfRow[i] = 0;
		for (j = 0; j < n; ++j){
			std::cout << "A[" << i << "][" << j << "]: "; std::cin >> A[i][j];
			sumOfRow[i] += A[i][j];
		}
	} std::cout << std::endl;

	// Display the result
	for (i = 0; i < m; ++i){
		std::cout << "sumOfRow[" << i << "]: " << sumOfRow[i] << std::endl;
	}

	return 0;
}
