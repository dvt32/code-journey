/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

7. Да се намери най-голямата цифра във всяко от три зададени цели числа.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int largestDigit(int number){
	
	int M = number;							// числото
	int c;									// цифрa на числото
	int c_max = 0;							// най-голямата цифра в числото
	
	while (M > 0)
	{
		c = M % 10;
		if (c > c_max) { c_max = c; }
		M /= 10;
	}

	return c_max;
}

// Главна функция
void main(){
	system("chcp 1251");

	int a, b, c;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b;
	cout << "Enter c: "; cin >> c;

	cout << endl;
	cout << "Най-голямата цифра на числото " << a << " е " << largestDigit(a) << endl;
	cout << "Най-голямата цифра на числото " << b << " е " << largestDigit(b) << endl;
	cout << "Най-голямата цифра на числото " << c << " е " << largestDigit(c) << endl;


	_getch();
}