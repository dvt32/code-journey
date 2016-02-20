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

int sumSqrtNechetniCifriLarger(int number1, int number2){
	
	int M = number1, N = number2;		// число 1 и 2
	int c_1, c_2;						// цифрa на число 1 и 2
	int sum_1 = 0, sum_2 = 0;
	
	while (M > 0)
	{
		c_1 = M % 10;
		if (c_1 % 2 == 1){ sum_1 += pow(c_1, 2); }
		M /= 10;
	}
	while (N > 0)
	{
		c_2 = N % 10;
		if (c_2 % 2 == 1){ sum_2 += pow(c_2, 2); }
		N /= 10;
	}
	if (sum_1 > sum_2) { return number1; }
	if (sum_1 < sum_2) { return number2; }
	if (sum_1 == sum_2) { return 0; }
}

// Главна функция
void main(){
	system("chcp 1251");

	int a, b;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b;

	int result = sumSqrtNechetniCifriLarger(a, b);

	if (result != 0)
		cout << endl << "Числото " << result << " има по-голяма сума на квадратите на нечетните му цифри." << endl;
	else
		cout << endl << "Числата имат еднаква сума на квадратите на нечетните им цифри." << endl;


	_getch();
}