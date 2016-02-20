/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

5. Да се намери при кое от две зададени цели числа средно-аритметичното на ненулевите цифри е по-голяма.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>



double averageAboveZeroDigits(int num, int c, double br, double sum){

	if (num == 0) {
		if (br == 0) { return 0; }
		return (sum / br);
	}

	c = num % 10; 
	if (c != 0) 
	{
		br++;
		sum += c;
	}

	if (num > 0) { return averageAboveZeroDigits(num / 10, c, br, sum); }
	
	
}



void main() {
	system("chcp 1251");
	
	int a, b;
	double c1 = 0, c2 = 0, br1 = 0, br2 = 0, sum1 = 0, sum2 = 0, avg1, avg2;
	// c - цифра на число 1 и 2 
	// br - брой на ненулевите цифри на число 1 и 2
	// sum - сума на ненулевите цифри на число 1 и 2
	// avg - средно-аритметично на ненулевите цифри на число 1 и 2

	cout << "Enter a: "; cin >> a;
	cout << "Enter b: "; cin >> b; cout << endl;

	avg1 = averageAboveZeroDigits(a, c1, br1, sum1);
	avg2 = averageAboveZeroDigits(b, c2, br2, sum2);

	if (avg1 > avg2) { cout << "Средно-аритметичното на ненулевите цифри на " << a << " e по-голямо. ("<<avg1<<")"; }
	if (avg1 < avg2) { cout << "Средно-аритметичното на ненулевите цифри на " << b << " e по-голямо. ("<<avg2<<")"; }
	if (avg1 == avg2) { cout << "Двете числа имат еднакво средно-аритметично на ненулевите им цифри."; }

	

	
	_getch();
}

