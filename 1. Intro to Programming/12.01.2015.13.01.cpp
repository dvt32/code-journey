/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

3) Даден е двумерен масив от с n реда и n стълба. 
Да се намери номера на реда, 
чиито елементи образуват аритметична прогресия.

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

	int arProgression;		// Променлива, определяваща дали елементите образуват аритметична прогресия -> 1 = да, 0 = не

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
		arProgression = 1;
		for (j = 0; j < n-1; j++){
			if (j>0 && A[i][j] != (A[i][j-1]+A[i][j+1]) / 2){
				arProgression = 0;
				break;
			}
		}
		if (arProgression == 1) { cout << "На ред " << i << " има аритметична прогресия." << endl; }
	}


	_getch();

	
}