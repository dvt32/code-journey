/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

21. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като аi =1, ако всичките елементи в i-ия ред са с еднакви стойности, 
и аi =0, ако всичките елементи в i-ия ред не са еднакви стойности..

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

	int a[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
				if (A[i][j] == A[i][j - 1] && A[i][0] == A[i][j]) {
					a[i] = 1;
				}
				else { a[i] = 0; }
				
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "a["<<i<<"]: " << a[i] << endl;
	}





	_getch();
}