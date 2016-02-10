/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

2. Да се състави програма, която проверява
дали се среща зададен символ в даден символен низ.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main()
{
	system("chcp 1251");

	char symbol;
	char string[30];
	int i = 0;

	cout << "Enter symbol: "; cin >> symbol;
	cout << "Enter string: "; cin >> string;

	while (string[i] != '\0')
	{
		if (string[i] == symbol) { cout << "\nНизът съдържа въведения символ.\n\n"; return; }
		i++;
	}
	if (string[i] == '\0') { cout << "\nНизът НЕ съдържа въведения символ.\n\n"; return; }


	_getch();
}