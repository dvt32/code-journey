/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

2) Да се намери номера на първия елемент от масива a[n] равен на дадена стойност b.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int b, n, i;
	cout << "b = "; cin >> b;
	cout << "n = "; cin >> n;

	int *a = new int[n];

	cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: "; cin >> a[i];
	}

	cout << endl;

	for (i = 0; i < n; i++){
		if (a[i] == b) { cout << "Елемент " << i << " е първият, който е равен на 'b'." << endl; return; }
	}

	delete[]a;


	_getch();

	
}