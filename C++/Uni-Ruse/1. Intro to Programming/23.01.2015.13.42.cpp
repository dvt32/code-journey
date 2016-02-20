/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

8. Да се намери произведението от най-големите четни цифри в три зададе-ни цели числа.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int largestEvenDigit(int number){
	
	int M = number;							// числото
	int c;									// цифрa на числото
	int c_max = 0;							// най-голямата четна цифра в числото
	
	while (M > 0)
	{
		c = M % 10;
		if (c % 2 == 0 && c > c_max) { c_max = c; }
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

	int multi = largestEvenDigit(a) * largestEvenDigit(b) * largestEvenDigit(c);

	cout << endl;
	cout << "Най-голямата четна цифра на числото " << a << " е " << largestEvenDigit(a) << endl;
	cout << "Най-голямата четна цифра на числото " << b << " е " << largestEvenDigit(b) << endl;
	cout << "Най-голямата четна цифра на числото " << c << " е " << largestEvenDigit(c) << endl;

	cout << endl;
	cout << "Произведението на най-големите четни цифри на трите числа е " << multi << endl;


	_getch();
}