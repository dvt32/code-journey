/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

21. Зададени са два едномерни целoчислeни масива А0, А1,...,Аn-1 и B0, B1,...,Bn-1. Да се създаде нов масив а0, а1,...,аn-1, като стойността на аi е равна на частното
на последните цифри на Аi и Bi.


*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void sumLastDigits(int *array1, int *array2, int numberOfElements, double *array3){
	
	int n = numberOfElements;
	int i;

	double c_1[30], c_2[30];				// Последна цифра на числото елемент в масив 1,2
	double sum[30];

	for (i = 0; i < n; i++) { 
		c_1[i] = array1[i] % 10;
		c_2[i] = array2[i] % 10;
		sum[i] = c_1[i] / c_2[i];
		array3[i] = sum[i];
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
	sumLastDigits(A, B, n, a);

	cout << endl;

	// Извеждане на a[i]
	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}





	_getch();
}