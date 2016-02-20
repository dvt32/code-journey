/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

2) Да се намерят 
средно аритметичните на елементите в отделните стълбове 
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

	double sum;
	double br;
	double avg[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){

		cout << endl << i << " стълб: " << endl;
		br = 0;
		sum = 0;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << j << "][" << i << "]: "; cin >> A[j][i];
			br++;
			sum += A[j][i];
			avg[i] = sum / br;

		}
	}

	cout << endl;

	for (i = 0, j = 0; i < m, j < n; i++, j++)
	{
		cout << "Средно-аритметичното на елементите на " << j << " стълб е: " << avg[i] << endl;
	}




	_getch();
}