/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

17. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, където n e крат-но на 3. Да се състави програма, която изчислява разликата между сумата от индексите на най-големите елементите от първата, втората и третата третина на масива.

*/

// Недовършена - какво се търси???

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

double result(int array[], int numberOfElements){
	
	int n = numberOfElements;
	int n_third = numberOfElements / 3;								// една трета от елементите в масива
	int arrayMax_1 = 0, arrayMax_2 = 0, arrayMax_3 = 0;				// най-големият елемент от 1,2,3 част на масива
	int arrayMaxInd_1 = 0, arrayMaxInd_2 = 0, arrayMaxInd_3 = 0;	// индекс на най-големия елемент от 1,2,3 част на масива
	int sumMaxInd_123 = 0; // сума на индексите на най-големите елементи от 3-те части на масива
	
	for (int i = 0; i < n_third; i++) { 
		if (array[i] > arrayMax_1) { arrayMax_1 = array[i]; arrayMaxInd_1 = i; }
	}
	for (int i = n_third; i < (n_third)*2; i++) {
		if (array[i] > arrayMax_2) { arrayMax_2 = array[i]; arrayMaxInd_2 = i; }
	}
	for (int i = (n_third)* 2; i < n; i++) {
		if (array[i] > arrayMax_3) { arrayMax_3 = array[i]; arrayMaxInd_3 = i; }
	}

	int sumMaxInd_123 = arrayMaxInd_1 + arrayMaxInd_2 + arrayMaxInd_3;

	// изчисляване на разликата goes here...

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

	cout << endl << "Резултат: " << result(A, n) << endl;



	_getch();
}