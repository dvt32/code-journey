/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

10. Да се намери сумата от квадратните корени на четните цифрите на всяко от три зададени цели числа.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>



double sumSqrt(int num, double sum){

	if (num == 0) return sum;

	int c = num % 10; 
	if (c % 2 == 0) { sum += sqrt(c); }

	if (num > 0) { return sumSqrt(num / 10, sum); }
	
	
}



void main() {
	system("chcp 1251");
	
	int num1, num2, num3;
	double sum = 0; // сума от квадратните корени на четните цифри на число 1,2,3


	cout << "Enter number 1: "; cin >> num1;
	cout << "Enter number 2: "; cin >> num2;
	cout << "Enter number 3: "; cin >> num3; cout << endl;

	double sum1 = sumSqrt(num1, sum);
	double sum2 = sumSqrt(num2, sum);
	double sum3 = sumSqrt(num3, sum);

	cout << "sum (1) = " << sum1 << endl;
	cout << "sum (2) = " << sum2 << endl;
	cout << "sum (3) = " << sum3 << endl;

	sum = sum1 + sum2 + sum3;

	cout << endl << "sum (1+2+3) = " << sum << endl;

	

	
	_getch();
}

