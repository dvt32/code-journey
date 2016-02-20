/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
1) Да се състави програма, която извежда сумата на четните цифри на зададено цяло число.
*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int N;
	int sum = 0;
	int c;					// Цифра

	cout << "Enter N: "; cin >> N;
	
	while (N > 0)
	{
		c = N % 10;
		if (c % 2 == 0) 
		{ 
			sum += c;
		}
		N = N / 10;
	}

	cout << "The sum of the positive digits of the number is " << sum;



	_getch();
}