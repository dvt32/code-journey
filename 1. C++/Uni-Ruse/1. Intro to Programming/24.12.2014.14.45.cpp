/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* УПР 2 (извънаудиторна работа */
/* 19. Да се състави алгоритъм, който проверява дали зададено цяло число съдържа цифрата 3.


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

	cout << endl << "Въведи цяло число: "; cin >> chislo;

	while (chislo > 0)
	{
		c = chislo % 10;
		if (c == 3) { cout << "Числото има цифрата 3."; break; }
		chislo = chislo / 10;
		
	}


	_getch();
}