/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 2. Да се състави алгоритъм, който извежда сумата на четните цифри на зададено цяло число. */

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
	int sumChetniCifri = 0; // Сума от четните цифри на числото

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		if (c % 2 == 0)
		{
			sumChetniCifri += c;
		}
		chislo = chislo / 10;
	}

	cout << endl << "Сумата от четните цифри на числото е равна на " << sumChetniCifri;


	_getch();
}