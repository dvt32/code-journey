/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// STL solution

/* 
	NOTE: 

	Решението може да се опрости значително ако добавим:
		std::cout << "Length of string: " << list.back().length() << std::endl;
	в първия do-while цикъл. Така дължината се извежда веднага след въвеждането на низа.
/* 

Задача 4. 

Даден е списък от символни низове. Да се напише програма, която
намира дължината на всеки елемент от списъка.

*/

#include "stdafx.h"
#include <iostream>
#include <list>
#include <string>

int main() {
	std::list<std::string> list;
	std::list<std::string>::iterator i;
	std::string value;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list elements
	do {
		std::cout << "Enter string value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list.push_back(value);
	} while(1); std::cout << std::endl;

	// Iterate through list and get each string's length
	std::cout << "Length of strings: ";
	for (i = list.begin(); i != list.end(); ++i){
		std::cout << i->length() << " ";
	}

	std::cout << std::endl;

	return 0;
}