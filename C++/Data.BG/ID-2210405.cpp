// http://forums.data.bg/index.php?showtopic=2210405

/*

Да се състави програма , която да съдържа следните функции:
· Съставяне на динамично представен списък с целочислени данни, съдържащи се във външен файл;
· Сортиране на елементите в структурата по метода чрез прост избор / селекция;
· Търсене на най-малкият елемент, кратен на 5 и по-голям от минималното кратно число на 7;
· Запис на изходните резултати във външен файл.

Главна функция main() - с меню за избор на функции и проверка за състоянието на данните.

*/

#include <iostream>
#include <list>
#include <fstream>
#include <string>

void makeListFromFile(std::list<int> &myList, std::string pathToFile)
{
	int line;
	std::ifstream myFile(pathToFile);
	if (myFile.is_open())
	{
		while (myFile >> line)
		{
			myList.push_back(line);
		}
		myFile.close();
	}
	else
	{
		std::cout << "Couldn't open file!" << std::endl;
	}
}

void sortList(std::list<int> &myList)
{
	if (!myList.empty())
	{
		for (std::list<int>::iterator it = myList.begin(); it != (--myList.end()); ++it)
		{
			int *minElement = &(*it);
			int temp;
			std::list<int>::iterator it2 = it;
			for (++it2; it2 != myList.end(); ++it2)
			{
				if (*minElement > *it2) {
					minElement = &(*it2);
				}
			}
			if (minElement != &(*it))
			{
				temp = *it;
				*it = *minElement;
				*minElement = temp;
			}
		}
	}
	else
	{
		std::cout << "List is empty!" << std::endl;
	}
}

int findMinElement(std::list<int> myList)
{
	int min_element_divisible_by_7 = std::numeric_limits<int>::max(),
		min_element = std::numeric_limits<int>::max();

	if (!myList.empty())
	{
		/* Get smallest element divisible by 7 */
		for (std::list<int>::iterator it = myList.begin(); it != myList.end(); ++it)
		{
			if (*it % 7 == 0 && *it < min_element_divisible_by_7)
			{
				min_element_divisible_by_7 = *it;
			}
		}

		/* Get smallest element divisible by 5 that is simultaneously LARGER than min_element_divisible_by_7 */
		for (std::list<int>::iterator it = myList.begin(); it != myList.end(); ++it)
		{
			if (*it % 5 == 0 && *it < min_element && *it > min_element_divisible_by_7)
			{
				min_element = *it;
			}
		}
	}

	return min_element;
}

void saveListToFile(std::list<int> myList, std::string filePath)
{
	std::ofstream myFile(filePath);
	if (myFile.is_open())
	{
		if (!myList.empty())
		{
			for (std::list<int>::iterator it = myList.begin(); it != myList.end(); ++it)
			{
				myFile << *it << std::endl;
			}
		}
		else
		{
			std::cout << "List is empty!" << std::endl;
		}
		myFile.close();
	}
	else
	{
		std::cout << "Couldn't open file!" << std::endl;
	}
}

void printList(std::list<int> myList) 
{
	if (!myList.empty())
	{
		for (std::list<int>::iterator it = myList.begin(); it != myList.end(); ++it) {
			std::cout << *it << std::endl;
		}
	}
	else
	{
		std::cout << "List is empty!" << std::endl;
	}
}

int main() {
	std::list<int> myList;
	int operationNumber;

	do 
	{
		std::cout << "\nMENU: " << std::endl;
		std::cout << "- [1] Make integer list from file" << std::endl;
		std::cout << "- [2] Sort list (via Selection Sort)" << std::endl;
		std::cout << "- [3] Find smallest element" << std::endl;
		std::cout << "- [4] Save list to file" << std::endl;
		std::cout << "- [5] Print list" << std::endl << std::endl;
		
		std::cout << "Enter operation number: "; std::cin >> operationNumber;

		switch (operationNumber)
		{
			case 0:
				break;
			case 1:
				makeListFromFile(myList, "input.txt");
				break;
			case 2:
				sortList(myList);
				break;
			case 3:
				std::cout << findMinElement(myList) << std::endl;
				break;
			case 4:
				saveListToFile(myList, "output.txt");
				break;
			case 5:
				printList(myList);
				break;
			default:
				break;
		}
	} 
	while (operationNumber != 0);

	return 0;
}