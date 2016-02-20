/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

2. Даден е масив A от n целoчислени елемента. 

Да се напише програма, която:
- създава масива а от n елемента, като а[i] e равно на сумата от квадратните корени на четните цифри на Ai;
- намира най-големия елемент в масива а.

(решението да е с рекурсивни функции)

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


class functions{
	public:
		// Функция за въвеждане елементите на едномерен масив
		void cinArray(int *array, int numberOfElements, int counter){
			if (counter == numberOfElements) { cout << endl; return; }
			cout << "- ["<<counter<<"]: "; cin >> array[counter];
			if (counter < numberOfElements) { cinArray(array, numberOfElements, ++counter); }
		}

		// Функция за намиране сумата от квадратните корени на четните цифри на цяло число
		double sumSqrtEvenDigits(int number, double sumContainer){
				if (number == 0) { return sumContainer; }
				int c = number % 10;
				if (c % 2 == 0) { sumContainer += sqrt(c); }
				if (number > 0) { return sumSqrtEvenDigits(number / 10, sumContainer); }	
		}

		// Функция за извеждане елементите на едномерен масив
		void coutArray(double *array, int numberOfElements, int counter){
			if (counter == numberOfElements) { cout << endl; return; }
			cout << "- [" << counter << "]: " << array[counter] << endl;
			if (counter < numberOfElements) { coutArray(array, numberOfElements, ++counter); }
		}

		// Функция за намиране най-големия елемент в едномерен масив
		double maxArrayElement(double *array, int numberOfElements, int counter, double maxContainer){
			if (counter == numberOfElements) { return maxContainer; }
			if (array[counter] > maxContainer) { maxContainer = array[counter]; }
			if (counter < numberOfElements) { return maxArrayElement(array, numberOfElements, ++counter, maxContainer); }
		}

};

void main(){
	system("chcp 1251");

	int A[30], i = 0, n;
	double a[30], sum = 0, max = INT_MIN;

	// Въвеждане броя на елементите в масива
	cout << "Enter n: "; cin >> n; cout << endl;

	// Обект за извикване на функциите от класа.
	functions fCall;
	
	// Въвеждане на елементите в масива 'A'
	cout << "Въведи елементите на масива 'А': " << endl; 	
	fCall.cinArray(A, n, i);

	cout << endl;

	// Определяне на стойностите на елементите в масива 'a'
	for (i = 0; i < n; i++){
		a[i] = fCall.sumSqrtEvenDigits(A[i], sum);
	} i = 0;

	// Извеждане на 'a' на екрана
	cout << "Елементи на масива 'a': " << endl;
	fCall.coutArray(a, n, i);

	// Намиране и извеждане на най-големия елемент в масива 'a'
	cout << endl << "Най-големият елемент в масива 'а' e равен на " << fCall.maxArrayElement(a, n, i, max) << endl << endl;
	return;
	
	_getch();
}

