/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
10) 
Масивът a0, a1,..., am-1 е нареден във възходящ ред, 
т.е. за всяко i<m, a[i+1] >= a[i]. 
Да се определи номерът на първия срещнат елемент, 
който е по-голям или равен на дадена стойност b.
 */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int a[30], b, m, i;

	cout << "Enter b: "; cin >> b;
	cout << "Enter m: "; cin >> m;

	for (i = 1; i < m; i++){
		cout << "Enter element number " << i << ": "; cin >> a[i];
		if (a[i - 1] > a[i]) { cout << "Елементите не са във възходящ ред." << endl; break; }
		if (a[i] >= b) {
			cout << endl << "Първият елемент със стойност по-голяма или равна на тази на 'b' е " << i << endl;
			break;
		}
	}
	
	

	_getch();
}