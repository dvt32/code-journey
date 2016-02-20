/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 8. Да се състави алгоритъм, който намира най-голямата цифра в зададено цяло число.

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
	int cMax = 0;           // Най-голяма цифра в числото

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		if (c > cMax)
		{
			cMax = c;
		}
		chislo = chislo / 10;
	}

	cout << endl << "Резултатът е " << cMax;


	_getch();
}