/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

4. Да се състави програма с рекурсивна функция за намиране на сумата от квадратите на целите числа от 1 до n.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

double i = 1, sum = 1;

// Функция за намиране сумата на квадратите на целите числа от 1 до n
double sumPow(int limit){

	::i++; ::sum += pow(i, 2);
	if (i < limit) { sumPow(limit); }
	if (i == limit) return sum;
}

void main() {
	system("chcp 1251");
	
	int n;

	cout << "Enter n: "; cin >> n; cout << endl;
	if (n <= 1) { return; }

	cout << "Сумата на квадратите на числата от 1 до " << n << " е: " << sumPow(n) << endl;

	
	_getch();
}

