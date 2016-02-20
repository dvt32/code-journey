/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

3) Да се намери 
броя на отрицателните елементи 
в отделните редове 
на двумерен масив с m реда и n стълба.

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

	int brNeg[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " ред: " << endl;
		brNeg[i] = 0;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
				if (A[i][j] < 0) { brNeg[i]++; }

		}
	}

	cout << endl;

	for (i = 0, j = 0; i < m, j < n; i++, j++)
	{
		cout << "Броят на отрицателните елементи на " << i << " ред е: " << brNeg[i] << endl;
	}




	_getch();
}