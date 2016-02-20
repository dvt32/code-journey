/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 2) Да се намери номерът на първия елемент от масива a[n] равен на
дадена стойност b. */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	const int n = 5;
	int i;
	int a[n];
	int b = 5;
	int indFirstElement = 0;


	cout << endl << "b=5" << endl;

	for (i = 0; i < n; i++)
	{
		cout << "a" << "[" << i << "]: "; cin >> a[i];
	}

	for (i = 0; i < n; i++)
	{
		if (a[i] == b)
		{ 
			indFirstElement = i; break;
		}

	}

	cout << "The first element to match the value of 'b' is " << indFirstElement;


	_getch();
}