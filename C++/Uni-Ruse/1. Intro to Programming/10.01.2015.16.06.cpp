/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

24. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е равна на сумата от квадратите на елементите в i-ия ред.

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
	int i, j;

	int a[30], sumKvadrati;

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " ред: " << endl;
			sumKvadrati = 0;
			for (j = 0; j < n; j++){
				cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
				sumKvadrati += pow(A[i][j], 2);
				a[i] = sumKvadrati;
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "a["<<i<<"]: " << a[i] << endl;
	}





	_getch();
}