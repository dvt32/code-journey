/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
Задача 2. 

Даден е двумерен масив А с m реда и n стълба. 

Да се изведе
- стойността на максималния елемент на масива и 
- номера на минималния елемент. 

*/

#include "stdafx.h"
#include <iostream>
#include <string>

int main()
{
	int A[30][30], m, n, i, j, maxElement, minElement;
	std::string indexOfMinElement;

	// Set number of elements
	std::cout << "Enter number of rows: "; std::cin >> m;
	std::cout << "Enter number of columns: "; std::cin >> n; std::cout << std::endl;

	// Enter values for each element in the array
	for (i = 0; i < m; ++i){
		for (j = 0; j < n; ++j){
			std::cout << "A[" << i << "][" << j << "]: "; std::cin >> A[i][j];
		}
	}

	// Find max element and index of min element
	maxElement = A[0][0], minElement = A[0][0], indexOfMinElement = "A[0][0]";
	for (i = 0; i < m; ++i){
		for (j = 0; j < n; ++j){
			// Find max element
			if (A[i][j] > maxElement) { maxElement = A[i][j]; }
			// Find min element and its index number
			if (A[i][j] < minElement) { 
				minElement = A[i][j];
				indexOfMinElement = "A[" + std::to_string(i) + "][" + std::to_string(j) + "]";
			}
		}
	}

	// Display the result
	std::cout << std::endl << "Max element: " << maxElement << std::endl;
	std::cout << "Min element: " << minElement << " (element: " << indexOfMinElement << ")" << std::endl << std::endl;

	return 0;
}
