/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

10. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е равна на 
броя на елементите в i-ия ред, които са в интервала [p,q], 
където p и q са зададени.

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

	int p, q;
	int br[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	cout << endl;

	cout << "Enter p: "; cin >> p;
	cout << "Enter q: "; cin >> q;

	for (i = 0; i < m; i++){
		br[i] = 0;
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
			if (A[i][j] >= p && A[i][j]<=q) { 
				br[i]++;
			}
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Брой на елементите в интервала ["<<p<<", "<<q<<"] на " << i << " ред: " << br[i] << endl;
	}





	_getch();
}