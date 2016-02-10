/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

11. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, 
където n e кратно на 2. 
Да се състави програма, която изчислява разликата между 
сумата на елементите от първата половина 
и сумата на елементите от втората половина на масива.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


int sumArray(int *array, int n, int i, int sum_Half){
	sum_Half += array[i];
	if (i == n) { return sum_Half; }
	else return sumArray(array, n, ++i, sum_Half);
}





void main() {
	system("chcp 1251");

	int A[30], 
		n, 
		i = 0,
		sum_firstHalf = 0, 
		sum_secondHalf = 0;

	cout << "Enter n: "; cin >> n; cout << endl; if (n % 2 != 0) return; 

	// Въвеждане на елементите в масива.
	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin >> A[i];
		if (i == (n/2) - 1) cout << endl;
	}

	cout << endl;

	// i = 4 след въвеждането на елементите, затова броячът се занулява
	i = 0;
	
	// Определяне на сумата на елементите от 1-вата половина на масива
	sum_firstHalf = sumArray(A, (n/2)-1, i, sum_firstHalf);
	// Продължаване към втората част, затова броячът започва от края на първата половина на масива
	i = n / 2;
	sum_secondHalf = sumArray(A, n-1, i, sum_secondHalf);


	// Извеждане на крайния резултат;
	cout << "Сума от 1 половина: " << sum_firstHalf << endl;
	cout << "Сума от 2 половина: " << sum_secondHalf << endl << endl;
	cout << sum_firstHalf << " - " << sum_secondHalf << " = " << sum_firstHalf - sum_secondHalf << endl;

	
	_getch();
}

