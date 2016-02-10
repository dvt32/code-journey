/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

11. Зададен е едномерният масив от символни низове А0, А1,...,Аn-1. 
Да се състави програма, която създава нов масив а0, а1,...,аn-1, 
като стойност-та на аi показва колко пъти се среща зададен символ в низа Аi.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void main(){
	system("chcp 1251");

	char A[30][30], symbol;

	int a[30], i, j, n, brSymbol;

	cout << "Enter n: "; cin >> n; cin.ignore();
	cout << "Enter symbol: "; cin >> symbol; cin.ignore();
	cout << endl;
	
	for (i = 0; i < n; i++){
		brSymbol = 0;
		cout << "A[" << i << "]: "; cin.getline(A[i], 30);
		for (j = 0; j < strlen(A[i]); j++)
		{
			if (A[i][j] == symbol) { brSymbol++; }
		}
		a[i] = brSymbol;
	}

	cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl; 
	}


	_getch();
}