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

// Функция за определяне на число с по-голяма сума на четните цифри
int sumChetniCifriLarger(int number1, int number2){
	
	int M = number1, N = number2;						// число 1 и 2
	int c_1, c_2;										// цифрa на число 1 и 2
	int sumChetniCifri_1 = 0, sumChetniCifri_2 = 0;		// сума на четните цифри на число 1 и 2
	
	while (M > 0)
	{
		c_1 = M % 10;
		if (c_1 % 2 == 0){ sumChetniCifri_1 += c_1; }
		M /= 10;
	}
	while (N > 0)
	{
		c_2 = N % 10;
		if (c_2 % 2 == 0){ sumChetniCifri_2 += c_2; }
		N /= 10;
	}
	if (sumChetniCifri_1 > sumChetniCifri_2) { return number1; }
	if (sumChetniCifri_1 < sumChetniCifri_2) { return number2; }
	if (sumChetniCifri_1 == sumChetniCifri_2) { return 0; }
}

// Главна функция
void main(){
	system("chcp 1251");

	int a, b;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b;

	int result = sumChetniCifriLarger(a, b);

	if (result != 0)
		cout << endl << "Числото " << result << " има по-голяма сума на на четните цифри." << endl;
	else
		cout << endl << "Числата имат еднаква сума на четните цифри." << endl;


	_getch();
}