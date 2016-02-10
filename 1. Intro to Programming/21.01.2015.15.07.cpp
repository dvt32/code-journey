/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

2. Дадена е поредица от ЕГН на група лица. 
Да се намерят поредните номера на най-младия и най-възрастния в групата.

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

	char EGN[30][11],
		godina_s[30][3], mesec_s[30][3], den_s[30][3],
		EGN_oldest[11], // ЕГН на най-възрастното лице
		EGN_youngest[11]; // ЕГН на най-младото лице

	int i, n,
		EGN_oldest_ind = 0, // номер на най-възрастното лице
		EGN_youngest_ind = 0, // номер на най-младото лице
		godina[30], mesec[30], den[30],
		godina_min = 2015, mesec_min = 52, den_min = 31,
		godina_max = 0000, mesec_max = 00, den_max = 00;

	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	// Въвеждане на имената, ЕГН-тата и отделяне на година/месец/ден на раждане.
	for (i = 0; i < n; i++){
		cout << "Лице " << i << ", ЕГН: "; cin.getline(EGN[i], 11);
		// Отделяне на годината
		strncpy_s(godina_s[i], EGN[i], 2);
		godina[i] = 1900 + atoi(godina_s[i]);
		// Отделяне на месеца и корекция за родените след 1999 г.
		strncpy_s(mesec_s[i], EGN[i] + 2, 2);
		mesec[i] = atoi(mesec_s[i]);
		if (mesec[i] > 40)
		{
			godina[i] += 100;
			mesec[i] -= 40;
		}
		// Отделяне на деня
		strncpy_s(den_s[i], EGN[i] + 4, 2);
		den[i] = atoi(den_s[i]);
	}

	cout << endl;

	// Сравняване на рождените дати - първо по година, след това по месец и по ден, ако е необходимо.
	for (i = 0; i < n; i++){

		// По година.
		if (godina[i] < godina_min)
		{
			godina_min = godina[i];
			strcpy_s(EGN_oldest, EGN[i]);
			EGN_oldest_ind = i;

		}

		if (godina[i] > godina_max)
		{
			godina_max = godina[i];
			strcpy_s(EGN_youngest, EGN[i]);
			EGN_youngest_ind = i;

		}

		// НАЙ-ВЪЗРАСТЕН - по месец и по ден (ако е необходимо)
		if (godina[i] == godina_min)
		{
			if (mesec[i] < mesec_min)
			{
				mesec_min = mesec[i];
				strcpy_s(EGN_oldest, EGN[i]);
				EGN_oldest_ind = i;
			}
			if (mesec[i] == mesec_min)
			{
				if (den[i] < den_min)
				{
					den_min = den[i];
					strcpy_s(EGN_oldest, EGN[i]);
					EGN_oldest_ind = i;
				}
			}

		// НАЙ-МЛАД - по месец и по ден (ако е необходимо)
			if (godina[i] == godina_max)
			{
				if (mesec[i] > mesec_max)
				{
					mesec_max = mesec[i];
					strcpy_s(EGN_youngest, EGN[i]);
					EGN_youngest_ind = i;
				}
				if (mesec[i] == mesec_max)
				{
					if (den[i] > den_max)
					{
						den_max = den[i];
						strcpy_s(EGN_youngest, EGN[i]);
						EGN_youngest_ind = i;
					}
				}
			}
		}
	}

	cout << "Лице " << EGN_oldest_ind << " е най-възрастно и има ЕГН " << EGN_oldest << "." << endl;
	cout << "Лице " << EGN_youngest_ind << " е най-младо и има ЕГН " << EGN_youngest << "." << endl;
	


	

	_getch();
}