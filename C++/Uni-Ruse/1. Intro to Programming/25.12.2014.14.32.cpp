/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 1) Да се намери броят на нулевите елементи в масива u с m елементи. */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	const int m = 5;
	int i;
	int u[m];
	int nullElements = 0;

	for (i = 0; i < m; i++)
	{
		cout << "u" << "[" << i << "]: "; cin >> u[i];
	}

	for (i = 0; i < m; i++)
	{
		if (u[i] == 0)
		{ 
			nullElements += 1;
		}

	}

	cout << "The number of null elements is " << nullElements;


	_getch();
}