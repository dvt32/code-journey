/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

4. Да се намери при кое от две зададени цели числа средно-аритметичното на цифрите е по-голяма.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


double br = 0, sum = 0;

double average(int number){

	double c = number % 10; 
	::br++;
	::sum += c;

	if (number > 0) { average(number / 10); }

	double avg = ::sum / (::br-1);
	return avg;
}



void main() {
	system("chcp 1251");
	
	int a, b;

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b; cout << endl;

	double a_avg = average(a); ::br = 0; sum = 0;
	double b_avg = average(b);

	cout << a_avg << endl << b_avg << endl;

	

	
	_getch();
}

