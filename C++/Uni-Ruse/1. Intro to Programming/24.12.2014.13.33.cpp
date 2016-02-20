/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 10. Да се състави алгоритъм, който извежда произведението на нечетните цифри на зададено
цяло число.

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
	int multi = 1;          // Произведение на цифрите

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		if ( c%2==1 )
		{
			multi *= c;
		}
		chislo = chislo / 10;
	}

	cout << endl << "Резултатът е " << multi;


	_getch();
}