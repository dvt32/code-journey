/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

3) Да се образува масив p от едномерния масив w чрез отстраняване на всички нулеви елементи в дадения масив.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int i, n, k=0; 
	// n - брой на елементите в 'w', 
	// k - брой на елементите в новия масив 'p'
	cout << "Enter n: "; cin >> n;

	int *w = new int[n];
	int *p = new int[n];

	cout << endl;

	for (i = 0; i < n; i++){
		cout << "w[" << i << "]: "; cin >> w[i];
		if (w[i] != 0){
			p[k] = w[i];
			k++;
			
		}
	}

	cout << endl;

	for (i = 0; i < k; i++){
		cout << "p[" << i << "]: " << p[i] << endl;
	}

	delete[]p;
	delete[]w;


	_getch();

	
}