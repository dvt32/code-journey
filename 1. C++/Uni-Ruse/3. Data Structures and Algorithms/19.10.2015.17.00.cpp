/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 1. Даден е списък от цели числа. Да се напише програма, която
пресмята средно-аритметичното на положителните елементи от списъка.

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
	List<int> myList;
	elem<int> *myElement;
	int numberOfPositiveElements = 0, sumOfPositiveElements = 0;
	std::string value;

	std::cout << "* Enter 'stop' to stop entering elements." << std::endl << std::endl;

	// Enter list elements
	do {
		std::cout << "Enter integer value for list: "; std::getline(std::cin, value);
		if (value == "stop") break;
		myList.AddAfter(std::stoi(value), std::stoi(value));
	} while(1); std::cout << std::endl;

	// Get number and sum of positive elements in the list
	myElement = myList.first;
	while (myElement != NULL){
		if (myElement->inf > 0) { numberOfPositiveElements++; sumOfPositiveElements += myElement->inf; }
		myElement = myElement->link;
	}

	// Display end result
	if (numberOfPositiveElements > 0) 
	{ 
		std::cout << "Average of positive elements is " << (double)sumOfPositiveElements / numberOfPositiveElements << "." << std::endl << std::endl; 
	}
	else { std::cout << "No positive elements found." << std::endl; }

	return 0;
}