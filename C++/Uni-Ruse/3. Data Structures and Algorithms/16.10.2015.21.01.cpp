/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/* 

Задача 2. Дадени са два списъка, чиито елементи са цели числа. Да се напише
програма, която извежда стойността на елементите, които се съдържат и в двата
списъка.

*/


#include "stdafx.h"
#include <iostream>
#include <list>
#include <string>

int main() {
	std::list<int> list1, list2;
	std::list<int>::iterator i, j;
	std::string value;

	std::cout << "* Enter 'stop' to stop entering numbers." << std::endl << std::endl;

	// Enter list 1 elements
	do {
		std::cout << "Enter integer value for list 1: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list1.push_back(std::stoi(value));
	} while(1); std::cout << std::endl;
	
	// Enter list 2 elements
	do {
		std::cout << "Enter integer value for list 2: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list2.push_back(std::stoi(value));
	} while(1); std::cout << std::endl;

	// Compare elements and print the ones that are present in both lists
	for (i = list1.begin(); i != list1.end(); ++i){
		for (j = list2.begin(); j != list2.end(); ++j) {
			if (*j == *i) { std::cout << *j << " "; }
		}
	} std::cout << std::endl;

	return 0;
}