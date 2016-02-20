/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

16. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1. 
Да се състави програма, която създава нов масив а0, а1,...,аn-1, 
като аi =1, ако цифрите на Аi са еднакви, и аi =0, ако цифрите на Аi не са еднакви.

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
	int a[30];

	int c[60];
	int cTemp[60];

	cout << "Enter n: "; cin >> n;

	for (i = 0; i < n; i++)
	{
		cout << "A[" << i << "]: "; cin >> A[i];
		while (A[i] > 0)
		{
			c[i] = A[i] % 10;
			if (A[i] / 10 != 0){
				cTemp[i] = (A[i] / 10) % 10;
			}
			if (c[i] == cTemp[i])
			{
				a[i] = 1;
			}
			else { a[i] = 0; break; }
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