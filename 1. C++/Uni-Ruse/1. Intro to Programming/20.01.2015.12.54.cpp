/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

16. Зададени са два едномерни масива от символни низове 
А0, А1,...,Аn-1 и E0, E1,..., En-1, 
където Аi и Ei са съответно 
името и ЕГН на i-тото лице. 
Да се състави програма, която извежда името на най-възрастното лице.

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

	char EGN[30][11], A[30][101],
			godina_s[30][3], mesec_s[30][3], den_s[30][3],
				A_oldest[101]; // A_oldest - името на най-възрастното лице.

	int i, n,
		godina[30], mesec[30], den[30],
		godina_min = 2015, mesec_min = 52, den_min = 31;
	
	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	// Въвеждане на имената, ЕГН-тата и отделяне на година/месец/ден на раждане.
	for (i = 0; i < n; i++){
		cout << "Лице " << i << ", име: "; cin.getline(A[i], 101);
		cout << "Лице " << i << ", ЕГН: "; cin.getline(EGN[i], 11);
		cout << endl;
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
			strcpy_s(A_oldest, A[i]);
			
		}

		if (godina[i] == godina_min)
		{
			// По месец. (ако са родени в една и съща година)
			if (mesec[i] < mesec_min)
			{
				mesec_min = mesec[i];
				strcpy_s(A_oldest, A[i]);
			}

			if (mesec[i] == mesec_min)
			{
				// По ден. (ако са родени през една и съща година и един и същ месец)
				if (den[i] < den_min)
				{
					den_min = den[i];
					strcpy_s(A_oldest, A[i]);
				}

			}

		}
	}

	cout << "Най-възрастното лице се казва " << A_oldest << "." << endl;




	_getch();
}