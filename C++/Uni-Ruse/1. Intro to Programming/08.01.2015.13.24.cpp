/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

3. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е равна на броя на отрицателните елементи в i-ия ред.

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

	int brOtricatelni[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){
		brOtricatelni[i] = 0;
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
			if (A[i][j] < 0) { 
				brOtricatelni[i]++;
			}
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Отрицателни елементи на " << i << " ред: " << brOtricatelni[i] << endl;
	}





	_getch();
}