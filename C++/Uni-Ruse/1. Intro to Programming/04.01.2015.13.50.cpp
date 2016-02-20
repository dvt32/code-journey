/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 4) Да се образува нов масив p[k] от масива w[n]. Новият масив не трябва да съдържа съседни повтарящи се елементи. */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int w[30], n, i;
	int p[30], k = 0;


	cout << "Брой елементи на 'w': "; cin >> n; cout << endl;

	for (i = 1; i < n+1; i++){
		cout << "Element " << i << " of 'w': "; cin >> w[i];
		if (w[i] != w[i-1]) { 
			p[k++] = w[i];
		}
	}

	cout << endl;

	for (i = 0; i < k; i++){
			cout << "p[" << i << "]: " << p[i] << endl;
		}
	
	

	_getch();
}