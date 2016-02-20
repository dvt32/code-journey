/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

12. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, 
където n e кратно на 2. 
Да се състави програма, която изчислява 
разликата между 
средно-аритметичното на елементите от първата половина и 
средно-аритметичното на елементите от втората половина на масива.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


double avgArray(int *array, int n, int i, double sum, double br){
	sum += array[i];
	br++;
	if (i == n) { return (sum/br); }
	else return avgArray(array, n, ++i, sum,br);
}





void main() {
	system("chcp 1251");

	int A[30],
		n,
		i = 0;
	double sum_firstHalf = 0, sum_secondHalf = 0,
			br_firstHalf = 0, br_secondHalf = 0,
			avg_firstHalf, avg_secondHalf;

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
	avg_firstHalf = avgArray(A, (n/2)-1, i, sum_firstHalf, br_firstHalf);
	// Продължаване към втората част, затова броячът започва от края на първата половина на масива
	i = n / 2;
	avg_secondHalf = avgArray(A, n-1, i, sum_secondHalf, br_secondHalf);


	// Извеждане на крайния резултат;
	cout << "Средно-аритметично от 1 половина: " << avg_firstHalf << endl;
	cout << "Средно-аритметично от 2 половина: " << avg_secondHalf << endl << endl;
	cout << avg_firstHalf << " - " << avg_secondHalf << " = " << avg_firstHalf - avg_secondHalf << endl;

	
	_getch();
}

