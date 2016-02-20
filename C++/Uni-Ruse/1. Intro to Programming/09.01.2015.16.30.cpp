/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

19. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е равна на индекса на най-голямата отрицателна стойност в i-ия ред.

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

	int maxNeg[30];
	int maxNeg_ind[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){
		maxNeg[i] = INT_MIN;
		maxNeg_ind[i] = 0;
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
			if (A[i][j] > maxNeg[i] && A[i][j]<0) {
				maxNeg[i] = A[i][j];
				maxNeg_ind[i] = j;
			}
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Индексът на най-голямата отрицателна стойност на " << i << " ред: " << maxNeg_ind[i] << endl;
	}





	_getch();
}