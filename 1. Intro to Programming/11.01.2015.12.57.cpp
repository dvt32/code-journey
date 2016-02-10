/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

1) Да се намери произведението 
от ненулевите елементи 
в отделните стълбове 
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

	int multiNenulevi[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " стълб: " << endl;
		multiNenulevi[i] = 1;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << j << "][" << i << "]: "; cin >> A[j][i];
			if (A[j][i] != 0)
			{
				multiNenulevi[i] *= A[j][i];
			}
			else {multiNenulevi[i] = 0;}

		}
	}

	cout << endl;

	for (i = 0, j = 0; i < m, j < n; i++, j++)
	{
		cout << "Произведението на ненулевите елементи на " << j << " стълб е: " << multiNenulevi[i] << endl;
	}




	_getch();
}