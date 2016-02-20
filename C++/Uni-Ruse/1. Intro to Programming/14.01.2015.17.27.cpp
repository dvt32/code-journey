/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

9) Масивът a0, a1,..., am-1 е нареден във възходящ ред, 
т.е. за всяко i<m a[i+1]>a[i]. 
Да се определи номера на първия срещнат елемент, който е по-голям или равен на дадена стойност b.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int i, m, b;
	cout << "Enter m: "; cin >> m;
	cout << "Enter b: "; cin >> b; cout << endl;

	int *a = new int[m];

	for (i = 0; i < m; i++){
		cout << "a[" << i << "]: "; cin >> a[i];
	}

	for (i = 0; i < m-1; i++){
		if (a[i] > a[i + 1]) { cout << endl << "Масивът не е подреден във възходящ ред." << endl; return; }	
	}

	for (i = 0; i < m; i++){
		if (a[i] >= b) {
			cout << endl << "Елемент номер " << i << " е първият, който е равен на или по-голям от 'b'." << endl; break;
		}
	}

	delete[]a;



	_getch();
	

	
}