/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

2) Даден е двумерен масив от с m реда и n стълба. 
Да се намери номера на реда, в който всички елементи са четни числа.

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

	int allEven;		// Променлива, определяваща дали всички елементи са четни -> 1 = всички четни, 0 = не всички четни

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
		allEven = 1;
		for (j = 0; j < n-1; j++){
			if (A[i][j] % 2 == 1){
				allEven = 0;
				break;
			}
		}
		if (allEven == 1) { cout << "На ред " << i << " всички елементи са четни." << endl; }
	}


	_getch();

	
}