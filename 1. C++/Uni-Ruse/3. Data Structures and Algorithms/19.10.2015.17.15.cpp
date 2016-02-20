/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 2. Дадени са два списъка, чиито елементи са цели числа. Да се напише
програма, която извежда стойността на елементите, които се съдържат и в двата
списъка.

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
	List<int> list1, list2;
	elem<int> *element1, *element2;
	std::string value;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list 1 elements
	do {
		std::cout << "Enter integer value for list 1: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list1.AddAfter(std::stoi(value), std::stoi(value));
	} while(1); std::cout << std::endl;

	// Enter list 2 elements
	do {
		std::cout << "Enter integer value for list 2: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list2.AddAfter(std::stoi(value), std::stoi(value));
	} while (1); std::cout << std::endl;

	// Compare the two lists and print the values that are present in both lists
	std::cout << "Elements that are in both lists: ";
	element1 = list1.first;
	
	while (element1 != NULL){
		element2 = list2.first;
		while (element2 != NULL){
			if (element2->inf == element1->inf){
				std::cout << element2->inf << " ";
			}
			element2 = element2->link;
		}
		element1 = element1->link;
	} std::cout << std::endl;

	return 0;
}