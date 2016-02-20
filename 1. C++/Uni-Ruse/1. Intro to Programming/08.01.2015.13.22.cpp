/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

2. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е равна на броя на положителните елементи в i-ия ред.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int A[30][30], m, n;
	int a[30];
	int i, j;

	int brPolojitelni[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){
		brPolojitelni[i] = 0;
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
			if (A[i][j] > 0) { 
				brPolojitelni[i]++;
			}
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Положителни елементи на " << i << " ред: " << brPolojitelni[i] << endl;
	}





	_getch();
}