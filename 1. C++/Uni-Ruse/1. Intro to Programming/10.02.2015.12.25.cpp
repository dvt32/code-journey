/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

8. Да се намери произведението от най-големите четни цифри в три зададени цели числа.

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
	if (c > digitMax && c%2==0) digitMax = c;

	if (num > 0) { return maxDigit(num / 10, digitMax); }
	
	
}



void main() {
	system("chcp 1251");
	
	int num1, num2, num3;
	int c_max = 0;


	cout << "Enter number 1: "; cin >> num1;
	cout << "Enter number 2: "; cin >> num2;
	cout << "Enter number 3: "; cin >> num3; cout << endl;

	int digitMax1 = maxDigit(num1, c_max);
	int digitMax2 = maxDigit(num2, c_max);
	int digitMax3 = maxDigit(num3, c_max);

	cout << "Произведението на най-големите четни цифри от 3-те числа е равно на " << digitMax1*digitMax2*digitMax3 << endl;

	

	
	_getch();
}

