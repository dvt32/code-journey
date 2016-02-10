/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*
2. Да се състави програма с рекурсивни функции 
за извеждане елементите на зададен масив в прав и обратен ред.

a) прав ред

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


int i = 0;

// Функция за извеждане на елементите на масива в прав ред рекурсивно
void coutArray(int *array, int numberOfElements){
	cout << "a[" << ::i << "]: " << array[i] << endl;
	i++;
	if (i < numberOfElements) coutArray(array, numberOfElements);
}

void main() {
	system("chcp 1251");
	
	int n, i, a[30];

	cout << "Enter n: "; cin >> n; cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: "; cin >> a[i];
	}

	cout << endl;

	// Извеждане на масива в прав ред
	coutArray(a, n);
	
	_getch();
}

