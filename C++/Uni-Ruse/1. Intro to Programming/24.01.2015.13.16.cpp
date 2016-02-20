/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*


23. Зададени са два едномерни целoчислeни масива А0, А1,...,Аn-1 и B0, B1,...,Bn-1. Да се състави програма, която създава нов масив а0, а1,...,аn-1, като стойността на
аi е равна на разликата между средно-аритметичното на нечетните цифри на Аi и средно-аритметичното на нечетните цифри на Bi.


*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void subAvgOdd(int *array1, int *array2, int numberOfElements, double *array3){
	
	int n = numberOfElements;
	int i;

	int c_1, c_2;
	double br_1[30], br_2[30];										// Брой нечетни цифри на елемент в масив 1,2
	double sum_1[30], sum_2[30];									// Сума на нечетните цифри на елемент в масив 1,2
	double avg_1[30], avg_2[30];									// Средно-аритметично на нечетните цифри на елемент в масив 1,2
	double avgMulti[30];											// Произведение от avg_1[i] и avg_2[i]

	for (i = 0; i < n; i++) { 
		sum_1[i] = 0;
		br_1[i] = 0;
		while (array1[i] > 0){
			c_1 = array1[i] % 10;
			if (c_1 % 2 == 1) { sum_1[i] += c_1; br_1[i]++; }
			array1[i] /= 10;
		}
		avg_1[i] = sum_1[i] / br_1[i];
	}

	for (i = 0; i < n; i++) {
		sum_2[i] = 0;
		br_2[i] = 0;
		while (array2[i] > 0){
			c_2 = array2[i] % 10;
			if (c_2 % 2 == 1) { sum_2[i] += c_2; br_2[i]++; }
			array2[i] /= 10;
		}
		avg_2[i] = sum_2[i] / br_2[i];
	}

	for (i = 0; i < n; i++){
		avgMulti[i] = avg_1[i] - avg_2[i];
		array3[i] = avgMulti[i];
	}
}

// Главна функция
void main(){
	system("chcp 1251");

	int i, n, A[30], B[30];
	double a[30];

	cout << "Enter n: "; cin >> n; cout << endl;

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin >> A[i];
	}
	
	cout << endl;

	for (i = 0; i < n; i++){
		cout << "B[" << i << "]: "; cin >> B[i];
	}

	// Извикване на функцията 
	// A - масив 1, B - масив 2, n - брой на елементите, a - новият масив
	subAvgOdd(A, B, n, a);

	cout << endl;

	// Извеждане на a[i]
	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}





	_getch();
}