/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

16. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, където n e крат-но на 3. Да се състави програма, която изчислява разликата между сумата на елементите от първата третина 
и сумата на елементите от втората третина 
и я разделя на сумата на елементите от третата третина на ма-сива.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

double result(int array[], int numberOfElements){
	
	int n = numberOfElements;
	int n_third = numberOfElements / 3;		// една трета от елементите в масива
	double sum_1 = 0, sum_2 = 0, sum_3 = 0;	// сума на елементите от 1,2,3 част от масива
	
	for (int i = 0; i < n_third; i++) { sum_1 += array[i]; }
	for (int i = n_third; i < (n_third)*2; i++) { sum_2 += array[i]; }
	for (int i = (n_third)*2; i < n; i++) { sum_3 += array[i]; }

	double result = (sum_1 - sum_2) / sum_3;
	return result;
}

// Главна функция
void main(){
	system("chcp 1251");

	int i, n, A[30];

	cout << "Enter n (кратно на 3): "; cin >> n; cout << endl;
	if (n % 3 != 0) { cout << "Невалидна стойност на 'n'. " << endl; return; }

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin >> A[i];
		if (i == n/3-1 || i == (n/3)*2-1) cout << endl;
	}

	cout << endl << "Разликата м/у сумата на ел. от 1 и 2 третина, раздел. на сумата от 3 третина на масива е " << result(A, n) << endl;



	_getch();
}