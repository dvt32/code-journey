/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 11. Да се състави алгоритъм, който намира сумата от вторите степени на цифрите на зададено
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
	int sum = 0;          // Сума от вторите степени на цифрите

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		sum += c*c;
		chislo = chislo / 10;
	}

	cout << endl << "Резултатът е " << sum;


	_getch();
}