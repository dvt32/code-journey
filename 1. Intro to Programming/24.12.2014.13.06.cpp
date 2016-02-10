/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа) */
/* 1. Да се състави алгоритъм, който извежда сумата на цифрите на зададено цяло число. */

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
	int sumCifri = 0;		// Сума от цифрите на число

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		sumCifri += c;
		chislo = chislo / 10;
	}

	cout << endl << "Сумата от цифрите на числото е равна на " << sumCifri;


	_getch();
}