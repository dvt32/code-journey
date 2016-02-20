/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*
1-а. Да се състави програма с 
рекурсивни функции за 
извеждане на цифрите на зададено цяло число в 
прав ред.
*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


// Функция за получване на число с обратните цифри на оригиналното число (с цел извличане на цифрите в прав ред)
int numberReverse(int number){

	int digit, numberCopy = number, numberReversed = 0;
	while (numberCopy > 0)
	{
		digit = numberCopy % 10;
		numberReversed = numberReversed * 10 + digit;
		numberCopy /= 10;
	}
	return numberReversed;
}


// Рекурсивна функция за извличане на цифрите в прав ред.
void getDigits(int number)
{
	int digit;
	 digit = number % 10;

	 if (number > 0)
	 {
		 cout << digit << " ";
		 getDigits(number / 10);
	 }
	 

	
}


void main() {
	system("chcp 1251");
	
	int n;

	cout << "Enter n: "; cin >> n; cout << endl;

	n = numberReverse(n);

	// Извеждане на цифрите в прав ред
	getDigits(n);

	
	_getch();
}

