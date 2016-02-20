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

double sumSqrtEvenDigits(int number){
	
	int M = number;							// числото
	int c;									// цифрa на числото
	double sumSqrt = 0;					// сума от квадратните корени на четните цифри на числото
	
	while (M > 0)
	{
		c = M % 10;
		if (c % 2 == 0) { sumSqrt += sqrt(c); }
		M /= 10;
	}

	return sumSqrt;
}

// Главна функция
void main(){
	system("chcp 1251");

	int a, b, c;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b;
	cout << "Enter c: "; cin >> c;

	cout << endl;
	cout << "Сумата от квадратните корени на четните цифри на " << a << " е " << sumSqrtEvenDigits(a) << endl;
	cout << "Сумата от квадратните корени на четните цифри на " << b << " е " << sumSqrtEvenDigits(b) << endl;
	cout << "Сумата от квадратните корени на четните цифри на " << c << " е " << sumSqrtEvenDigits(c) << endl;


	_getch();
}