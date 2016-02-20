/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

62. Зададен е масивът от ЕГН-та E0, E1,..., En-1 Да се състави програма, коя-то създава 
нов масив а0, а1,...,аn-1, като стойността на 
аi е равна на месеца на раждане на лицето с ЕГН Ei.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void monthBorn(char s1[][11], int numberOfElements, int *result){

	int i, n = numberOfElements;
	int mesec_int[30];
	char mesec[30][3];

	for (i = 0; i < n; i++){
		strncpy_s(mesec[i], s1[i] + 2, 2);
		mesec_int[i] = atoi(mesec[i]);
		if (mesec_int[i] > 12) { mesec_int[i] -= 40; } // корекция за родени след 1999 г.
		result[i] = mesec_int[i];
	}
}



// Главна функция
void main(){
	system("chcp 1251");

	int i, n, a[30];
	char EGN[30][11];

	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < n; i++){
		cout << "EGN[" << i << "]: "; cin.getline(EGN[i], 11);
	}

	cout << endl;

	// Извикване на функцията
	monthBorn(EGN, n, a);

	for (i = 0; i < n; i++)
	{
		cout << "a["<<i<<"]: " << a[i] << endl;
	}



	_getch();
}