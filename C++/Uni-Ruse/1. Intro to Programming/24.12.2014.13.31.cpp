/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 9. Да се състави алгоритъм, който намира най-малката нечетна цифра в зададено цяло число.

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
	int cMin = 9;           // Най-малка цифра в числото

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		if ( (c%2==1) && (c<cMin) )
		{
			cMin = c;
		}
		chislo = chislo / 10;
	}

	cout << endl << "Резултатът е " << cMin;


	_getch();
}