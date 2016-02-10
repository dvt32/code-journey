/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

3. Да се намери при кое от две зададени цели числа сумата от квадратите на нечетните цифри е по-голяма.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int sum_1 = 0, sum_2 = 0;

int largerPowOddDigitSum(int number1, int number2){

	int c_1 = number1 % 10;
	int c_2 = number2 % 10;
	if (c_1 % 2) { ::sum_1 += pow(c_1, 2); }
	if (c_2 % 2) { ::sum_2 += pow(c_2, 2); }

	if (number1 > 0 || number2 > 0) { largerPowOddDigitSum(number1 / 10, number2 / 10); }

	if (::sum_1 > ::sum_2) return number1;
	if (::sum_2 > ::sum_1) return number2;
	if (::sum_1 == ::sum_2) return 0;

}

void main() {
	system("chcp 1251");
	
	int a, b;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b; cout << endl;

	if (largerPowOddDigitSum(a, b) != 0)
	{
		cout << "Числото " << largerPowOddDigitSum(a, b) << " има по-голяма сума на квадратите на нечетните му цифри." << endl;
	}
	else cout << "Числата имат еднаква сума на квадратите на нечетните им цифри." << endl;

	
	_getch();
}

