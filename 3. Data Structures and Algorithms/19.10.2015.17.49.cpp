/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 7. Даден е списък от символни низове. Да се напише програма, която
проверява даден символен низ дали се среща в списъка и колко пъти се среща.

*/

#include "stdafx.h"
#include <iostream>
#include <string>

// List implementation
template <class T>
struct elem
{
	T inf;
	elem <T> *link;
};
template <class T>
class List
{
public:
	List();
	~List();
	void AddAfter(T y, T x);
	void AddBefore(T y, T x);
	int Del_El(T x);
	void Print_list();
	elem <T> *first;
	void Del_list();
};
template <class T>
List<T>::List()
{
	first = NULL;
}
template <class T>
List<T>::~List()
{
	Del_list();
}
template <class T>
void List<T>::AddAfter(T y, T x)
{
	elem <T> *q = new elem <T>;
	elem <T> *p = first;
	while (p && p->inf != y)p = p->link;
	if (p)
	{
		q->inf = x;
		q->link = p->link;
		p->link = q;
	}
	else
	{
		q->inf = x;
		q->link = first;
		first = q;
	}
}
template <class T>
void List<T>::AddBefore(T y, T x)
{
	elem <T> *q = new elem <T>;
	elem <T> *p = first;
	while (p && p->inf != y)p = p->link;
	if (p)
	{
		*q = *p;
		p->inf = x;
		p->link = q;
	}
	else
	{
		q->inf = x;
		q->link = first;
		first = q;
	}
}
template <class T>
int List <T>::Del_El(T x)
{
	elem <T> *p = first;
	while (p && p->inf != x)p = p->link;
	if (!p)return 0;
	if (p->link)
	{
		elem <T> *q = p->link;
		p->inf = q->inf;
		p->link = q->link;
		delete q;
		return 1;
	}
	else return 0;
}
template <class T>
void List<T>::Print_list()
{
	elem <T> *p = first;
	while (p)
	{
		cout << p->inf << " ";
		p = p->link;
	}
	cout << endl;
}
template <class T>
void List<T>::Del_list()
{
	elem <T> *p = first, *q;
	while (p)
	{
		q = p; p = p->link;
		delete q;
	}
}
// End list implementation

int main() {
	List<std::string> list;
	elem<std::string> *element;
	std::string value, valueBefore, searchValue;
	int numberOfInstances = 0;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list elements
	do {
		std::cout << "Enter string value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list.AddAfter(valueBefore, value);
		valueBefore = value;
	} while (1); std::cout << std::endl;

	// Enter string to search for in the list
	std::cout << "Enter string to search for: "; std::getline(std::cin, searchValue);

	// Get number of instances of 'searchValue' in the list
	element = list.first;
	while (element != NULL) {
		if (element->inf == searchValue) { numberOfInstances++; }
		element = element->link;
	} std::cout << std::endl;

	// Display end result
	std::cout << "Number of instances of string '" << searchValue << "': " << numberOfInstances << std::endl << std::endl;

	return 0;
}