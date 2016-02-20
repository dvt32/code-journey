/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

9. Да се състави програма, която определя 
кое от две лица със зададени ЕГН-та е по-възрастно.

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

	char EGN[2][11], godina_s[2][3], mesec_s[2][3], den_s[2][3];
	int i, godina[2], mesec[2], den[2];

	// Въвеждане на 2-те ЕГН-та и отделяне на година/месец/ден на раждане.
	for (i = 0; i < 2; i++){
		cout << "Въведи ЕГН с номер " << i+1 << ": "; cin >> EGN[i];
		// Отделяне на годината
		strncpy_s(godina_s[i], EGN[i], 2);
		godina[i] = 1900 + atoi(godina_s[i]);
		// Отделяне на месеца и корекция за родените след 1999 г.
		strncpy_s(mesec_s[i], EGN[i]+2, 2);
		mesec[i] = atoi(mesec_s[i]);
		if (mesec[i] > 40) 
		{
			godina[i] += 100;
			mesec[i] -= 40;
		}
		// Отделяне на деня
		strncpy_s(den_s[i], EGN[i]+4, 2);
		den[i] = atoi(den_s[i]);
	}

	cout << endl;

	// Сравняване на рождените дати - първо по година, след това по месец и по ден, ако е необходимо.
	for (i = 0; i < 1; i++){	// i < 1, за да може да използваме елемента i+1

		// По година.
		if (godina[i] < godina[i + 1]) 
		{cout << "Лицето с ЕГН " << EGN[i] << " е по-възрастно." << endl; return;}

		if (godina[i] > godina[i + 1])
		{cout << "Лицето с ЕГН " << EGN[i + 1] << " е по-възрастно." << endl; return;}

		if (godina[i] == godina[i + 1])
		{
			// По месец. (ако са родени в една и съща година)
			if (mesec[i] < mesec[i + 1])
			{cout << "Лицето с ЕГН " << EGN[i] << " е по-възрастно." << endl; return;}

			if (mesec[i] > mesec[i+1])
			{cout << "Лицето с ЕГН " << EGN[i+1] << " е по-възрастно." << endl; return;}

			if (mesec[i] == mesec[i + 1])
			{
				// По ден. (ако са родени през една и съща година и един и същ месец)
				if (den[i] < den[i + 1])
				{cout << "Лицето с ЕГН " << EGN[i] << " е по-възрастно." << endl; return;}

				if (den[i] > den[i + 1])
				{cout << "Лицето с ЕГН " << EGN[i+1] << " е по-възрастно." << endl; return;}

				if (den[i] == den[i + 1])
				{cout << "Двете лица са родени на една и съща дата." << endl; return;}
			}
			
		}
	}




	_getch();
}