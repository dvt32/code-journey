/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

6. Да се намери произведението на ненулевите цифри на три зададени числа.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>



int multiAboveZeroDigits(int num, int c, int multi){

	if (num == 0) return multi;

	c = num % 10; 
	if (c != 0) multi *= c;

	if (num > 0) { return multiAboveZeroDigits(num / 10, c, multi); }
	
	
}



void main() {
	system("chcp 1251");
	
	int num1, num2, num3;
	int c = 0, multi = 1;
	// c - цифра на число 1,2,3
	// multi - произведение на ненулевите цифри на число 1,2,3


	cout << "Enter number 1: "; cin >> num1;
	cout << "Enter number 2: "; cin >> num2;
	cout << "Enter number 3: "; cin >> num3; cout << endl;

	int multi1 = multiAboveZeroDigits(num1, c, multi);
	int multi2 = multiAboveZeroDigits(num2, c, multi);
	int multi3 = multiAboveZeroDigits(num3, c, multi);

	cout << "multi(1): " << multi1 << endl;
	cout << "multi(2): " << multi2 << endl;
	cout << "multi(3): " << multi3 << endl;

	

	
	_getch();
}

