/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

14. Зададен е едномерен масив от цели числа А0, А1,...,Аn-1, където n e кратно на 2. 
Да се състави програма, която изчислява 
сумата на
- най-големия елемент от първата половина и 
- най-големия елемент от втората половина на масива.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


int maxArray(int *array, int n, int i, int max){
	if (array[i] > max) { max = array[i]; }
	if (i == n) { return max; }
	else return maxArray(array, n, ++i, max);
}





void main() {
	system("chcp 1251");

	int A[30],
		n,
		i = 0,
		max_firstHalf = INT_MIN, // най-големият елемент в първата половина на масива
		max_secondHalf = INT_MIN; // най-големият елемент във втората половина на масива

	cout << "Enter n: "; cin >> n; cout << endl; if (n % 2 != 0) return; 

	// Въвеждане на елементите в масива.
	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin >> A[i];
		if (i == (n/2) - 1) cout << endl;
	}

	cout << endl;

	// i = 4 след въвеждането на елементите, затова броячът се занулява
	i = 0;
	
	// Първа част
	max_firstHalf = maxArray(A, (n/2)-1, i, max_firstHalf);
	// Продължаване към втората част, затова броячът започва от края на първата половина на масива
	i = n / 2; 
	// Втора част
	max_secondHalf = maxArray(A, n-1, i, max_secondHalf);


	// Извеждане на крайния резултат;
	cout << "Най-голям елемент, 1 половина: " << max_firstHalf << endl;
	cout << "Най-голям елемент, 2 половина: " << max_secondHalf << endl << endl;
	cout << max_firstHalf << " + " << max_secondHalf << " = " << max_firstHalf + max_secondHalf << endl;

	
	_getch();
}

