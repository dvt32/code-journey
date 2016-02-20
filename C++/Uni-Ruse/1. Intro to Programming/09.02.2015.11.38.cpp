/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

2. Да се намери при кое от две зададени цели числа сумата на четните цифри е по-голяма.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int sum_1 = 0, sum_2 = 0;

int largerPositiveDigitSum(int number1, int number2){

	int c_1 = number1 % 10;
	int c_2 = number2 % 10;
	if (!(c_1 % 2)) { ::sum_1 += c_1; }
	if (!(c_2 % 2)) { ::sum_2 += c_2; }

	if (number1 > 0 || number2 > 0) { largerPositiveDigitSum(number1 / 10, number2 / 10); }

	int number3 = -1;
	if (::sum_1 > ::sum_2) return number1;
	if (::sum_2 > ::sum_1) return number2;
	if (::sum_1 == ::sum_2) return number3;

}

void main() {
	system("chcp 1251");
	
	int a, b;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b; cout << endl;

	if (largerPositiveDigitSum(a, b) != -1)
	{
		cout << "Числото " << largerPositiveDigitSum(a, b) << " има по-голяма сума на четните цифри." << endl;
	}
	else cout << "Числата имат еднаква сума на четните цифри." << endl;

	
	_getch();
}

