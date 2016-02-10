/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/*

Задача 5. 

Даден е списък от символни низове. Да се напише програма, която
създава нов списък, съдържащ тези елементи от списъка, които имат дължина
по-голяма от 5.

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

	// Iterate through list, get each string's length and add the ones with (length > 5) to the newList
	for (i = list.begin(); i != list.end(); ++i){
		if (i->length() > 5) {
			newList.push_back(*i);
		}
	}

	// Display new list
	std::cout << "Elements in new list: ";
	for (i = newList.begin(); i != newList.end(); ++i){
		std::cout << *i << " ";
	} std::cout << std::endl << std::endl;

	return 0;
}