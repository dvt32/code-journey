/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

6. Да се намери произведението на ненулевите цифри на три зададени чис-ла.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int multiNenuleviCifri(int number){
	
	int M = number;							// числото
	int c;									// цифрa на числото
	int multi = 1;							// произведение на ненулевите цифри на числото
	
	while (M > 0)
	{
		c = M % 10;
		if (c != 0) { multi *= c; }
		M /= 10;
	}

	return multi;
}

// Главна функция
void main(){
	system("chcp 1251");

	int a, b, c;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b;
	cout << "Enter c: "; cin >> c;

	cout << "\nПроизведението на ненулевите цифри на числото " << a << " е " << multiNenuleviCifri(a) << endl;
	cout << "Произведението на ненулевите цифри на числото " << b << " е " << multiNenuleviCifri(b) << endl;
	cout << "Произведението на ненулевите цифри на числото " << c << " е " << multiNenuleviCifri(c) << endl;


	_getch();
}