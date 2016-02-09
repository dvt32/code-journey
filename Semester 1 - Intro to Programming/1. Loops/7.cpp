/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 7. Да се състави алгоритъм, който извежда средно-аритметичното на цифрите на зададено ця-
ло число, които са по-големи от 3 и по-малки от 7.

 */

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int chislo;				// Цяло число
	int c;					// Цифра на число

	int n = 0;								// Брой на цифрите
	int sumCifri = 0;						// Сума на цифрите
	float avg;				// Средно аритметично на цифрите.

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		if (c > 3 && c < 7)
		{
			sumCifri += c;
			n += 1;
		}
		avg = sumCifri / n;
		chislo = chislo / 10;
	}

	cout << endl << "Средно-аритметичното на цифрите е " << avg;


	_getch();
}