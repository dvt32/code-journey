/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

63. Зададен е масивът от ЕГН-та E0, E1,..., En-1 
Да се състави програма, коя-то създава два нови масива М0, М1, М2 ....и W0, W1, W2, ..., 
съдържащи ЕГН-та съответно на мъжете и жените.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int brMen = 0, brWomen = 0;			// брой мъже и жени
int m = 0, w = 0;					// m - брояч на ЕГН-та на мъже, w - брояч на ЕГН-та на жени

void monthBorn(char s1[][11], int numberOfElements, char result1[][11], char result2[][11]){

	int i, n = numberOfElements,
		gender[30];

	char gender_s[30][2];

	for (i = 0; i < n; i++){
		// Отделяне на пола (предпоследна цифра от ЕГН, 9-та, четна = мъж, нечетна = жена)
		strncpy_s(gender_s[i], s1[i] + 8, 1);
		gender[i] = atoi(gender_s[i]);
		// Определяне на броя на мъже/жени и стойността на всеки елемент в новите масиви
		if (gender[i] % 2 == 0) { ::brMen++; strcpy_s(result1[::m++], s1[i]); }
		if (gender[i] % 2 == 1) { ::brWomen++; strcpy_s(result2[::w++], s1[i]); }
	}
}



// Главна функция
void main(){
	system("chcp 1251");

	int i, n, a[30];
	char EGN[30][11], M[30][11], W[30][11];

	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < n; i++){
		cout << "EGN[" << i << "]: "; cin.getline(EGN[i], 11);
	}

	cout << endl;

	// Извикване на функцията
	monthBorn(EGN, n, M, W);

	for (::m = 0; ::m < ::brMen; ::m++)
	{
		cout << "M["<<::m<<"]: " << M[::m] << endl;
	}

	cout << endl;

	for (::w = 0; ::w < ::brWomen; ::w++)
	{
		cout << "W[" << ::w << "]: " << W[::w] << endl;
	}



	_getch();
}