/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

20. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1. 
Да се състави програма, която създава нов масив а0, а1,...,аn-1, 
като стойността на аi е равна на сумата от квадратите на четните цифри на Аi.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int A[30], n, i;
	double a[30] = {0};

	int c[30];

	cout << "Enter n: "; cin >> n;

	for (i = 0; i < n; i++)
	{
		cout << "A[" << i << "]: "; cin >> A[i];
		while (A[i] > 0)
		{
			c[i] = A[i] % 10;
			if (c[i] % 2 == 0)
			{
				a[i] += pow(c[i], 2);
			}
			A[i] /= 10;
		}
		
	}

	cout << endl;


	for (i = 0; i < n; i++)
	{
		cout << "a[" << i << "]: " << a[i] << endl;
	}





	_getch();
}