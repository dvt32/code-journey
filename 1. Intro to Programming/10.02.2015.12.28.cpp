/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

9. Да се намери сумата от най-малките нечетни цифри в три зададени цели числа.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>



int minDigit(int num, int digitMin){

	if (num == 0) return digitMin;

	int c = num % 10; 
	if (c < digitMin && c%2==1) digitMin = c;

	if (num > 0) { return minDigit(num / 10, digitMin); }
	
	
}



void main() {
	system("chcp 1251");
	
	int num1, num2, num3;
	int c_min = 9;


	cout << "Enter number 1: "; cin >> num1;
	cout << "Enter number 2: "; cin >> num2;
	cout << "Enter number 3: "; cin >> num3; cout << endl;

	int digitMin1 = minDigit(num1, c_min);
	int digitMin2 = minDigit(num2, c_min);
	int digitMin3 = minDigit(num3, c_min);

	cout << "Сумата от най-малките нечетни цифри в 3-те числа е равна на " << digitMin1+digitMin2+digitMin3 << endl;

	

	
	_getch();
}

