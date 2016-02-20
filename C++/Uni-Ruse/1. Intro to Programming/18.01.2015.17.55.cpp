/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

10. Зададен е едномерният масив от символни низове А0, А1,...,Аn-1. 
Да се състави програма, която създава нов масив а0, а1,...,аn-1, 
като стойност-та на аi е равна на броя на символите в низа Аi.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	char A[30][30];
	int a[30];
	int n, i;

	cout << "Enter n: "; cin >> n; 
	cin.ignore(); cout << endl;

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin.getline(A[i], 30-1);
		a[i] = strlen(A[i]);
	}

	cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}


	_getch();
}