/* 
30.
Да се състави програма, която последователно въвежда цели числа.
	Когато броят на въведените ненулеви числа стане N (N e зададено)
	или 
	броят на въведените нулеви числа стане 2, 
въвеждането се прекратява и 
се извежда средно аритметичното на четните и броят на нечетните от въведените числа.

 
*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int i;
	int a[1337];

	int brNulevi = 0;					// Брой нулеви числа
	int brNenulevi = 0;					// Брой ненулеви числа
	int N;								// Необходим брой ненулеви числа за излизане от цикъла.
	int brChetni = 0;					// Брой четни числа
	int sumChetni = 0;					// Сума на четните числа
	int brNechetni = 0;					// Брой нечетни числа.



	cout << endl << "Enter N: "; cin >> N;

	cout << endl << "ЗАБЕЛЕЖКА: 0 не се смята за число.";

	cout << endl << endl;

	// Въвеждане на числата
	for (i = 0; i < 1337; i++)
	{
		cout << "Enter element number " << i << ": ";
		cin >> a[i];
		if (a[i] != 0) 
		{
			brNenulevi++;
			if (brNenulevi == N) { 
									if (a[i] % 2 == 0)
									{
										brChetni++;
										sumChetni += a[i];
									}
									if (a[i] % 2 == 1)
									{
										brNechetni++;
									}
									break;}
			if (a[i] % 2 == 0)
				{
					brChetni++;
					sumChetni += a[i];
				}
				if (a[i] % 2 == 1)
				{
					brNechetni++;
				}
		}
		if (a[i] == 0) 
		{ 
			brNulevi++;
			if (brNulevi == 2) { break; }
		}
		
	}
	
	cout << endl << "Броят на нечетните числа е " << brNechetni << endl;

	if (brChetni > 0)
	{
		cout << "Средно аритметичното на четните числа е " << (double)sumChetni / brChetni;
	}
	

	

	_getch();
}