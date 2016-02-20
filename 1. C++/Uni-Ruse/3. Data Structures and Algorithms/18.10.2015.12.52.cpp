/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/*

Задача 7. Даден е списък от символни низове. Да се напише програма, която
проверява даден символен низ дали се среща в списъка и колко пъти се среща.

*/

#include "stdafx.h"
#include <iostream>
#include <list>
#include <string>

int main() {
	std::list<std::string> list, newList;
	std::list<std::string>::iterator i;
	std::string value, searchValue;
	int numberOfInstances = 0;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list elements
	do {
		std::cout << "Enter string value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list.push_back(value);
	} while(1); std::cout << std::endl;

	// Enter string to search for inside the list
	std::cout << "Enter string to search for in list: "; std::getline(std::cin, searchValue); std::cout << std::endl;

	// Iterate through list and find number of instances of std::string 'searchValue'
	for (i = list.begin(); i != list.end(); ++i){
		if (*i == searchValue) { numberOfInstances++; }
	}

	std::cout << "Number of instances of string '" + searchValue + "': " << numberOfInstances << std::endl;

	return 0;
}