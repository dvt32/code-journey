/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

15. Зададен е едномерният масив от ЕГН-та E0, E1,..., En-1 Да се състави програма, която създава два нови масива М0, М1, М2 ....и W0, W1, W2, ..., съдържащи ЕГН съответно на мъжете и жените.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void main(){
	system("chcp 1251");

	char EGN[30][11], gender_s[30][2], M[30][11], W[30][11];

	int gender[30], i, n,
		brMen = 0, brWomen = 0, 
		m = 0, w = 0; // m - брояч на ЕГН-тата на мъжете, w - брояч на ЕГН-тата на жените

	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	// Въвеждане на ЕГН-тата
	for (i = 0; i < n; i++)
	{
		cout << "Въведи ЕГН с номер " << i << ": "; cin.getline(EGN[i], 30);
		// Отделяне на цифрата за пола (предпоследната, 9-тата, четна = мъж, нечетна = жена) и конвертиране в int
		strncpy_s(gender_s[i], EGN[i] + 8, 1); gender_s[i][2] = '\0';
		gender[i] = atoi(gender_s[i]);
		// Добавяне на ЕГН-тата на мъжете в масива 'M'
		if (gender[i] % 2 == 0)
		{
				brMen++;
				strcpy_s(M[m++], EGN[i]);
		}
		// Добавяне на ЕГН-тата на жените в масива 'W'
		if (gender[i] % 2 == 1)
		{
				brWomen++;
				strcpy_s(W[w++], EGN[i]);
		}
	}

	cout << endl;

	// Извеждане на 'M'
	for (m = 0; m < brMen; m++){
		cout << "M[" << m << "]: " << M[m] << endl;
	}

	cout << endl;

	// Извеждане на 'W'
	for (w = 0; w < brWomen; w++){
		cout << "W[" << w << "]: " << W[w] << endl;
	}



	_getch();
}