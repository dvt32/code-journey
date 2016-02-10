/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 3. Даден е списък, чиито елементи са цели числа. Да се напише
програма, която извежда сумата на минималния и максималния елемент на
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
	List<int> list;
	elem<int> *element;
	std::string value;
	int maxValue, minValue;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list 1 elements
	do {
		std::cout << "Enter integer value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		list.AddAfter(std::stoi(value), std::stoi(value));
	} while(1); std::cout << std::endl;

	// Get max and min element from list
	maxValue = list.first->inf, minValue = list.first->inf;
	element = list.first;
	while (element != NULL) {
		if (element->inf > maxValue) { maxValue = element->inf; }
		if (element->inf < minValue) { minValue = element->inf; }
		element = element->link;
	}

	// Display end result
	std::cout << "Max value: " << maxValue << std::endl;
	std::cout << "Min value: " << minValue << std::endl;

	return 0;
}