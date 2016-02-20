/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

4) Да се намери 
произведението от квадратите на елементите 
в отделните редове 
на двумерен масив с m реда и n стълба, 
чиито абсолютни стойности са в диапазона [1, 1.5].

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	double A[30][30];
	int m, n, i, j;

	double multi[30];			// Произведение на квадратите на елементите отгворящи на условието (по ред)

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " ред: " << endl;
		multi[i] = 1;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
			if (fabs(A[i][j]) >= 1 && fabs(A[i][j]) <= 1.5)
			{
				multi[i] *= pow(A[i][j], 2);
			}

		}
	}

	cout << endl;


	for (i = 0, j = 0; i < m, j < n; i++, j++)
	{
		cout << "Произв. на квадр. на ел. с абс. ст-ст в диапазона [1, 1.5] на " << i << " ред е: " << multi[i] << endl;
	}




	_getch();
}