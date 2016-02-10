/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

19. Зададени са два едномерни целoчислeни масива А0, А1,...,Аn-1 и B0, B1,...,Bn-1. 
Да се създаде нов масив а0, а1,...,аn-1, като стойността на аi е равна на сумата от броя на ненулевите цифри на Аi и Bi.


*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void sumBrAboveZeroDigits(int *array1, int *array2, int numberOfElements, int *array3){
	
	int n = numberOfElements;
	int i;

	int c_1, c_2;						// Цифра на числото елемент в масив 1,2
	int br_1[30], br_2[30];				// Брой ненулеви цифри на елементите в масив 1,2
	int sum[30];						// Масив с елементи сума от броя на ненулевите цифри на 2-та елемента от масив 1,2
	
	// Определяне броя на ненулевите цифри на всеки елемент в масив 1
	for (i = 0; i < n; i++) { 
		br_1[i] = 0;
		while (array1[i] > 0){
			c_1 = array1[i] % 10;
			if (c_1 != 0) { br_1[i]++; }
			array1[i] /= 10;
		}
	}

	// Определяне броя на ненулевите цифри на всеки елемент в масив 2
	for (i = 0; i < n; i++) {
		br_2[i] = 0;
		while (array2[i] > 0){
			c_2 = array2[i] % 10;
			if (c_2 != 0) { br_2[i]++; }
			array2[i] /= 10;
		}
	}

	// Определяне на сумата от ненулевите цифри на елементите от масив 1 и 2
	// и поставяне на стойност за всеки елемент от масив 3 (масивът-резултат)
	for (i = 0; i < n; i++) { 
		sum[i] = br_1[i] + br_2[i];
		array3[i] = sum[i];
	}
}

// Главна функция
void main(){
	system("chcp 1251");

	int i, n, A[30], B[30], a[30];

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
	sumBrAboveZeroDigits(A, B, n, a);

	cout << endl;

	// Извеждане на a[i]
	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}





	_getch();
}