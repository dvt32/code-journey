/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 2) Да се намери номерът на първия елемент от масива a[n] равен на дадена стойност b. */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int b;
	int a[1337];
	int n;

	cout << "Enter b: "; cin >> b;
	cout << "Enter n: "; cin >> n;

	for (int i = 0; i < n; i++){
		cout << "Element " << i << " of 'a': "; cin >> a[i];
		if (a[i] == b) { 
			cout << "Елемент номер " << i << " е първият равен на 'b'"; break; 
		}
	}
	

	_getch();
}