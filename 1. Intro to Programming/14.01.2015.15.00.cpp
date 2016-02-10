/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

7) Дадени са два масива a и b, 
които съдържат катетите на m правоъгълни триъгълници. 
Да се намери номера на триъгълника с най-голямо лице.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int i, m;

	cout << "Enter n: "; cin >> m;

	double *a = new double[m]; // Катет 1, страната 'a'
	double *b = new double[m]; // Катет 2, страната 'b'
	double *S = new double[m]; // Лицето на триъгълника
	double S_max = 0;		   // Най-голямото лице от лицата на триъгълниците
	int S_max_ind = 0;		   // Номер на триъгълника с най-голямо лице.

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Триъгълник " << i << ", катет 1: "; cin >> a[i];
		cout << "Триъгълник " << i << ", катет 2: "; cin >> b[i];
		S[i] = (a[i] * b[i]) / 2;
		cout << "Лице на триъгълника: " << S[i] << endl << endl;
		if (S[i] > S_max){
			S_max = S[i];
			S_max_ind = i;
		}
	}

	cout << "Триъгълник " << S_max_ind << " има най-голямо лице (" << S_max << ")." << endl;

	delete[]S;
	delete[]b;
	delete[]a;


	_getch();

	
}