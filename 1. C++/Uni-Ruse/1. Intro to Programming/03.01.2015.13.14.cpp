/* 

33. Да се състави програма, която 
последователно въвежда цели числа 
докато сумата им стане M 
или броят им стане N 
и намира поредния номер на най-малкото от въведените числа.
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
	int aMin;					// Най-малкото число в масива.
	int indMin = 0;				// Номер на най-малкото число в масива.
	int M;						// Необходима сума на елементите за излизане от цикъла.
	int N;						// Необходим брой елементи за излизане от цикъла.
	int sumAll = 0;				// Сума на всички въведени елементи.
	int brAll = 0;				// Брой на всички елементи.

	cout << "Enter N: "; cin >> N;
	cout << "Enter M: "; cin >> M;
	cout << endl;

	for (i = 0, aMin = 2147483647; i < 1337; i++)
	{
		cout << "Enter element number " << i << ": "; cin >> a[i];

		if (a[i] < aMin) { aMin = a[i]; indMin = i; }

		brAll++;
		if (brAll == M) { break; }

		sumAll += a[i];
		if (sumAll == N || sumAll > N) { break; }

	}

	cout << endl << "Сума на всички елементи: " << sumAll;
	cout << endl << "Брой на всички елементи: " << brAll;

	cout << endl << endl << "Номерът на най-малкото въведено число (" << aMin << ") е " << indMin << endl;
	




	_getch();
}
