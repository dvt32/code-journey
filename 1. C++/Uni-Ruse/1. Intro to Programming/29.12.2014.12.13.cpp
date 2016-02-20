/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
2) Да се състави програма, която намира най-малката нечетна цифра в зададено цяло число.
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
	int c;					// Цифра
	int minNechetna = 9;


	cout << "Enter N: "; cin >> N;
	
	while (N > 0)
	{
		c = N % 10;
		if (c < minNechetna && c != 0) 
		{ 
			minNechetna = c;
		}
		N = N / 10;
	}

	cout << "The smallest odd digit in the number is " << minNechetna;



	_getch();
}