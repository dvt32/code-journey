/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

26. Зададен е двумерен масив А с m реда n стълба, съдържащ ЕГН-та на група лица. 
Да се състави програма, която намира най-младата жена в целия двумерен масив.

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

	char A[30][30][11], A_youngestWoman[11], // A_youngestWoman - ЕГН на най-младата жена
			godina_s[100][3], mesec_s[100][3], den_s[100][3], gender_s[100][2];
				

	int i, j, m, n,
		godina[30][30], mesec[30][30], den[30][30], gender[30][30],
		godina_max = 0000, mesec_max = 00, den_max = 00;

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	// Въвеждане на ЕГН-тата и отделяне на година/месец/ден на раждане.
	for (i = 0; i < n; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < m; j++)
		{
			cout << "-A["<<i<<"]["<<j<<"], ЕГН: "; cin.getline(A[i][j], 11);
			// Отделяне на годината
			strncpy_s(godina_s[i], A[i][j], 2);
			godina[i][j] = 1900 + atoi(godina_s[i]);
			// Отделяне на месеца и корекция за родените след 1999 г.
			strncpy_s(mesec_s[i], A[i][j] + 2, 2);
			mesec[i][j] = atoi(mesec_s[i]);
			if (mesec[i][j] > 40)
			{
				godina[i][j] += 100;
				mesec[i][j] -= 40;
			}
			// Отделяне на деня
			strncpy_s(den_s[i], A[i][j] + 4, 2);
			den[i][j] = atoi(den_s[i]);
			// Отделяне на пола (предпоследната цифра, 9-та, нечетна = жена)
			strncpy_s(gender_s[i], A[i][j] + 8, 1);
			gender[i][j] = atoi(gender_s[i]);
		}
	}

	cout << endl;

	// Сравняване на рождените дати - първо по година, след това по месец и по ден, ако е необходимо.
	for (i = 0; i < n; i++){

		for (j = 0; j < n; j++){
			// По година.
			if (godina[i][j] > godina_max && gender[i][j] % 2 == 1)
			{
				godina_max = godina[i][j];
				strcpy_s(A_youngestWoman, A[i][j]);

			}

			if (godina[i][j] == godina_max)
			{
				// По месец. (ако са родени в една и съща година)
				if (mesec[i][j] > mesec_max && gender[i][j] % 2 == 1)
				{
					mesec_max = mesec[i][j];
					strcpy_s(A_youngestWoman, A[i][j]);
				}

				if (mesec[i][j] == mesec_max)
				{
					// По ден. (ако са родени през една и съща година и един и същ месец)
					if (den[i][j] > den_max && gender[i][j] % 2 == 1)
					{
						den_max = den[i][j];
						strcpy_s(A_youngestWoman, A[i][j]);
					}

				}

			}
		}
	}

	cout << "ЕГН-то на най-младата жена е " << A_youngestWoman << "." << endl;


	

	_getch();
}