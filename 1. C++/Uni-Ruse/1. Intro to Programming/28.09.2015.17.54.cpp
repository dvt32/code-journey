/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* Задача 1. 

Даден е едномерен масив М с n елемента. 
Да се изведе 
- броя на нулевите елементи и 
- средно аритметично на положителните елементи на масива. 

*/

#include "stdafx.h"
#include <iostream>

int main()
{

	int M[30], n, i, numberOfNullElements = 0, numberOfPositiveElements = 0, sumOfPositiveElements = 0;
	double averageOfPositiveElements = 0.0;

	std::cout << "Enter number of elements: "; std::cin >> n; std::cout << std::endl;

	for (i = 0; i < n; ++i){
		std::cout << "Enter M[" << i << "]: "; std::cin >> M[i];
		if (M[i] == 0) { numberOfNullElements++; }
		if (M[i] >0) { numberOfPositiveElements++; sumOfPositiveElements += M[i]; }
	}

	averageOfPositiveElements = (double) sumOfPositiveElements / numberOfPositiveElements;

	std::cout << std::endl << "Number of null elements: " << numberOfNullElements << std::endl;
	std::cout << "Average of positive numbers: " << averageOfPositiveElements << std::endl << std::endl;

}
