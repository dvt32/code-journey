/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

1) Дадени са катетите на n правоъгълни триъгълника. 
Да се напише програма, която намира и изведежда номера и лицето на триъгълника с най-голямо лице.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int n, i;
	cout << "Enter n: "; cin >> n;

	double *a = new double[n]; // Динамичен масив с катет 1 на триъгълника (страната "a")
	double *b = new double[n]; // Динамичен масив с катет 2 на триъгълника (страната "b")
	double *S = new double[n]; // Динамичен масив с лицето на триъгълника
	double S_max = 0;		   // Най-голямото лице.
	int S_max_ind = 0;		   // Индекс или номер на триъгълника с най-голямото лице.

	cout << endl;

	for (i = 0; i < n; i++){
		cout << i << " триъгълник, катет 1: "; cin >> a[i];
		cout << i << " триъгълник, катет 2: "; cin >> b[i];
		S[i] = (a[i] * b[i]) / 2;
		cout << "Лицето на триъгълника: " << S[i] << endl << endl;
		if (S[i] > S_max) {
			S_max = S[i];
			S_max_ind = i;
		}
	}

	cout << "Триъгълник " << S_max_ind << " има най-голямо лице. (" << S_max << ")" << endl;

	delete[]S;
	delete[]b;
	delete[]a;


	_getch();

	
}