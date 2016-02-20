/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*
1-б. Да се състави програма с 
рекурсивни функции за 
извеждане на цифрите на зададено цяло число в 
обратен ред.
*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


void getDigitsReverse(int number)
{
	int digit;
	digit = number % 10;

	if (number > 0)
	{
		cout << digit << " ";
		getDigitsReverse(number / 10);
	}
}




void main() {
	system("chcp 1251");
	
	int n;

	cout << "Enter n: "; cin >> n; cout << endl;

	// Извеждане на цифрите в обратен ред
	getDigitsReverse(n);

	
	_getch();
}