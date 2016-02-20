/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*
2. Да се състави програма с рекурсивни функции 
за извеждане елементите на зададен масив в прав и обратен ред.

б) обратен ред

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


int i;

// Функция за извеждане на елементите на масива в обратен ред рекурсивно
void coutArrayReverse(int *array, int numberOfElements){
	i = numberOfElements-1;
	cout << "a[" << ::i << "]: " << array[--numberOfElements] << endl;
	i--;
	if (numberOfElements > 0) coutArrayReverse(array, numberOfElements);
}

void main() {
	system("chcp 1251");
	
	int n, i, a[30];

	cout << "Enter n: "; cin >> n; cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: "; cin >> a[i];
	}

	cout << endl;

	// Извеждане на масива в обратен ред
	coutArrayReverse(a, n);
	
	_getch();
}

