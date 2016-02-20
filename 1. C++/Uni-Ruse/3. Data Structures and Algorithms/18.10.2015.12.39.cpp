/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/*

Задача 6. Даден е списък от символни низове. Да се напише програма, която
извежда първата буква на всеки елемент от списъка.

*/

#include "stdafx.h"
#include <iostream>
#include <list>
#include <string>

int main() {
	std::list<std::string> list, newList;
	std::list<std::string>::iterator i;
	std::string value;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list elements
	do {
		std::cout << "Enter string value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list.push_back(value);
	} while(1); std::cout << std::endl;

	// Iterate through list and display each string's first letter
	std::cout << "First letter of each string: ";
	for (i = list.begin(); i != list.end(); ++i){
		std::cout << i->at(0) << " ";
	}

	return 0;
}