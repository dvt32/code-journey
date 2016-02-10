/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 1) Да се намери броят на нулевите елементи в масива u с m елементи. */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int brNulevi = 0;
	int u[1337];
	int m;

	cout << "Enter m: "; cin >> m;

	for (int i = 0; i < m; i++){
		cout << "Element " << i << " of 'u': "; cin >> u[i];
		if (u[i] == 0) { brNulevi++; }
	}
	
	cout << "Броят на нулевите елементи е " << brNulevi;

	_getch();
}