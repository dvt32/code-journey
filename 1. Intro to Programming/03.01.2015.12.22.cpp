/* 
32. Да се състави програма, която 
иска да въвеждаме цели числа, 
докато броят на въведените положителни числа стане N 
или броят на въведените нулеви числа стане М. 

Програмата извежда средно-аритметичното на всички въведени числа.
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
	int brPolojitelni = 0;		// Брой положителни числа.
	int N;						// Необходим брой въведени положителни числа, за да се излезе от цикъла.
	int brNulevi = 0;			// Брой нулеви числа.
	int M;						// Необходим брой въведени нулеви числа, за да се излезе от цикъла.
	int sumAll = 0;				// Сума на всички въведени елементи.
	int brAll = 0;				// Брой на всички елементи.

	cout << "Enter N: "; cin >> N;
	cout << "Enter M: "; cin >> M;
	cout << endl;

	for (i = 0; i < 1337; i++)
	{
		cout << "Enter element number " << i << ": "; cin >> a[i];
		brAll++;
		sumAll += a[i];
		if (a[i] > 0) { 
			brPolojitelni++;
			if (brPolojitelni == N) {
				break;
			}
		}
		if (a[i] == 0) {
			brNulevi++;
			if (brNulevi == M){
				break;
			}
		}
	}

	cout << endl << "Брой положителни: " << brPolojitelni;
	cout << endl << "Брой нулеви: " << brNulevi;
	cout << endl << "Сума на всички елементи: " << sumAll;
	cout << endl << "Брой на всички елементи: " << brAll;

	cout << endl << endl << "Средно-аритметичното на всички въведени елементи е " << (double)sumAll / brAll;
	




	_getch();
}
