/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 

Задача 4. 

В РУ има к факултета и n компютърни зали. За всяка зала е известен броя на компютрите и на кой факултет принадлежи. 

Да се изведе броя на компютрите за всеки факултет.

*/

#include "stdafx.h"
#include <iostream>

struct PCRoom { int numberOfPCs, facultyNumber; };

int main()
{
	int k, n, numberOfPCsInFaculty[30];
	PCRoom rooms[30];

	std::cout << "Enter number of rooms: "; std::cin >> n;
	std::cout << "Enter number of faculties: "; std::cin >> k; std::cout << std::endl;

	// Enter data
	for (int i = 0; i < n; ++i) 
	{
		std::cout << "Enter number of PCs in room " << i << ": "; std::cin >> rooms[i].numberOfPCs;
		std::cout << "Enter faculty number for room " << i << ": "; std::cin >> rooms[i].facultyNumber; std::cout << std::endl;	
	}

	// Get number of PCs in each faculty
	for (int i = 0; i < k; ++i)
	{
		numberOfPCsInFaculty[i] = 0;
		for (int j = 0; j < n; ++j)
		{
			if (rooms[j].facultyNumber == i) { numberOfPCsInFaculty[i] += rooms[j].numberOfPCs; }
		}
		std::cout << "Number of PCs in faculty " << i << ": " << numberOfPCsInFaculty[i] << std::endl;
	} std::cout << std::endl;
	

	return 0;
}
