/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

27. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е 
равна на произведението от третите степени на елементите в i-ия ред.

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

	double a[30], sumPow3;

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " ред: " << endl;
			sumPow3 = 1;
			for (j = 0; j < n; j++){
				cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
				sumPow3 *= pow(A[i][j], 3);
				a[i] = sumPow3;
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "a["<<i<<"]: " << a[i] << endl;
	}





	_getch();
}