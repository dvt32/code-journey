/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/* 

Задача 1. Даден е списък от цели числа. Да се напише програма, която
пресмята средно-аритметичното на положителните елементи от списъка.

*/


#include "stdafx.h"
#include <iostream>
#include <list>

int main() {
	std::list<int> myList;
	char valueControl = '0';
	int elementOfList, numberOfPositiveElements = 0, sumOfPositiveElements = 0;

	// Enter data into the list
	while (valueControl != 'n'){
		std::cout << "Integer element value to add to list: "; std::cin >> elementOfList;
		myList.push_back(elementOfList);
		if (myList.back() > 0) { 
			sumOfPositiveElements += myList.back();
			numberOfPositiveElements++; 
		}
		std::cout << "Add another element? Enter 'n' to stop: "; std::cin >> valueControl;
	}

	// Display end result
	if (numberOfPositiveElements != 0) {
		std::cout << std::endl << "Average of positive elements in list: " << (double)sumOfPositiveElements / numberOfPositiveElements << std::endl;
	}
	else { std::cout << std::endl << "No positive elements in list." << std::endl; }








	return 0;
}