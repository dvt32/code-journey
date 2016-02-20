/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
4. Да се състави програма, която извежда средно-аритметичното на цифрите на зададено цяло число.
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
	int sum = 0;			// Сума на цифрите
	int br = 0;				// Брой на цифрите
	double avg = 0.0;


	cout << "Enter N: "; cin >> N;
	
	while (N > 0)
	{
		c = N % 10;
		sum += c;
		br++;
		N = N / 10;
	}

	avg = sum / br;
	if (br == 0) cout << "Няма цифри различни от 0.";
	else cout << "Средно-аритметичното на цифрите е равно на " << avg;



	_getch();
}