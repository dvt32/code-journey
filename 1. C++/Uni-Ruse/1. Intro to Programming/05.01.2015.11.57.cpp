/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
8) Дадени са два масива a и b, 
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

	double a[30];					// Масив с Катет 1 на триъгълника. (страната "a")
	double b[30];					// Масив с Катет 2 на триъгълника. (страната "b")
	int m;							// Брой на правоъгълните триъгълници.
	int i;							// Брояч в цикъла

	double S[30];					// Масив, съдържащ лицата на триъгълниците.
	double S_max = 0.0;
	int S_max_ind;

	cout << "Enter m: "; cin >> m;

	for (i = 1; i < m + 1; i++){
		cout << endl;
		cout << "Триъгълник " << i << ", катет 1: "; cin >> a[i];
		cout << "Триъгълник " << i << ", катет 2: "; cin >> b[i];
		S[i] = (a[i] * b[i]) / 2;
		if (S[i] > S_max){
			S_max = S[i];
			S_max_ind = i;
		}
	}

	cout << endl << "Номерът на триъгълника с най-голямото лице (" << S_max << ") е " << S_max_ind << ".";



	
	

	_getch();
}