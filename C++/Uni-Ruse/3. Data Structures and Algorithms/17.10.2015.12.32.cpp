/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/* 

Задача 3. 

Даден е списък, чиито елементи са цели числа. 

Да се напише програма, която:
- извежда сумата на минималния и максималния елемент на списъка.

*/


#include "stdafx.h"
#include <iostream>
#include <list>
#include <string>

int main() {
	std::list<int> list;
	std::list<int>::iterator i;
	std::string value;
	int maxElement, minElement;

	std::cout << "* Enter 'stop' to stop entering numbers." << std::endl << std::endl;

	// Enter list elements
	do {
		std::cout << "Enter integer value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list.push_back(std::stoi(value));
	} while(1); std::cout << std::endl;
	
	// Find the max element and the min element
	maxElement = list.front(), minElement = list.front();
	for (i = list.begin(); i != list.end(); ++i){
		if (*i > maxElement) { maxElement = *i; }
		if (*i < minElement) { minElement = *i; }
 	}

	// Display end result
	std::cout << "Max element: " << maxElement << std::endl;
	std::cout << "Min element: " << minElement << std::endl << std::endl;

	return 0;
}