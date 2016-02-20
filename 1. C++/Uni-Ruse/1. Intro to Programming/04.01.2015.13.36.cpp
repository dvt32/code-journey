/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 3) Да се образува масив p от едномерния масив w чрез отстраняване на всички нулеви елементи в дадения масив. */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int w[30], m, i;
	int p[30], k = 0;


	cout << "Брой елементи на 'w': "; cin >> m; cout << endl;

	for (i = 0; i < m; i++){
		cout << "Element " << i << " of 'w': "; cin >> w[i];
		if (w[i] != 0) { 
			p[k++] = w[i];
		}
	}

	cout << endl;

	for (i = 0; i < k; i++){
			cout << "p[" << i << "]: " << p[i] << endl;
		}
	
	

	_getch();
}