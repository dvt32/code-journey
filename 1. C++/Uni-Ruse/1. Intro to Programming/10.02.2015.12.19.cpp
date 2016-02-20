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



int maxDigit(int num, int digitMax){

	if (num == 0) return digitMax;

	int c = num % 10; 
	if (c > digitMax) digitMax = c;

	if (num > 0) { return maxDigit(num / 10, digitMax); }
	
	
}



void main() {
	system("chcp 1251");
	
	int num1, num2, num3;
	int c_max = 0; // c_max = най-голямата цифра в число 1,2,3


	cout << "Enter number 1: "; cin >> num1;
	cout << "Enter number 2: "; cin >> num2;
	cout << "Enter number 3: "; cin >> num3; cout << endl;

	int digitMax1 = maxDigit(num1, c_max);
	int digitMax2 = maxDigit(num2, c_max);
	int digitMax3 = maxDigit(num3, c_max);

	cout << "maxdigit(1): " << digitMax1 << endl;
	cout << "maxdigit(2): " << digitMax2 << endl;
	cout << "maxdigit(3): " << digitMax3 << endl;

	

	
	_getch();
}

