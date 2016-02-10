/* 

31 Да се състави програма, 
която въвежда цели числа 
докато сумата им стане по-голяма или равна на зададено число М. 

Програмата извежда поредния номер на онова число от въведените числа, което е най близко до зададено число М.
*/

#include "stdafx.h"
using namespace std;
#include<iostream>
#include<stdlib.h>
#include<conio.h>
#include <math.h>


void main(){
	system("chcp 1251");

	int a[1337];				// Масив за целите числа, които ще въвеждаме.
	int i;						// Брояч
	int aMax;					// Числото най-близко до M (т.е най-голямото).
	int indMax = 0;				// Номер на най-голямото число.
	int M;						// Необходима сума на елементите за излизане от цикъла.
	int sumAll = 0;				// Сума на всички въведени елементи.
	int brAll = 0;				// Брой на всички елементи.

	cout << "Enter M: "; cin >> M;
	cout << endl;

	for (i = 0, aMax = -2147483647; i < 1337; i++)
	{
		cout << "Enter element number " << i << ": "; cin >> a[i];

		if (a[i] > aMax) { aMax = a[i]; indMax = i; }

		sumAll += a[i];
		if (sumAll >= M) { break; }

	}

	cout << endl << "Сума на всички елементи: " << sumAll;

	cout << endl << endl << "Номерът на числото най-близко до M (" << aMax << ") е " << indMax << endl;
	




	_getch();
}
