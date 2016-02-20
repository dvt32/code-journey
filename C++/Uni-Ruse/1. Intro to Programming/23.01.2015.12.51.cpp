/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

1. Да се намери при кое от две зададени цели числа сумата от цифрите е по-голяма.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

// Функция за определяне на число с по-голяма сума от цифрите
int sumCifriLarger(int number1, int number2){
	
	int M = number1, N = number2;			// число 1 и 2
	int sumCifri_1 = 0, sumCifri_2 = 0;		// сума на цифрите на число 1 и 2
	int c_1, c_2;							// цифрa на число 1 и 2
	while (M > 0)
	{
		c_1 = M % 10;
		sumCifri_1 += c_1;
		M /= 10;
	}
	while (N > 0)
	{
		c_2 = N % 10;
		sumCifri_2 += c_2;
		N /= 10;
	}
	if (sumCifri_1 > sumCifri_2) { return number1; }
	if (sumCifri_1 < sumCifri_2) { return number2; }
	if (sumCifri_1 == sumCifri_2) { return 0; }
}

// Главна функция
void main(){
	system("chcp 1251");

	int a, b;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b;

	int largerDigitSum = sumCifriLarger(a, b);

	if (largerDigitSum != 0)
		cout << endl << "Числото " << largerDigitSum << " има по-голяма сума на цифрите." << endl;
	else
		cout << endl << "Числата имат еднаква сума на цифрите." << endl;


	_getch();
}