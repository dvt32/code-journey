/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

1. Даден е масив A от n целoчислени елемента. 

Да се напише програма, която:
- създава масива а от n елемента, като а[i] e равно на сумата от квадратните корени на четните цифри на Ai;
- намира най-големия елемент в масива а.

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
		void cinArray(int *array, int numberOfElements){
			for (int i = 0; i < numberOfElements; i++){
				cout << "- ["<<i<<"]: "; cin >> array[i];
			} cout << endl;
		}

		// Функция за намиране сумата от квадратните корени на четните цифри на цяло число
		double sumSqrtEvenDigits(int number){
			int c;
			double sum = 0;
			while (number > 0){
				c = number % 10;
				if (c % 2 == 0) { sum += sqrt(c); }
				number /= 10;
			}
			return sum;
		}

		// Функция за намиране най-големия елемент в едномерен масив
		double maxArrayElement(double *array, int numberOfElements){
			double max = INT_MIN;
			for (int i = 0; i < numberOfElements; i++){
				if (array[i] > max) { max = array[i]; }
			}
			return max;	
		}

		// Функция за извеждане елементите на едномерен масив
		void coutArray(double *array, int numberOfElements){
			for (int i = 0; i < numberOfElements; i++){
				cout << "- [" << i << "]: " << array[i] << endl;
			}
		}
};

void main(){
	system("chcp 1251");

	int A[30], i, n;
	double a[30];

	// Въвеждане броя на елементите в масива
	cout << "Enter n: "; cin >> n; cout << endl;

	// Обект за извикване на функциите от класа.
	functions fCall;
	
	// Въвеждане на елементите в масива 'A'
	cout << "Въведи елементите на масива 'А': " << endl; 	
	fCall.cinArray(A, n);

	cout << endl;

	// Определяне на стойностите на елементите в масива 'a'
	for (i = 0; i < n; i++){
		a[i] = fCall.sumSqrtEvenDigits(A[i]);
	}

	// Извеждане на 'a' на екрана
	cout << "Елементи на масива 'a': " << endl;
	fCall.coutArray(a, n);

	// Намиране и извеждане на най-големия елемент в масива 'a'
	cout << endl << "Най-големият елемент в масива 'а' e равен на " << fCall.maxArrayElement(a, n) << endl << endl;
	return;
	
	_getch();
}

