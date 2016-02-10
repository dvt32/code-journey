/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

4) Даден е двумерен масив от с n реда и n стълба. 
Да се намери номера на реда, 
чиито елементи образуват симетрична последователност (т.е. геометрична прогресия).

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

	int geoProgression;		// Променлива, определяваща дали елементите образуват геометрична прогресия -> 1 = да, 0 = не

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
		geoProgression = 1;
		for (j = 0; j < n-1; j++){
			if (j>0 && pow(A[i][j],2) != A[i][j-1]*A[i][j+1]){
				geoProgression = 0;
				break;
			}
		}
		if (geoProgression == 1) { cout << "На ред " << i << " има геометрична прогресия." << endl; }
	}


	_getch();

	
}