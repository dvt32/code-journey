/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

5. Да се състави програма с рекурсивна функция за 
намиране произведението на положителните елементи 
на едномерен масив с n елемента.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int i = 0, multi = 1;

int multiArray(int *array, int numberOfElements){
	if (array[i] > 0) { ::multi *= array[i]; }
	i++;
	if (i < numberOfElements) { multiArray(array, numberOfElements); }
	else return ::multi;
}

void main() {
	system("chcp 1251");
	
	int n, i, a[30];

	cout << "Enter n: "; cin >> n; cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: "; cin >> a[i];
	}

	cout << "Произведението на положителните елементи е " << multiArray(a, n) << endl;

	
	_getch();
}

