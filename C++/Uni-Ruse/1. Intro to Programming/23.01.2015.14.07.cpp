/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

11. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, 
където n e кратно на 2. 
Да се състави програма, която изчислява 
разликата между сумата на елементите от първата половина 
и сумата на елементите от втората половина на масива.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int razlika(int array[], int numberOfElements){
	
	int n = numberOfElements;
	int n_half = numberOfElements / 2;		// половината елементи на масива
	int sum_1 = 0, sum_2 = 0;			// сума на елементите от 1-вата и 2-рата част на масива
	
	for (int i = 0; i < n_half; i++){ sum_1 += array[i]; }
	for (int i = n_half; i < n; i++){ sum_2 += array[i]; }

	int razlika = sum_1 - sum_2;
	return razlika;
	

}

// Главна функция
void main(){
	system("chcp 1251");

	int i, n, A[30];

	cout << "Enter n (кратно на 2): "; cin >> n; cout << endl;
	if (n % 2 == 1) { cout << "Невалидна стойност на 'n'. " << endl; return; }

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin >> A[i];
	}

	cout << endl << "Разликата между елементите от 1-вата и 2-рата половина на масива е " << razlika(A, n) << endl;




	_getch();
}