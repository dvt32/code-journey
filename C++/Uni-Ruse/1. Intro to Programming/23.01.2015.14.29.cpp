/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

14. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, където n e крат-но на 2. 
Да се състави програма, която изчислява 
сумата най-големия елемент от първата половина 
и най-големия елемент от втората полови-на на масива.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

int sum(int array[], int numberOfElements){
	
	int n = numberOfElements;
	int n_half = numberOfElements / 2;		// половината елементи на масива
	int arrayMax_1 = 0, arrayMax_2 = 0;		// най-големият елемент в 1-вата и 2-рата половина на масива
	
	for (int i = 0; i < n_half; i++)
	{ 
		if (array[i] > arrayMax_1) arrayMax_1 = array[i]; 
	}
	for (int i = n_half; i < n; i++)
	{
		if (array[i] > arrayMax_2) arrayMax_2 = array[i];
	}

	int sum = arrayMax_1 + arrayMax_2;
	return sum;
}

// Главна функция
void main(){
	system("chcp 1251");

	int i, n, A[30];

	cout << "Enter n (кратно на 2): "; cin >> n; cout << endl;
	if (n % 2 == 1) { cout << "Невалидна стойност на 'n'. " << endl; return; }

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin >> A[i];
		if (i == n/2-1) cout << endl;
	}

	cout << endl << "Сумата на най-големите елементи от 2-те половини на масива е " << sum(A, n) << endl;



	_getch();
}