/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

6) Даден е двумерен масив с m реда и n стълба. 
За всеки стълб да се намери елементът с най-малка стойност. 
Да се намери след това най-голямата сред тези стойности, както и номера на стълба в който се намира тя.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int A[30][30];
	int m, n, i, j;

	int minColumn[30];			// Масив, съдържащ най-малката стойност на всеки стълб.
	int maxFromMin;				// Най-голямата от най-малките стойности, извлечени от всеки стълб.
	int maxFromMin_ind;			// Номер на стълба, в който се намира тази стойност.

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " стълб: " << endl;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << j << "][" << i << "]: "; cin >> A[j][i];
		}
	}

	cout << endl;

	// Определяне на НМС по стълб и след това най-голямата от тези стойности.
	for (i = 0; i < m; i++){

		minColumn[i] = INT_MAX;
		maxFromMin = minColumn[i];
		for (j = 0; j < n; j++)
		{
			if (A[j][i] < minColumn[i]) { minColumn[i] = A[j][i]; }
		}
		if (minColumn[i] < maxFromMin) { 
			maxFromMin = minColumn[i];
			maxFromMin_ind = i;
		}
		
	}

	for (i = 0; i < m; i++){
		cout << "НМС на " << i << " стълб: " << minColumn[i] << endl;
		if (i == m - 1) {
			cout << "- НГС от тези стойности: " << maxFromMin << " (" << maxFromMin_ind << " стълб)." << endl;
		}
	}


	_getch();

	
}