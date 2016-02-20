/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

1) Даден е двумерен масив с m реда и n стълба.
Да се намери номера на реда, в който всички елементи са равни.

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

	int allEqual;		// Променлива, определяваща дали всички елементи са равни -> 1 = всички равни, 0 = не всички са равни

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
		}
	}

	cout << endl;

	// Краен резултат

	for (i = 0; i < m; i++){
		allEqual = 1;
		for (j = 0; j < n-1; j++){
			if (A[i][j] != A[i][j+1]){
				allEqual = 0;
				break;
			}
		}
		if (allEqual == 1) { cout << "На ред " << i << " всички елементи са еднакви." << endl; }
	}


	_getch();

	
}