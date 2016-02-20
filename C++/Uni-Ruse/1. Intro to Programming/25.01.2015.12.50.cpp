/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

56. Зададен e масив от символни низове А0, А1,...,Аn-1, 
съдържащ букви от кирилицата и препинателни знаци. 
Да се състави програма, която преброява главните букви във всеки символен низ.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void brCapitalLettersString(char array1[][30], int numberOfElements, int *array2){

	int i, j = 0, n = numberOfElements;
	int brCapitalLetters[30];	// Масив, съдържащ броя главни букви от кирилицата във всеки низ

	for (i = 0; i < n; i++){
		brCapitalLetters[i] = 0;
		for (j = 0; j < strlen(array1[i]); j++){
			// Ограничаване на въвежданите символи в низовете
			if ((array1[i][j] < 'А' || array1[i][j] > 'я') &&
				(array1[i][j] != '.' &&
				array1[i][j] != ',' &&
				array1[i][j] != '?' &&
				array1[i][j] != '!' &&
				array1[i][j] != ';' &&
				array1[i][j] != ':' &&
				array1[i][j] != '-' &&
				array1[i][j] != '(' &&
				array1[i][j] != ')' &&
				array1[i][j] != '\'' &&
				array1[i][j] != '"'))
			{
				brCapitalLetters[i] = -1; break;
			}
			// Преброяване на главните букви, ако всички символи отговарят на условието.
			if (array1[i][j] >= 'А' && array1[i][j] <= 'Я') { brCapitalLetters[i]++; }
		}
		array2[i] = brCapitalLetters[i];
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
	brCapitalLettersString(A, n, a);

	for (i = 0; i < n; i++){
		if (a[i] > -1)
		cout << "Главни букви в низ " << i << ": " << a[i] << endl;
		else cout << "Низ " << i << " е невалиден." << endl;
	}



	_getch();
}