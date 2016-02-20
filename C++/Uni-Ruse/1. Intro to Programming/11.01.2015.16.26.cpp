/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

5) Даден е двумерен масив с m реда и n стълба. 
Да се намери номера на реда, в който всички елементи са с нулеви стойности.

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

	int samoNuli;		// Променлива, определяваща дали има само нули на даден ред. 1 = само нули / 0 = не са само нули.

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
		samoNuli = 1;
		for (j = 0; j < n; j++){
			if (A[i][j] != 0){
				samoNuli = 0;
				break;
			}
		}
		if (samoNuli == 1) { cout << "Ред " << i << " има само нули." << endl; }
	}


	_getch();

	
}