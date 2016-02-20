/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

54. Зададен е масивът от символни низове А0, А1,...,Аn-1. Да се състави програма, която създава нов масив а0, а1,...,аn-1, като стойността на аi е равна на броя на
символите в низа Аi.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void strlenArrayElement(char array1[][30], int numberOfElements, int *array2){

	int i, n = numberOfElements;

	for (i = 0; i < n; i++){
		array2[i] = strlen(array1[i]);
	}

}


// Главна функция
void main(){
	system("chcp 1251");

	char A[30][30];
	int a[30], i, n;

	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin.getline(A[i], 30);
	}

	cout << endl;

	// Извикване на функцията
	strlenArrayElement(A, n, a);

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}



	_getch();
}